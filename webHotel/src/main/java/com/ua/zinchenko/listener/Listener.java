package com.ua.zinchenko.listener;

import com.ua.zinchenko.controllers.*;
import com.ua.zinchenko.db.dao.impl.*;
import com.ua.zinchenko.db.models.Application;
import com.ua.zinchenko.db.models.ConfirmationForAdmin;
import com.ua.zinchenko.db.models.User;
import com.ua.zinchenko.validation.Validation;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class Listener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        AdminServlet adminServlet = new AdminServlet();
        ApplicationServlet applicationServlet = new ApplicationServlet();
        ConfirmationOfAdminServlet confirmationOfAdminServlet = new ConfirmationOfAdminServlet();
        LoginServlet loginServlet = new LoginServlet();
        LogOutServlet logOutServlet = new LogOutServlet();
        ProfileServlet profileServlet = new ProfileServlet();
        RegistrationServlet registrationServlet = new RegistrationServlet();
        RoomServlet roomServlet = new RoomServlet();

        ApplicationDAOImpl applicationDAO = new ApplicationDAOImpl();
        ConfirmationForAdminDAOImpl confirmationForAdminDAO = new ConfirmationForAdminDAOImpl();
        RoomDAOImpl roomDAO = new RoomDAOImpl();
        UserDAOImpl userDAO = new UserDAOImpl();
        UserRoomDAOImpl userRoomDAO = new UserRoomDAOImpl();
        Validation validation = new Validation();

        Application application = new Application();
        User user = new User();
        ConfirmationForAdmin confirmationForAdmin = new ConfirmationForAdmin();

        servletContext.setAttribute("adminServlet", adminServlet);
        servletContext.setAttribute("applicationServlet", applicationServlet);
        servletContext.setAttribute("confirmationOfAdminServlet", confirmationOfAdminServlet);
        servletContext.setAttribute("loginServlet", loginServlet);
        servletContext.setAttribute("logOutServlet", logOutServlet);
        servletContext.setAttribute("profileServlet", profileServlet);
        servletContext.setAttribute("registrationServlet", registrationServlet);
        servletContext.setAttribute("roomServlet", roomServlet);

        servletContext.setAttribute("applicationDAO", applicationDAO);
        servletContext.setAttribute("confirmationForAdminDAO", confirmationForAdminDAO);
        servletContext.setAttribute("roomDAO", roomDAO);
        servletContext.setAttribute("userDAO", userDAO);
        servletContext.setAttribute("userRoomDAO", userRoomDAO);
        servletContext.setAttribute("validation", validation);

        servletContext.setAttribute("application", application);
        servletContext.setAttribute("user", user);
        servletContext.setAttribute("confirmationForAdmin", confirmationForAdmin);


    }
}
