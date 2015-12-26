package net.wings.web.controller;

import net.wings.service.BussinessService;
import net.wings.service.impl.BussinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelectCustomerServlet",urlPatterns = "/DelectCustomerServlet")
public class DelectCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            BussinessService service = new BussinessServiceImpl();
            service.delectCustomer(request.getParameter("id"));
            request.setAttribute("message", "删除成功");
        }catch (Exception e){
            e.printStackTrace();
            request.setAttribute("message", "删除失败");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

}

