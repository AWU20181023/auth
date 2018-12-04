package com.gree.auth.config;

import com.google.common.base.Predicates;
import com.gree.auth.constant.ConstantEum;
import com.gree.auth.utils.AuthUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 260152(AWU) on 2018/12/3 17:07.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket api() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .paths(PathSelectors.regex("/.*"))
                .build()
                .apiInfo(apiInfo());

        Integer authMethod = AuthUtils.getAuthMethod();
        if (!ConstantEum.USE_COOKIE.getInteger().equals(authMethod)) {
            ParameterBuilder parameterBuilder = new ParameterBuilder();
            List<Parameter> parameters = new ArrayList<>();
            parameterBuilder.name("Authorization").description("身份令牌").modelRef(new ModelRef("string"))
                    .parameterType("header").required(true).build();
            parameters.add(parameterBuilder.build());
            docket.globalOperationParameters(parameters);
        }

        return docket;
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("接口文档")
                .version("1.0.0")
                .build();
    }
}
