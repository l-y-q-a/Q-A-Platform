package com.example.chatplatform.controller;

import com.example.chatplatform.model.Reply;
import com.example.chatplatform.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ThreadService threadService;

    @PostMapping
    public String addReply(@RequestParam int threadId,
                           @RequestParam String content,
                           @RequestParam(required = false) String author) {

        Reply reply = new Reply();
        reply.setThreadId(threadId);
        reply.setContent(content);
        reply.setAuthor(author != null && !author.trim().isEmpty() ? author : "匿名用户");

        threadService.addReply(reply);
        return "redirect:/threads/" + threadId;
    }
}