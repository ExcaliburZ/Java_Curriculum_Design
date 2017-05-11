package net.wings.domain;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wing on 2017/5/10.
 * <p>
 * create table user(
 * account varchar(40) primary key,
 * name varchar(40) not null,
 * password varchar(4) not null,
 * email varchar(40) not null,
 * s_number varchar(20),
 * description varchar(160)
 * );
 */
public class User {
    private String account;
    private String name;
    private String password;
    private String email;
    @SerializedName("number")
    private String s_number;
    private String description;

    public String getAccount() {
        return account;
    }

    public User() {
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getS_number() {
        return s_number;
    }

    public void setS_number(String s_number) {
        this.s_number = s_number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User(String account, String name, String password, String email, String number, String description) {
        this.account = account;
        this.name = name;
        this.password = password;
        this.email = email;
        this.s_number = number;
        this.description = description;
    }
}
