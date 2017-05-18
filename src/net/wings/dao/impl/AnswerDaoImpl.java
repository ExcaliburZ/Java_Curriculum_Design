package net.wings.dao.impl;

import net.wings.domain.*;
import net.wings.exception.DaoException;
import net.wings.utils.BeanHandler;
import net.wings.utils.BeanListHandler;
import net.wings.utils.JdbcUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wing on 2015/12/26.
 */
public class AnswerDaoImpl {
    /*
 create table answer(
 id varchar(40) primary key,
 user_account varchar(40),
 clazz_id varchar(40),
 question_id varchar(40),
 answer varchar(250) not null,
 answer_time varchar(80),
 constraint question_id_an foreign key(question_id) references question(id),
 constraint user_account_an foreign key(user_account) references user(account),
  constraint clazz_id_an foreign key(clazz_id) references clazz(id)
 );
 );
    * */
    public void add(Answer item) {
        try {
            String sql = "insert into answer" +
                    "(id,user_account,clazz_id,question_id,answer,answer_time)" +
                    " values(?,?,?,?,?,?)";
            Object params[] = {item.getId(),
                    item.getUser_account(),
                    item.getClazz_id(),
                    item.getQuestion_id(),
                    item.getAnswer(),
                    item.getAnswer_time()};
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

    public boolean findAnswer(String userAccount, String queId) {
        String sql = "select * from answer where user_account = ? and question_id= ?";
        Object params[] = {userAccount, queId};
        Answer select = (Answer) JdbcUtils.select(sql, params,
                new BeanHandler(Answer.class));
        return select != null;
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

    public List<Answer> getAnswerList(String questionId) {
        String sql = "select * from answer where question_id = ?";
        Object params[] = {questionId};
        List<Answer> answerList = (List<Answer>) JdbcUtils.select(sql, params,
                new BeanListHandler(Answer.class));
        UserDaoImpl dao = new UserDaoImpl();
        for (Answer answer : answerList) {
            String user_account = answer.getUser_account();
            User byAccount = dao.findByAccount(user_account);
            answer.setUser_name(byAccount.getName());
            answer.setUser_number(byAccount.getS_number());
        }
        return answerList;
    }
}
