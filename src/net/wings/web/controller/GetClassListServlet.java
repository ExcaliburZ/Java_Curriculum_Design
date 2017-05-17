package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.ClazzDaoImpl;
import net.wings.dao.impl.SelectClazzDaoImpl;
import net.wings.domain.Clazz;
import net.wings.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
@WebServlet(name = "get_class_list", urlPatterns = "/get_class_list")
public class GetClassListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String account = request.getParameter("account");
        ClazzDaoImpl dao = new ClazzDaoImpl();
        List<Clazz> classList = dao.getClassListByAccount(account);
        SelectClazzDaoImpl selectClazzDao = new SelectClazzDaoImpl();
        for (Clazz clazz : classList) {
            List<User> studentList = selectClazzDao.getStudentListByClazzID(clazz.getId());
            clazz.setStudentList(studentList);
        }
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(classList));
    }
}
