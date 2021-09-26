package com.ua.zinchenko.db.dao;

import com.ua.zinchenko.db.entity.Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface ApplicationDAO {

    void insertApplication(Application application);

    List<Application> getApplicationList();

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);

    Application myResultSet(ResultSet resultSet);
}
