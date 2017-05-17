package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.CheckInDaoImpl;
import net.wings.domain.CheckIn;
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
@WebServlet(name = "student_check_in", urlPatterns = "/student_check_in")
public class StudentCheckInServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        Gson gson = new Gson();
        String clazzId = request.getParameter("clazz_id");
        String password = request.getParameter("password");
        String studentID = request.getParameter("student_id");
        String studentName = request.getParameter("student_name");
        String studentNumber = request.getParameter("student_number");
        CheckInDaoImpl dao = new CheckInDaoImpl();
        CheckIn lastCheck = dao.getLastCheck(clazzId);

        PrintWriter writer = response.getWriter();

        if (lastCheck == null) {
            writer.print(gson.toJson(new Result(302, "请等待老师发布签到信息")));
            return;
        }
        long currentTime = System.currentTimeMillis();
        Long checkStartTime = Long.valueOf(lastCheck.getCreateTime());
        int maxTimeLimit = 1000 * 60 * 10;

        if (currentTime - checkStartTime > maxTimeLimit) {
            writer.print(gson.toJson(new Result(302, "签到失败,超时")));
            return;
        }
        if (!password.equals(lastCheck.getPassword())) {
            writer.print(gson.toJson(new Result(302, "签到码错误")));
            return;
        }
        if (dao.hasCheckIn(studentID, lastCheck.getId())) {
            writer.print(gson.toJson(new Result(302, "请勿重复签到")));
            return;
        }
        dao.studentCheckIn(clazzId,
                studentID,
                studentName,
                studentNumber,
                String.valueOf(currentTime),
                lastCheck.getId());

        writer.print(gson.toJson(new Result(200, "success")));
    }
}
