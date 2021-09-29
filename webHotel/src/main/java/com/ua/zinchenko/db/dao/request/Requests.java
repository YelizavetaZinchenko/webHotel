package com.ua.zinchenko.db.dao.request;

public final class Requests {

    public static final String CP_1251 = "cp1251";
    public static final String TEXT_HTML = "text/html";
    public static final String ERRORS = "/errors.jsp";

    public static final String INSERT_USER = "INSERT INTO user (email, name, isAdmin, password) VALUES (?, ?, ?, ?)";
    public static final String VALIDATION_OF_USER = "SELECT * FROM user WHERE email = ? AND password = ?";
    public static final String SELECT_FROM_USER = "SELECT* FROM user";
    public static final String GET_ID_BY_EMAIL = "SELECT id_user FROM user WHERE email = ?";
    public static final String GET_EMAIL_BY_ID = "SELECT email FROM user WHERE id_user = ?";
    public static final String GET_IS_ADMIN_BY_ID = "SELECT isAdmin FROM user WHERE id_user = ?";
    public static final String GET_NAME_BY_EMAIL = "SELECT name FROM user WHERE email = ?";
    public static final String GET_USER_BY_ID = "SELECT* FROM user WHERE id_user = ?";


    public static final String SELECT_FROM_ROOM = "SELECT* FROM room";
    public static final String SELECT_SUGGESTED_ROOMS_BY_ID = "SELECT * FROM room WHERE id_room IN (SELECT room_admin_id FROM confirmationForAdmin WHERE user_admin_id = ?);";
    public static final String SELECT_FROM_ROOM_BY_PRICE = "SELECT* FROM room ORDER BY price  DESC";
    public static final String SELECT_FROM_ROOM_BY_SEATS = "SELECT* FROM room ORDER BY amountOfSeats DESC";
    public static final String SELECT_FROM_ROOM_BY_CLASS = "SELECT* FROM room ORDER BY classOfRoom DESC";
    public static final String SELECT_FROM_ROOM_BY_STATUS = "SELECT* FROM room ORDER BY statusOfRoom DESC";
    public static final String UPDATE_ROOM_ORDER_BY_ID = "UPDATE room SET statusOfRoom = 'booked' WHERE id_room = ?";

    public static final String INSERT_INTO_USER_ROOM = "INSERT INTO userRoom (room_id, user_id) VALUES (?, ?)";
    public static final String SELECT_ID_USER_ROOM_BY_ROOM_ID = "SELECT id_userRoom FROM userRoom WHERE user_id = ?";
    public static final String SELECT_FROM_USER_ROOM = "SELECT* FROM userRoom";
    public static final String SELECT_ROOMS_BY_USER_ID = "SELECT * FROM room WHERE id_room IN (SELECT room_id FROM userRoom WHERE user_id = ?);";

    public static final String INSERT_APPLICATION = "INSERT INTO application (price, amountOfSeats, classOfRoom, statusOfRoom) VALUES (?, ?, ?, ?)";
    public static final String SELECT_FROM_APPLICATION = "SELECT* FROM application";

    public static final String INSERT_INTO_CONFIRMATION_FOR_ADMIN = "INSERT INTO confirmationForAdmin (room_admin_id, user_admin_id) VALUES (?, ?)";
    public static final String DELETE_FROM_CONFIRMATION_FOR_ADMIN_BY_USER_ID = "DELETE FROM confirmationForAdmin WHERE user_admin_id = ?";

    public Requests() {
    }
}
