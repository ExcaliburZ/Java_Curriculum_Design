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


@WebServlet(name = "addCustomerServlet", urlPatterns = "/addCustomerServlet")
public class addCustomerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            customer c = WebUtils.requestToBean(request, customer.class);
            c.setId(WebUtils.getID());
            BusinessService service = new BusinessServiceImpl();
            service.addCustomer(c);
            request.setAttribute("message", "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "添加失败");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String gender[] = {"男", "女"};
        String preference[] = {"读书", "看报", "唱歌", "大保健"};
        String type[] = {"普通客户", "会员用户", "VIP用户"};
/*      request.setAttribute("gender", Globals.gender);
        request.setAttribute("preference", Globals.preference);
        request.setAttribute("type", Globals.type);*/
        request.setAttribute("gender", gender);
        request.setAttribute("preference", preference);
        request.setAttribute("type", type);
        request.getRequestDispatcher("WEB-INF/jsp/addcustomer.jsp").forward(request, response);

    }
}
