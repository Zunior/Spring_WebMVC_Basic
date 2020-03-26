package rs.engineering.javacourse.springMvcConfigurationDomaci03.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import rs.engineering.javacourse.springMvcConfigurationDomaci03.controller.UserController;
import rs.engineering.javacourse.springMvcConfigurationDomaci03.dto.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
		"rs.engineering.javacourse.springMvcConfigurationDomaci03.controller",
		"rs.engineering.javacourse.springMvcConfigurationDomaci03.repository",
		"rs.engineering.javacourse.springMvcConfigurationDomaci03.service"
})
public class MyWebContextConfig {
	
//	@Bean
//	public UserController userController() {
//		return new UserController();
//	}
	
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		return new RequestMappingHandlerMapping();
	}
	
	BeanNameUrlHandlerMapping  beanNameUrlHandlerMapping() {
		return new BeanNameUrlHandlerMapping();
	}
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/engineering_spring");
		dataSource.setUsername("root");
		dataSource.setPassword("12345");
		
		return dataSource;
	}
	
	@Bean
	JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
