package net.wings.web.controller;

import net.wings.service.BizService;
import net.wings.service.impl.BizServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
@WebServlet(name = "StatisticsServlet", urlPatterns = "/StatisticsServlet")
public class StatisticsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            BizService service = new BizServiceImpl();

            List statistics = service.getStatistics();
            request.setAttribute("statistics",statistics);

            int trainCount = service.getTrainCount();
            request.setAttribute("trainCount",trainCount);

            int employeeCount = service.getEmployeeCount();
            request.setAttribute("employeeCount",employeeCount);

            request.getRequestDispatcher("/WEB-INF/jsp/statistics.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "failed");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }

    }
}
