package vip.rbac.easy.modules.meituan.service.mapper;

import vip.rbac.easy.mapper.EntityMapper;
import vip.rbac.easy.modules.meituan.domain.Hotel;
import vip.rbac.easy.modules.meituan.service.dto.HotelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author 夜孤城
* @date 2019-08-28
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface HotelMapper extends EntityMapper<HotelDTO, Hotel> {

}