package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.UserDaoImpl;
import net.wings.domain.Result;
import net.wings.domain.User;
import net.wings.utils.JsonUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by wing on 2015/12/26.
 */
@WebServlet(name = "register", urlPatterns = "/register")
public class AddUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("gert11");
        request.setCharacterEncoding("UTF-8");
        String userStr = JsonUtils.getBody(request);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        User user = gson.fromJson(userStr, User.class);
        UserDaoImpl userDao = new UserDaoImpl();
        User byAccount = userDao.findByAccount(user.getAccount());
//        String characterEncoding = response.getCharacterEncoding();
        PrintWriter writer = response.getWriter();
        if (byAccount != null) {
            writer.print(gson.toJson(new Result(303, "账户已存在")));
            return;
        }
        User byNumber = userDao.findByNumber(user.getS_number());
        if (byNumber != null) {
            writer.print(gson.toJson(new Result(303, "学号已存在")));
            return;
        }
        userDao.add(user);
        writer.print(gson.toJson(new Result(200, "success")));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
