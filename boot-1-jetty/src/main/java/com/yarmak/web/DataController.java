package com.yarmak.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DataController {

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<String> listStudents() {
        return List.of("Jason", "Brad", "Wilson", "Graham");
    }
}
