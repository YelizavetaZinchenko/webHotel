package com.ua.zinchenko.db.dao;

import com.ua.zinchenko.db.entity.ConfirmationForAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public interface ConfirmationForAdminDAO {

    void insertConfirmationForAdmin(ConfirmationForAdmin confirmationForAdmin);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);

    ConfirmationForAdmin myResultSet(ResultSet resultSet);
}
