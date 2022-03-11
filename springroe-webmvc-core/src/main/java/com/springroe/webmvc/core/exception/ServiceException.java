package com.springroe.webmvc.core.exception;

import io.github.springroe.data.core.exception.AbstractException;

public class ServiceException extends AbstractException {

    public ServiceException(String errorCode) {
        super(errorCode);
    }

}
