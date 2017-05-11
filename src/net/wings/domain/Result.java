package net.wings.domain;

/**
 * Created by wing on 2017/4/28.
 */

public class Result {
    public int code;
    public String message;

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                '}';
    }
}
