package vip.rbac.easy.modules.system.service.mapper;

import vip.rbac.easy.mapper.EntityMapper;
import vip.rbac.easy.modules.system.domain.Role;
import vip.rbac.easy.modules.system.service.dto.RoleSmallDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2019-5-23
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleSmallMapper extends EntityMapper<RoleSmallDTO, Role> {

}
