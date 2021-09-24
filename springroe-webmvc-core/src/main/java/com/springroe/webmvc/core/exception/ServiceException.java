package com.springroe.webmvc.core.exception;

import io.github.springroe.data.core.exception.AbstractException;

public class ServiceException extends AbstractException {
    public ServiceException(String message, String errorCode) {
        super(message, errorCode);
    }

    public ServiceException(String message, Throwable throwable, String errorCode) {
        super(message, throwable, errorCode);
    }

    public ServiceException(Throwable cause, String errorCode) {
        super(cause, errorCode);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, String errorCode) {
        super(message, cause, enableSuppression, writableStackTrace, errorCode);
    }

    public ServiceException(String errorCode) {
        super(errorCode);
    }
}
