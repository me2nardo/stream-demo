package org.github.stream.beta.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by vlevash on 7/27/17.
 */
public interface BetaListener {

    String INPUT = "input_beta";
    String INPUT_SERVICE = "service";
    String OUTPUT = "output_beta";

    @Input(BetaListener.INPUT)
    SubscribableChannel inputChannel();

    @Input(BetaListener.INPUT_SERVICE)
    SubscribableChannel inputServiceChannel();

    @Output(BetaListener.OUTPUT)
    MessageChannel outputChannel();
}
