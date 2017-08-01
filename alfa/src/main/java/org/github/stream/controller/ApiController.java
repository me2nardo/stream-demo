package org.github.stream.controller;

import org.github.stream.listener.AlfaGateway;
import org.github.stream.model.LoginVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by vlevash on 7/27/17.
 */
@RestController
@RequestMapping(value = "/api")
public class ApiController {
    private final Logger LOG = LoggerFactory.getLogger(ApiController.class);

    @Autowired
    private AlfaGateway alfaGateway;

    @PostMapping(value = "/todo")
    public ResponseEntity sendMessage(@RequestBody LoginVM loginVM){
        alfaGateway.generate(loginVM);
        LOG.info("Generate {}"+loginVM);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }


}
