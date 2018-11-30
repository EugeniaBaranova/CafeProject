package com.epam.web.controller;

import com.epam.web.controller.command.Command;
import com.epam.web.controller.command.CommandFactory;
import com.epam.web.controller.command.CommandResult;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        Command action = CommandFactory.create(command);
        CommandResult commandResult = null;
        try {
            commandResult = action.execute(req, resp);
        } catch (Exception e) {
            //TODO logger
            req.setAttribute("errorMassage", e.getMessage());
            dispatch(req, resp, "/error.jsp");
        }
        if (commandResult.isRedirect()) {
            resp.sendRedirect(req.getContextPath() + "/redirected");
        } else {
            String page = commandResult.getPage();
            dispatch(req, resp, page);
        }

    }

    private void dispatch(HttpServletRequest req, HttpServletResponse resp, String page) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }

}
