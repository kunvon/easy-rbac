package vip.rbac.easy.modules.meituan.service.dto;

import lombok.Data;
import java.io.Serializable;


/**
* @author 夜孤城
* @date 2019-08-28
*/
@Data
public class HotelDTO implements Serializable {

    // 酒店ID
    private String poiid;

    // 酒店真实ID
    private String realpoiid;

    // 酒店名称
    private String name;

    // 经度
    private Float lat;

    // 纬度
    private Float lng;

    // 标签
    private String poirecommendtag;

    // 星级
    private Float scoreintro;

    // 评论数量
    private Float commentscountdesc;
}