package io.github.springroe.webmvc.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult<T> extends Result {
    private String errorCode;
    private String message;
    private Boolean success;
    private T body;

    public static <T> ApiResult<T> success(String message, T body) {
        return new ApiResult<>(null, message, true, body);
    }

    public static <T> ApiResult<T> error(String message, String errorCode) {
        return new ApiResult<>(errorCode, message, false, null);
    }
}