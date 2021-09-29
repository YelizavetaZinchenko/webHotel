package com.ua.zinchenko.db.dao.impl;

import com.ua.zinchenko.db.dao.RoomDAO;
import com.ua.zinchenko.db.connection.DBManager;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.models.Room;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class RoomDAOImpl implements RoomDAO {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;
    private final Logger logger = Logger.getLogger(RoomDAOImpl.class);

    /**
     * Gets suggested rooms sorted by user's id
     */
    @Override
    public Room getSuggestedRoomByUserId(int userId) {
        logger.info("Start getSuggestedRoomByUserId");
        Room room = new Room();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_SUGGESTED_ROOMS_BY_ID);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                room.setId(rs.getInt("id_room"));
                room.setPrice(rs.getDouble("price"));
                room.setAmountOfSeats(rs.getInt("amountOfSeats"));
                room.setClassOfRoom(rs.getString("classOfRoom"));
                room.setStatusOfRoom(rs.getString("statusOfRoom"));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        logger.info("Completed getSuggestedRoomByUserId");
        return room;
    }

    @Override
    public Room getBillStatusById(int userId) {
        logger.info("Start getBillStatusById");
        Room room = new Room();
        try {
            connection = DBManager.getConnection();
            preparedStatement = connection.prepareStatement(Requests.SELECT_BILL_STATUS_BY_ID);
            preparedStatement.setInt(1, userId);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                room.setBill(rs.getBoolean("bill"));
            }
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        } finally {
            closing(connection, preparedStatement, rs);
        }
        logger.info("Completed getBillStatusById");
        return room;
    }


    /**
     * Gets rooms sorted by price option
     */
    @Override
    public List<Room> getRoomByPrice(double price) {
        logger.info("Start getRoomByPrice");
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
        logger.info("Completed getRoomByPrice");
        return roomList;
    }

    /**
     * Gets rooms sorted by amountOfSeats option
     */
    @Override
    public List<Room> getRoomByAmountOfSeats(int amountOfSeats) {
        logger.info("Start getRoomByAmountOfSeats");
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
        logger.info("Completed getRoomByAmountOfSeats");
        return roomList;
    }

    /**
     * Gets rooms sorted by ClassOfRoom option
     */
    @Override
    public List<Room> getRoomByClass(String classOfRoom) {
        logger.info("Start getRoomByClass");
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
        logger.info("Completed getRoomByClass");
        return roomList;
    }

    /**
     * Gets list of rooms
     */
    @Override
    public List<Room> getRoomList() {
        logger.info("Start getRoomList");
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
        logger.info("Completed getRoomList");
        return roomList;
    }

    /**
     * Gets list of rooms sorted by price option
     */
    @Override
    public List<Room> getRoomListByPrice() {
        logger.info("Start getRoomListByPrice");
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
        logger.info("Completed getRoomListByPrice");
        return roomList;
    }

    /**
     * Gets  list of rooms sorted by amountOfSeats option
     */

    public static void main(String[] args) {
        System.out.println(new RoomDAOImpl().getRoomListBySeats());
    }

    @Override
    public List<Room> getRoomListBySeats() {
        logger.info("Start getRoomListBySeats");
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
        logger.info("Completed getRoomListBySeats");
        return roomList;
    }

    /**
     * Gets rooms sorted by user's id
     */

    @Override
    public List<Room> getRoomByUserId(int userId) {
        logger.info("Start getRoomByUserId");
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
        logger.info("Completed getRoomByUserId");
        return roomList;
    }

    /**
     * Gets list of rooms sorted by statusOfRoom option
     */

    @Override
    public List<Room> getRoomListByStatus() {
        logger.info("Start getRoomListByStatus");
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
        logger.info("Completed getRoomListByStatus");
        return roomList;
    }

    /**
     * Gets list of rooms sorted by classOfRoom option
     */

    @Override
    public List<Room> getRoomListByClass() {
        logger.info("Start getRoomListByClass");
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
        logger.info("Completed getRoomListByClass");
        return roomList;
    }

    /**
     * Method made for pagination
     */

    @Override
    public List<Integer> setPageList(List<Room> roomList, String amount) {
        logger.info("Start setPageList");
        List<Integer> pageList = new ArrayList<>();
        if (!Objects.equals(amount, null)) {
            int roomAmount = Integer.parseInt(amount);
            if (roomAmount % 2 != 0 && roomAmount > 1) {
                for (int i = 0; i < roomList.size() / roomAmount; i++) {
                    pageList.add(i + 1);
                }
                pageList.add(pageList.size() + 1);
            } else {
                for (int i = 0; i < roomList.size() / roomAmount; i++) {
                    pageList.add(i + 1);
                }
            }
        }
        logger.info("Completed setPageList");
        return pageList;
    }

    /**
     * Gets rooms sorted by statusOfRoom option
     */

    @Override
    public List<Room> getRoomByStatus(String statusOfRoom) {
        logger.info("Start getRoomByStatus");
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
        logger.info("Completed getRoomByStatus");
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
            room.setBill(resultSet.getBoolean("bill"));
        } catch (SQLException sqlException) {
            Logger.getLogger(sqlException.getMessage());
        }
        return room;
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
}
