package com.snglowsys.rest;

import com.snglowsys.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProducerController {

    @Autowired
    private MessageChannel output;

    @PostMapping("/publish")
    public Customer publishEvent(@RequestBody Customer customer) {
        output.send(MessageBuilder.withPayload(customer).build());
        return customer;
    }
}
