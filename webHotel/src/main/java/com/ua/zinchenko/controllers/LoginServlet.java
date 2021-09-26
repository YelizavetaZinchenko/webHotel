package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.impl.UserDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        String email = req.getParameter("Email");
        String password = req.getParameter("Password");

        UserDAOImpl userDAOImpl = new UserDAOImpl();
        HttpSession session = req.getSession();

        if (userDAOImpl.exists(email, password)) {
            int userId = userDAOImpl.getUserIdByEmail(email);
            session.setAttribute("someID", userId);
            session.setAttribute("someName", userDAOImpl.getNameByEmail(email));
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}