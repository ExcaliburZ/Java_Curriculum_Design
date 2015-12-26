package net.wings.web.controller;

import net.wings.domain.EmployeePageBean;
import net.wings.domain.QueryInfo;
import net.wings.service.BizService;
import net.wings.service.impl.BizServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wing on 2015/12/26.
 */
@WebServlet(name = "ListEmployeeServlet", urlPatterns = "/ListEmployeeServlet")
public class ListEmployeeServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            QueryInfo info = new QueryInfo();
            info.setPagesize(
                    request.getParameter("pagesize") == null ?
                            new QueryInfo().getPagesize() :
                            Integer.parseInt(request.getParameter("pagesize")));
            info.setCurrentpage(request.getParameter("currentpage") == null ?
                    1 : Integer.parseInt(request.getParameter("currentpage")));
            BizService service = new BizServiceImpl();
            EmployeePageBean pageBean = service.pageQuery(info);
            request.setAttribute("pagebean", pageBean);
            request.getRequestDispatcher("/WEB-INF/jsp/listEmployee.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "query failed");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
        }

    }
}
