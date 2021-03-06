package cn.business.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger2Config {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(apiInfo())
				.select()
				//为当前包路径
				.apis(RequestHandlerSelectors.basePackage("com.main.controller"))
				.paths(PathSelectors.any())
				.build();
	}
	//构建 api文档的详细信息函数
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				//页面标题
				.title("YH.Copo-Report RESTful API [易惠科技]")
				//创建人
				.contact(new Contact("Fuqiang Chen", "https://www.ylzinfo.com", "1126883892@qq.com"))
				//版本号
				.version("1.0")
				//描述
				.description("基础组件-报表接口描述说明")
				.build();
	}
}