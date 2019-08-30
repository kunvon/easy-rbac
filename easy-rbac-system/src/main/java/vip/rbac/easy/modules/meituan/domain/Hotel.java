package vip.rbac.easy.modules.meituan.domain;

import lombok.Data;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import javax.persistence.*;
import java.io.Serializable;

/**
* @author 夜孤城
* @date 2019-08-28
*/
@Entity
@Data
@Table(name="meituan_hotel")
public class Hotel implements Serializable {

    // 酒店ID
    @Id
    @Column(name = "poiid")
    private String poiid;

    // 酒店真实ID
    @Column(name = "realPoiId")
    private String realpoiid;

    // 酒店名称
    @Column(name = "name",nullable = false)
    private String name;

    // 经度
    @Column(name = "lat",nullable = false)
    private Float lat;

    // 纬度
    @Column(name = "lng",nullable = false)
    private Float lng;

    // 标签
    @Column(name = "poiRecommendTag")
    private String poirecommendtag;

    // 星级
    @Column(name = "scoreIntro")
    private Float scoreintro;

    // 评论数量
    @Column(name = "commentsCountDesc")
    private Float commentscountdesc;

    public void copy(Hotel source){
        BeanUtil.copyProperties(source,this, CopyOptions.create().setIgnoreNullValue(true));
    }
}