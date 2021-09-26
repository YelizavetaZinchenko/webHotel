package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.impl.UserDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        User user = new User();
        UserDAOImpl userDAO = new UserDAOImpl();

        String email = req.getParameter("Email");
        String name = req.getParameter("Name");
        String password = req.getParameter("Password");

        user.setEmail(email);
        user.setName(name);
        user.setAdmin(false);
        user.setPassword(password);
        userDAO.insertUser(user);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}