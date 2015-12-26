package net.wings.web.controller;

import net.wings.domain.Employee;
import net.wings.domain.Train;
import net.wings.exception.OutOfLimitException;
import net.wings.service.BizService;
import net.wings.service.impl.BizServiceImpl;
import net.wings.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
@WebServlet(name = "AddEmployeeServlet", urlPatterns = "/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    BizService service = new BizServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setCharacterEncoding("UTF-8");
            Employee employee = WebUtils.requestToBean(request, Employee.class);
            Train train = service.findTrain(employee.getTrain_id());
            String name = train.getName();
            employee.setTrain_name(name);
            employee.setId(WebUtils.getID());
            service.addEmployee(employee);
            request.setAttribute("message", "Add Employee Success");
        } catch (OutOfLimitException e) {
            e.printStackTrace();
            request.setAttribute("message", "Member out of Limit");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("message", "Add Employee Failed");
        }
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Train> trainList = service.getAllTrain();
        List<String> names = new ArrayList<>();
        for (Train item : trainList) {
            names.add(item.getName());
        }
        request.setAttribute("trains", trainList);
        request.getRequestDispatcher("WEB-INF/jsp/addEmployee.jsp").forward(request, response);
    }
}
