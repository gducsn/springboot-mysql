package spr.entity.student.service;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfing implements WebMvcConfigurer {

	  @Override
	  //definisci il path, in questo caso l'home page
	  public void addViewControllers(ViewControllerRegistry registry) {
	    registry.addViewController("/").setViewName("home");
	  } 
}
