package net.wings.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by wing on 2017/5/2.
 */

public class Clazz implements Serializable {
    private String name;
    private String id;
    private int limitNum;
    private String createTime;
    private List<User> studentList;
    private String create_user_account;

    public String getCreate_user_account() {
        return create_user_account;
    }

    public void setCreate_user_account(String create_user_account) {
        this.create_user_account = create_user_account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(int limitNum) {
        this.limitNum = limitNum;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<User> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<User> studentList) {
        this.studentList = studentList;
    }
}
