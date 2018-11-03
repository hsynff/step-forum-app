package com.step.forum.servlet;

import com.mysql.cj.xdevapi.JsonArray;
import com.step.forum.constants.MessageConstants;
import com.step.forum.dao.TopicDaoImpl;
import com.step.forum.job.PopularTopicsUpdater;
import com.step.forum.model.Topic;
import com.step.forum.model.User;
import com.step.forum.service.TopicService;
import com.step.forum.service.TopicServiceImpl;
import org.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@WebServlet(name = "TopicServlet", urlPatterns = "/ts")
public class TopicServlet extends HttpServlet {

    private TopicService topicService = new TopicServiceImpl(new TopicDaoImpl());
    private PopularTopicsUpdater updater;

    @Override
    public void init() throws ServletException {
        updater = new PopularTopicsUpdater(topicService);
        updater.startJob();
    }

    @Override
    public void destroy() {
        updater.stopJob();
    }

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


        if (action.equals("getPopularTopics")) {
            List<Topic> listTopics = updater.getPopularTopics();
            JSONArray jsonArray = new JSONArray(listTopics);
            response.setContentType("application/json");
            response.getWriter().write(jsonArray.toString());
        } else if (action.equals("addNewTopic")) {
            String title = request.getParameter("title");
            String desc = request.getParameter("desc");
            User user = (User) request.getSession().getAttribute("user");

            Topic topic = new Topic();
            topic.setTitle(title);
            topic.setDesc(desc);
            topic.setShareDate(LocalDateTime.now());
            topic.setViewCount(0);
            topic.setUser(user);
            topicService.addTopic(topic);
            request.getSession().setAttribute("message", MessageConstants.SUCCESS_ADD_TOPIC);
            response.sendRedirect("/");


        }else if(action.equals("getSimilarTopics")){
            String title=request.getParameter("title");
            String[] keywords = title.trim().split(" ");
            keywords = Arrays.stream(keywords).filter(s -> s.length()>= 3).toArray(s -> new String[s]);
            System.out.println(Arrays.toString(keywords));
            List<Topic> topicList = topicService.getSimilarTopics(keywords);
            request.setAttribute("topicList", topicList);
            address = "/WEB-INF/fragment/similar-topics-fragments.jsp";
        }


        if (address != null) {
            request.getRequestDispatcher(address).forward(request, response);
        }


    }
}


