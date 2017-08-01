package org.github.stream.beta.service;

import org.github.stream.beta.listener.BetaGateway;
import org.github.stream.beta.listener.BetaListener;
import org.github.stream.beta.model.Feed;
import org.github.stream.beta.model.LoginVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Created by vlevash on 7/27/17.
 */
@Component
public class LoginVmHandler {

    private final Logger LOG = LoggerFactory.getLogger(LoginVmHandler.class);
    private final BetaGateway betaGateway;

    public LoginVmHandler(BetaGateway betaGateway) {
        this.betaGateway = betaGateway;
    }

    @StreamListener(BetaListener.INPUT)
    public void generate(LoginVM loginVM){
        LOG.info("Get {}"+loginVM);
        Feed feed = new Feed();
        feed.setFeedName("some:"+ LocalDateTime.now());

        betaGateway.generate(feed);

        LOG.info("Generate Feed {}"+feed);
    }
}
