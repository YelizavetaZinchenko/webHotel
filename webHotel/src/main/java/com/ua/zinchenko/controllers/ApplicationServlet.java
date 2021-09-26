package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.impl.ApplicationDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.entity.Application;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ApplicationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        Application application = new Application();
        ApplicationDAOImpl applicationDAO = new ApplicationDAOImpl();

        double price = Double.parseDouble(req.getParameter("price"));
        int amountOfSeats = Integer.parseInt(req.getParameter("amountOfSeats"));
        String classOfRoom = req.getParameter("classOfRoom");
        String statusOfRoom = req.getParameter("statusOfRoom");

        application.setPrice(price);
        application.setAmountOfSeats(amountOfSeats);
        application.setClassOfRoom(classOfRoom);
        application.setStatusOfRoom(statusOfRoom);
        applicationDAO.insertApplication(application);

        req.getRequestDispatcher("RoomServlet").forward(req, resp);
    }
}
