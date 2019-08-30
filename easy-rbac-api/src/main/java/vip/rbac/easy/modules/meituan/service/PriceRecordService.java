package vip.rbac.easy.modules.meituan.service;

import vip.rbac.easy.modules.meituan.domain.PriceRecord;
import vip.rbac.easy.modules.meituan.service.dto.PriceRecordDTO;
import vip.rbac.easy.modules.meituan.service.dto.PriceRecordQueryCriteria;
//import org.springframework.cache.annotation.CacheConfig;
//import org.springframework.cache.annotation.CacheEvict;
//import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;

/**
* @author 夜孤城
* @date 2019-08-28
*/
//@CacheConfig(cacheNames = "PriceRecord")
public interface PriceRecordService {

    /**
    * queryAll 分页
    * @param criteria
    * @param pageable
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    Object queryAll(PriceRecordQueryCriteria criteria, Pageable pageable);

    /**
    * queryAll 不分页
    * @param criteria
    * @return
    */
    //@Cacheable(keyGenerator = "keyGenerator")
    public Object queryAll(PriceRecordQueryCriteria criteria);

    /**
     * findById
     * @param id
     * @return
     */
    //@Cacheable(key = "#p0")
    PriceRecordDTO findById(Integer id);

    /**
     * create
     * @param resources
     * @return
     */
    //@CacheEvict(allEntries = true)
    PriceRecordDTO create(PriceRecord resources);

    /**
     * update
     * @param resources
     */
    //@CacheEvict(allEntries = true)
    void update(PriceRecord resources);

    /**
     * delete
     * @param id
     */
    //@CacheEvict(allEntries = true)
    void delete(Integer id);
}