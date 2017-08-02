package org.github.stream.controller;

import org.github.stream.model.LoginVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vlevash on 8/1/17.
 */
@RestController
@RequestMapping(value = "/api")
public class AlfaController {

    private final Logger LOG = LoggerFactory.getLogger(AlfaController.class);

    @Autowired
    private BinderAwareChannelResolver channelResolver;

    @Autowired
    private Tracer tracer;

    @PostMapping(value = "/alfa")
    public ResponseEntity generateAlfa(@RequestBody LoginVM loginVM){

        Span span = tracer.continueSpan(tracer.getCurrentSpan());

        Map<String,Object> headers = new HashMap<>();
        headers.put("spanId",Long.toHexString(span.getSpanId()));
        headers.put("spanParentSpanId",Long.toHexString(span.getTraceId()));
        headers.put("spanTraceId",Long.toHexString(span.getTraceId()));
        headers.put("spanSampled",1);
        //headers.put("spanSampleId",span.);
        headers.put("spanName",span.getName());

        headers.put(Span.CLIENT_RECV,span.getBegin());
        //headers.put(Span.SERVER_RECV,span.)

        headers.put(MessageHeaders.CONTENT_TYPE,"application/json");

       // System.out.println("Exportable:"+span.isExportable());



        channelResolver.resolveDestination("service_exchange")
                .send(MessageBuilder.createMessage(loginVM.getName(),
                        new MessageHeaders(headers)));

        LOG.info("Send:"+loginVM.getName());

        tracer.close(span);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
