package com.example.springboothelloworld;

import com.example.springboothelloworld.dto.Consumer;
import com.example.springboothelloworld.dto.Producer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@Configuration
@EnableSwagger2
public class SpringbootHelloworldApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootHelloworldApplication.class, args);
    }


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.springboothelloworld"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("云外呼ftp服务")
                .description("云外呼ftp服务Online API文档")
                .version("1.0")
                .build();
    }
}

