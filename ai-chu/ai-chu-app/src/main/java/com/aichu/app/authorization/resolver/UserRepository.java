package com.aichu.app.authorization.resolver;

import com.aichu.app.vo.request.AcUserRequestDao;
import com.aichu.common.util.auth.repository.ModelRepository;
import com.aichu.common.util.common.BeanUtil;
import com.aichu.common.util.common.Utils;
import com.aichu.common.util.exception.BusinessException;
import com.aichu.dao.autogeneration.object.AcUserDO;
import com.aichu.manager.enums.ResultCodeEnum;
import com.aichu.service.api.AcUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @Package: com.tangor.biz.device$
 * @ClassName: DeviceUserBiz$
 * @Author: zhangchao
 * @CreateDate: 2019/3/26$
 * @Version: V1.1.0
 */
@Component
public class UserRepository implements ModelRepository<AcUserRequestDao> {

    @Autowired
    private AcUserService acUserService;

    @Override
    public AcUserRequestDao getModel(Object key) throws Exception{
        if (Utils.isEmpty(key)) {
            return null;
        }
        String phone = (String) key;
        // Service 調用
        AcUserDO acUserDO = null;
        try {
            acUserDO = acUserService.selectAcUserByPhone(phone);
        } catch (Exception e) {
            throw new BusinessException(ResultCodeEnum.LOGIN_TOKEN_EFFICACY.getCode(), ResultCodeEnum.LOGIN_TOKEN_EFFICACY.getMessage());
        }

        return BeanUtil.copy(acUserDO, AcUserRequestDao.class);
    }
}
