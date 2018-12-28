
package com.dm.official.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dm.official.dto.CONST;
import com.dm.official.entity.Classic;
import com.dm.official.entity.News;
import com.dm.official.entity.Recent;
import com.dm.official.service.ClassicService;
import com.dm.official.service.NewsService;
import com.dm.official.service.RecentService;

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
	NewsService newsService;

	@Autowired
	RecentService recentService;

	@Autowired
	ClassicService classicService;

	/**
	 * 主页
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(ModelMap param) {

		List<News> newslist = newsService.top(3);
		param.addAttribute("newsList", newslist);

		List<Recent> recentList = recentService.top(5);
		param.addAttribute("recentList", recentList);

		List<Classic> classicList = classicService.top(5);
		param.addAttribute("classicList", classicList);

		return "index";
	}

	/**
	 * 业务范围
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/scope", method = RequestMethod.GET)
	public String scope(ModelMap param) {
		return "scope";
	}

	/**
	 * 新闻默认
	 */
	@RequestMapping(path = "/news")
	public void defaultNews(HttpServletResponse response) throws IOException {
		response.sendRedirect("/news/"+CONST.DEFAULT_PAGE_SIZE+"/1");
	}
	
	/**
	 * 	新闻公告
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/news/{page_size}/{page_no}", method = RequestMethod.GET)
	public String news(ModelMap param, @PathVariable("page_size") String size, @PathVariable("page_no") String number) {

		int pageNumber;
		int pageSize;
		
		try {
			pageSize = Integer.parseInt(size);
		} catch (NumberFormatException e) {
			pageSize = CONST.DEFAULT_PAGE_SIZE;
		}
		
		try {
			pageNumber = Integer.parseInt(number);
		} catch (NumberFormatException e) {
			pageNumber = 1;
		}
		
		Page<News> newsList = this.newsService.page(pageNumber, pageSize);
		
		param.addAttribute("newsList", newsList.getContent());
		param.addAttribute("totalElementsNumber", newsList.getTotalElements());
		param.addAttribute("currentPageNumber", number);
		
		param.addAttribute("pageSize", pageSize);

		return "news";
	}

	/**
	 * 合作伙伴
	 * 
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

		Page<Recent> recentList = null;
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

		Page<Classic> classicList = null;
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
	@RequestMapping(value = "/news/detail", method = RequestMethod.GET)
	public String newsDetail(ModelMap param, String id) {

		News dt = newsService.getDetail(Integer.parseInt(id));
		param.addAttribute("title", dt.getTitle());
		param.addAttribute("detail", dt.getDetail());

		return "detail";
	}

	/**
	 * detail页面详情展示
	 * 
	 * @param param
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/recent/detail", method = RequestMethod.GET)
	public String recentDetail(ModelMap param, String id) {

		Recent dt = recentService.getDetail(Integer.parseInt(id));
		param.addAttribute("title", dt.getTitle());
		param.addAttribute("detail", dt.getDetail());

		return "detail";
	}

	/**
	 * detail页面详情展示
	 * 
	 * @param param
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/classic/detail", method = RequestMethod.GET)
	public String classicDetail(ModelMap param, String id) {

		Classic dt = classicService.getDetail(Integer.parseInt(id));
		param.addAttribute("title", dt.getTitle());
		param.addAttribute("detail", dt.getDetail());

		return "detail";
	}

}