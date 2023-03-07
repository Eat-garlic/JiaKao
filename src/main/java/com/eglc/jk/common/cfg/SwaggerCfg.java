package com.eglc.jk.common.cfg;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerCfg implements InitializingBean {
    @Autowired
    Environment environment;

    private boolean enable;



    @Bean
    public Docket sysdocket() {
        return groupDocket("01_系统",
                "系统模块文档",
                "用户，角色，资源",
                "/sys.*");
    }


        @Bean
    public Docket examdocket(){
        return groupDocket("03_考试",
                            "考场模块文档",
                            "考场， 科1科4， 科2科3" ,
                            "/exam.*");


        /* basedocket()
                .groupName()
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.regex())
                .build();*/
    }




    @Bean
    public Docket metadatadocket(){
      return   groupDocket("02_元数据",
                          "元数据模块文档",
                          "数据字典类型，数据字典条目，省份，城市",
                          "/(dict.*|plate.*)");

    }





    private Docket groupDocket(String group,
                               String  title,
                               String description,
                               String regex){

        return   basedocket()
                .groupName(group)
                .apiInfo(apiInfo(title,description))
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
               /* .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))*/
                .paths(PathSelectors.regex(regex))
                .build();

    }


    private Docket basedocket(){
     /*   Parameter token = new ParameterBuilder()
                .name("token")
                .description("用户登录令牌")
                .parameterType("header")
                .modelRef( new ModelRef("String"))
                .build();*/
        return new Docket(DocumentationType.SWAGGER_2)
               // .ignoredParameterTypes(HttpServlet.class)
                .enable(enable);
    }


    private ApiInfo apiInfo(String title, String description) {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version("1.0.0")
                .build();


    }

    @Override
    public void afterPropertiesSet() throws Exception {
             enable = environment.acceptsProfiles(Profiles.of("pro", "dev"));
    }











    /*@Bean
    public Docket docket(){
        Docket docket = new Docket(DocumentationType.SWAGGER_2);
            docket.apiInfo(apiInfo());
            return docket;
    }

    private ApiInfo apiInfo() {
        ApiInfoBuilder builder = new ApiInfoBuilder();

        builder.title("eglc驾考系统接口文档");
        builder.description("这是一份详细的接口文档");
        builder.version("1.0.0");
        return builder.build();

    }*/


}
