package io.github.springroe.webmvc.wechat.com.crud;

import io.github.springroe.webmvc.core.domain.ApiResult;
import io.github.springroe.webmvc.core.web.EntityController;
import io.github.springroe.data.core.domain.Persistable;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.Serializable;

/**
 * @param <T>  entity class
 * @param <ID> id class
 */
public interface DeletableController<T extends Persistable<ID>, ID extends Serializable> extends EntityController<T, ID> {


    @Operation(summary = "删除")
    @DeleteMapping(path = "/{id}")
    // @SerializationFilter(templateMethodName = "getSerializationFilter")
    // @PreAuthorize("@ss.hasPermi('delete')")
    // @OperateLogMethod(buildLogMethodName = "deleteLog")
    default ApiResult<?> delete(@Parameter(description = "id", required = true) @PathVariable ID id) {
        // TODO complete delete logic
        getService().deleteById(id);
        return ApiResult.success("删除成功", null);
    }

}
