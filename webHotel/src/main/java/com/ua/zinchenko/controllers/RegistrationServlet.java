package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.impl.UserDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.models.User;
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

public class RegistrationServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(RegistrationServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Start RegistrationServlet");
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        ServletContext servletContext = req.getServletContext();
        Validation validation = (Validation) servletContext.getAttribute("validation");
        User user = (User) servletContext.getAttribute("user");
        UserDAOImpl userDAO = (UserDAOImpl) servletContext.getAttribute("userDAO");

        String email = req.getParameter("Email");
        String name = req.getParameter("Name");
        String password = req.getParameter("Password");

        if (validation.validationForPassword(password) && validation.validationForName(name)) {
            user.setEmail(email);
            user.setName(name);
            user.setAdmin(false);
            user.setPassword(password);
            userDAO.insertUser(user);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/signin.jsp").forward(req, resp);
        }
        logger.info("Completed RegistrationServlet");
    }
}