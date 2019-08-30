package vip.rbac.easy.modules.system.service.mapper;

import vip.rbac.easy.mapper.EntityMapper;
import vip.rbac.easy.modules.system.domain.Dept;
import vip.rbac.easy.modules.system.service.dto.DeptSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author Zheng Jie
* @date 2019-03-25
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DeptSmallMapper extends EntityMapper<DeptSmallDTO, Dept> {

}