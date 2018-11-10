package com.step.forum.service;

import com.step.forum.exceptions.UserCredentialsException;
import com.step.forum.model.User;

public interface UserService {
    User loginUser(String email, String password) throws UserCredentialsException;
    boolean registerUser(User user) throws UserCredentialsException;
}
