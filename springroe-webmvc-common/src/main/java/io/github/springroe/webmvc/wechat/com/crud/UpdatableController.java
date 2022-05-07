package io.github.springroe.webmvc.wechat.com.crud;

import io.github.springroe.webmvc.core.domain.ApiResult;
import io.github.springroe.webmvc.core.web.EntityController;
import io.github.springroe.data.core.domain.Persistable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.val;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

/**
 * @param <T>  entity class
 * @param <ID> id class
 * @param <S>  post body
 * @param <D>  return DTO class
 */
public interface UpdatableController<T extends Persistable<ID>, ID extends Serializable, S, D> extends EntityController<T, ID> {

    @Operation(summary = "更新")
    @PutMapping(path = "/{id}")
    // @SerializationFilter(templateMethodName = "getSerializationFilter")
    // @PreAuthorize("@ss.hasPermi('query')")
    // @OperateLogMethod(buildLogMethodName = "saveLog")
    default ApiResult<D> update(@Parameter(description = "id", required = true) @PathVariable ID id, @Parameter(description = "data", required = true) @RequestBody S s) {
        // TODO complete update logic
        preDtoUpdate(s);
        var t = convertObject(s, getEntityClass());
        preEntityUpdate(t);
        t = getService().update(t);
        Class<D> dClass = (Class<D>) getGenericClass(3);
        val d = convertObject(t, dClass);
        return ApiResult.success("更新成功", d);
    }

    default void preDtoUpdate(S s) {
        // do nothing
    }

    default void preEntityUpdate(T t) {
        // do nothing
    }

}
