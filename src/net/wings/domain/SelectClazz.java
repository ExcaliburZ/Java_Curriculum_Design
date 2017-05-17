package net.wings.domain;

import java.io.Serializable;

/**
 * Created by wing on 2017/5/2.
 * create table select_clazz(
 * user_account varchar(40),
 * name varchar(40) not null,
 * clazz_id varchar(40),
 * s_number varchar(20),
 * constraint user_account_FK foreign key(user_account) references user(account),
 * constraint clazz_id_FK foreign key(clazz_id) references clazz(id)
 * );
 */

public class SelectClazz implements Serializable {
    private String user_account;
    private String s_number;
    private String clazz_id;
    private String name;

    public SelectClazz() {
    }

    public SelectClazz(String user_account, String s_number, String clazz_id, String name) {
        this.user_account = user_account;
        this.s_number = s_number;
        this.clazz_id = clazz_id;
        this.name = name;
    }

    public String getUser_account() {
        return user_account;
    }

    public void setUser_account(String user_account) {
        this.user_account = user_account;
    }

    public String getS_number() {
        return s_number;
    }

    public void setS_number(String s_number) {
        this.s_number = s_number;
    }

    public String getClazz_id() {
        return clazz_id;
    }

    public void setClazz_id(String clazz_id) {
        this.clazz_id = clazz_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
