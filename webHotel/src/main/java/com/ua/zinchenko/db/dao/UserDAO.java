package com.ua.zinchenko.db.dao;

import com.ua.zinchenko.db.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface UserDAO {

    void insertUser(User user);

    List<User> getUserList();

    User myResultSet(ResultSet resultSet);

    int getUserIdByEmail(String email);

    String getEmailById(int id);

    String getNameByEmail(String email);

    boolean getIsAdminById(int id);

    boolean exists(String name, String pass);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);
}
