package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.CheckInDaoImpl;
import net.wings.domain.CheckInRequest;
import net.wings.domain.CheckInResultData;
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
@WebServlet(name = "check_in_result", urlPatterns = "/check_in_result")
public class GetCheckInResultServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String bodyStr = JsonUtils.getBody(request);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
//        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        CheckInRequest checkInRequest = gson.fromJson(bodyStr, CheckInRequest.class);
        CheckInDaoImpl dao = new CheckInDaoImpl();
        CheckInResultData checkInResultData = dao.getCheckInResultData(checkInRequest);
        writer.print(gson.toJson(checkInResultData));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
