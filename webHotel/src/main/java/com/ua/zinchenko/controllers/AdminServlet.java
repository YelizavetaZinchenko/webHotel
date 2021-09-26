package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.impl.ApplicationDAOImpl;
import com.ua.zinchenko.db.dao.impl.RoomDAOImpl;
import com.ua.zinchenko.db.dao.impl.UserDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.entity.Application;
import com.ua.zinchenko.db.entity.Room;
import com.ua.zinchenko.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        UserDAOImpl userDAOImpl = new UserDAOImpl();
        RoomDAOImpl roomDAOImpl = new RoomDAOImpl();
        ApplicationDAOImpl applicationDAOImpl = new ApplicationDAOImpl();

        List<User> userList = userDAOImpl.getUserList();
        List<Room> roomList = roomDAOImpl.getRoomList();
        List<Application> applicationList = applicationDAOImpl.getApplicationList();

        req.setAttribute("roomList", roomList);
        req.setAttribute("userList", userList);
        req.setAttribute("applicationList", applicationList);

        req.getRequestDispatcher("/actionsOfAdmin.jsp").forward(req, resp);
    }
}
