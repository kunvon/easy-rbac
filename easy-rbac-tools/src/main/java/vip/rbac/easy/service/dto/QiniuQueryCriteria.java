package vip.rbac.easy.service.dto;

import vip.rbac.easy.annotation.Query;
import lombok.Data;

/**
 * @author Zheng Jie
 * @date 2019-6-4 09:54:37
 */
@Data
public class QiniuQueryCriteria{

    @Query(type = Query.Type.INNER_LIKE)
    private String key;
}
