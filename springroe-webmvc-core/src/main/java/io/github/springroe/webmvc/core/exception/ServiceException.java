package io.github.springroe.webmvc.core.exception;

import io.github.springroe.data.core.exception.AbstractException;
import lombok.Getter;

public class ServiceException extends AbstractException {

    @Getter
    private final String message;

    public ServiceException(String message, String errorCode) {
        super(errorCode);
        this.message = message;
    }

    public ServiceException(String message) {
        this(message, "200");
    }

    public ServiceException(String message, Throwable e) {
        this(message, "200");
        addSuppressed(e);
    }
}
