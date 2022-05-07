package io.github.springroe.webmvc.core.service;

import io.github.springroe.data.core.domain.Persistable;

import java.io.Serializable;

public abstract class AbstractEntityService<T extends Persistable<ID>, ID extends Serializable>
        implements EntityService<T, ID> {

}
