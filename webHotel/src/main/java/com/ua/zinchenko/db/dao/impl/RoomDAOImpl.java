package com.ua.zinchenko.db.dao.impl;

import com.ua.zinchenko.db.dao.RoomDAO;
import com.ua.zinchenko.db.dao.connection.DBManager;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.entity.Room;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    @Override
    public List<Room> getRoomByPrice(double price) {
        List<Room> roomList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_FROM_ROOM_BY_PRICE);
            preparedStatement.setDouble(1, price);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                roomList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return roomList;
    }

    @Override
    public List<Room> getRoomByAmountOfSeats(int amountOfSeats) {
        List<Room> roomList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_FROM_ROOM_BY_SEATS);
            preparedStatement.setInt(1, amountOfSeats);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                roomList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return roomList;
    }

    @Override
    public List<Room> getRoomByClass(String classOfRoom) {
        List<Room> roomList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_FROM_ROOM_BY_CLASS);
            preparedStatement.setString(1, classOfRoom);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                roomList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return roomList;
    }

    @Override
    public List<Room> getRoomList() {
        List<Room> roomList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_FROM_ROOM);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                roomList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return roomList;
    }

    @Override
    public List<Room> getRoomListByPrice() {
        List<Room> roomList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_FROM_ROOM_BY_PRICE);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                roomList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return roomList;
    }

    @Override
    public List<Room> getRoomListBySeats() {
        List<Room> roomList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_FROM_ROOM_BY_SEATS);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                roomList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return roomList;
    }

    @Override
    public List<Room> getRoomByUserId(int userId) {
        List<Room> roomList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_ROOMS_BY_USER_ID);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                roomList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return roomList;
    }

    @Override
    public List<Room> getRoomListByStatus() {
        List<Room> roomList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_FROM_ROOM_BY_STATUS);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                roomList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return roomList;
    }

    @Override
    public List<Room> getRoomListByClass() {
        List<Room> roomList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_FROM_ROOM_BY_CLASS);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                roomList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return roomList;
    }

    @Override
    public List<Room> getRoomByStatus(String statusOfRoom) {
        List<Room> roomList = new ArrayList<>();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_FROM_ROOM_BY_STATUS);
            preparedStatement.setString(1, statusOfRoom);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                roomList.add(myResultSet(rs));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        return roomList;
    }

    @Override
    public Room myResultSet(ResultSet resultSet) {
        Room room = new Room();
        try {
            room.setId(resultSet.getInt("id_room"));
            room.setPrice(resultSet.getDouble("price"));
            room.setAmountOfSeats(resultSet.getInt("amountOfSeats"));
            room.setClassOfRoom(resultSet.getString("classOfRoom"));
            room.setStatusOfRoom(resultSet.getString("statusOfRoom"));
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
        return room;
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
}
