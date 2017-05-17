package net.wings.domain;

import java.util.List;

/**
 * Created by wing on 2017/4/28.
 */

public class LoginInfo extends Result {
    public String account;
    public String number;
    public String name;
    public String email;
    public String description;
    public List<String> classes;

    public LoginInfo(int code, String message) {
        super(code, message);
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }
}
