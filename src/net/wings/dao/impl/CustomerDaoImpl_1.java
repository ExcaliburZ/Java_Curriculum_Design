package net.wings.dao.impl;

import net.wings.domain.QuertResult;
import net.wings.domain.customer;
import net.wings.exception.DaoException;
import net.wings.utils.BeanHandler;
import net.wings.utils.BeanListHandler;
import net.wings.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//需要操作数据库，所以拷贝Jdbcutils和db.properties文件

/*
public class CustomerDaoImpl_1 implements net.wings.dao.CustomerDao {

    @Override
    public void add(customer c) {

        String sql = "insert into customer(id,name,gender,birthday,cellphone,email,preference,type,description) values (?,?,?,?,?,?,?,?,?);";
        Object params[] = {c.getId(), c.getName(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(), c.getPreference(), c.getType(), c.getDescription()};
        JdbcUtils.update(sql, params);

    }

    @Override
    public void delect(String id) {
        String sql = "delete from customer where id=?";
        Object params[] = {id};
        JdbcUtils.update(sql, params);
    }

    @Override
    public void update(customer c) {

        String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=?  where id=?";
        Object params[] = {c.getName(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(), c.getPreference(), c.getType(), c.getDescription(), c.getId()};
        JdbcUtils.update(sql, params);
    }

    @Override
    public customer find(String id) {

        String sql = "select * from customer where id=?";
        Object params[] = {id};
        return (customer) JdbcUtils.select(sql, params, new BeanHandler(customer.class));
    }

    @Override
    public List<customer> getAll() {

        String sql = "select * from customer";
        Object params[] = null;
        return (List<customer>) JdbcUtils.select(sql, params, new BeanListHandler(customer.class));
    }

    public QuertResult pageQuery(int startindex, int pagesize) {
        Connection connection = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        QuertResult qr = new QuertResult();
        try {
            connection = JdbcUtils.getconnection();
            String sql = "select * from customer limit " + startindex + "," + pagesize + "";
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            List<customer> list = new ArrayList();
            while (rs.next()) {
                customer c = new customer();
                c.setEmail(rs.getString("email"));
                c.setBirthday(rs.getDate("birthday"));
                c.setId(rs.getString("id"));
                c.setCellphone(rs.getString("cellphone"));
                c.setDescription(rs.getString("description"));
                c.setGender(rs.getString("gender"));
                c.setPreference(rs.getString("preference"));
                c.setName(rs.getString("name"));
                c.setType(rs.getString("type"));
                list.add(c);
            }
            qr.setList(list);
            sql = "select count(*) from customer";
            st = connection.prepareStatement(sql);
            rs = st.executeQuery();
            if (rs.next()) {
                qr.setTotalrecord(rs.getInt("count(*)"));
            }
            return qr;
        } catch (Exception e) {
            throw new DaoException(e);
        } finally {
            JdbcUtils.release(connection, rs, st);
        }
    }
}
*/
