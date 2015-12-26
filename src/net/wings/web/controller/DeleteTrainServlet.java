package net.wings.web.controller;

import net.wings.service.BizService;
import net.wings.service.impl.BizServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wing on 2015/12/26.
 */
@WebServlet(name = "DeleteTrainServlet", urlPatterns = "/DeleteTrainServlet")
public class DeleteTrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            BizService service = new BizServiceImpl();
            service.deleteTrain(request.getParameter("id"));
            request.setAttribute("message", "Delete Train Success!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Delete Train Failed!");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }
}
