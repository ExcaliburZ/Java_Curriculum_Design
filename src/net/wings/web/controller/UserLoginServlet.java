package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.UserDaoImpl;
import net.wings.domain.LoginInfo;
import net.wings.domain.User;
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
@WebServlet(name = "login", urlPatterns = "/login")
public class UserLoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("gert11");
        request.setCharacterEncoding("UTF-8");
        String userStr = JsonUtils.getBody(request);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        User user = gson.fromJson(userStr, User.class);
        UserDaoImpl userDao = new UserDaoImpl();

        PrintWriter writer = response.getWriter();

        User byAccount = userDao.findByAccount(user.getAccount());
        if (byAccount == null) {
            LoginInfo info = new LoginInfo(302, "用户名不存在");
            writer.print(gson.toJson(info));
            return;
        }
        if (userDao.Login(user)) {
            LoginInfo info = new LoginInfo(200, "success");
            info.setAccount(byAccount.getAccount());
            info.setDescription(byAccount.getDescription());
            info.setEmail(byAccount.getEmail());
            info.setName(byAccount.getName());
            info.setNumber(byAccount.getS_number());
            writer.print(gson.toJson(info));
        } else {
            LoginInfo info = new LoginInfo(302, "密码错误");
            writer.print(gson.toJson(info));
        }

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String gender[] = {"男", "女"};
//        request.setAttribute("gender", gender);
//        request.getRequestDispatcher("WEB-INF/jsp/addTrain.jsp").forward(request, response);
        System.out.println("gert");
    }
}
