package net.wings.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class WordsFilter implements Filter {

    private List<String> banWords = new ArrayList<String>();
    private List<String> auditWords = new ArrayList<String>();
    private List<String> replaceWords = new ArrayList<String>();

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding("UTF-8");
        //检查提交数据是否包含禁用词
        Enumeration e = request.getParameterNames();
        while(e.hasMoreElements()){
            String name = (String) e.nextElement();
            String data = request.getParameter(name);
            for(String regex : banWords){
                Pattern pattern = Pattern.compile(regex);
                Matcher m = pattern.matcher(data);
                if(m.find()){
                    request.setAttribute("message", "文章中包括非法词汇，请检查后再提交！！");
                    request.getRequestDispatcher("/message.jsp").forward(request, response);
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    public void init(FilterConfig config) throws ServletException {
        String path = WordsFilter.class.getClassLoader().getResource("net/wings/words").getPath();
        File files[] = new File(path).listFiles();
        for (File file : files) {
            if (!file.getName().endsWith(".txt")) {
                continue;
            }
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                String line = null;

                while ((line = br.readLine()) != null) {
                    String s[] = line.split("\\|");
                    if (s.length != 2) {
                        continue;
                    }
                    if (s[1].trim().equals("1")) {
                        banWords.add(s[0].trim());
                        continue;
                    }
                    if (s[1].trim().equals("2")) {
                        auditWords.add(s[0].trim());
                        continue;
                    }
                    if (s[1].trim().equals("3")) {
                        replaceWords.add(s[0].trim());
                        continue;
                    }

                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(auditWords);
        System.out.println(banWords);
        System.out.println(replaceWords);

    }

}
