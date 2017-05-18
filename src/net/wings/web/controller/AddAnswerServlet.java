package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.AnswerDaoImpl;
import net.wings.domain.Answer;
import net.wings.domain.Result;
import net.wings.utils.JsonUtils;
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
@WebServlet(name = "add_answer", urlPatterns = "/add_answer")
public class AddAnswerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userStr = JsonUtils.getBody(request);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter writer = response.getWriter();
        Gson gson = new Gson();
        Answer answer = gson.fromJson(userStr, Answer.class);
        answer.setId(WebUtils.getID());
        AnswerDaoImpl dao = new AnswerDaoImpl();
        if (dao.findAnswer(answer.getUser_account(), answer.getQuestion_id())) {
            writer.print(gson.toJson(new Result(302, "请勿重复回答")));
            return;
        }
        dao.add(answer);
        writer.print(gson.toJson(new Result(200, "success")));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
