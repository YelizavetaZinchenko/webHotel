package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.request.Requests;
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


public class LocalizationServlet extends HttpServlet {

    private final Logger logger = Logger.getLogger(LocalizationServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("Start LocalizationServlet");
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        HttpSession session = req.getSession();
        session.setAttribute("language", req.getParameter("language"));
        resp.sendRedirect(req.getHeader("Referer"));
        logger.info("Completed LocalizationServlet");
    }
}
