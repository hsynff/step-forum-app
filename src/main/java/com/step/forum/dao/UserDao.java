package com.step.forum.dao;

import com.step.forum.exceptions.UserCredentialsException;
import com.step.forum.model.User;

import java.util.List;

public interface UserDao {
    User loginUser(String email, String password) throws UserCredentialsException;
    boolean registerUser(User user) throws UserCredentialsException;
}
