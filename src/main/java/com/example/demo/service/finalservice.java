package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.finalRepo;

@Service
public class finalservice {
    
    @Autowired
    finalRepo repo;

    public void Add(User u) {
        repo.save(u);
    }

    public User getByEmail(String email) {
        return null;
    }
}
