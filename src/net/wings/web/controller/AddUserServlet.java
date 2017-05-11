package net.wings.web.controller;

import com.google.gson.Gson;
import net.wings.dao.UserDaoImpl;
import net.wings.domain.Result;
import net.wings.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by wing on 2015/12/26.
 */
@WebServlet(name = "register", urlPatterns = "/register")
public class AddUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("gert11");
        request.setCharacterEncoding("UTF-8");
        String userStr = getBody(request);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
//        PrintWriter out = response.getWriter();
        Gson gson = new Gson();
        User user = gson.fromJson(userStr, User.class);
        UserDaoImpl userDao = new UserDaoImpl();
        User byAccount = userDao.findByAccount(user.getAccount());
        String characterEncoding = response.getCharacterEncoding();
        String toJson = gson.toJson(new Result(303, "要不起"));
        PrintWriter writer = response.getWriter();
        writer.print(toJson);
//        if (byAccount != null) {
////            out.print(gson.toJson(new Result(303, "账户已存在")));
//            return;
//        }
//        User byNumber = userDao.findByNumber(user.getS_number());
//        if (byNumber != null) {
////            out.print(gson.toJson(new Result(303, "学号已存在")));
//            return;
//        }
//        userDao.add(user);

//        out.print(gson.toJson(new Result(200, "success")));
    }

    public static String getBody(HttpServletRequest request) throws IOException {

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {
            InputStream inputStream = request.getInputStream();
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                char[] charBuffer = new char[128];
                int bytesRead = -1;
                while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, bytesRead);
                }
            } else {
                stringBuilder.append("");
            }
        } catch (IOException ex) {
            throw ex;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException ex) {
                    throw ex;
                }
            }
        }

        body = stringBuilder.toString();
        return body;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        String gender[] = {"男", "女"};
//        request.setAttribute("gender", gender);
//        request.getRequestDispatcher("WEB-INF/jsp/addTrain.jsp").forward(request, response);
        System.out.println("gert");
    }
}
