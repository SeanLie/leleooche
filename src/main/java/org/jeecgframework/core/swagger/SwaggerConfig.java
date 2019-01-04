package org.jeecgframework.core.swagger;

import java.util.ArrayList;
import java.util.List;

import org.jeecgframework.jwt.def.JwtConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
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

/**
 * swagger 配置文件
 * 
 * @author 张加强
 * @date 20171030
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).pathMapping("/rest/")// 对请求的路径增加rest前缀
				.globalOperationParameters(setHeaderToken()).select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) // 只过滤包含有ApiOperation注解的方法
				.paths(PathSelectors.any()) // 对所有的路径进行监控
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Ooche-预约洗车- APIs").description("更多乐乐科网产品，请关注：...")
				.termsOfServiceUrl("http://127.0.0.1").contact("深圳市乐乐网络科技有限公司").version("1.0.0").build();
	}

	private List<Parameter> setHeaderToken() {
		ParameterBuilder tokenPar = new ParameterBuilder();
		List<Parameter> pars = new ArrayList<Parameter>();
		tokenPar.name(JwtConstants.AUTHORIZATION).description("token").modelRef(new ModelRef("string"))
				.parameterType("header").required(false).build();
		pars.add(tokenPar.build());
		return pars;
	}
}