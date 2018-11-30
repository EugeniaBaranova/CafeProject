package com.epam.web.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {

    CommandResult execute(HttpServletRequest req, HttpServletResponse resp);
}
