package com.ua.zinchenko.filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by Zinchenko Yelizaveta on 30.09.2021.
 */

public class EncodingFilter implements Filter {
    private final Logger logger = Logger.getLogger(EncodingFilter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("Start doFilter");

        servletRequest.setCharacterEncoding("cp1251");
        servletResponse.setContentType("text/html");

        filterChain.doFilter(servletRequest, servletResponse);
        logger.info("Completed doFilter");
    }
}
