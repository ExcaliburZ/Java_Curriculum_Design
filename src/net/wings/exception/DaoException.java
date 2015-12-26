package net.wings.exception;

/**
 * Created by wing on 2014/10/18.
 */
public class DaoException extends RuntimeException {
    public DaoException(Throwable cause) {
        super(cause);
    }

    public DaoException() {
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
