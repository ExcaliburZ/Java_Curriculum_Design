package net.wings.domain;

import java.sql.Statement;

/**
 * Created by wing on 2014/10/20.
 */
public class QueryInfo {
    private int pagesize = 10;
    private int currentpage = 1;
    private int startindex;
    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getStartindex() {
        this.startindex = (this.currentpage - 1) * this.pagesize;
        return startindex;
    }
}
