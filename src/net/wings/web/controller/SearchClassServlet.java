package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.ClazzDaoImpl;
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
@WebServlet(name = "search_class", urlPatterns = "/search_class")
public class SearchClassServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String key = request.getParameter("key");
        ClazzDaoImpl dao = new ClazzDaoImpl();
        List<Clazz> classList = dao.searchClass(key);
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(classList));
    }
}
