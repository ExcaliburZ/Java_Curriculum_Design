package net.wings.dao.impl;

import net.wings.domain.*;
import net.wings.exception.DaoException;
import net.wings.utils.BeanListHandler;
import net.wings.utils.JdbcUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
public class QuestionDaoImpl {
    /*
  create table question(
 id varchar(40) primary key,
 title varchar(160) not null,
 create_time varchar(80),
 content varchar(250),
 clazz_id varchar(40),
 constraint clazz_que_FK foreign key(clazz_id) references clazz(id)
 );
 );
    * */
    public void add(Question item) {
        try {
            String sql = "insert into question" +
                    "(id,title,content,create_time,clazz_id)" +
                    " values(?,?,?,?,?)";
            Object params[] = {item.getId(),
                    item.getTitle(),
                    item.getContent(),
                    item.getCreate_time(),
                    item.getClazz_id()};
            JdbcUtils.update(sql, params);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
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

    public List<Document> getDocList(String clazzId) {
        try {
            String sql = "select * from document where clazz_id = ?";
            Object params[] = {clazzId};
            List<Document> documentList = (List<Document>) JdbcUtils.select(sql, params,
                    new BeanListHandler(Document.class));
            return documentList;
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public void removeDoc(String id) {
        try {
            Document document = find(id);
            File file = new File(document.getDownload_url() + "\\" + document.getUuidname());
            if (file.exists()) {
                boolean delete = file.delete();
            }
            String sql = "delete from document where id=?";
            Object params[] = {id};
            JdbcUtils.update(sql, params);
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public Document find(String id) {
        try {
            String sql = "select * from document where id = ?";
            Object params[] = {id};
            return (Document) JdbcUtils.select(sql, params,
                    new net.wings.utils.BeanHandler(Document.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }

    public List<Question> getQuestionList(String clazzId) {
        try {
            String sql = "select * from question where clazz_id = ?";
            Object params[] = {clazzId};
            return (List<Question>) JdbcUtils.select(sql, params,
                    new BeanListHandler(Question.class));
        } catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
