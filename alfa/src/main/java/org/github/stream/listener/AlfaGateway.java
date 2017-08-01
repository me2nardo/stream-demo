package org.github.stream.listener;

import org.github.stream.model.LoginVM;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by vlevash on 7/27/17.
 */
@MessagingGateway
public interface AlfaGateway {

    @Gateway(requestChannel = AlfaListener.OUTPUT)
    void generate(LoginVM loginVM);
}
