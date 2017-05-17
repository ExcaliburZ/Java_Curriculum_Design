package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.SelectClazzDaoImpl;
import net.wings.domain.Result;

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
@WebServlet(name = "join_class", urlPatterns = "/join_class")
public class JoinClassServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        String clazzId = request.getParameter("clazz_id");
        String account = request.getParameter("account");
        SelectClazzDaoImpl dao = new SelectClazzDaoImpl();
        if (dao.hasJoin(clazzId, account)) {
            writer.print(gson.toJson(new Result(302, "请勿重复加入同一班级")));
            return;
        }
        if (dao.hasOutOfLimit(clazzId)) {
            writer.print(gson.toJson(new Result(302, "班级人数已满,请联系任课老师")));
            return;
        }
        dao.joinClass(clazzId, account);
        writer.print(gson.toJson(new Result(200, "success")));
    }
}
