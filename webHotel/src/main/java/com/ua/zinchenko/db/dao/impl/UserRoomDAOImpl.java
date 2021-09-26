package com.ua.zinchenko.db.dao.impl;

import com.ua.zinchenko.db.dao.UserRoomDAO;
import com.ua.zinchenko.db.dao.connection.DBManager;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.entity.UserRoom;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoomDAOImpl implements UserRoomDAO {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    @Override
    public void insertUserRoom(int userId, int roomId) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.INSERT_INTO_USER_ROOM);
            preparedStatement.setInt(1, roomId);
            preparedStatement.setInt(2, userId);
            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
    }

    @Override
    public void updateRoomOrderById(int room_id) {
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.UPDATE_ROOM_ORDER_BY_ID);
            preparedStatement.setInt(1, room_id);
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
    public int getUserRoomIdByUserId(int userId) {
        int id = 0;
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_ID_USER_ROOM_BY_ROOM_ID);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id_permission");
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return id;
    }

    @Override
    public List<UserRoom> getUserRoomList() {
        List<UserRoom> userRoomList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_FROM_USER_ROOM);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                userRoomList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return userRoomList;
    }

    @Override
    public UserRoom myResultSet(ResultSet resultSet) {
        UserRoom userRoom = new UserRoom();
        try {
            userRoom.setId(resultSet.getInt("id_permission"));
            userRoom.setUser_id(resultSet.getInt("user_id"));
            userRoom.setRoom_id(resultSet.getInt("room_id"));
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
        return userRoom;
    }
}
