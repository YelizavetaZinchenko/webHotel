package com.ua.zinchenko.controllers;

import com.ua.zinchenko.db.dao.impl.ConfirmationForAdminDAOImpl;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.entity.ConfirmationForAdmin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ConfirmationOfAdminServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(Requests.CP_1251);
        resp.setContentType(Requests.TEXT_HTML);

        ConfirmationForAdmin confirmationForAdmin = new ConfirmationForAdmin();
        ConfirmationForAdminDAOImpl confirmationForAdminDAO = new ConfirmationForAdminDAOImpl();

        int user_admin_id = Integer.parseInt(req.getParameter("user_admin_id"));
        int room_admin_id = Integer.parseInt(req.getParameter("room_admin_id"));

        confirmationForAdmin.setUser_admin_id(user_admin_id);
        confirmationForAdmin.setRoom_admin_id(room_admin_id);
        confirmationForAdminDAO.insertConfirmationForAdmin(confirmationForAdmin);

        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
