package com.epam.web;

import com.epam.web.command.Command;
import com.epam.web.command.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
        /*String name = req.getParameter("name");
        req.setAttribute("name", name);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String command = req.getParameter("command");
        Command action = CommandFactory.create(command);
        String page = null;
        try {
            page = action.execute(req, resp);
        } catch (Exception e) {
            req.setAttribute("errorMassage", e.getMessage());
            page = "/error.jsp";
        }
        dispatch(req, resp, page);
    }

    private void dispatch(HttpServletRequest req, HttpServletResponse resp, String page) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(req, resp);
    }

}
