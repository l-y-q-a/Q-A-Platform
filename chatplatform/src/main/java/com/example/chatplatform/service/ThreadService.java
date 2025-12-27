package com.example.chatplatform.service;

import com.example.chatplatform.dao.DataStore;
import com.example.chatplatform.model.Thread;
import com.example.chatplatform.model.Reply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ThreadService {

    @Autowired
    private DataStore dataStore;

    public List<Thread> getAllThreads() {
        return dataStore.getAllThreads();
    }

    public Thread getThread(int id) {
        return dataStore.getThread(id);
    }

    public void addThread(Thread thread) {
        dataStore.addThread(thread);
    }

    public List<Reply> getReplies(int threadId) {
        return dataStore.getReplies(threadId);
    }

    public void addReply(Reply reply) {
        dataStore.addReply(reply);
    }
}
