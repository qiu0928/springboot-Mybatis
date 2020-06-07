package org.jeccg.module.config;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



@Configuration
@EnableSwagger2
@Profile({"dev","text"})
@EnableSwaggerBootstrapUI
public class SwaggerConfig  implements WebMvcConfigurer{

    /**
     *
     * 显示swagger-ui.html文档展示页，还必须注入swagger资源：
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    //enable是否启动swagger
    @Bean
    public Docket createRestApi1() { //Environment environment
//        //设置要显示的swagger环境
//        Profiles profiles = Profiles.of("dev","text");
//        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
//        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                .enable(flag)
                .groupName("A");
    }
    @Bean
    public Docket createRestApi() { //Environment environment
//        //设置要显示的swagger环境
//        Profiles profiles = Profiles.of("dev","text");
//        //通过environment.acceptsProfiles判断是否处在自己设定的环境当中
//        boolean flag = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                .enable(flag)
                .groupName("分组")
                .select()// 选择那些路径和api会生成document
                //RequestHandlerSelectors ,配置要扫描的接口的方式
                //basePackage：指定要扫描的包
                //any():扫描全部
                //none();不扫描
                //withClassAnnotation:扫描类上的注解，参数是一个注解的放射对象
                //withMethodAnnotation： 扫描的方法上的注解
                //此包路径下的类，才生成接口文档
                .apis(RequestHandlerSelectors.basePackage("org.jeccg.module"))
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                //patchs() 过滤什么路径
                .paths(PathSelectors.any())
             //   .paths(PathSelectors.ant("/jeccg/module/**"))
                .build();
    }
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // //大标题
                .title("jeecg_boot 后台服务API接口文档")
                // 版本号
                .version("1.0")
//				.termsOfServiceUrl("NO terms of service")
                // 描述
                .description("后台API接口")
                // 作者
                .contact("JEECG团队")
                .license("The Apache License, Version 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .build();
    }
}
