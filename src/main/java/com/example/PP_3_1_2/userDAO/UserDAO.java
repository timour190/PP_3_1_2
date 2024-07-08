package com.example.PP_3_1_2.userDAO;


import com.example.PP_3_1_2.model.User;

import java.util.List;

public interface UserDAO {

    public List<User> list();

    public User user(int id);

    public void save(User user);


    public void update(User user, int id);


    public void delete(int id);
}
