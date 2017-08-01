package org.github.stream;

import org.github.stream.listener.AlfaListener;
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
@EnableBinding(AlfaListener.class)
public class AlfaApplication {

    @Bean
    public Sampler defaultSampler() {
        return new AlwaysSampler();
    }

      public static void main(String[] args) {
            new SpringApplicationBuilder(AlfaApplication.class).web(true).run(args);
        }
 }

