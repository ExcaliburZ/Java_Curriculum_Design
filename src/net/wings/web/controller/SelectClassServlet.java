package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.SelectClazzDaoImpl;
import net.wings.domain.Result;
import net.wings.domain.SelectClazz;
import net.wings.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by wing on 2015/12/26.
 */
@WebServlet(name = "select_class", urlPatterns = "/select_class")
public class SelectClassServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String bodyStr = JsonUtils.getBody(request);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
//        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        SelectClazz selectClazz = gson.fromJson(bodyStr, SelectClazz.class);
        SelectClazzDaoImpl dao = new SelectClazzDaoImpl();
        dao.add(selectClazz);
        writer.print(gson.toJson(new Result(200, "success")));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
