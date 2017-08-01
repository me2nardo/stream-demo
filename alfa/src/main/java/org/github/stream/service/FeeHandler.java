package org.github.stream.service;

import org.github.stream.listener.AlfaListener;
import org.github.stream.model.Feed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

/**
 * Created by vlevash on 7/27/17.
 */
@Component
public class FeeHandler {

    private final Logger LOG = LoggerFactory.getLogger(FeeHandler.class);

    private final PersonHandler personHandler;

    public FeeHandler(PersonHandler personHandler) {
        this.personHandler = personHandler;
    }

    @StreamListener(AlfaListener.INPUT)
    public void in(Feed feed){
        LOG.info("Getting Feed: {}"+feed);

        personHandler.provide(feed.getFeedName());
    }
}
