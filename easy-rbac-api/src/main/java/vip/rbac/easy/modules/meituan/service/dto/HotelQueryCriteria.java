package vip.rbac.easy.modules.meituan.service.dto;

import vip.rbac.easy.annotation.Query;
import lombok.Data;

/**
* @author 夜孤城
* @date 2019-08-28
*/
@Data
public class HotelQueryCriteria{

    // 精确
    @Query
    private String poiid;

    // 精确
    @Query
    private String realpoiid;

    // 模糊
    @Query(type = Query.Type.INNER_LIKE)
    private String name;

    // 精确
    @Query
    private Float lat;

    // 精确
    @Query
    private Float lng;

    // 精确
    @Query
    private Float scoreintro;

    // 精确
    @Query
    private Float commentscountdesc;
}