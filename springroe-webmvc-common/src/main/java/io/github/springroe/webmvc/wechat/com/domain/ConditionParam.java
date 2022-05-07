package io.github.springroe.webmvc.wechat.com.domain;

import lombok.*;

import java.util.Collections;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConditionParam {
    private String name = null;
    private List<?> values = Collections.emptyList();
    private List<ConditionParam> conditions = Collections.emptyList();
    private ConditionType condition = null;
}
