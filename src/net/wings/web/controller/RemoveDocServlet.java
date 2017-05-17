package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.DocumentDaoImpl;
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
@WebServlet(name = "remove_doc", urlPatterns = "/remove_doc")
public class RemoveDocServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String id = request.getParameter("id");
        DocumentDaoImpl dao = new DocumentDaoImpl();
        dao.removeDoc(id);
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(new Result(200, "success")));
    }
}
