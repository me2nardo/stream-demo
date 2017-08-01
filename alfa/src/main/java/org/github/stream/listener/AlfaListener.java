package org.github.stream.listener;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by vlevash on 7/27/17.
 */
public interface AlfaListener {

    String INPUT = "input_alfa";
    String OUTPUT = "output_alfa";

    @Input(AlfaListener.INPUT)
    SubscribableChannel inputChannel();

    @Output(AlfaListener.OUTPUT)
    MessageChannel outputChannel();
}
