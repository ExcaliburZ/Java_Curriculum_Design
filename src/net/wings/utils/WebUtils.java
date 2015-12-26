package net.wings.utils;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * Created by wing on 2014/10/19.
 */
public class WebUtils {
//    public static customer Tobean(HttpServletRequest request,customer c){
//
//        /*c.setEmail(request.getParameter("email"));
//        c.setBirthday(new Date());
//        c.setGender(request.getParameter("gender"));
//        c.setName(request.getParameter("name"));
//        c.setCellphone(request.getParameter("cellphone"));
//        c.setDescription(request.getParameter("description"));
//        c.setPreference(request.getParameter("preference"));
//        c.setType(request.getParameter("type"));*/
//        c.setName(request.getParameter("name"));
//
//        return c;
//    }

    public static <T> T requestToBean(HttpServletRequest request, Class beanClass) {
        try {
            T bean = (T) beanClass.newInstance();
            Map map = request.getParameterMap();
            ConvertUtils.register(new Converter() {
                @Override
                public Object convert(Class type, Object value) {
                    if (value == null) {
                        return null;
                    }
                    String str = (String) value;
                    if (str.trim().equals("")) {
                        return null;
                    }
                    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

                    try {
                        return df.parse(str);
                    } catch (ParseException e) {
                        throw new RuntimeException();
                    }
                }
            }, Date.class);
            BeanUtils.populate(bean, map);
            return  bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static String getID(){
        return UUID.randomUUID().toString();
    }
}
