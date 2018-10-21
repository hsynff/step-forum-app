package com.step.forum.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "NavigationServlet", urlPatterns = "/ns")
public class NavigationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(response, request);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(response, request);
    }

    private void processRequest(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        String action = null;
        String address = null;

        if (request.getParameter("action") != null){
            action = request.getParameter("action");
        }else{
            response.sendRedirect("/");
            return;
        }


        if (action.equals("topic")){
            address = "/WEB-INF/view/topic.jsp";
        }else if (action.equals("new-topic")){
            address = "/WEB-INF/view/new-topic.jsp";
        }else if (action.equals("new-account")){
            address = "/WEB-INF/view/new-account.jsp";
        }


        if (address != null){
            request.getRequestDispatcher(address).forward(request, response);
        }


    }
}
