package com.step.forum.service;

import com.step.forum.dao.UserDao;
import com.step.forum.exceptions.UserCredentialsException;
import com.step.forum.model.Action;
import com.step.forum.model.User;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User loginUser(String email, String password) throws UserCredentialsException, SQLException {
        return userDao.loginUser(email, password);
    }

    @Override
    public void registerUser(User user) throws UserCredentialsException, SQLException {
        userDao.registerUser(user);
    }

    @Override
    public List<Action> getActionListByRoleId(int idRole) throws SQLException {
        return userDao.getActionListByRoleId(idRole);
    }
}
