package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.ConfirmationForAdminDAO;
import com.ua.zinchenko.db.dao.impl.RoomDAOImpl;
import com.ua.zinchenko.db.dao.impl.UserDAOImpl;
import com.ua.zinchenko.db.dao.impl.UserRoomDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.models.Room;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class ProfileServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(ProfileServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Start ProfileServlet");
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        ServletContext servletContext = req.getServletContext();
        UserDAOImpl userDAOImpl = (UserDAOImpl) servletContext.getAttribute("userDAO");
        RoomDAOImpl roomDAOImpl = (RoomDAOImpl) servletContext.getAttribute("roomDAO");
        UserRoomDAOImpl userRoomDAO = (UserRoomDAOImpl) servletContext.getAttribute("userRoomDAO");
        ConfirmationForAdminDAO confirmationForAdminDAO = (ConfirmationForAdminDAO) servletContext.getAttribute("confirmationForAdminDAO");

        HttpSession session = req.getSession();

        int userId = Integer.parseInt(session.getAttribute("someID").toString());
        List<Room> roomList;
        List<Room> tmpRoomList = roomDAOImpl.getRoomByUserId(userId);

        if (req.getParameter("suggestedRoomId") != null) {
            int roomId = Integer.parseInt(req.getParameter("suggestedRoomId"));
            userRoomDAO.insertUserRoom(userId, roomId);
            userRoomDAO.updateRoomOrderById(roomId);

            confirmationForAdminDAO.deleteFieldFromTableByUserId(userId);
        }

        if (req.getParameter("roomId") != null) {
            int roomId = Integer.parseInt(req.getParameter("roomId"));
            userRoomDAO.insertUserRoom(userId, roomId);
            userRoomDAO.updateRoomOrderById(roomId);
        }

        if (Boolean.parseBoolean(req.getParameter("billPayment"))) {
            for (Room room : tmpRoomList) {
                userRoomDAO.updateBillOfRoomsById(room.getId());
            }
        }

        Room suggestedRoom = roomDAOImpl.getSuggestedRoomByUserId(userId);
        roomList = roomDAOImpl.getRoomByUserId(userId);
        boolean isAdmin = userDAOImpl.getIsAdminById(userId);
        String userEmail = userDAOImpl.getEmailById(userId);
        boolean bill = true;

        for (Room room : roomList) {
            if (!room.isBill()) {
                bill = false;
                break;
            }
        }

        req.setAttribute("bill", bill);
        req.setAttribute("roomList", roomList);
        req.setAttribute("isAdmin", isAdmin);
        req.setAttribute("suggestedRoom", suggestedRoom);
        req.setAttribute("userEmail", userEmail);
        req.getRequestDispatcher("/profile.jsp").forward(req, resp);
        logger.info("Completed ProfileServlet");
    }
}
