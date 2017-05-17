package net.wings.dao.impl;

import net.wings.domain.Clazz;
import net.wings.domain.SelectClazz;
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
public class SelectClazzDaoImpl {

    public void add(SelectClazz item) {
        try {
            String sql = "insert into select_clazz" +
                    "(clazz_id,name,user_account,s_number)" +
                    " values(?,?,?,?)";
            Object params[] = {
                    item.getClazz_id(), item.getName(), item.getUser_account(), item.getS_number()};
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

    //
    public List<User> getStudentListByClazzID(String clazzID) {
        try {
            String sql = "select * from select_clazz where clazz_id = ?";
            Object params[] = {clazzID};
            List<SelectClazz> selectClazzList = (List<SelectClazz>) JdbcUtils.select(sql, params,
                    new BeanListHandler(SelectClazz.class));
            List<User> userList = new ArrayList<>();
            for (SelectClazz clazz : selectClazzList) {
                User student = new User();
                student.setAccount(clazz.getUser_account());
                student.setName(clazz.getName());
                student.setS_number(clazz.getS_number());
                userList.add(student);
            }
            return userList;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<Clazz> getClazzListByStudentAccount(String account) {
        try {
            String sql = "select * from select_clazz where user_account = ?";
            Object params[] = {account};
            List<SelectClazz> clazzIdList = (List<SelectClazz>) JdbcUtils.select(sql, params,
                    new BeanListHandler(SelectClazz.class));
            List<Clazz> clazzList = new ArrayList<>();
            for (SelectClazz id : clazzIdList) {
                ClazzDaoImpl dao = new ClazzDaoImpl();
                Clazz clazz = dao.getClass(id.getClazz_id());
                clazzList.add(clazz);
            }
            return clazzList;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public boolean hasJoin(String clazzId, String account) {
        try {
            String sql = "select * from select_clazz where clazz_id=? and user_account = ?";
            Object params[] = {clazzId, account};
            SelectClazz select = (SelectClazz) JdbcUtils.select(sql, params,
                    new BeanHandler(SelectClazz.class));
            return select != null;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public boolean hasOutOfLimit(String clazzId) {
        ClazzDaoImpl dao = new ClazzDaoImpl();
        Clazz aClass = dao.getClass(clazzId);
        int limitNum = aClass.getLimitNum();
        String sql = "select * from select_clazz where clazz_id=?";
        Object params[] = {clazzId};
        List<SelectClazz> select = (List<SelectClazz>) JdbcUtils.select(sql, params,
                new BeanListHandler(SelectClazz.class));
        return limitNum <= select.size();
    }

    public void joinClass(String clazzId, String account) {
        UserDaoImpl dao = new UserDaoImpl();
        User byAccount = dao.findByAccount(account);
        SelectClazz selectClazz = new SelectClazz();
        selectClazz.setClazz_id(clazzId);
        selectClazz.setName(byAccount.getName());
        selectClazz.setS_number(byAccount.getS_number());
        selectClazz.setUser_account(byAccount.getAccount());
        add(selectClazz);
    }
}
