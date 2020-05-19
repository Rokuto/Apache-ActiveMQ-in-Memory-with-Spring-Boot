package com.example.activemqinmemory.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class Producer {

    @Autowired
    private Queue queue;

    @Autowired
    private JmsTemplate jmsTemplate;

    @GetMapping(value="publish/{msg}")
    public String publish(@PathVariable("msg") final String msg) {
        jmsTemplate.convertAndSend(queue, msg);
        return "Your message <b>" +msg+ "</b> published successfully";
    }

}