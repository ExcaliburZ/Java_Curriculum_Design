package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.AnswerDaoImpl;
import net.wings.domain.Answer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "get_answer_list", urlPatterns = "/get_answer_list")
public class GetAnswerListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        String questionId = request.getParameter("question_id");
        AnswerDaoImpl dao = new AnswerDaoImpl();
        List<Answer> answerList = dao.getAnswerList(questionId);
//        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        writer.print(gson.toJson(answerList));
    }
}
