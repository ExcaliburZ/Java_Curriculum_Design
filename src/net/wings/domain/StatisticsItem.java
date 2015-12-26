package net.wings.domain;

/**
 * Created by wing on 2015/12/26.
 */
public class StatisticsItem {
    private String id;
    private String name;
    private String mlimit;
    private String count;

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

    public String getMlimit() {
        return mlimit;
    }

    public void setMlimit(String mlimit) {
        this.mlimit = mlimit;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
