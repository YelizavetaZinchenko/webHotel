package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.impl.RoomDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.entity.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class RoomServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        RoomDAOImpl roomDAOImpl = new RoomDAOImpl();
        List<Room> roomList = roomDAOImpl.getRoomList();
        String sort = req.getParameter("Sort");

        if (Objects.equals(sort, "Price")) {
            roomList = roomDAOImpl.getRoomListByPrice();
        } else if (Objects.equals(sort, "Amount Of Seats")) {
            roomList = roomDAOImpl.getRoomListBySeats();
        } else if (Objects.equals(sort, "Class Of Room")) {
            roomList = roomDAOImpl.getRoomListByClass();
        } else if (Objects.equals(sort, "Status Of Room")) {
            roomList = roomDAOImpl.getRoomListByStatus();
        }

        req.setAttribute("roomList", roomList);
        req.getRequestDispatcher("/book.jsp").forward(req, resp);
    }
}
