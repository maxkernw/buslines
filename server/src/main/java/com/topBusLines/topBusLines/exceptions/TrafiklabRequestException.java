package com.topBusLines.topBusLines.exceptions;

public class TrafiklabRequestException extends RuntimeException {
    public TrafiklabRequestException() {
    }

    public TrafiklabRequestException(String message) {
        super(message);
    }

    public TrafiklabRequestException(String message, Throwable cause) {
        super(message, cause);
    }

    public TrafiklabRequestException(Throwable cause) {
        super(cause);
    }

    public TrafiklabRequestException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
