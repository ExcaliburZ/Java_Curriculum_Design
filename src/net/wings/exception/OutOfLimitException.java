package net.wings.exception;

/**
 * Created by wing on 2015/12/26.
 */
public class OutOfLimitException extends RuntimeException {
    public OutOfLimitException(Throwable cause) {
        super(cause);
    }

    public OutOfLimitException() {
    }

    public OutOfLimitException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfLimitException(String message) {
        super(message);
    }

    public OutOfLimitException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
