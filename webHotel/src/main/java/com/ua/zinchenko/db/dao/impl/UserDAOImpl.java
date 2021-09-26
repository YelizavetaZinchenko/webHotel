package com.ua.zinchenko.db.dao.impl;

import com.ua.zinchenko.db.dao.UserDAO;
import com.ua.zinchenko.db.dao.connection.DBManager;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet rs = null;


    @Override
    public void insertUser(User user) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.INSERT_USER);
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setBoolean(3, user.getAdmin());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
    }

    @Override
    public List<User> getUserList() {
        List<User> userList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_FROM_USER);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return userList;
    }

    @Override
    public User myResultSet(ResultSet resultSet) {
        User user = new User();
        try {
            user.setId(resultSet.getInt("id_user"));
            user.setEmail(resultSet.getString("email"));
            user.setName(resultSet.getString("name"));
            user.setAdmin(resultSet.getBoolean("admin"));
            user.setPassword(resultSet.getString("password"));
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
        return user;
    }

    @Override
    public int getUserIdByEmail(String email) {
        int id = 0;
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.GET_ID_BY_EMAIL);
            preparedStatement.setString(1, email);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_user");
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return id;
    }

    @Override
    public String getEmailById(int id) {
        String email = null;
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.GET_EMAIL_BY_ID);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                email = rs.getString("email");
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return email;
    }


    @Override
    public String getNameByEmail(String email) {
        String name = null;
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.GET_NAME_BY_EMAIL);
            preparedStatement.setString(1, email);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                name = rs.getString("name");
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return name;
    }

    @Override
    public boolean getIsAdminById(int id) {
        boolean isAdmin = false;
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.GET_IS_ADMIN_BY_ID);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                isAdmin = rs.getBoolean("isAdmin");
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return isAdmin;
    }

    @Override
    public boolean exists(String email, String pass) {
        boolean status = false;
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.VALIDATION_OF_USER);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, pass);
            rs = preparedStatement.executeQuery();
            status = rs.next();
        } catch (Exception e) {
            Logger.getLogger(e.getMessage());
        }
        return status;
    }

    @Override
    public void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                preparedStatement.close();
                connection.close();
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
    }
}
