package net.wings.utils;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler implements ResultSetHandler {
    private Class clazz;

    public BeanListHandler(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public Object handler(ResultSet rs) {

        List list = new ArrayList();
        try {
            while (rs.next()) {
                Object bean = clazz.newInstance();
                ResultSetMetaData metaData = rs.getMetaData();
                int count = metaData.getColumnCount();
                for (int i = 0; i < count; i++) {
                    String name = metaData.getColumnName(i + 1);
                    Object value = rs.getObject(name);
                    Field field = bean.getClass().getDeclaredField(name);
                    field.setAccessible(true);
                    field.set(bean, value);
                }
                list.add(bean);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return list;
    }
}