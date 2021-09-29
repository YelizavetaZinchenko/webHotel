package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.impl.ApplicationDAOImpl;
import com.ua.zinchenko.db.dao.impl.RoomDAOImpl;
import com.ua.zinchenko.db.dao.impl.UserDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.models.Application;
import com.ua.zinchenko.db.models.Room;
import com.ua.zinchenko.db.models.User;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class AdminServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(AdminServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        logger.info("Start AdminServlet");
        ServletContext servletContext = req.getServletContext();
        UserDAOImpl userDAOImpl = (UserDAOImpl) servletContext.getAttribute("userDAO");
        RoomDAOImpl roomDAOImpl = (RoomDAOImpl) servletContext.getAttribute("roomDAO");
        ApplicationDAOImpl applicationDAOImpl = (ApplicationDAOImpl) servletContext.getAttribute("applicationDAO");

        List<User> userList = userDAOImpl.getUserList();
        List<Room> roomList = roomDAOImpl.getRoomList();
        List<Application> applicationList = applicationDAOImpl.getApplicationList();

        req.setAttribute("roomList", roomList);
        req.setAttribute("userList", userList);
        req.setAttribute("applicationList", applicationList);

        req.getRequestDispatcher("/actionsOfAdmin.jsp").forward(req, resp);
        logger.info("Completed AdminServlet");
    }
}
