
package com.dm.official.ctrl;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;


/**
 * 
 */
@Api(value = "外")
@Controller
@RequestMapping("/o/")
@EnableAutoConfiguration
public class MsgOuterController {
	
}