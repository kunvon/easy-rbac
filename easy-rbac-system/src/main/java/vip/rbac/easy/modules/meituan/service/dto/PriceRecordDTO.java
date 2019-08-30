package vip.rbac.easy.modules.meituan.service.dto;

import vip.rbac.easy.modules.meituan.domain.Hotel;
import lombok.Data;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;


/**
* @author 夜孤城
* @date 2019-08-28
*/
@Data
public class PriceRecordDTO implements Serializable {

    // 自增主键
    private Integer id;

    // 抓取时间
    private Timestamp clawtime;

    // 价格时间
    private Timestamp pricedate;

    // 房间名称
    private String roomname;

    // 价格
    private BigDecimal price;

    // 剩余房间数
    private Integer leftroom;

    // 标签
    private String description;

    private Hotel hotel;
}