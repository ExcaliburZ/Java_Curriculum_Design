package net.wings.web.controller;

import net.wings.service.BusinessService;
import net.wings.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteCustomerServlet",urlPatterns = "/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            BusinessService service = new BusinessServiceImpl();
            service.delectCustomer(request.getParameter("id"));
            request.setAttribute("message", "Delete Success!");
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("message", "Delete Failed!");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

}

