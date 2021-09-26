package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.impl.RoomDAOImpl;
import com.ua.zinchenko.db.dao.impl.UserDAOImpl;
import com.ua.zinchenko.db.dao.impl.UserRoomDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.entity.Room;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ProfileServlet extends HttpServlet {

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
        UserRoomDAOImpl permissionDAO = new UserRoomDAOImpl();

        HttpSession session = req.getSession();

        List<Room> roomList;
        int userId = Integer.parseInt(session.getAttribute("someID").toString());

        if (req.getParameter("roomId") != null) {
            int roomId = Integer.parseInt(req.getParameter("roomId"));
            permissionDAO.insertUserRoom(userId, roomId);
            permissionDAO.updateRoomOrderById(roomId);
        }

        roomList = roomDAOImpl.getRoomByUserId(userId);
        boolean isAdmin = userDAOImpl.getIsAdminById(userId);
        String userEmail = userDAOImpl.getEmailById(userId);

        req.setAttribute("roomList", roomList);
        req.setAttribute("isAdmin", isAdmin);

        req.setAttribute("userEmail", userEmail);
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
    }
}
