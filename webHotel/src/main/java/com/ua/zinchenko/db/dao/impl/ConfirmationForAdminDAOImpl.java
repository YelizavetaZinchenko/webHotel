package com.ua.zinchenko.db.dao.impl;

import com.ua.zinchenko.db.dao.ConfirmationForAdminDAO;
import com.ua.zinchenko.db.dao.connection.DBManager;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.entity.ConfirmationForAdmin;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConfirmationForAdminDAOImpl implements ConfirmationForAdminDAO {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;


    @Override
    public void insertConfirmationForAdmin(ConfirmationForAdmin confirmationForAdmin) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.INSERT_INTO_CONFIRMATION_FOR_ADMIN);
            preparedStatement.setInt(1, confirmationForAdmin.getRoom_admin_id());
            preparedStatement.setInt(2, confirmationForAdmin.getUser_admin_id());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
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

    @Override
    public ConfirmationForAdmin myResultSet(ResultSet resultSet) {
        ConfirmationForAdmin confirmationForAdmin = new ConfirmationForAdmin();
        try {
            confirmationForAdmin.setId_confirmationForAdmin(resultSet.getInt("id_confirmationForAdmin"));
            confirmationForAdmin.setUser_admin_id(resultSet.getInt("user_admin_id"));
            confirmationForAdmin.setRoom_admin_id(resultSet.getInt("room_admin_id"));
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
        return confirmationForAdmin;
    }
}
