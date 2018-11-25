package com.step.forum.dao;

import com.step.forum.exceptions.UserCredentialsException;
import com.step.forum.model.Action;
import com.step.forum.model.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    User loginUser(String email, String password) throws UserCredentialsException, SQLException;
    void registerUser(User user) throws UserCredentialsException, SQLException;
    List<Action> getActionListByRoleId(int idRole) throws SQLException;
}
