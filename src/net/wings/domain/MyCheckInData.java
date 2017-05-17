package net.wings.domain;

/**
 * Created by wing on 2017/5/10.
 */

public class MyCheckInData {
    private int count;
    private int amount;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public MyCheckInData(int count, int amount) {
        this.count = count;
        this.amount = amount;
    }
}
