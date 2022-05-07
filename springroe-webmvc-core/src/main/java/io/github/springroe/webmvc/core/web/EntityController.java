package io.github.springroe.webmvc.core.web;

import io.github.springroe.webmvc.core.convert.EntityConvertSupport;
import io.github.springroe.webmvc.core.reflect.GenericHelper;
import io.github.springroe.webmvc.core.service.EntityService;
import io.github.springroe.data.core.domain.Persistable;

import java.io.Serializable;

public interface EntityController<T extends Persistable<ID>, ID extends Serializable>
        extends SpringroeController,
        EntityConvertSupport {

    EntityService<T, ID> getService();


    default Class<T> getEntityClass() {
        return getService().getEntityClass();
    }

    default Class<?> getGenericClass(int index) {
        return GenericHelper.getGenericClass(getClass(), index);
    }


}
