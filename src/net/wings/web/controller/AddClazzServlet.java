package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.ClazzDaoImpl;
import net.wings.domain.Clazz;
import net.wings.domain.Result;
import net.wings.utils.JsonUtils;
import net.wings.utils.TimeUtils;
import net.wings.utils.WebUtils;

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
@WebServlet(name = "add_class", urlPatterns = "/add_class")
public class AddClazzServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String bodyStr = JsonUtils.getBody(request);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
//        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        Clazz clazz = gson.fromJson(bodyStr, Clazz.class);
        clazz.setId(WebUtils.getID());
        String format = TimeUtils.getDateString();
        clazz.setCreateTime(format);
        ClazzDaoImpl dao = new ClazzDaoImpl();
        dao.add(clazz);
        writer.print(gson.toJson(new Result(200, "success")));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
