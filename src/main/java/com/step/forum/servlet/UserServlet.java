package com.step.forum.servlet;

import com.step.forum.constants.MessageConstants;
import com.step.forum.dao.UserDaoImpl;
import com.step.forum.exceptions.UserCredentialsException;
import com.step.forum.model.User;
import com.step.forum.service.UserService;
import com.step.forum.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserServlet", urlPatterns = "/us")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserServiceImpl(new UserDaoImpl());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = null;
        String address = null;
        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        } else {
            response.sendRedirect("/");
            return;
        }

        if (action.equals("doLogin")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            try {
                User user = userService.loginUser(email, password);

                request.getSession().setAttribute("user", user);
                response.sendRedirect("/");

            } catch (UserCredentialsException e) {
                request.setAttribute("message", e.getMessage());
                address = "/WEB-INF/view/login.jsp";
            }

        }else if (action.equals("logout")){
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            session.invalidate();
            response.sendRedirect("/");
        }

        if (address != null) {
            request.getRequestDispatcher(address).forward(request, response);
        }


    }
}
