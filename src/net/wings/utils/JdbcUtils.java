package net.wings.utils;

import org.apache.commons.dbcp2.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;


public class JdbcUtils {
    static Properties prop = new Properties();
    static DataSource dataSource;


    static {
        InputStream in = JdbcUtils.class.getClassLoader().
                getResourceAsStream("dbcpconfig.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            BasicDataSourceFactory factory = new BasicDataSourceFactory();
            dataSource = factory.createDataSource(prop);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getconnection() throws SQLException {

        return dataSource.getConnection();
    }

    //关闭资源模版代码
    public static void release(Connection connection, ResultSet rs, Statement st) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (st != null) {
            try {
                st.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            st = null;
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void update(String sql, Object params[]) {

        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = getconnection();
            st = conn.prepareStatement(sql);
            for (int i = 0; i < params.length; i++) {
                st.setObject(i + 1, params[i]);
            }
            st.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);

        } finally {
            JdbcUtils.release(conn, rs, st);
        }

    }

    public static Object select(String sql, Object params[], ResultSetHandler handler) {


        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = getconnection();
            st = conn.prepareStatement(sql);
            if (params ==null){
                rs =st.executeQuery();
            }else {
                for (int i = 0; i < params.length; i++) {
                    st.setObject(i + 1, params[i]);
                }
                rs = st.executeQuery();
            }
            return handler.handler(rs);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(conn, rs, st);
        }

    }
    public static Object select(String sql, ResultSetHandler handler) {


        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn = getconnection();
            st = conn.prepareStatement(sql);
            rs = st.executeQuery();
            return handler.handler(rs);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            JdbcUtils.release(conn, rs, st);
        }

    }
}
