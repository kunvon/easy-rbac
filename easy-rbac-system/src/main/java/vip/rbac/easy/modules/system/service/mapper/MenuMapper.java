package vip.rbac.easy.modules.system.service.mapper;

import vip.rbac.easy.modules.system.domain.Menu;
import vip.rbac.easy.mapper.EntityMapper;
import vip.rbac.easy.modules.system.service.dto.MenuDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Zheng Jie
 * @date 2018-12-17
 */
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MenuMapper extends EntityMapper<MenuDTO, Menu> {

}
