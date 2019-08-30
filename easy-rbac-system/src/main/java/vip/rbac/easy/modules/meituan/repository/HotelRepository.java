package vip.rbac.easy.modules.meituan.repository;

import vip.rbac.easy.modules.meituan.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
* @author 夜孤城
* @date 2019-08-28
*/
public interface HotelRepository extends JpaRepository<Hotel, String>, JpaSpecificationExecutor {
}