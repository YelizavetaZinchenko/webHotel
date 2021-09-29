package com.ua.zinchenko.db.dao;

import com.ua.zinchenko.db.models.ConfirmationForAdmin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public interface ConfirmationForAdminDAO {

    void deleteFieldFromTableByUserId(int userId);

    void insertConfirmationForAdmin(ConfirmationForAdmin confirmationForAdmin);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);

    ConfirmationForAdmin myResultSet(ResultSet resultSet);
}
