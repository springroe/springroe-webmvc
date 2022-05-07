package io.github.springroe.webmvc.core.convert;

import io.github.springroe.webmvc.core.exception.ServiceException;

import java.lang.reflect.InvocationTargetException;

public interface EntityConvertSupport {

    default <D> D convertObject(Object source, Class<D> targetClazz) {
        D dataObject = null;
        try {
            dataObject = targetClazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new ServiceException("500");
        }
        return dataObject;
    }


}
