package io.github.springroe.webmvc.wechat.com.crud;

import io.github.springroe.webmvc.core.domain.ApiResult;
import io.github.springroe.webmvc.core.web.EntityController;
import io.github.springroe.data.core.domain.Persistable;
import io.swagger.v3.oas.annotations.Operation;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @param <T>  entity class
 * @param <ID> id class
 * @param <D>  return DTO class
 */
public interface AllListController<T extends Persistable<ID>, ID extends Serializable, D> extends EntityController<T, ID> {

    @Operation(summary = "List")
    @GetMapping(path = "/list")
    // @SerializationFilter(templateMethodName = "listSerializationFilter")
    // @PreAuthorize("@ss.hasPermi('query')")
    default ApiResult<Iterable<D>> list() {
        // TODO complete list find logic
        val list = new ArrayList<D>();
        return ApiResult.success("查询成功", list);
    }

}
