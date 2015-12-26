package net.wings.domain;

import java.util.Date;

/**
 * Created by wing on 2014/10/18.
 */
public class customer {
    String id;
    String name;
    String gender;
    Date birthday;
    String cellphone;
    String email;
    String preference;
    String type;
    String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public customer() {
    }

    public customer(String id, String gender, String name, Date birthday, String cellphone, String email, String preference, String type, String description) {

        this.id = id;
        this.gender = gender;
        this.name = name;
        this.birthday = birthday;
        this.cellphone = cellphone;
        this.email = email;
        this.preference = preference;
        this.type = type;
        this.description = description;
    }
}
