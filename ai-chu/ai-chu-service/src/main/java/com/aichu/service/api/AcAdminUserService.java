package com.aichu.service.api;

import com.aichu.common.util.api.BaseResponse;
import com.aichu.dao.workstation.object.AcAdminUserDao;
import com.aichu.service.dto.*;

import java.util.List;

/**
 * @ClassName AcAdminUserService
 * @Author yuan.shuai
 * @Description 管理员列表
 * @Date 2019/11/4
 * @Version 1.0.0
 */
public interface AcAdminUserService {

    /**
     * @Description 通过管理员名称获取信息
     * @Param userName
     * @Return AcAdminUserDao
     * @Author yuan.shuai
     * @Date  2019/11/4
     * @Version 1.0.0
     */
    AcAdminUserDao getAdminUserToUserName(String userName) throws Exception;

    /**
     * @Description 管理员登录
     * @Param BackLoginDTO
     * @Return AdminUserLoginDTO
     * @Author yuan.shuai
     * @Date  2019/11/4
     * @Version 1.0.0
     */
    AdminUserLoginDTO adminUserLogin(BackLoginDTO backLoginDTO) throws Exception;

    /**
     * @Description 管理员修改密码
     * @Param AdminUserUpdatePwdDTO
     * @Author yuan.shuai
     * @Date  2019/11/4
     * @Version 1.0.0
     */
    void updateAdminUserPwd(AdminUserUpdatePwdDTO updatePwdDTO) throws Exception;

    /**
     * @Description 后台用户修改昵称
     * @Param aliasName
     * @Author yuan.shuai
     * @Date  2019/8/3
     * @Version 1.0.0
     */
    Boolean updateAdminUserAliasName(String aliasName) throws Exception;

    /**
     * @Description 管理员列表查询
     * @Param AdminUserQueryDTO
     * @Return BaseResponse<List<AdminUserDTO>>
     * @Author yuan.shuai
     * @Date  2019/11/4
     * @Version 1.0.0
     */
    BaseResponse<List<AdminUserDTO>> getAdminUserList(AdminUserQueryDTO queryDTO) throws Exception;

    /**
     * @Description 管理员新增/修改
     * @Param  AdminUserAddOrUpdateDTO
     * @Return Boolean
     * @Author yuan.shuai
     * @Date  2019/11/4
     * @Version 1.0.0
     */
    Boolean addOrUpdateAdminUser(AdminUserAddOrUpdateDTO addOrUpdateDTO) throws Exception;

    /**
     * @Description 管理员删除
     * @Param id
     * @Return Boolean
     * @Author yuan.shuai
     * @Date  2019/11/4
     * @Version 1.0.0
     */
    Boolean deleteAdminUser(Integer id) throws Exception;

    /**
     * @Description 查询管理员详情（查看详情）
     * @Param id
     * @Return ViewAdminUserBackDetailDTO
     * @Author yuan.shuai
     * @Date  2019/12/17
     * @Version 1.0.0
     */
    ViewAdminUserBackDetailDTO getViewAdminUserBackDetail(Integer id) throws Exception;

    /**
     * @Description 查询管理员详情 （编辑）
     * @Param id
     * @Return EditorAdminUserBackDTO
     * @Author yuan.shuai
     * @Date  2019/7/30
     * @Version 1.0.0
     */
    EditorAdminUserBackDTO getEitorAdminUserBackDetail(Integer id) throws Exception;

    /**
     * @Description 修改管理员头像
     * @Author yuan.shuai
     * @Date 2019/12/25 11:46
     * @Param AdminUserHeadImgUpdateDTO
     * @Return Boolean
     * @Version 1.0.0
     **/
    Boolean updateAdminUserHeadImg(AdminUserHeadImgUpdateDTO updateDTO) throws Exception;
}
