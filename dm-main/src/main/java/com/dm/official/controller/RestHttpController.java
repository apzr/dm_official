package com.dm.official.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestHttpController {

	@Autowired
	ApplicationContext application;

	@RequestMapping(path = "/")
	public void redirect0(HttpServletResponse response) throws IOException {
		response.sendRedirect("/index");
	}

}
