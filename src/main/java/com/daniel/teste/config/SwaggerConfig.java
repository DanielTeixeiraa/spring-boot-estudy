package com.daniel.teste.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Header;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
//CONFIGURAÇAO DO SWAGGER
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	private final ResponseMessage m201 = simpleMessage(201, "Recurso criado");
	private final ResponseMessage m204put = simpleMessage(204, "Atualização ok");
	private final ResponseMessage m204del = simpleMessage(204, "Deleção ok");
	private final ResponseMessage m403 = simpleMessage(403, "Não autorizado");
	private final ResponseMessage m404 = simpleMessage(404, "Não encontrado");
	private final ResponseMessage m422 = simpleMessage(422, "Erro de validação");
	private final ResponseMessage m500 = simpleMessage(500, "Erro inesperado");
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.globalResponseMessage(RequestMethod.GET, Arrays.asList(m403, m404, m500))
				.globalResponseMessage(RequestMethod.POST, Arrays.asList(m201, m403, m422, m500))
				.globalResponseMessage(RequestMethod.PUT, Arrays.asList(m204put, m403, m404, m422, m500))
				.globalResponseMessage(RequestMethod.DELETE, Arrays.asList(m204del, m403, m404, m500))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.daniel.teste.controllers"))
				.paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
	}
	private ApiInfo apiInfo() {
	    return new ApiInfoBuilder()
	    		.title("Simples Spring Boot REST API")
	            .description("APi usada para o curso de spring")
	            .version("1.0.0")
	            .license("Apache License Version 2.0")
	            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
	            .contact(new Contact("Daniel Teixeira",null, "daniel.teixeirari@gmail.com"))
	            .build();
	}
	private ResponseMessage simpleMessage(int code, String msg) {
		return new ResponseMessageBuilder().code(code).message(msg).build();
		}
	private ResponseMessage customMessage1() {
		Map<String, Header> map = new HashMap<>();
		map.put("location", new Header("location", "URI do novo recurso", new ModelRef("string")));
		return new ResponseMessageBuilder()
		.code(201)
		.message("Recurso criado")
		.headersWithDescription(map)
		.build();
		}
}
//EXEMPLO
//private ApiInfo apiInfo() {
//    return new ApiInfoBuilder()
//            .title("Simple Spring Boot REST API")
//            .description(""Um exemplo de aplicação Spring Boot REST API"")
//            .version("1.0.0")
//            .license("Apache License Version 2.0")
//            .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0"")
//            .contact(new Contact("Wladimilson", "https://treinaweb.com.br", "contato@treinaweb.com.br"))
//            .build();
//}