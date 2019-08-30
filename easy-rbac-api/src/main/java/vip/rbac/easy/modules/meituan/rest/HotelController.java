package vip.rbac.easy.modules.meituan.rest;

import vip.rbac.easy.aop.log.Log;
import vip.rbac.easy.modules.meituan.domain.Hotel;
import vip.rbac.easy.modules.meituan.service.HotelService;
import vip.rbac.easy.modules.meituan.service.dto.HotelQueryCriteria;
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
@Api(tags = "Hotel管理")
@RestController
@RequestMapping("api")
public class HotelController {

    @Autowired
    private HotelService HotelService;

    @Log("查询Hotel")
    @ApiOperation(value = "查询Hotel")
    @GetMapping(value = "/Hotel")
    @PreAuthorize("hasAnyRole('ADMIN','HOTEL_ALL','HOTEL_SELECT')")
    public ResponseEntity getHotels(HotelQueryCriteria criteria, Pageable pageable){
        return new ResponseEntity(HotelService.queryAll(criteria,pageable),HttpStatus.OK);
    }

    @Log("新增Hotel")
    @ApiOperation(value = "新增Hotel")
    @PostMapping(value = "/Hotel")
    @PreAuthorize("hasAnyRole('ADMIN','HOTEL_ALL','HOTEL_CREATE')")
    public ResponseEntity create(@Validated @RequestBody Hotel resources){
        return new ResponseEntity(HotelService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改Hotel")
    @ApiOperation(value = "修改Hotel")
    @PutMapping(value = "/Hotel")
    @PreAuthorize("hasAnyRole('ADMIN','HOTEL_ALL','HOTEL_EDIT')")
    public ResponseEntity update(@Validated @RequestBody Hotel resources){
        HotelService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除Hotel")
    @ApiOperation(value = "删除Hotel")
    @DeleteMapping(value = "/Hotel/{poiid}")
    @PreAuthorize("hasAnyRole('ADMIN','HOTEL_ALL','HOTEL_DELETE')")
    public ResponseEntity delete(@PathVariable String poiid){
        HotelService.delete(poiid);
        return new ResponseEntity(HttpStatus.OK);
    }
}