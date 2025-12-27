package com.example.chatplatform.service;

import com.example.chatplatform.dao.DataStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private DataStore dataStore;

    public boolean validateUser(String username, String password) {
        return dataStore.validateUser(username, password);
    }
}
