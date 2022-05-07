package io.github.springroe.webmvc.wechat.com.crud;

import io.github.springroe.webmvc.core.domain.ApiResult;
import io.github.springroe.webmvc.core.web.EntityController;
import io.github.springroe.data.core.domain.Persistable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.val;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.Serializable;

/**
 * @param <T>  entity class
 * @param <ID> id class
 * @param <S>  post body
 * @param <D>  return DTO class
 */
public interface InsertableController<T extends Persistable<ID>, ID extends Serializable, S, D> extends EntityController<T, ID> {


    @Operation(summary = "新增")
    @PostMapping(path = "/")
    // @SerializationFilter(templateMethodName = "getSerializationFilter")
    // @PreAuthorize("@ss.hasPermi('query')")
    // @OperateLogMethod(buildLogMethodName = "saveLog")
    default ApiResult<D> insert(@Parameter(description = "data", required = true) @RequestBody S s) {
        // TODO complete insert logic
        preDtoInsert(s);
        var t = convertObject(s, getEntityClass());
        preEntityInsert(t);
        t = getService().add(t);
        Class<D> dClass = (Class<D>) getGenericClass(3);
        val d = convertObject(t, dClass);
        return ApiResult.success("新增成功", d);
    }

    default void preDtoInsert(S s) {
        // do nothing
    }

    default void preEntityInsert(T t) {
        // do nothing
    }

}
