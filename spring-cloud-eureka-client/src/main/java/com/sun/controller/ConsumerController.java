package com.sun.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.sun.model.Student;
import com.sun.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping(value="ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumser() {
        return restTemplate.getForEntity("http://server/hello",String.class).getBody();
    }

    @RequestMapping(value="getStudent", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getStudentDefault")
    public Student getStudent() {
        return restTemplate.getForEntity("http://server/getStudent",Student.class).getBody();
    }

    public Student getStudentDefault() {
        Student student = new Student(1L,"zhangsan", 18);

        return student;
    }

    @RequestMapping(value="postStr", method = RequestMethod.GET)
    public String postStr() {
        Student student = new Student();
        return restTemplate.postForEntity("http://server/post?name={1}",student, String.class,"lisi").getBody();
    }

    @RequestMapping(value="postStudent", method = RequestMethod.GET)
    public Student postStudent() {
        Student student = new Student();
        return restTemplate.postForEntity("http://server/postStudent?name={1}",student,Student.class,"wangwu").getBody();
    }


    @RequestMapping(value="hystrixHello", method = RequestMethod.GET)
    public String hystrixHello() {
        return consumerService.helloService();
    }

}
