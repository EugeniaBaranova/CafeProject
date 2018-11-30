package com.epam.web.controller.command;

import com.epam.web.entity.User;
import com.epam.web.service.UserService;
import com.epam.web.service.UserServiceImpl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

public class LoginCommand implements Command {
    @Override
    public CommandResult execute(HttpServletRequest req, HttpServletResponse resp) {

        HttpSession session = req.getSession(true);
        session.setAttribute("user", new User("Jane", "admin"));

        UserService userService = new UserServiceImpl();
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        Optional<User> user = userService.login(login, password);

        user.ifPresent(u -> req.setAttribute("user", u));

        return CommandResult.forward("/WEB-INF/pages/main.jsp");
    }
}
