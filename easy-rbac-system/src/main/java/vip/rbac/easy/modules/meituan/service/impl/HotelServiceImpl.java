package vip.rbac.easy.modules.meituan.service.impl;

import vip.rbac.easy.modules.meituan.domain.Hotel;
import vip.rbac.easy.modules.meituan.repository.HotelRepository;
import vip.rbac.easy.modules.meituan.service.HotelService;
import vip.rbac.easy.modules.meituan.service.dto.HotelDTO;
import vip.rbac.easy.modules.meituan.service.dto.HotelQueryCriteria;
import vip.rbac.easy.modules.meituan.service.mapper.HotelMapper;
import vip.rbac.easy.utils.PageUtil;
import vip.rbac.easy.utils.QueryHelp;
import vip.rbac.easy.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import cn.hutool.core.util.IdUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
* @author 夜孤城
* @date 2019-08-28
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepository HotelRepository;

    @Autowired
    private HotelMapper HotelMapper;

    @Override
    public Object queryAll(HotelQueryCriteria criteria, Pageable pageable){
        Page<Hotel> page = HotelRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(HotelMapper::toDto));
    }

    @Override
    public Object queryAll(HotelQueryCriteria criteria){
        return HotelMapper.toDto(HotelRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public HotelDTO findById(String poiid) {
        Optional<Hotel> Hotel = HotelRepository.findById(poiid);
        ValidationUtil.isNull(Hotel,"Hotel","poiid",poiid);
        return HotelMapper.toDto(Hotel.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public HotelDTO create(Hotel resources) {
        resources.setPoiid(IdUtil.simpleUUID()); 
        return HotelMapper.toDto(HotelRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Hotel resources) {
        Optional<Hotel> optionalHotel = HotelRepository.findById(resources.getPoiid());
        ValidationUtil.isNull( optionalHotel,"Hotel","id",resources.getPoiid());
        Hotel Hotel = optionalHotel.get();
        Hotel.copy(resources);
        HotelRepository.save(Hotel);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String poiid) {
        HotelRepository.deleteById(poiid);
    }
}