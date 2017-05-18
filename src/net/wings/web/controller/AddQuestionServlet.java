package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.QuestionDaoImpl;
import net.wings.domain.Question;
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
@WebServlet(name = "add_question", urlPatterns = "/add_question")
public class AddQuestionServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userStr = JsonUtils.getBody(request);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        Gson gson = new Gson();
        Question question = gson.fromJson(userStr, Question.class);
        question.setId(WebUtils.getID());
        QuestionDaoImpl dao = new QuestionDaoImpl();
        dao.add(question);

        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(new Result(200, "success")));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
}
