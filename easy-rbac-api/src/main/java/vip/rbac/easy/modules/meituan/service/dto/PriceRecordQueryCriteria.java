package vip.rbac.easy.modules.meituan.service.dto;

import vip.rbac.easy.annotation.Query;
import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;

/**
* @author 夜孤城
* @date 2019-08-28
*/
@Data
public class PriceRecordQueryCriteria{

    // 精确
    @Query(type = Query.Type.INNER_LIKE,joinName = "hotel",propName = "name")
    private String hotelName;

    // 精确
    @Query(type = Query.Type.INNER_LIKE)
    private String roomName;

    @Query(type = Query.Type.EQUAL)
    private Timestamp pricedate;
}