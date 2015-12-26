package net.wings.web.controller;

import net.wings.domain.Employee;
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
import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
@WebServlet(name = "UpdateEmployeeServlet", urlPatterns = "/UpdateEmployeeServlet")
public class UpdateEmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            Employee employee = WebUtils.requestToBean(request, Employee.class);
            BizService service = new BizServiceImpl();
            Train train = service.findTrain(employee.getTrain_id());
            String name = train.getName();
            employee.setTrain_name(name);
            service.updateEmployee(employee);
            request.setAttribute("message", "Update Employee Success!");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Update Employee Failed!");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BizService service = new BizServiceImpl();
        List<Train> trainList = service.getAllTrain();
        request.setAttribute("trains", trainList);

        Employee employee = service.findEmployee(request.getParameter("id"));
        request.setAttribute("employee", employee);

        request.getRequestDispatcher("/WEB-INF/jsp/updateEmployee.jsp").forward(request, response);
    }
}
