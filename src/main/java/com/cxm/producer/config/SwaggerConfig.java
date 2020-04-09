package com.cxm.producer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger配置类
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger.enable}")
    private boolean enable;

    @Bean
    public Docket createRestApi(){
     return new Docket(DocumentationType.SWAGGER_2)
                .groupName("demo-intterface")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cxm.producer"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .enable(enable);

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("自定义系统平台接口文档")
                .description("这是我有一个demo的接口文档")
                .termsOfServiceUrl("https://xingtian.github.io/trace.github.io/")
                .version("1.0")
                .build();
    }


}
