package net.wings.domain;

import java.util.List;

/**
 * Created by wing on 2014/10/20.
 */
public class QuertResult {
    private List<customer> list; //������Ҫ��ʾҳ������
    private int totalrecord;    //���ݵ�����Ŀ

    public List<customer> getList() {
        return list;
    }

    public void setList(List<customer> list) {
        this.list = list;
    }

    public int getTotalrecord() {
        return totalrecord;
    }

    public void setTotalrecord(int totalrecord) {
        this.totalrecord = totalrecord;
    }
}
