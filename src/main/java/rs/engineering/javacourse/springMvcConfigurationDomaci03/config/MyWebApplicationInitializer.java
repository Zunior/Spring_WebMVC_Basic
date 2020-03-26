package rs.engineering.javacourse.springMvcConfigurationDomaci03.config;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import rs.engineering.javacourse.springMvcConfigurationDomaci03.dto.User;
import rs.engineering.javacourse.springMvcConfigurationDomaci03.service.UserService;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("======================================================");
		System.out.println("============= MyWebApplicationInitializer ============");
		System.out.println("======================================================");

		AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
		webApplicationContext.register(MyWebContextConfig.class);
		webApplicationContext.setServletContext(servletContext);

		ServletRegistration.Dynamic dispatcherServlet = servletContext.addServlet("myServletDispatcherContext",
				new DispatcherServlet(webApplicationContext));
		dispatcherServlet.addMapping("/");
		dispatcherServlet.setLoadOnStartup(1);
	}

}
