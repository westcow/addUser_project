package com.bjb.dao;

import com.bjb.entity.User;

public interface UserDao {

    public int addUser(User user);

    public User queryUser(Integer id);
}
