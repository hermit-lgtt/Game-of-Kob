package com.example.backend.controller.pk;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
@RestController
public class BotInfoController {
    @RequestMapping("/pk/getbotinfo/")
    public List<String> getBotInfo(){
        LinkedList<String> list = new LinkedList<>();
        list.add("sword");
        list.add("tiger");
        list.add("apple");
        return list;
    }
}
