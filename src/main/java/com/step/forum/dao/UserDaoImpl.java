package com.step.forum.dao;

import com.step.forum.constants.MessageConstants;
import com.step.forum.constants.UserConstants;
import com.step.forum.exceptions.UserCredentialsException;
import com.step.forum.model.Role;
import com.step.forum.model.User;
import com.step.forum.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    private final String GET_USER_BY_EMAIL_SQL = "select * from user where email = ?";

    @Override
    public User loginUser(String email, String password) throws UserCredentialsException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(GET_USER_BY_EMAIL_SQL);
            ps.setString(1, email);
            rs = ps.executeQuery();
            if (rs.next()){
                if (!password.equals(rs.getString("password"))){
                    throw new UserCredentialsException(MessageConstants.ERROR_INVALID_PASSWORD);
                }
                if (rs.getInt("status") != UserConstants.USER_STATUS_ACTIVE){
                    throw new UserCredentialsException(MessageConstants.ERROR_INACTIVE_ACCOUNT);
                }
                user = new User();
                user.setId(rs.getInt("id_user"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                Role role = new Role();
                role.setId(rs.getInt("id_role"));
                user.setRole(role);

            }else {
                throw new UserCredentialsException(MessageConstants.ERROR_INVALID_EMAIL);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new UserCredentialsException(MessageConstants.ERROR_INTERNAL);
        } finally {
            DbUtil.closeAll(con, ps, rs);
        }
        return user;
    }
}
