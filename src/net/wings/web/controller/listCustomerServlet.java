package net.wings.web.controller;

import net.wings.domain.PageBean;
import net.wings.domain.QueryInfo;
import net.wings.domain.customer;
import net.wings.service.BussinessService;
import net.wings.service.impl.BussinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@WebServlet(name = "listCustomerServlet", urlPatterns = "/listCustomerServlet")
public class listCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            QueryInfo info =new QueryInfo();
            info.setPagesize(request.getParameter("pagesize")==null?new QueryInfo().getPagesize():Integer.parseInt(request.getParameter("pagesize")));
            info.setCurrentpage(request.getParameter("currentpage")==null?1:Integer.parseInt(request.getParameter("currentpage")));
            BussinessService service = new BussinessServiceImpl();
            PageBean pageBean =service.pageQuery(info);
            request.setAttribute("pagebean",pageBean);
            request.getRequestDispatcher("/WEB-INF/jsp/listCustomer.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "查看用户失败");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }
    }
}
