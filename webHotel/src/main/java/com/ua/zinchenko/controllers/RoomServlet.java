package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.impl.RoomDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.models.Room;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class RoomServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(RoomServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Start RoomServlet");
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        ServletContext servletContext = req.getServletContext();
        RoomDAOImpl roomDAOImpl = (RoomDAOImpl) servletContext.getAttribute("roomDAO");
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

        int amountOfRooms = roomDAOImpl.getRoomList().size();
        int amount = 3;
        List<Integer> pageList = roomDAOImpl.setPageList(roomList, String.valueOf(amount));
        req.setAttribute("pageList", pageList);


        if (req.getParameter("page") != null) {
            int amountOfRoomsOnPage = (Integer.parseInt(req.getParameter("page")) - 1) * amount;
            if (amountOfRoomsOnPage > 0) {
                roomList.subList(0, amountOfRoomsOnPage).clear();
            }
            if (amount > roomList.size()) {
                amount = roomList.size();
            }
        }

        req.setAttribute("Amount", amount);
        req.setAttribute("roomAmount", amountOfRooms);
        req.setAttribute("roomList", roomList);
        req.getRequestDispatcher("/book.jsp").forward(req, resp);
        logger.info("Completed RoomServlet");
    }
}
