package vip.rbac.easy.service.mapper;

import vip.rbac.easy.service.dto.LogSmallDTO;
import vip.rbac.easy.domain.Log;
import vip.rbac.easy.mapper.EntityMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2019-5-22
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LogSmallMapper extends EntityMapper<LogSmallDTO, Log> {

}