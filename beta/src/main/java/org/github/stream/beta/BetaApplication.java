package org.github.stream.beta;

import org.github.stream.beta.listener.BetaListener;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;

/**
 * Created by vlevash on 7/27/17.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(BetaListener.class)
public class BetaApplication {

    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }

    public static void main(String[] args) {

        new SpringApplicationBuilder(BetaApplication.class).web(true).run(args);
    }
}
