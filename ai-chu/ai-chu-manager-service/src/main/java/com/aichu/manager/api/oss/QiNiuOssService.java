package com.aichu.manager.api.oss;

import com.aichu.manager.config.QiNiuOSSConfig;
import com.aichu.manager.dto.UploadFileDTO;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName QiNiuOssService
 * @Description 七牛云对象存储OSS信息Service
 * @Author Melon
 * @Date 2019/7/19 11:03
 * @Version 1.0.0
 **/
@Service
public class QiNiuOssService {

    private Logger logger = LoggerFactory.getLogger(QiNiuOssService.class);

    @Autowired
    private QiNiuOSSConfig qiNiuOSSConfig;

    /***
     * @Author Melon
     * @Description 七牛云文件上传凭证
     * @Date 16:58 2019/12/26
     * @Param [bucketName]
     * @Return java.lang.String
     **/
    public UploadFileDTO qiuNiuOSSUploadCertificate() throws Exception {
        logger.info("----七牛云文件上传凭证---Start---");

        UploadFileDTO uploadFileDTO = new UploadFileDTO();

        Auth auth = Auth.create(qiNiuOSSConfig.getQiNiuAccessKey(), qiNiuOSSConfig.getQiNiuSecretKey());

        uploadFileDTO.setQiuNiuOSSUploadCertificate(auth.uploadToken(qiNiuOSSConfig.getQiNiuBucket()));
        uploadFileDTO.setQiuNiuOSSUploadUrl(qiNiuOSSConfig.getQiNiuCndDomain());

        logger.info("----七牛云文件上传凭证---End---");
        return uploadFileDTO;
    }
}
