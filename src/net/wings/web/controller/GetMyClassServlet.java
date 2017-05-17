package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.SelectClazzDaoImpl;
import net.wings.domain.Clazz;

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
@WebServlet(name = "my_class", urlPatterns = "/my_class")
public class GetMyClassServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String account = request.getParameter("account");
        SelectClazzDaoImpl dao = new SelectClazzDaoImpl();
        List<Clazz> classList = dao.getClazzListByStudentAccount(account);
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(classList));
    }
}
