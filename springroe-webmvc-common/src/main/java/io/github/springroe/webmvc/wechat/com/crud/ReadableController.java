package io.github.springroe.webmvc.wechat.com.crud;

import io.github.springroe.webmvc.core.domain.ApiResult;
import io.github.springroe.webmvc.core.web.EntityController;
import io.github.springroe.data.core.domain.Persistable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * @param <T>  entity class
 * @param <ID> id class
 * @param <D>  return DTO class
 */
public interface ReadableController<T extends Persistable<ID>, ID extends Serializable, D> extends EntityController<T, ID> {


    @Operation(summary = "获取")
    @GetMapping(path = "/{id}")
    // @SerializationFilter(templateMethodName = "getSerializationFilter")
    // @PreAuthorize("@ss.hasPermi('query')")
    default ApiResult<D> get(@Parameter(description = "id", required = true) @PathVariable ID id) {
        // TODO complete get logic
        val t = getService().getById(id);
        postEntityGet(t);
        Class<D> dClass = (Class<D>) getGenericClass(2);
        val d = convertObject(t, dClass);
        postDtoGet(d);
        return ApiResult.success("查询成功", d);
    }

    default void postEntityGet(T t) {
        // do nothing
    }

    default void postDtoGet(D t) {
        // do nothing
    }
}
