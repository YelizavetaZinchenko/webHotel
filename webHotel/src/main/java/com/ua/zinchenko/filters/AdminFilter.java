package com.ua.zinchenko.filters;

import com.ua.zinchenko.db.dao.UserDAO;
import com.ua.zinchenko.db.dao.request.Requests;
import com.ua.zinchenko.db.models.Room;
import com.ua.zinchenko.db.models.User;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class AdminFilter implements Filter {
    private final Logger logger = Logger.getLogger(AdminFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Start doFilter");

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();

        ServletContext servletContext = req.getServletContext();
        UserDAO userDAO = (UserDAO) servletContext.getAttribute("userDAO");

        int userId = Integer.parseInt(session.getAttribute("someID").toString());
        User user = userDAO.getUserById(userId);

        if (user.getAdmin()) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            req.getRequestDispatcher(Requests.ERRORS)
                    .forward(req, resp);
        }
        logger.info("Completed doFilter");
    }
}
