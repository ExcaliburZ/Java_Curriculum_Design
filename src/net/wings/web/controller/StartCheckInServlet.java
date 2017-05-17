package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.CheckInDaoImpl;
import net.wings.domain.CheckIn;
import net.wings.domain.Result;
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
@WebServlet(name = "start_check_in", urlPatterns = "/start_check_in")
public class StartCheckInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String clazzId = request.getParameter("clazz_id");
        String password = request.getParameter("password");
        CheckIn checkIn = new CheckIn(WebUtils.getID(), password, String.valueOf(System.currentTimeMillis()), clazzId);
        CheckInDaoImpl dao = new CheckInDaoImpl();
        dao.add(checkIn);
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(new Result(200, "success")));
    }
}
