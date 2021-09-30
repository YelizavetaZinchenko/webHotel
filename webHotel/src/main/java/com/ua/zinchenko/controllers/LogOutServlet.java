package com.ua.zinchenko.controllers;

import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class LogOutServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(LogOutServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Start LogOutServlet");
        HttpSession session = req.getSession();
        session.removeAttribute("someID");
        session.removeAttribute("someName");

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
        logger.info("Completed LogOutServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
