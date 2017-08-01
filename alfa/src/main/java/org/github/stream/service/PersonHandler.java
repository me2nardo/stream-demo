package org.github.stream.service;

import org.github.stream.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.stream.binding.BinderAwareChannelResolver;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vlevash on 7/27/17.
 */
@Component
public class PersonHandler {

    private final Logger LOG = LoggerFactory.getLogger(PersonHandler.class);

    @Autowired
    private BinderAwareChannelResolver channelResolver;

    @Autowired
    private Tracer tracer;

    @Async
    public void provide(String name){

        Span span = tracer.continueSpan(tracer.getCurrentSpan());
        LOG.info("SpanID:" + span.getSpanId() +":"+span.getName());

        Person person = new Person(name);

        LOG.info("Person:"+person);


        Map<String,Object> headers = new HashMap<>();
        headers.put("spanId",span.getSpanId());
        headers.put("spanParentSpanId",span.getParents().get(span.getParents().size()));
        headers.put("spanTraceId",span.getTraceId());
        //headers.put("spanSampleId",span.);
        headers.put("spanName",span.getName());

       headers.put(Span.CLIENT_RECV,span.getBegin());
       //headers.put(Span.SERVER_RECV,span.)

        headers.put(MessageHeaders.CONTENT_TYPE,"application/json");

        channelResolver.resolveDestination("service_exchange").send(MessageBuilder.createMessage(person.getName(),
                new MessageHeaders(headers)));

        tracer.close(span);
    }
}
