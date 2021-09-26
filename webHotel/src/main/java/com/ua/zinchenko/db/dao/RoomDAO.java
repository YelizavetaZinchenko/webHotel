package com.ua.zinchenko.db.dao;

import com.ua.zinchenko.db.entity.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public interface RoomDAO {

    List<Room> getRoomByUserId(int userId);

    List<Room> getRoomByPrice(double price);

    List<Room> getRoomByAmountOfSeats(int amountOfSeats);

    List<Room> getRoomByClass(String classOfRoom);

    List<Room> getRoomByStatus(String statusOfRoom);

    List<Room> getRoomList();

    List<Room> getRoomListByPrice();

    List<Room> getRoomListBySeats();

    List<Room> getRoomListByStatus();

    List<Room> getRoomListByClass();

    Room myResultSet(ResultSet resultSet);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);
}
