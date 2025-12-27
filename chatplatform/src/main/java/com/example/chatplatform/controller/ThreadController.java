package com.example.chatplatform.controller;

import com.example.chatplatform.model.Thread;
import com.example.chatplatform.service.ThreadService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/threads")
public class ThreadController {

    @Autowired
    private ThreadService threadService;

    @GetMapping
    public String listThreads(Model model) {
        model.addAttribute("threads", threadService.getAllThreads());
        return "thread-list";
    }

    @GetMapping("/new")
    public String newThreadPage() {
        return "create-thread";
    }

    @PostMapping
    public String createThread(@RequestParam String title,
                               @RequestParam String content,
                               HttpSession session) {
        Thread thread = new Thread();
        thread.setTitle(title);
        thread.setContent(content);
        thread.setAuthor((String) session.getAttribute("user"));

        threadService.addThread(thread);
        return "redirect:/threads";
    }

    @GetMapping("/{id}")
    public String viewThread(@PathVariable int id, Model model) {
        Thread thread = threadService.getThread(id);
        if (thread == null) {
            return "redirect:/threads";
        }

        model.addAttribute("thread", thread);
        model.addAttribute("replies", threadService.getReplies(id));
        return "thread-detail";
    }
}