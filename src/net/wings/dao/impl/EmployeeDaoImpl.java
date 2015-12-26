package net.wings.dao.impl;

import net.wings.dao.EmployeeDao;
import net.wings.domain.*;
import net.wings.exception.DaoException;
import net.wings.utils.BeanListHandler;
import net.wings.utils.IntHandler;
import net.wings.utils.JdbcUtils;

import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
public class EmployeeDaoImpl implements EmployeeDao {
    @Override
    public void add(Employee item) {
        try {
            String sql = "insert into employee" +
                    "(id,name,gender,age,phone,train_id,train_name)" +
                    " values(?,?,?,?,?,?,?)";
            Object params[] = {
                    item.getId(),
                    item.getName(),
                    item.getGender(),
                    item.getAge(),
                    item.getPhone(),
                    item.getTrain_id(),
                    item.getTrain_name()};
            JdbcUtils.update(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            String sql = "delete from employee where id=?";
            Object params[] = {id};
            JdbcUtils.update(sql, params);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public void update(Employee item) {
        try {
            String sql = "update employee " +
                    "set name=?,gender=?,age=?,phone=?,train_id=?,train_name=? where id=?";

            Object params[] = {
                    item.getName(),
                    item.getGender(),
                    item.getAge(),
                    item.getPhone(),
                    item.getTrain_id(),
                    item.getTrain_name(),
                    item.getId()};
            JdbcUtils.update(sql, params);
            System.out.println("aa");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee find(String id) {
        try {
            String sql = "select * from employee where id=?";
            Object params[] = {id};
            return (Employee) JdbcUtils.select(sql, params,
                    new net.wings.utils.BeanHandler(Employee.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Employee findByName(String name) {
        try {
            String sql = "select * from employee where name=?";
            Object params[] = {name};
            return (Employee) JdbcUtils.select(sql, params,
                    new net.wings.utils.BeanHandler(Employee.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public List<Employee> getAll() {
        try {
            String sql = "select * from employee";
            Object params[] = {};
            return (List<Employee>) JdbcUtils.select(sql,
                    new net.wings.utils.BeanListHandler(Employee.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    @Override
    public QueryEmployeeResult pageQuery(int startindex, int pagesize) {
        QueryEmployeeResult qr = new QueryEmployeeResult();

        try {
            String sql = "select * from employee limit ?,?";
            Object params[] = {startindex, pagesize};
            List list = (List) JdbcUtils.select(sql, params,
                    new BeanListHandler(Employee.class));
            qr.setList(list);
            sql = "select count(*) from employee";
            params = new Object[]{};
            int totalrecord = (Integer) JdbcUtils.select(sql, new IntHandler());
            qr.setTotalrecord(totalrecord);
            return qr;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
