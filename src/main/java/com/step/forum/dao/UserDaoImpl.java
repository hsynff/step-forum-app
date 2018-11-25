package com.step.forum.dao;

import com.step.forum.constants.MessageConstants;
import com.step.forum.constants.UserConstants;
import com.step.forum.exceptions.UserCredentialsException;
import com.step.forum.model.Action;
import com.step.forum.model.Role;
import com.step.forum.model.User;
import com.step.forum.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final String GET_USER_COUNT_BY_EMAIL = "select count(*) from user where email = ?";
    private final String INSERT_NEW_USER_SQL = "insert into user(email, password, token, status, id_role, first_name, last_name, img) values (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String GET_USER_BY_EMAIL_SQL = "select * from user where email = ?";
    private final String GET_ACTION_LIST_BY_ROLE_ID_SQL = "select * from action a inner join role_action ra on a.id_action=ra.id_action where ra.id_role=?";

    @Override
    public User loginUser(String email, String password) throws UserCredentialsException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_USER_BY_EMAIL_SQL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (!password.equals(rs.getString("password"))) {
                    throw new UserCredentialsException(MessageConstants.ERROR_INVALID_PASSWORD);
                }
                if (rs.getInt("status") != UserConstants.USER_STATUS_ACTIVE) {
                    throw new UserCredentialsException(MessageConstants.ERROR_INACTIVE_ACCOUNT);
                }
                user = new User();
                user.setId(rs.getInt("id_user"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setImagePath(rs.getString("img"));
                Role role = new Role();
                role.setId(rs.getInt("id_role"));
                user.setRole(role);

            } else {
                throw new UserCredentialsException(MessageConstants.ERROR_INVALID_EMAIL);
            }
        } finally {
            DbUtil.closeAll(con, ps, rs);
        }
        return user;
    }

    @Override
    public void registerUser(User user) throws UserCredentialsException, SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            if (!isEmailValid(user.getEmail())) {
                throw new UserCredentialsException(MessageConstants.ERROR_DUPLICATE_EMAIL);
            }
            con = DbUtil.getConnection();
            ps = con.prepareStatement(INSERT_NEW_USER_SQL);
            ps.setString(1, user.getEmail());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getToken());
            ps.setInt(4, user.getStatus());
            ps.setInt(5, user.getRole().getId());
            ps.setString(6, user.getFirstName());
            ps.setString(7, user.getLastName());
            ps.setString(8, user.getImagePath());
            ps.executeUpdate();
        } finally {
            DbUtil.closeAll(con, ps);
        }
    }

    @Override
    public List<Action> getActionListByRoleId(int idRole) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Action> list = new ArrayList<>();
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_ACTION_LIST_BY_ROLE_ID_SQL);
            ps.setInt(1, idRole);
            rs = ps.executeQuery();
            while (rs.next()) {
                Action action = new Action();
                action.setId(rs.getInt("id_action"));
                action.setActionType(rs.getString("action_type"));
                list.add(action);

            }

        } finally {
            DbUtil.closeAll(con, ps, rs);
        }
        return list;
    }

    private boolean isEmailValid(String email) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean result = false;
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_USER_COUNT_BY_EMAIL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            result = rs.next();
        } finally {
            DbUtil.closeAll(con, ps);
        }
        return result;
    }

}
