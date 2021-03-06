package com.aichu.admin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;


/**
 * @ClassName SwaggerConfigure
 * @Description Swagger2配置类,在与spring boot集成时,放在与Application.java同级的目录下,通过@Configuration注解,
 * 让Spring来加载该类配置,再通过@EnableSwagger2注解来启用Swagger2。
 * @Author Melon
 * @Date 2019/7/18 17:35
 * @Version 1.0.0
 **/
@Configuration
@EnableSwagger2
public class SwaggerConfigure {

    /***
     * @Author Melon
     * @Description 创建API应用,apiInfo() 增加API相关信息,通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     *   本例采用指定扫描的包路径来定义指定要建立API的目录。
     * @Date 17:36 2019/7/18
     * @Param []
     * @Return springfox.documentation.spring.web.plugins.Docket
     **/
    @Bean
    public Docket createRestApi() {

        //添加请求头参数
        new ParameterBuilder().parameterType("header")
                .name("sessionId").description("身份令牌")
                .modelRef(new ModelRef("String"))
                .required(false).build();
        new ArrayList<>().add(new ParameterBuilder().build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.aichu.admin.api"))
                .paths(PathSelectors.any())
                .build();
    }

    /***
     * @Author Melon
     * @Description 创建该API的基本信息（这些基本信息会展现在文档页面中）,访问地址：http://项目实际地址/swagger-ui.html
     * @Date 17:37 2019/7/18
     * @Param []
     * @Return springfox.documentation.constant.ApiInfo
     **/
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("爱触项目组WEB端-API接口文档")
                .description("Spring Boot中使用Swagger2构建RESTful---API----WEB")
                .termsOfServiceUrl("http://aichu.com")
                .contact(new Contact("爱触", "http://www.aichu.com", "641028943@QQ.com"))
                .version("1.0.0")
                .license("license")
                .build();
    }

}