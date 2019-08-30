package vip.rbac.easy.modules.system.service.dto;

import lombok.Data;
import vip.rbac.easy.annotation.Query;

/**
 * 公共查询类
 */
@Data
public class CommonQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String name;
}
