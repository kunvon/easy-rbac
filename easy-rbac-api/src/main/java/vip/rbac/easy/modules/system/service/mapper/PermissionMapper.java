package vip.rbac.easy.modules.system.service.mapper;

import vip.rbac.easy.modules.system.domain.Permission;
import vip.rbac.easy.mapper.EntityMapper;
import vip.rbac.easy.modules.system.service.dto.PermissionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PermissionMapper extends EntityMapper<PermissionDTO, Permission> {

}
