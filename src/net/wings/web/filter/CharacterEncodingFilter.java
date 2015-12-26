package net.wings.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;


public class CharacterEncodingFilter implements Filter {

    private FilterConfig config;
    private String defaultCharset = "UTF-8";
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String charset = config.getInitParameter("charset");
        if (charset == null) {
            charset = defaultCharset;
        }
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        response.setContentType("text/html;charset="+charset);
        System.out.println("CharacterEncodingFilter work");
//        chain.doFilter(new Myrequset(request), response);
        chain.doFilter(request,response);
    }
    class Myrequset extends HttpServletRequestWrapper {
        private HttpServletRequest request;
        public Myrequset(HttpServletRequest request) {
            super(request);
            this.request =request;
        }

        @Override
        public String getParameter(String name) {
            String value = super.getParameter(name);
            if (value==null){
                return null;
            }
            if (!request.getMethod().equalsIgnoreCase("get")){
                return value;
            }
            try {
                return new String(value.getBytes("iso8859-1"),request.getCharacterEncoding());
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void init(FilterConfig config) throws ServletException {
        System.out.println("work");
        this.config = config;
    }

}
