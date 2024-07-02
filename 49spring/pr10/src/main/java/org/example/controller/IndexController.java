package org.example.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//        resp.setContentType("text/html");
//        resp.getWriter().print("<h1>Hello World</h1>");

//        req.getRequestDispatcher("/views/index.jsp").forward(req, resp);

        String value = req.getParameter("message");

        String json = "{\"message\": \"" + value + "\"}";
        resp.getWriter().println(json);
    }
}
