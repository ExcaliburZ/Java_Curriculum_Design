package net.wings.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class BeanHandler implements ResultSetHandler {
    private Class clazz;

    public BeanHandler(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object handler(ResultSet rs) {

        try {
            if (!rs.next()) {
                return null;
            }
            //创建代表结果集的bean
            Object bean = clazz.newInstance();
            ResultSetMetaData metaData = rs.getMetaData();
            int num = metaData.getColumnCount();
            for (int i = 0; i < num; i++) {
                String name = metaData.getColumnName(i + 1);
                Object value = rs.getObject(name);
                Field field = bean.getClass().getDeclaredField(name);
                field.setAccessible(true);
                field.set(bean, value);
            }
            return bean;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
