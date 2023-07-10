package com.ali.rest.webservices.restfulwebservices.helloworld;

import com.ali.rest.webservices.restfulwebservices.helloworld.HelloWorldBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {
	@Autowired
	private MessageSource messageSource;
	@GetMapping("/hello")
	public String helloWorldController(){
		return "Salam";
	}
	@GetMapping("hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello World");
	}

	@GetMapping("hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World,%s",name));
	}

	@GetMapping("/hello-world-internationalization")
	public String helloWorldInternationalization(){
		return messageSource.getMessage("good.morning.message",null,"Default Message", LocaleContextHolder.getLocale());
	}
}