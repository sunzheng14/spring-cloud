package com.sun.zq;

import com.sun.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HelloController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public String index() {
        return "Hello World";
    }

    @RequestMapping(value = "getStudent", method = RequestMethod.GET)
    public Student getStudent() {
        return new Student(1L, "zhangsan");
    }

    @RequestMapping(value = "post", method = RequestMethod.POST)
    public String post(String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "postStudent", method = RequestMethod.POST)
    public Student postStudent(String name) {
        return new Student(1L, name);
    }
}
