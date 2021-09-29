package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.impl.UserDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.validation.Validation;
import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class LoginServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(LoginServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Start LoginServlet");
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        ServletContext servletContext = req.getServletContext();
        Validation validation = (Validation) servletContext.getAttribute("validation");
        UserDAOImpl userDAOImpl = (UserDAOImpl) servletContext.getAttribute("userDAO");
        HttpSession session = req.getSession();

        String email = req.getParameter("Email");
        String password = req.getParameter("Password");

        if (userDAOImpl.exists(email, password) && validation.validationForPassword(password)) {
            int userId = userDAOImpl.getUserIdByEmail(email);
            session.setAttribute("someID", userId);
            session.setAttribute("someName", userDAOImpl.getNameByEmail(email));
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
        logger.info("Completed LoginServlet");
    }
}