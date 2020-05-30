package com.aichu.dao.type;

import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

/**
 * @ClassName GeneratorJavaTypeResolver
 * @Description 将tinyint转换为Integer，这里是关键所在
 * @Author Melon
 * @Date 2019/7/18 16:21
 * @Version 1.0.0
 **/
public class GeneratorJavaTypeResolver extends JavaTypeResolverDefaultImpl {

    public GeneratorJavaTypeResolver() {
        super();
        super.typeMap.put(-6, new JdbcTypeInformation("TINYINT",
                new FullyQualifiedJavaType(Integer.class.getName())));
    }
}