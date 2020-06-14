package com.intercorp.api.retail.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    public static final Contact CONTACT_DEVELOP = new Contact("Leyter Palacios","https://twitter.com/LeyterPalacios","leyterpalacios@gmail.com");
    public static final ApiInfo API_INFO = new ApiInfo("API REST RETAIL","Servicio web para INTERCORP","1.0",
            "urn:tos", CONTACT_DEVELOP.getName(),"Apache 2.0","http://www.apache.org/licenses/LICENSE-2,0");
public Docket api(){
    return new Docket(DocumentationType.SWAGGER_2).apiInfo(API_INFO);
}

}
