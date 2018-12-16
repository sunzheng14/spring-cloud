package com.sun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private RestTemplate restTemplate;

    @Override
    //@HystrixCommand(fallbackMethod="helloFallBack")
    public String helloService() {
        ResponseEntity<String> entity = restTemplate.getForEntity("http://hello-server/hello", String.class);
        return entity.getBody();
    }

    public String helloFallBack(){
        return "error";
    }
}
