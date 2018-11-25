package com.step.forum.servlet;

import com.step.forum.constants.NavigationConstants;
import com.step.forum.dao.TopicDaoImpl;
import com.step.forum.model.Topic;
import com.step.forum.service.TopicService;
import com.step.forum.service.TopicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "NavigationServlet", urlPatterns = "/ns")
public class NavigationServlet extends HttpServlet {
    private TopicService topicService = new TopicServiceImpl(new TopicDaoImpl());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(response, request);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(response, request);
    }

    private void processRequest(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        String action = null;
        String address = null;


        if (request.getParameter("action") != null) {
            action = request.getParameter("action");
        } else {
            response.sendRedirect("/");
            return;
        }


        if (action.equals(NavigationConstants.ACTION_TOPIC)) {
            String idT = request.getParameter("id");
            int idTopic = Integer.parseInt(idT);
            Topic topic = null;
            try {
                topic = topicService.getTopicById(idTopic);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (topic == null){
                response.sendRedirect("/");
                return;
            }
            request.setAttribute("topic", topic);
            try {
                topicService.updateTopicViewCount(idTopic);
            } catch (SQLException e) {
                e.printStackTrace();
            }

            address = NavigationConstants.PAGE_TOPIC;

        } else if (action.equals(NavigationConstants.ACTION_NEW_TOPIC)) {
            address = NavigationConstants.PAGE_NEW_TOPIC;
        } else if (action.equals(NavigationConstants.ACTION_NEW_ACCOUNT)) {
            address = NavigationConstants.PAGE_NEW_ACCOUNT;
        } else if (action.equals(NavigationConstants.ACTION_LOGIN)) {
            address = NavigationConstants.PAGE_LOGIN;
        }


        if (address != null) {
            request.getRequestDispatcher(address).forward(request, response);
        }


    }
}
