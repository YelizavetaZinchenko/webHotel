package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.impl.ApplicationDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.models.Application;
import com.ua.zinchenko.validation.Validation;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class ApplicationServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(ApplicationServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Start ApplicationServlet");
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        ServletContext servletContext = req.getServletContext();
        Validation validation = (Validation) servletContext.getAttribute("validation");
        Application application = (Application) servletContext.getAttribute("application");
        ApplicationDAOImpl applicationDAO = (ApplicationDAOImpl) servletContext.getAttribute("applicationDAO");

        double price = Double.parseDouble(req.getParameter("price"));
        int amountOfSeats = Integer.parseInt(req.getParameter("amountOfSeats"));
        String classOfRoom = req.getParameter("classOfRoom");
        String statusOfRoom = req.getParameter("statusOfRoom");

        if (validation.validationForClassInApplication(classOfRoom) && validation.validationForStatusInApplication(statusOfRoom)) {
            application.setPrice(price);
            application.setAmountOfSeats(amountOfSeats);
            application.setClassOfRoom(classOfRoom);
            application.setStatusOfRoom(statusOfRoom);
            applicationDAO.insertApplication(application);
            req.getRequestDispatcher("RoomServlet").forward(req, resp);
        } else {
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
        logger.info("Completed ApplicationServlet");
    }
}
