package net.wings.domain;

import java.util.List;

/**
 * Created by wing on 2014/10/20.
 */
public class EmployeePageBean {
    private List<Employee> list;
    private int totalpage;
    private int totalrecord;
    private int currentpage;
    private int pagesize;
    private int previouspage;
    private int nextpage;
    private int pagebar[];

    public void setPagebar(int[] pagebar) {
        this.pagebar = pagebar;
    }

    public int[] getPagebar() {

        int startpage;
        int endpage;
        int pagebar[] = null;
        if (this.totalpage <= 10) {
            pagebar = new int[this.totalpage];
            startpage = 1;
            endpage = this.totalpage;
        } else {
            pagebar = new int[10];
            startpage = this.currentpage - 4;
            endpage = this.currentpage + 5;
            //总页数=30      29   34   21   30
            if (startpage < 1) {
                startpage = 1;
                endpage = 10;
            }
            if (endpage > this.totalpage) {
                endpage = this.totalpage;
                startpage = this.totalpage - 9;
            }
        }

        int index = 0;
        for (int i = startpage; i <= endpage; i++) {
            pagebar[index++] = i;
        }

        this.pagebar = pagebar;
        return this.pagebar;

    }

    public List<Employee> getList() {
        return list;
    }

    public void setList(List<Employee> list) {
        this.list = list;
    }

    public int getTotalrecord() {
        return totalrecord;
    }

    public void setTotalrecord(int totalrecord) {
        this.totalrecord = totalrecord;
    }

    public int getCurrentpage() {
        return currentpage;
    }

    public void setCurrentpage(int currentpage) {
        this.currentpage = currentpage;
    }

    public int getTotalpage() {
        if (this.totalrecord % this.pagesize == 0) {
            this.totalpage = this.totalrecord / this.pagesize;
        } else {
            this.totalpage = (this.totalrecord / this.pagesize) + 1;
        }
        return totalpage;
    }

    public int getPreviouspage() {
        if (currentpage - 1 < 1) {
            this.previouspage = 1;
        } else {
            this.previouspage = this.currentpage - 1;
        }
        return previouspage;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getNextpage() {
        if (this.currentpage + 1 > this.totalpage) {
            this.nextpage = this.totalpage;
        } else {
            this.nextpage = this.currentpage + 1;
        }
        return nextpage;
    }


}
