package com.dao;

import java.util.List;

import com.bean.User;

public interface UserDao {
    void ajouter( User user );
    List<User> lister();
}