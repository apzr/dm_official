
package com.dm.official.ctrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dm.official.ctrl.controller.DetailController;
import com.dm.official.dto.STATIC;
import com.dm.official.entity.Detail;
import com.dm.official.persistences.SpringBootJdbc;

import io.swagger.annotations.Api;

/**
 * 
 */
@Api(value = "主入口")
@Controller
@RequestMapping("/")
@EnableAutoConfiguration
public class MainController {

	@Autowired
	SpringBootJdbc dao;

	@Autowired
	DetailController detailController;

	/**
	 * 主页
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap param) {
		
		List<Detail> newslist = detailController.top(3, STATIC.TYPE_NEWS);
		param.addAttribute("newsList", newslist);
		
		List<Detail> recentList = detailController.top(5, STATIC.TYPE_RECENT);
		param.addAttribute("recentList", recentList);
		
		List<Detail> classicList = detailController.top(5, STATIC.TYPE_CLASSIC);
		param.addAttribute("classicList", classicList);
		
		return "index"; 
	}
	
	/**
	 * 业务范围
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/scope", method = RequestMethod.GET)
	public String scope(ModelMap param) {
		return "scope"; 
	}
	
	/**
	 * 新闻公告
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String news(ModelMap param) {
		
		List<Detail> newslist = detailController.top(999, STATIC.TYPE_NEWS);
		param.addAttribute("newsList", newslist);
		
		return "news"; 
	}
	
	/**
	 * 合作伙伴
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/partner", method = RequestMethod.GET)
	public String partner(ModelMap param) {
		return "partner"; 
	}
	
	/**
	 * 企业动态
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/recent", method = RequestMethod.GET)
	public String recent(ModelMap param) {
		
		List<Detail> recentList = detailController.top(999, STATIC.TYPE_RECENT);
		param.addAttribute("recentList", recentList);
		
		return "recent"; 
	}
	
	/**
	 * 经典案件
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/classic", method = RequestMethod.GET)
	public String classic(ModelMap param) {
		
		List<Detail> classicList = detailController.top(999, STATIC.TYPE_CLASSIC);
		param.addAttribute("classicList", classicList);
		
		return "classic"; 
	}

	/**
	 * 关于我们
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(ModelMap param) {
		return "about"; 
	}

	/**
	 * 联系我们
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(ModelMap param) {
		return "contact"; 
	}

	/**
	 * detail页面详情展示
	 * 
	 * @param param
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(ModelMap param, String id) {
		Detail dt = detailController.getDetail(Integer.parseInt(id));
		
		param.addAttribute("title",dt.getTitle());
		param.addAttribute("detail",dt.getDetail());
		
		return "detail"; 
	}
	
}