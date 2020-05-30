package com.aichu.common.util.auth.repository;

/**
 * @ClassName ModelRepository 
 * @Description ModelRepository
 * @Author Melon
 * @Date 2019/7/18 10:06
 * @Version 1.0.0
 **/
public interface ModelRepository<T> {

  /***
   * @Author Melon
   * @Description 根据自己需求强制转换为需要的对象
   * @Date 10:08 2019/7/18
   * @Param [obj]
   * @Return T
   **/
  T getModel(Object obj) throws Exception;
}
