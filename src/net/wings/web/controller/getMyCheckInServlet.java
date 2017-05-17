package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.CheckInDaoImpl;
import net.wings.domain.MyCheckInData;

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
@WebServlet(name = "get_my_check_in", urlPatterns = "/get_my_check_in")
public class getMyCheckInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String clazzId = request.getParameter("clazz_id");
        String account = request.getParameter("account");
        CheckInDaoImpl dao = new CheckInDaoImpl();
        MyCheckInData myCheckInData = dao.getMyCheckInData(clazzId, account);
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(myCheckInData));
    }
}
