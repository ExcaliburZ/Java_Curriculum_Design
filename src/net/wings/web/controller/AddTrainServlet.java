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
@WebServlet(name = "AddTrainServlet", urlPatterns = "/AddTrainServlet")
public class AddTrainServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            Train c = WebUtils.requestToBean(request, Train.class);
            c.setId(WebUtils.getID());
            BizService service = new BizServiceImpl();
            service.addTrain(c);
            request.setAttribute("message", "Add Train Success");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Add Train Failed");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String gender[] = {"男", "女"};
        request.setAttribute("gender", gender);
        request.getRequestDispatcher("WEB-INF/jsp/addTrain.jsp").forward(request, response);
    }
}
