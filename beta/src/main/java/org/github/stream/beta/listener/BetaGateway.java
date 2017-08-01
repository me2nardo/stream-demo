package org.github.stream.beta.listener;

import org.github.stream.beta.model.Feed;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by vlevash on 7/27/17.
 */
@MessagingGateway
public interface BetaGateway {

    @Gateway(requestChannel = BetaListener.OUTPUT)
    void generate(Feed feed);
}
