package net.wings.domain;

/**
 * Created by wing on 2015/12/26.
 */
/*
    id varchar(40) primary key,
          name varchar(40) not null,
          place varchar(40) not null,
          during varchar(40) not null,
          mlimit varchar(40) not null
    * */
public class Train {
    String id;
    String name;
    String during;
    String place;
    String mlimit;

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

    public String getDuring() {
        return during;
    }

    public void setDuring(String during) {
        this.during = during;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getMlimit() {
        return mlimit;
    }

    public void setMlimit(String mlimit) {
        this.mlimit = mlimit;
    }

    public Train(String id, String name, String during, String place, String mlimit) {
        this.id = id;
        this.name = name;
        this.during = during;
        this.place = place;
        this.mlimit = mlimit;
    }

    public Train() {
    }
}
