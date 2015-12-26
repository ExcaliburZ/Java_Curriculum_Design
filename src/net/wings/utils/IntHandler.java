package net.wings.utils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wing on 2014/10/23.
 */
public class IntHandler implements ResultSetHandler {

    @Override
    public Object handler(ResultSet rs) {
        try {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return 0;
    }
}
