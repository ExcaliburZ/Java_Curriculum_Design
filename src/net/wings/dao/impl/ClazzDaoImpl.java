package net.wings.dao.impl;

import net.wings.domain.Clazz;
import net.wings.domain.User;
import net.wings.exception.DaoException;
import net.wings.utils.BeanHandler;
import net.wings.utils.BeanListHandler;
import net.wings.utils.JdbcUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
public class ClazzDaoImpl {

    public void add(Clazz item) {
        try {
            String sql = "insert into clazz" +
                    "(id,name,limitNum,createTime,create_user_account)" +
                    " values(?,?,?,?,?)";
            Object params[] = {
                    item.getId(),
                    item.getName(),
                    item.getLimitNum(),
                    item.getCreateTime(),
                    item.getCreate_user_account()};
            JdbcUtils.update(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //    public void delete(String id) {
//        try {
//            String sql = "delete from train where id=?";
//            Object params[] = {id};
//            JdbcUtils.update(sql, params);
//        } catch (Exception e) {
//            throw new DaoException(e);
//        }
//    }
//
//    public void update(Train item) {
//        try {
//            String sql = "update train set name=?,place=?,during=?,mlimit=? where id=?";
//
//            Object params[] = {
//                    item.getName(),
//                    item.getPlace(),
//                    item.getDuring(),
//                    item.getMlimit(),
//                    item.getId()};
//            JdbcUtils.update(sql, params);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
    public User findByAccount(String account) {
        try {
            String sql = "select * from user where account = ?";
            Object params[] = {account};
            return (User) JdbcUtils.select(sql, params,
                    new BeanHandler(User.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }


    public User findByNumber(String number) {
        try {
            String sql = "select * from user where s_number=?";
            Object params[] = {number};
            return (User) JdbcUtils.select(sql, params,
                    new BeanHandler(User.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    //
    public List<Clazz> getClassListByAccount(String account) {
        try {
            String sql = "select * from clazz where create_user_account = ?";
            Object params[] = {account};
            return (List<Clazz>) JdbcUtils.select(sql, params,
                    new net.wings.utils.BeanListHandler(Clazz.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Clazz getClass(String id) {
        try {
            String sql = "select * from clazz where id = ?";
            Object params[] = {id};
            return (Clazz) JdbcUtils.select(sql, params,
                    new net.wings.utils.BeanHandler(Clazz.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<Clazz> searchClass(String key) {
        List<Clazz> result = new ArrayList<>();
        try {
            String sql = "select * from clazz where create_user_account like ?";
            Object params[] = {key + "%"};
            List<Clazz> select = (List<Clazz>) JdbcUtils.select(sql, params,
                    new BeanListHandler(Clazz.class));
            String sql_name = "select * from clazz where name like ?";
            Object param_name[] = {key + "%"};
            List<Clazz> byName = (List<Clazz>) JdbcUtils.select(sql_name, param_name,
                    new BeanListHandler(Clazz.class));
            result.addAll(select);
            result.addAll(byName);
            return result;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
