package net.wings.dao.impl;

import net.wings.domain.User;
import net.wings.exception.DaoException;
import net.wings.utils.BeanHandler;
import net.wings.utils.JdbcUtils;

/**
 * Created by wing on 2015/12/26.
 */
public class UserDaoImpl {

    public void add(User item) {
        try {
            String sql = "insert into user" +
                    "(account,name,password,email,s_number,description)" +
                    " values(?,?,?,?,?,?)";
            Object params[] = {
                    item.getAccount(),
                    item.getName(),
                    item.getPassword(),
                    item.getEmail(),
                    item.getS_number(),
                    item.getDescription()};
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
                    new net.wings.utils.BeanHandler(User.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Boolean Login(User user) {
        String account = user.getAccount();
        String password = user.getPassword();
        try {
            String sql = "select * from user where account = ?";
            Object params[] = {account};
            User select = (User) JdbcUtils.select(sql, params,
                    new BeanHandler(User.class));
            return select.getPassword().equals(password);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }


    public User findByNumber(String number) {
        try {
            String sql = "select * from user where s_number=?";
            Object params[] = {number};
            return (User) JdbcUtils.select(sql, params,
                    new net.wings.utils.BeanHandler(User.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
//
//    public List<Train> getAll() {
//        try {
//            String sql = "select * from train";
//            Object params[] = {};
//            return (List<Train>) JdbcUtils.select(sql,
//                    new net.wings.utils.BeanListHandler(Train.class));
//        } catch (Exception e) {
//            throw new DaoException(e);
//        }
//    }
}
