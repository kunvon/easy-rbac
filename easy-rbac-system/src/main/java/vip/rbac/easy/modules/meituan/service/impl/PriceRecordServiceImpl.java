package vip.rbac.easy.modules.meituan.service.impl;

import vip.rbac.easy.modules.meituan.domain.PriceRecord;
import vip.rbac.easy.modules.meituan.repository.PriceRecordRepository;
import vip.rbac.easy.modules.meituan.service.PriceRecordService;
import vip.rbac.easy.modules.meituan.service.dto.PriceRecordDTO;
import vip.rbac.easy.modules.meituan.service.dto.PriceRecordQueryCriteria;
import vip.rbac.easy.modules.meituan.service.mapper.PriceRecordMapper;
import vip.rbac.easy.utils.PageUtil;
import vip.rbac.easy.utils.QueryHelp;
import vip.rbac.easy.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


/**
* @author 夜孤城
* @date 2019-08-28
*/
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PriceRecordServiceImpl implements PriceRecordService {

    @Autowired
    private PriceRecordRepository PriceRecordRepository;

    @Autowired
    private PriceRecordMapper PriceRecordMapper;

    @Override
    public Object queryAll(PriceRecordQueryCriteria criteria, Pageable pageable){
        Page<PriceRecord> page = PriceRecordRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable);
        return PageUtil.toPage(page.map(PriceRecordMapper::toDto));
    }

    @Override
    public Object queryAll(PriceRecordQueryCriteria criteria){
        return PriceRecordMapper.toDto(PriceRecordRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder)));
    }

    @Override
    public PriceRecordDTO findById(Integer id) {
        Optional<PriceRecord> PriceRecord = PriceRecordRepository.findById(id);
        ValidationUtil.isNull(PriceRecord,"PriceRecord","id",id);
        return PriceRecordMapper.toDto(PriceRecord.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PriceRecordDTO create(PriceRecord resources) {
        return PriceRecordMapper.toDto(PriceRecordRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(PriceRecord resources) {
        Optional<PriceRecord> optionalPriceRecord = PriceRecordRepository.findById(resources.getId());
        ValidationUtil.isNull( optionalPriceRecord,"PriceRecord","id",resources.getId());
        PriceRecord PriceRecord = optionalPriceRecord.get();
        PriceRecord.copy(resources);
        PriceRecordRepository.save(PriceRecord);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        PriceRecordRepository.deleteById(id);
    }
}