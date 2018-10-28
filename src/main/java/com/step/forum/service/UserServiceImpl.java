package com.step.forum.service;

import com.step.forum.dao.UserDao;
import com.step.forum.exceptions.UserCredentialsException;
import com.step.forum.model.User;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User loginUser(String email, String password) throws UserCredentialsException {
        return userDao.loginUser(email, password);
    }
}
