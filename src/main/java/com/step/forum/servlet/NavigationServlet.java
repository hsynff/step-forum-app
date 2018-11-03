package com.step.forum.servlet;

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


        if (action.equals("topic")) {
            String idT = request.getParameter("id");
            int idTopic = Integer.parseInt(idT);
            Topic topic = topicService.getTopicById(idTopic);
            request.setAttribute("topic", topic);
            topicService.updateTopicViewCount(idTopic);

            address = "/WEB-INF/view/topic.jsp";

        } else if (action.equals("new-topic")) {
            address = "/WEB-INF/view/new-topic.jsp";
        } else if (action.equals("new-account")) {
            address = "/WEB-INF/view/new-account.jsp";
        } else if (action.equals("login")) {
            address = "/WEB-INF/view/login.jsp";
        }


        if (address != null) {
            request.getRequestDispatcher(address).forward(request, response);
        }


    }
}
