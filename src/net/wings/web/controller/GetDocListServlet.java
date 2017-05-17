package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.DocumentDaoImpl;
import net.wings.domain.Document;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
@WebServlet(name = "doc_list", urlPatterns = "/doc_list")
public class GetDocListServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        String clazzId = request.getParameter("clazz_id");
        DocumentDaoImpl documentDao = new DocumentDaoImpl();
        List<Document> docList = documentDao.getDocList(clazzId);
        Gson gson = new Gson();
        PrintWriter writer = response.getWriter();
        writer.print(gson.toJson(docList));
    }
}
