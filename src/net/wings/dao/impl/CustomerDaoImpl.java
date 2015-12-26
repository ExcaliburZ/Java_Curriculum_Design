package net.wings.dao.impl;

import net.wings.dao.CustomerDao;
import net.wings.domain.customer;
import net.wings.exception.DaoException;
import net.wings.utils.BeanHandler;
import net.wings.utils.BeanListHandler;
import net.wings.utils.IntHandler;
import net.wings.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//hibernate
public class CustomerDaoImpl implements CustomerDao {


    public void add(customer c) {
        try {
            String sql = "insert into customer(id,name,gender,birthday,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?,?)";
            Object params[] = {c.getId(), c.getName(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(), c.getPreference(), c.getType(), c.getDescription()};
            JdbcUtils.update(sql, params);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void update(customer c) {   //id
        try {
            String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=?  where id=?";
            Object params[] = {c.getName(), c.getGender(), c.getBirthday(), c.getCellphone(), c.getEmail(), c.getPreference(), c.getType(), c.getDescription(), c.getId()};
            JdbcUtils.update(sql, params);
        } catch (Exception e) {
            throw new DaoException(e);
        }

    }

    public void delete(String id) {
        try {
            String sql = "delete from customer where id=?";
            Object params[] = {id};
            JdbcUtils.update(sql, params);
        } catch (Exception e) {
            throw new DaoException(e);
        }


    }

    public customer find(String id) {
        try {
            String sql = "select * from customer where id=?";
            Object params[] = {id};
            return (customer) JdbcUtils.select(sql, params, new BeanHandler(customer.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }


    public List<customer> getAll() {
        try {
            String sql = "select * from customer";
            Object params[] = {};
            return (List<customer>) JdbcUtils.select(sql, new BeanListHandler(customer.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }


    }

    //获取到页面数据和页面大小
    public net.wings.domain.QuertResult pageQuery(int startindex, int pagesize) {

        net.wings.domain.QuertResult qr = new net.wings.domain.QuertResult();

        try {
            String sql = "select * from customer limit ?,?";
            Object params[] = {startindex, pagesize};
            List list = (List) JdbcUtils.select(sql, params, new BeanListHandler(customer.class));
            qr.setList(list);

            sql = "select count(*) from customer";
            params = new Object[]{};
            int totalrecord = (Integer) JdbcUtils.select(sql, new IntHandler());
            qr.setTotalrecord(totalrecord);
            return qr;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}

/*import net.wings.domain.QuertResult;
import net.wings.domain.customer;
import net.wings.exception.DaoException;
import net.wings.utils.BeanHandler;
import net.wings.utils.BeanListHandler;
import net.wings.utils.IntHandler;
import net.wings.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

//需要操作数据库，所以拷贝Jdbcutils和db.properties文件

public class CustomerDaoImpl implements net.wings.dao.CustomerDao {

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
        Object params[] = {};
        return (List<customer>) JdbcUtils.select(sql, params, new BeanListHandler(customer.class));
    }

    public QuertResult pageQuery(int startindex, int pagesize) {
        QuertResult qr = new QuertResult();
        String sql = "select * from customer limit " + startindex + "," + pagesize + "";
        Object params[] = {startindex, pagesize};
        List list = (List) JdbcUtils.select(sql, params, new BeanListHandler(customer.class));
        qr.setList(list);

        sql = "select count(*) from customer";
        Object params2[] ={};
        int totalrecord = (Integer) JdbcUtils.select(sql, params2, new IntHandler());
        qr.setTotalrecord(totalrecord);
        return qr;
    }
}*/
