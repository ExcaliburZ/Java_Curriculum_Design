package net.wings.dao.impl;

import net.wings.domain.*;
import net.wings.exception.DaoException;
import net.wings.utils.BeanHandler;
import net.wings.utils.BeanListHandler;
import net.wings.utils.JdbcUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
public class CheckInDaoImpl {
    /*
    create table check_in(
     id varchar(40) primary key,
     password varchar(40) not null,
     createTime varchar(40) not null,
     clazz_id varchar(40),
     constraint clazz_check_FK foreign key(clazz_id) references clazz(id)
     );
    * */
    public void add(CheckIn item) {
        try {
            String sql = "insert into check_in" +
                    "(id,password,createTime,clazz_id)" +
                    " values(?,?,?,?)";
            Object params[] = {item.getId(), item.getPassword(), item.getCreateTime(), item.getClazz_id()};
            JdbcUtils.update(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CheckIn getLastCheck(String classId) {
        String sql = "select * from check_in where clazz_id = ? order by createTime desc limit 1;";
        Object params[] = {classId};
        return (CheckIn) JdbcUtils.select(sql, params,
                new BeanHandler(CheckIn.class));
    }

    public boolean hasCheckIn(String userAccount, String CheckInId) {
        String sql = "select * from student_check_in where user_account = ? and check_in_id = ?;";
        Object params[] = {userAccount, CheckInId};
        StudentCheckIn select = (StudentCheckIn) JdbcUtils.select(sql, params,
                new BeanHandler(StudentCheckIn.class));
        return select != null;
    }

    /*
    *  create table student_check_in(
 user_account varchar(40),
 name varchar(40) not null,
 clazz_id varchar(40),
 s_number varchar(20),
 check_time varchar(40),
 check_in_id varchar(40),
 constraint check_in_id_sc foreign key(check_in_id) references check_in(id),
 constraint user_account_sc foreign key(user_account) references user(account),
  constraint clazz_id_sc foreign key(clazz_id) references clazz(id)
 );
    * */
    public void studentCheckIn(String clazzId, String studentID, String studentName,
                               String studentNumber, String time, String checkInID) {
        try {
            String sql = "insert into student_check_in " +
                    "(clazz_id,user_account,name,s_number,check_time,check_in_id)" +
                    " values(?,?,?,?,?,?)";
            Object params[] = {clazzId, studentID, studentName, studentNumber, time, checkInID};
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
    public List<CheckIn> getCheckInListByClazzID(String clazzID) {
        try {
            String sql = "select * from check_in where clazz_id = ?";
            Object params[] = {clazzID};
            List<CheckIn> selectClazzList = (List<CheckIn>) JdbcUtils.select(sql, params,
                    new BeanListHandler(CheckIn.class));
            return selectClazzList;
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

    public MyCheckInData getMyCheckInData(String clazzId, String account) {
        String sql = "select * from check_in where clazz_id = ?";
        Object params[] = {clazzId};
        List<CheckIn> selectClazzList = (List<CheckIn>) JdbcUtils.select(sql, params,
                new BeanListHandler(CheckIn.class));
        String sql_sc = "select * from student_check_in where user_account = ? and clazz_id = ?;";
        Object param_sc[] = {account, clazzId};
        List<StudentCheckIn> select = (List<StudentCheckIn>) JdbcUtils.select(sql_sc, param_sc,
                new BeanListHandler(StudentCheckIn.class));
        return new MyCheckInData(select == null ? 0 : select.size(),
                selectClazzList == null ? 0 : selectClazzList.size());
    }

    public CheckInResultData getCheckInResultData(CheckInRequest request) {
        CheckInResultData resultData = new CheckInResultData();
        String sql = "select * from check_in where clazz_id = ?";
        Object params[] = {request.getClassID()};
        List<CheckIn> selectClazzList = (List<CheckIn>) JdbcUtils.select(sql, params,
                new BeanListHandler(CheckIn.class));
        resultData.setAmount(selectClazzList.size());
        List<CheckInItem> checkInItemList = new ArrayList<>();
        for (String account : request.getAccountList()) {
            CheckInItem item = new CheckInItem();
            String sql_sc = "select * from student_check_in where user_account = ? and clazz_id = ?;";
            Object param_sc[] = {account, request.getClassID()};
            List<StudentCheckIn> select = (List<StudentCheckIn>) JdbcUtils.select(sql_sc, param_sc,
                    new BeanListHandler(StudentCheckIn.class));
            UserDaoImpl dao = new UserDaoImpl();
            User user = dao.findByAccount(account);
            item.setCount(select.size());
            item.setAccount(account);
            item.setName(user.getName());
            item.setS_number(user.getS_number());
            checkInItemList.add(item);
        }
        resultData.setCheckInList(checkInItemList);
        return resultData;
    }
}
