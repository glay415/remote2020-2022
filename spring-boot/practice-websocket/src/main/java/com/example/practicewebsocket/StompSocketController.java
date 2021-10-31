package com.example.practicewebsocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.Optional;

@Controller
public class StompSocketController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/user")
    public void showUsers(String msg) {

        System.out.println("msg" + msg);
        HashMap<String, Object> payload = new HashMap<>();
        payload.put("name","chanwoo");
        simpMessagingTemplate.convertAndSend("/topic/a", payload);
    }
}
