package com.ua.zinchenko.db.dao.impl;

import com.ua.zinchenko.db.dao.ApplicationDAO;
import com.ua.zinchenko.db.connection.DBManager;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.models.Application;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class ApplicationDAOImpl implements ApplicationDAO {

    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;
    private static ResultSet rs = null;
    private final Logger logger = Logger.getLogger(ApplicationDAOImpl.class);

    /**
     * Gets the options in the Application table that based in MySQL
     */
    @Override
    public void insertApplication(Application application) {
        logger.info("Start insertApplication");
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.INSERT_APPLICATION);
            preparedStatement.setInt(1, application.getUser_id());
            preparedStatement.setDouble(2, application.getPrice());
            preparedStatement.setInt(3, application.getAmountOfSeats());
            preparedStatement.setString(4, application.getClassOfRoom());
            preparedStatement.setString(5, application.getStatusOfRoom());
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        logger.info("Сompleted insertApplication");
    }

    /**
     * Gets the Application list
     */
    @Override
    public List<Application> getApplicationList() {
        logger.info("Start getApplicationList");
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
        logger.info("Completed getApplicationList");
        return applicationList;
    }

    /**
     * Closes connection, resultSet and preparedStatement
     */

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
            application.setUser_id(resultSet.getInt("user_id"));
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
