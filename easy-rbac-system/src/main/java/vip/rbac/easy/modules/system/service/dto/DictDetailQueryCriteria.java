package vip.rbac.easy.modules.system.service.dto;

import lombok.Data;
import vip.rbac.easy.annotation.Query;

/**
* @author Zheng Jie
* @date 2019-04-10
*/
@Data
public class DictDetailQueryCriteria {

    @Query(type = Query.Type.INNER_LIKE)
    private String label;

    @Query(propName = "name",joinName = "dict")
    private String dictName;
}