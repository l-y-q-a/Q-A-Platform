package com.example.chatplatform.dao;

import com.example.chatplatform.model.User;
import com.example.chatplatform.model.Thread;
import com.example.chatplatform.model.Reply;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class DataStore {
    private Map<String, User> users = new HashMap<>();
    private Map<Integer, Thread> threads = new HashMap<>();
    private Map<Integer, List<Reply>> replies = new HashMap<>();
    private int threadId = 1;

    @PostConstruct
    public void init() {
        // 添加测试账号 - 正确的构造函数调用
        users.put("admin", new User("admin", "123456"));
        users.put("user", new User("user", "123456"));
    }

    public boolean validateUser(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }

    public List<Thread> getAllThreads() {
        return new ArrayList<>(threads.values());
    }

    public Thread getThread(int id) {
        return threads.get(id);
    }

    public void addThread(Thread thread) {
        thread.setId(threadId++);
        thread.setCreateTime(new Date());
        threads.put(thread.getId(), thread);
    }

    public List<Reply> getReplies(int threadId) {
        return replies.getOrDefault(threadId, new ArrayList<>());
    }

    public void addReply(Reply reply) {
        reply.setCreateTime(new Date());
        int threadId = reply.getThreadId();
        if (!replies.containsKey(threadId)) {
            replies.put(threadId, new ArrayList<>());
        }
        replies.get(threadId).add(reply);
    }
}