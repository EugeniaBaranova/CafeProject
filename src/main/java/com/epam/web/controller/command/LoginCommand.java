package com.epam.web.controller.command;

import com.epam.web.entity.User;
import com.epam.web.service.UserService;
import com.epam.web.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

public class LoginCommand implements Command {
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        UserServiceImpl userService = new UserServiceImpl();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Optional<User> user = userService.login(login, password);

        user.ifPresent(u -> req.setAttribute("user", u) );


        return "/WEB_INF/main.jsp";
    }
}
