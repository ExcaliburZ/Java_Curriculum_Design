package net.wings.web.controller;

import net.wings.domain.Train;
import net.wings.service.BizService;
import net.wings.service.impl.BizServiceImpl;
import net.wings.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wing on 2015/12/26.
 */
@WebServlet(name = "UpdateTrainServlet", urlPatterns = "/UpdateTrainServlet")
public class UpdateTrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            Train c = WebUtils.requestToBean(request, Train.class);
            BizService service = new BizServiceImpl();
            service.updateTrain(c);
            request.setAttribute("message", "Update Train Success!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Update Train Failed!");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BizService service = new BizServiceImpl();
        Train train = service.findTrain(request.getParameter("id"));
        request.setAttribute("train", train);

        request.getRequestDispatcher("/WEB-INF/jsp/updateTrain.jsp").forward(request, response);
    }
}
