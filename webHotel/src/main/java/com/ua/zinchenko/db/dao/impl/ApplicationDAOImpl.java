package com.ua.zinchenko.db.dao.impl;

import com.ua.zinchenko.db.dao.ApplicationDAO;
import com.ua.zinchenko.db.dao.connection.DBManager;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.entity.Application;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ApplicationDAOImpl implements ApplicationDAO {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet rs = null;

    @Override
    public void insertApplication(Application application) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.INSERT_APPLICATION);
            preparedStatement.setDouble(1, application.getPrice());
            preparedStatement.setInt(2, application.getAmountOfSeats());
            preparedStatement.setString(3, application.getClassOfRoom());
            preparedStatement.setString(4, application.getStatusOfRoom());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
    }

    @Override
    public List<Application> getApplicationList() {
        List<Application> applicationList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_FROM_APPLICATION);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                applicationList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return applicationList;
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
    public Application myResultSet(ResultSet resultSet) {
        Application application = new Application();
        try {
            application.setId(resultSet.getInt("id_application"));
            application.setPrice(resultSet.getDouble("price"));
            application.setAmountOfSeats(resultSet.getInt("amountOfSeats"));
            application.setClassOfRoom(resultSet.getString("classOfRoom"));
            application.setStatusOfRoom(resultSet.getString("statusOfRoom"));
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
        return application;
    }
}
