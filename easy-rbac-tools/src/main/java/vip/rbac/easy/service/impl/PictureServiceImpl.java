package vip.rbac.easy.service.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.alibaba.fastjson.JSON;
import vip.rbac.easy.exception.BadRequestException;
import vip.rbac.easy.repository.PictureRepository;
import vip.rbac.easy.service.dto.PictureQueryCriteria;
import vip.rbac.easy.utils.FileUtil;
import vip.rbac.easy.utils.PageUtil;
import vip.rbac.easy.utils.QueryHelp;
import vip.rbac.easy.utils.ValidationUtil;
import lombok.extern.slf4j.Slf4j;
import vip.rbac.easy.domain.Picture;
import vip.rbac.easy.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.HashMap;
import java.util.Optional;

/**
 * @author Zheng Jie
 * @date 2018-12-27
 */
@Slf4j
@Service(value = "pictureService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    public static final String SUCCESS = "success";

    public static final String CODE = "code";

    public static final String MSG = "msg";

    @Override
    public Object queryAll(PictureQueryCriteria criteria, Pageable pageable){
        return PageUtil.toPage(pictureRepository.findAll((root, criteriaQuery, criteriaBuilder) -> QueryHelp.getPredicate(root,criteria,criteriaBuilder),pageable));
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Picture upload(MultipartFile multipartFile, String username) {
        File file = FileUtil.toFile(multipartFile);

        HashMap<String, Object> paramMap = new HashMap<>(1);

        paramMap.put("smfile", file);
        String result= HttpUtil.post(GAdminConstant.Url.SM_MS_URL, paramMap);

        JSONObject jsonObject = JSONUtil.parseObj(result);
        Picture picture = null;
        if(!jsonObject.get(CODE).toString().equals(SUCCESS)){
            throw new BadRequestException(jsonObject.get(MSG).toString());
        }
        //转成实体类
        picture = JSON.parseObject(jsonObject.get("data").toString(), Picture.class);
        picture.setSize(FileUtil.getSize(Integer.valueOf(picture.getSize())));
        picture.setUsername(username);
        picture.setFilename(FileUtil.getFileNameNoEx(multipartFile.getOriginalFilename())+"."+FileUtil.getExtensionName(multipartFile.getOriginalFilename()));
        pictureRepository.save(picture);
        //删除临时文件
        FileUtil.deleteFile(file);
        return picture;

    }

    @Override
    public Picture findById(Long id) {
        Optional<Picture> picture = pictureRepository.findById(id);
        ValidationUtil.isNull(picture,"Picture","id",id);
        return picture.get();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Picture picture) {
        try {
            String result= HttpUtil.get(picture.getDelete());
            pictureRepository.delete(picture);
        } catch(Exception e){
            pictureRepository.delete(picture);
        }

    }

    @Override
    public void deleteAll(Long[] ids) {
        for (Long id : ids) {
            delete(findById(id));
        }
    }
}
