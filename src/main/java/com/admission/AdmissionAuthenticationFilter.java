package com.admission;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/admission/*"})
public class AdmissionAuthenticationFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization code, if needed
    }

    public void doFilter(javax.servlet.ServletRequest servletRequest, javax.servlet.ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // Get the current session (create one if it doesn't exist)
        HttpSession session = request.getSession(true);

        // Check if the user has already entered signup information
        boolean hasSignedUp = session.getAttribute("hasSignedUp") != null;

        if (hasSignedUp) {
            // User has signed up, allow access to the admission page
            filterChain.doFilter(request, response);
        } else {
            // User has not signed up, redirect to the signup page
            response.sendRedirect(request.getContextPath() + "/signup.html");
        }
    }

    public void destroy() {
        // Cleanup code, if needed
    }
}
