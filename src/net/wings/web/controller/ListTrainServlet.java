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
@WebServlet(name = "ListTrainServlet", urlPatterns = "/ListTrainServlet")
public class ListTrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            BizService service = new BizServiceImpl();
            List Trains = service.getAllTrain();
            request.setAttribute("trains",Trains);
            request.getRequestDispatcher("/WEB-INF/jsp/listTrain.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "failed");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }

    }
}
