package vip.rbac.easy.modules.system.service.mapper;

import vip.rbac.easy.modules.system.domain.User;
import vip.rbac.easy.mapper.EntityMapper;
import vip.rbac.easy.modules.system.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring",uses = {RoleMapper.class, DeptMapper.class, JobMapper.class},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
