package vip.rbac.easy.modules.meituan.rest;

import vip.rbac.easy.aop.log.Log;
import vip.rbac.easy.modules.meituan.domain.PriceRecord;
import vip.rbac.easy.modules.meituan.service.PriceRecordService;
import vip.rbac.easy.modules.meituan.service.dto.PriceRecordQueryCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

/**
* @author 夜孤城
* @date 2019-08-28
*/
@Api(tags = "PriceRecord管理")
@RestController
@RequestMapping("api")
public class PriceRecordController {

    @Autowired
    private PriceRecordService PriceRecordService;

    @Log("查询PriceRecord")
    @ApiOperation(value = "查询PriceRecord")
    @GetMapping(value = "/PriceRecord")
    @PreAuthorize("hasAnyRole('ADMIN','PRICERECORD_ALL','PRICERECORD_SELECT')")
    public ResponseEntity getPriceRecords(PriceRecordQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(PriceRecordService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增PriceRecord")
    @ApiOperation(value = "新增PriceRecord")
    @PostMapping(value = "/PriceRecord")
    @PreAuthorize("hasAnyRole('ADMIN','PRICERECORD_ALL','PRICERECORD_CREATE')")
    public ResponseEntity create(@Validated @RequestBody PriceRecord resources){
        return new ResponseEntity(PriceRecordService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改PriceRecord")
    @ApiOperation(value = "修改PriceRecord")
    @PutMapping(value = "/PriceRecord")
    @PreAuthorize("hasAnyRole('ADMIN','PRICERECORD_ALL','PRICERECORD_EDIT')")
    public ResponseEntity update(@Validated @RequestBody PriceRecord resources){
        PriceRecordService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除PriceRecord")
    @ApiOperation(value = "删除PriceRecord")
    @DeleteMapping(value = "/PriceRecord/{id}")
    @PreAuthorize("hasAnyRole('ADMIN','PRICERECORD_ALL','PRICERECORD_DELETE')")
    public ResponseEntity delete(@PathVariable Integer id){
        PriceRecordService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}