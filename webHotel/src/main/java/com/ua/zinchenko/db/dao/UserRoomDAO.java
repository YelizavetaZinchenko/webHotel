package com.ua.zinchenko.db.dao;

import com.ua.zinchenko.db.entity.UserRoom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface UserRoomDAO {

    void insertUserRoom(int userId, int roomId);

    void updateRoomOrderById(int room_id);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);

    int getUserRoomIdByUserId(int userId);

    List<UserRoom> getUserRoomList();

    UserRoom myResultSet(ResultSet resultSet);
}
