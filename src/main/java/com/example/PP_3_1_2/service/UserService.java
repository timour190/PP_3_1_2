package com.example.PP_3_1_2.service;

import com.example.PP_3_1_2.model.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {
    public List<User> list();

    public User user(int id);

    @Transactional
    public void save(User user);

    @Transactional
    public void update(User user, int id);

    @Transactional
    public void delete(int id);
}