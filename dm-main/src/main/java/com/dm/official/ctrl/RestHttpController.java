package com.dm.official.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHttpController {
	
	@Autowired  
	ApplicationContext application;
	
	@RequestMapping(path="/")
	public String restGet() {
		
		return "please visit \"/swagger-ui.html\" to discover more.";
	}

}
