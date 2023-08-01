package com.example.backend.controller.pk;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IndexController {
    @RequestMapping("/pk/index/")
    public String index(){
        return "hello world";
    }
}
