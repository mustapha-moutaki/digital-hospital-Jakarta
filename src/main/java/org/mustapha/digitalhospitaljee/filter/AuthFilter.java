package org.mustapha.digitalhospitaljee.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*") // Protect all routes
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        String path = req.getRequestURI();
        HttpSession session = req.getSession(false);

        // Allow login, register, and static files
        if (path.contains("login") || path.contains("LoginController") ||
                path.contains("css") || path.contains("js")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // Check if the user is logged in
        if (session == null || session.getAttribute("currentUserId") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // If logged in  continue
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
