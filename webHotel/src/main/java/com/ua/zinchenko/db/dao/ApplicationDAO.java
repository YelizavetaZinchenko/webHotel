package com.ua.zinchenko.db.dao;

import com.ua.zinchenko.db.models.Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public interface ApplicationDAO {

    void insertApplication(Application application);

    List<Application> getApplicationList();

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);

    Application myResultSet(ResultSet resultSet);
}
