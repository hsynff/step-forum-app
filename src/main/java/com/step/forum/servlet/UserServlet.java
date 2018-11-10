package com.step.forum.servlet;

import com.step.forum.constants.MessageConstants;
import com.step.forum.constants.UserConstants;
import com.step.forum.dao.UserDaoImpl;
import com.step.forum.exceptions.UserCredentialsException;
import com.step.forum.model.Role;
import com.step.forum.model.User;
import com.step.forum.service.UserService;
import com.step.forum.service.UserServiceImpl;
import com.step.forum.util.Config;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@WebServlet(name = "UserServlet", urlPatterns = "/us")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 5)
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

        } else if (action.equals("logout")) {
            HttpSession session = request.getSession();
            session.removeAttribute("user");
            session.invalidate();
            response.sendRedirect("/");
        } else if (action.equals("doRegister")) {


            System.out.println(Config.getImageUploadPath());

//            String firstName = request.getParameter("firstName");
//            String lastName = request.getParameter("lastName");
//            String email = request.getParameter("email");
//            String password = request.getParameter("pass");
//
//
//            //TODO validate
//            if (!password.equals(request.getParameter("pass2"))) {
//                request.setAttribute("message", MessageConstants.ERROR_PASSWORD_IS_NOT_MATCH);
//                request.getRequestDispatcher("/WEB-INF/view/new-account.jsp").forward(request, response);
//                return;
//            }
//
//            Part img = request.getPart("img");
//
//            Path pathToSaveFile = Paths.get(getServletContext().getRealPath("/"), "uploads", email);
//
//            if (!Files.exists(pathToSaveFile)) {
//                Files.createDirectories(pathToSaveFile);
//            }
//
//            Path file = Paths.get(pathToSaveFile.toString(), img.getSubmittedFileName());
//
//            Files.copy(img.getInputStream(), file, StandardCopyOption.REPLACE_EXISTING);
//
//            Path pathToSaveDb = Paths.get(email, img.getSubmittedFileName());
//
//            User user = new User();
//            user.setFirstName(firstName);
//            user.setLastName(lastName);
//            user.setImagePath(pathToSaveDb.toString());
//            user.setEmail(email);
//            user.setPassword(password);
//            user.setStatus(UserConstants.USER_STATUS_INACTIVE);
//            user.setToken(UUID.randomUUID().toString());
//            Role role = new Role();
//            role.setId(UserConstants.ROLE_ID_USER);
//            user.setRole(role);
//            try {
//                if (userService.registerUser(user)) {
//                    request.getSession().setAttribute("message", MessageConstants.SUCCESS_REGISTER);
//                    response.sendRedirect("/");
//                } else {
//                    request.setAttribute("message", MessageConstants.ERROR_INTERNAL);
//                    request.getRequestDispatcher("/WEB-INF/view/new-account.jsp").forward(request, response);
//                }
//            } catch (UserCredentialsException e) {
//                request.setAttribute("message", e.getMessage());
//                request.getRequestDispatcher("/WEB-INF/view/new-account.jsp").forward(request, response);
//            }

        }

        if (address != null) {
            request.getRequestDispatcher(address).forward(request, response);
        }


    }
}
