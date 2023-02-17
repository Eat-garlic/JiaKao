package com.eglc.jk.common.cfg;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import javax.servlet.http.HttpServlet;

@Configuration
@EnableSwagger2
public class SwaggerCfg {

    @Bean
    public Docket examdocket(Environment environment){
        boolean enable = environment.acceptsProfiles(Profiles.of("pro", "dev"));
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(HttpServlet.class)
                .enable(enable)
                .groupName("考试")
                .apiInfo(apiInfo("考场模块文档", "考场， 科1科4， 科2科3"))
                .select()
                //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.regex("/exam.*"))
                .build();
    }



    @Bean
    public Docket metadatadocket(Environment environment){
        boolean enable = environment.acceptsProfiles(Profiles.of("pro", "dev"));
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(HttpServlet.class)
                .enable(enable)
                .groupName("元数据")
                .apiInfo(apiInfo("元数据模块文档","数据字典类型，数据字典条目，省份，城市"))
                .select()
                //.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.regex("/(dict.*|plate.*)"))
                .build();
    }


    private ApiInfo apiInfo(String title, String description) {
        return new ApiInfoBuilder()
                .title(title)
                .description(description)
                .version("1.0.0")
                .build();


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
