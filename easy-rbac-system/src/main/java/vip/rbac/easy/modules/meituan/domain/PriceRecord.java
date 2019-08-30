package vip.rbac.easy.modules.meituan.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.sql.Timestamp;
import java.math.BigDecimal;
import java.io.Serializable;

/**
* @author 夜孤城
* @date 2019-08-28
*/
@Entity
@Data
@Table(name="meituan_price_record")
public class PriceRecord implements Serializable {

    // 自增主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    // 抓取时间
    @Column(name = "clawTime",nullable = false)
    private Timestamp clawtime;

    // 价格时间
    @Column(name = "priceDate",nullable = false)
    private Timestamp pricedate;

    // 房间名称
    @Column(name = "roomName",nullable = false)
    private String roomname;

    // 价格
    @Column(name = "price",nullable = false)
    private BigDecimal price;

    // 剩余房间数
    @Column(name = "leftRoom",nullable = false)
    private Integer leftroom;

    // 标签
    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "hotelId",nullable = false)
    private Hotel hotel;

    public void copy(PriceRecord source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}