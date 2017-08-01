package org.github.stream.beta.service;

import org.github.stream.beta.listener.BetaListener;
import org.github.stream.beta.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Span;

import org.springframework.cloud.sleuth.Tracer;
import org.springframework.cloud.sleuth.annotation.ContinueSpan;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * Created by vlevash on 7/27/17.
 */
@Component
public class PersonHandler {

    private final Logger LOG = LoggerFactory.getLogger(PersonHandler.class);

    @Autowired
    private Tracer tracer;


    @NewSpan
    @StreamListener(BetaListener.INPUT_SERVICE)
    public void listenPerson(Message<String> person){

    //    tracer.

        //person.getHeaders().forEach((k,v)->System.out.println("Key:"+k));

        LOG.info("SpanID:"+person.getHeaders().get("X-B3-SpanId"));

        LOG.info("Person from dynamic:"+person.getPayload());
    }
}
