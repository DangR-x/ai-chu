package com.aichu.admin.aspect;

import com.aichu.admin.config.OperationLog;
import com.aichu.admin.vo.request.BackLoginRequest;
import com.aichu.manager.api.shiro.ShiroCustomService;
import com.aichu.service.api.AcAdminActionLogService;
import com.aichu.service.dto.AcAdminActionLogDTO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @ClassName SysLogAspect
 * @Author yuan.shuai
 * @Description 系统日志：切面处理类
 * @Date 2019/10/31
 * @Version 1.0.0
 */
@Aspect
@Component
public class SysLogAspect {

    private Logger logger = LoggerFactory.getLogger(SysLogAspect.class);

    @Autowired
    private ShiroCustomService shiroCustomService;

    @Autowired
    private AcAdminActionLogService wzAdminActionLogService;

    // 切入点，在注解位置切入代码
    @Pointcut("@annotation(com.aichu.admin.config.OperationLog)")
    public void logPoinCut(){
    }

    // 切面 ，配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) throws Exception{
        logger.info("操作日志记录操作");

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        System.out.println("进入切面");

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();
        // IP
        String ipAddr = getRemoteHost(request);
        // 请求路径
        String url = request.getRequestURI();

        OperationLog operationLog = method.getAnnotation(OperationLog.class);
        // 注解中的描述
        String noteValue = operationLog.value();
        wzAdminActionLogService.addAdminActionLog(this.encapsulateData(joinPoint,url,noteValue,ipAddr));
        logger.info("操作日志记录操作完成");
    }

    /**
     * 获取目标主机的ip
     * @param request
     * @return String
     */
    private String getRemoteHost(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            //Proxy-Client-IP：apache 服务代理
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ip != null && ip.length() != 0) {
            ip = ip.split(",")[0];
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip) ? "127.0.0.1" : ip;
    }

    /**
     * @Description 处理数据
     * @Param JoinPoint,url(请求路径)，noteValue（操作内容），ipAddr（IP）
     * @Return String
     * @Author yuan.shuai
     * @Date  2019/11/9
     * @Version 1.1.0
     */
    private AcAdminActionLogDTO encapsulateData(JoinPoint joinPoint, String url, String noteValue, String ipAddr) throws Exception{
        AcAdminActionLogDTO wzAdminActionLogDTO = new AcAdminActionLogDTO();
        Integer userId = null;
        if (!Objects.equals(url,"/admin/user/login")){
            userId = shiroCustomService.getAdminUserIdToSessionId();
        }
        wzAdminActionLogDTO.setAdminUserId(userId);
        wzAdminActionLogDTO.setActionIp(ipAddr);
        if (Objects.isNull(joinPoint.getArgs())){
            wzAdminActionLogDTO.setActionLog(noteValue);
        } else {
            String params ;
            String jsons = JSON.toJSONString(joinPoint.getArgs());
            JSONArray jsonArray = JSON.parseArray(jsons);
            JSONObject jsonObject = JSON.parseObject(jsonArray.get(0).toString());
            // 处理一些特殊的请求，例如登录，宗祠修改/新增,族谱新增/修改
            if (Objects.equals(url,"/admin/user/login")){
                BackLoginRequest backLoginRequest = JSON.parseObject(jsonObject.get("data").toString(), BackLoginRequest.class);
                params = "登录账号：" + backLoginRequest.getUserName();
            } else if (Objects.equals(url,"/temple/manager/updateOrAddAncestral")){ //
//                AncestralTempleRequest templeRequest = JSON.parseObject(jsonObject.get("data").toString(),AncestralTempleRequest.class);
//                if (Objects.nonNull(templeRequest.getId())){
//                    params = "编辑宗祠ID："+templeRequest.getId();
//                } else {
//                    params = "新增宗祠名称："+templeRequest.getName();
//                }
            } else if (Objects.equals(url,"/family/manager/updateOrAddFamily")){ // 新增修改族谱
//                FamilyTreeRequest templeRequest = JSON.parseObject(jsonObject.get("data").toString(),FamilyTreeRequest.class);
//                if (Objects.nonNull(templeRequest.getId())){
//                    params = "编辑家族ID："+templeRequest.getId();
//                } else {
//                    params = "新增家族名称："+templeRequest.getName();
//                }
            } else if (Objects.equals(url,"/sysnews/manager/addOrUpdateNews")) { // 系统活动新增修改
//                SysNewsAddOrUpdateRequest sysNewsAddOrUpdateRequest = JSON.parseObject(jsonObject.get("data").toString(),SysNewsAddOrUpdateRequest.class);
//                if (Objects.nonNull(sysNewsAddOrUpdateRequest.getId())){
//                    params = "编辑系统活动ID："+sysNewsAddOrUpdateRequest.getId();
//                } else {
//                    params = "新增系统活动标题："+sysNewsAddOrUpdateRequest.getTitle();
//                }
            } else if (Objects.equals(url,"/familyNews/manager/updateOrAddFamilyNews")){ // 家族活动新增
//                FamilyActivityUpdateOrAddRequest familyActivityUpdateOrAddRequest = JSON.parseObject(jsonObject.get("data").toString(),FamilyActivityUpdateOrAddRequest.class);
//                if (Objects.nonNull(familyActivityUpdateOrAddRequest.getId())){
//                    params = "编辑家族活动ID："+familyActivityUpdateOrAddRequest.getId();
//                } else {
//                    params = "新增家族活动标题："+familyActivityUpdateOrAddRequest.getTitle();
//                }
            } else {
                params = noteValue + ":" + jsonObject.get("data").toString();
            }
            wzAdminActionLogDTO.setActionLog(null);
        }
        wzAdminActionLogDTO.setActionModel(noteValue);

        return wzAdminActionLogDTO;
    }
}
