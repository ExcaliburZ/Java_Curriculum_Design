package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.impl.DocumentDaoImpl;
import net.wings.domain.Result;
import net.wings.domain.Document;
import net.wings.utils.DownloadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "upload", urlPatterns = "/upload")
public class UploadDocServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        String clazzId = request.getParameter("clazz_id");
        String size = request.getParameter("size");

//        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        String savePath = this.getServletContext().getRealPath("/document");
        Document document = DownloadUtils.doupload(request, savePath);
        document.setClazz_id(clazzId);
        document.setSize(size);
        DocumentDaoImpl documentDao = new DocumentDaoImpl();
        documentDao.add(document);
        writer.print(gson.toJson(new Result(200, "success")));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
