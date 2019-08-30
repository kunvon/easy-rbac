package vip.rbac.easy.modules.meituan.service;

import vip.rbac.easy.modules.meituan.domain.Hotel;
import vip.rbac.easy.modules.meituan.service.dto.HotelDTO;
import vip.rbac.easy.modules.meituan.service.dto.HotelQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author 夜孤城
* @date 2019-08-28
*/
//@CacheConfig(cacheNames = "Hotel")
public interface HotelService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(HotelQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(HotelQueryCriteria criteria);

    /**
     * findById
     * @param poiid
     * @return
     */
    //@Cacheable(key = "#p0")
    HotelDTO findById(String poiid);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    HotelDTO create(Hotel resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(Hotel resources);

    /**
     * delete
     * @param poiid
     */
    //@CacheEvict(allEntries = true)
    void delete(String poiid);
}