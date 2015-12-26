package net.wings.domain;

/**
 * Created by wing on 2015/12/26.
 */

/*
 create table employee(
         id varchar(40) primary key,
         name varchar(40) not null,
         gender varchar(4) not null,
         age varchar(40) not null,
         phone varchar(20),
         train_id varchar(40),
        constraint category_id_FK foreign key(train_id) references train(id)
          );
* */
public class Employee {
    String id;
    String name;
    String gender;
    String age;
    String phone;
    String train_id;
    String train_name;

    public String getTrain_name() {
        return train_name;
    }

    public void setTrain_name(String train_name) {
        this.train_name = train_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTrain_id() {
        return train_id;
    }

    public void setTrain_id(String train_id) {
        this.train_id = train_id;
    }

    public Employee(String id, String name, String gender, String age, String phone, String train_id, String train_name) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.phone = phone;
        this.train_id = train_id;
        this.train_name = train_name;
    }

    public Employee() {
    }
}
