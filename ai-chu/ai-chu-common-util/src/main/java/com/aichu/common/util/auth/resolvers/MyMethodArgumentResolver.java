package com.aichu.common.util.auth.resolvers;

import com.aichu.common.util.auth.repository.ModelRepository;
import com.aichu.common.util.exception.BusinessException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.function.Function;

/**
 * @ClassName MyMethodArgumentResolver
 * @Description 方法解析器
 * @Author Melon
 * @Date 2019/7/19 10:23
 * @Version 1.0.0
 **/
public class MyMethodArgumentResolver<T> implements HandlerMethodArgumentResolver {

  /** 模型的类名 */
  private Class<T> modelClass;

  /** 通过Key获得用户模型的实现类 */
  private ModelRepository<T> modelRepository;

  /** 匹配使用的注解类型 */
  private Class currAnnotationClass;

  /** 从header中获取需要的value */
  private Function<NativeWebRequest, String> callFunc;

    public MyMethodArgumentResolver<T> setModelClass(String className) {
    try {
      this.modelClass = (Class<T>) Class.forName(className);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return this;
  }

    public MyMethodArgumentResolver setCallFunc(Function<NativeWebRequest, String> callFunc) {
        this.callFunc = callFunc;
        return this;
    }

    public MyMethodArgumentResolver<T> setCurrAnnotationClass(Class currAnnotationClass) {
        this.currAnnotationClass = currAnnotationClass;
        return this;
    }

    public MyMethodArgumentResolver<T> setModelClass(Class<T> modelClass) {
    this.modelClass = modelClass;
    return this;
  }

  public MyMethodArgumentResolver setModelRepository(ModelRepository<T> modelRepository) {
    this.modelRepository = modelRepository;
    return this;
  }

  @Override
  public boolean supportsParameter(MethodParameter parameter) {
    // 如果参数类型是自定义支持类型
    return parameter.hasParameterAnnotations()
            && parameter.getParameterType().isAssignableFrom(modelClass)
            && parameter.hasParameterAnnotation(currAnnotationClass);
  }

  @Override
  public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception{

      String value = callFunc.apply(webRequest);
      if (StringUtils.isNotBlank(value)) {
          Object object = modelRepository.getModel(value);
          if (object != null) {
              return object;
          } else {
              throw new BusinessException(201007, "登陆已过期，请重新登陆");
          }
      }
      return null;
  }
}
