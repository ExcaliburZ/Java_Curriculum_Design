package net.wings.web.controller;

import net.wings.domain.customer;
import net.wings.service.BusinessService;
import net.wings.service.impl.BusinessServiceImpl;
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
@WebServlet(name = "UpdateServlet", urlPatterns = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            customer c = WebUtils.requestToBean(request, customer.class);
            BusinessService service = new BusinessServiceImpl();
            service.updateCustomer(c);
            request.setAttribute("message", "Update Success!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Update Failed!");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BusinessService service = new BusinessServiceImpl();
        customer c = service.find(request.getParameter("id"));
        request.setAttribute("customer", c);

        request.getRequestDispatcher("/WEB-INF/jsp/updateCustomer.jsp").forward(request, response);
    }
}
