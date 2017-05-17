package net.wings.domain;

/**
 * Created by wing on 2017/5/14.
 * create table check_in(
 * id varchar(40) primary key,
 * password varchar(40) not null,
 * createTime varchar(40) not null,
 * clazz_id varchar(40),
 * constraint clazz_check_FK foreign key(clazz_id) references clazz(id)
 * );
 */
public class CheckIn {
    private String id;
    private String password;
    private String createTime;
    private String clazz_id;

    public CheckIn() {
    }

    public CheckIn(String id, String password, String createTime, String clazz_id) {
        this.id = id;
        this.password = password;
        this.createTime = createTime;
        this.clazz_id = clazz_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getClazz_id() {
        return clazz_id;
    }

    public void setClazz_id(String clazz_id) {
        this.clazz_id = clazz_id;
    }
}
