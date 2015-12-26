
package net.wings.web.controller;


import net.wings.domain.customer;
import net.wings.service.BussinessService;
import net.wings.service.impl.BussinessServiceImpl;
import net.wings.utils.Glo;
import net.wings.utils.Globals;
import net.wings.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "UpdateCustomerServlet", urlPatterns = "/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            request.setCharacterEncoding("UTF-8");
  /*        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            customer c = new customer();
            c.setEmail(request.getParameter("email"));
            c.setBirthday(sf.parse(request.getParameter("birthday")));
            c.setGender(request.getParameter("gender"));
            c.setName(request.getParameter("name"));
            c.setCellphone(request.getParameter("cellphone"));
            c.setDescription(request.getParameter("description"));
            c.setPreference(request.getParameter("preference"));
            c.setType(request.getParameter("type"));
            c.setId(request.getParameter("id"));*/
            customer c = WebUtils.requestToBean(request, customer.class);
            BussinessService service = new BussinessServiceImpl();
            service.updateCustomer(c);
            request.setAttribute("message", "修改成功");
        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("message", "修改失败");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//        request.setCharacterEncoding("UTF-8");
//        response.setCharacterEncoding("UTF-8");
        BussinessService service = new BussinessServiceImpl();
        customer c = service.find(request.getParameter("id"));

        request.setAttribute("customer", c);
        String gender[]={"男","女"};
        String preference[]={"读书","看报","唱歌","大保健"};
        String type[]={"普通客户","会员用户","VIP用户"};
//        request.setAttribute("gender", Globals.gender);
//        request.setAttribute("preference", Globals.preference);
//        request.setAttribute("type", Globals.type);
        request.setAttribute("gender", gender);
        request.setAttribute("preference", preference);
        request.setAttribute("type", type);
        request.getRequestDispatcher("/WEB-INF/jsp/updateCustomer.jsp").forward(request, response);
    }
}
