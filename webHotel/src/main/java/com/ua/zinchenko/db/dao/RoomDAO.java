package com.ua.zinchenko.db.dao;

import com.ua.zinchenko.db.models.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public interface RoomDAO {


    Room getSuggestedRoomByUserId(int userId);

    Room getBillStatusById(int userId);

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

    List<Integer> setPageList(List<Room> roomList, String amount);

    Room myResultSet(ResultSet resultSet);

    void closing(Connection connection, PreparedStatement preparedStatement, ResultSet rs);
}
