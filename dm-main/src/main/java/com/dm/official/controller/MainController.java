
package com.dm.official.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dm.official.dto.CONST;
import com.dm.official.entity.About;
import com.dm.official.entity.Classic;
import com.dm.official.entity.Counsel;
import com.dm.official.entity.News;
import com.dm.official.entity.Partner;
import com.dm.official.entity.Recent;
import com.dm.official.entity.Scope;
import com.dm.official.service.AboutService;
import com.dm.official.service.ClassicService;
import com.dm.official.service.CounselService;
import com.dm.official.service.MailService;
import com.dm.official.service.NewsService;
import com.dm.official.service.PartnerService;
import com.dm.official.service.RecentService;
import com.dm.official.service.ScopeService;
import com.dm.official.util.DateUtils;

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
	ScopeService scopeService;

	@Autowired
	RecentService recentService;
	
	@Autowired
	PartnerService partnerService;

	@Autowired
	ClassicService classicService;
	
	@Autowired
	AboutService aboutService;
	
	@Autowired
	CounselService counelService;
	
	@Autowired
	MailService mailService;

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
	 * 主页
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(ModelMap param) {
		return "home";
	}

	/**
	 * 业务范围
	 * 
	 * @param param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/scope", method = RequestMethod.GET)
	public void defaultScope(HttpServletResponse response) throws IOException {
		response.sendRedirect("/scope/"+CONST.DEFAULT_PAGE_SIZE+"/1");
	}
	
	/**
	 * 业务范围
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/scope/{page_size}/{page_no}", method = RequestMethod.GET)
	public String scope(ModelMap param, @PathVariable("page_size") String pSize, @PathVariable("page_no") String currentPage) {
		int pageNumber;
		int pageSize;
		
		try {
			pageSize = Integer.parseInt(pSize);
		} catch (NumberFormatException e) {
			pageSize = CONST.DEFAULT_PAGE_SIZE;
		}
		
		try {
			pageNumber = Integer.parseInt(currentPage);
		} catch (NumberFormatException e) {
			pageNumber = 1;
		}
		
		Page<Scope> scopeList = this.scopeService.page(pageNumber, pageSize);
		
		param.addAttribute("list", scopeList.getContent());
		
		param.addAttribute("elementsCount", scopeList.getTotalElements());
		param.addAttribute("currentPage", currentPage);
		param.addAttribute("pageSize", pageSize);

		return "scope";
	}

	/**
	 * detail页面详情展示
	 * 
	 * @param param
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/scope/detail", method = RequestMethod.GET)
	public String scopeDetail(ModelMap param, String id) {

		Scope sp = scopeService.getDetail(Integer.parseInt(id));
		param.addAttribute("title", sp.getTitle());
		param.addAttribute("detail", sp.getDetail());

		return "detail";
	}
	
	/**
	 *  新闻默认
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(path = "/news")
	public void defaultNews(HttpServletResponse response) throws IOException {
		response.sendRedirect("/news/"+CONST.DEFAULT_PAGE_SIZE+"/1");
	}
	
	/**
	 * 新闻公告
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/news/{page_size}/{page_no}", method = RequestMethod.GET)
	public String news(ModelMap param, @PathVariable("page_size") String pSize, @PathVariable("page_no") String currentPage) {

		int pageNumber;
		int pageSize;
		
		try {
			pageSize = Integer.parseInt(pSize);
		} catch (NumberFormatException e) {
			pageSize = CONST.DEFAULT_PAGE_SIZE;
		}
		
		try {
			pageNumber = Integer.parseInt(currentPage);
		} catch (NumberFormatException e) {
			pageNumber = 1;
		}
		
		Page<News> newsList = this.newsService.page(pageNumber, pageSize);
		
		param.addAttribute("list", newsList.getContent());
		
		param.addAttribute("elementsCount", newsList.getTotalElements());
		param.addAttribute("currentPage", currentPage);
		param.addAttribute("pageSize", pageSize);

		return "news";
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
	
	/*合作伙伴*/
	@RequestMapping(path = "/partner")
	public void defaultPartner(HttpServletResponse response) throws IOException {
		response.sendRedirect("/partner/"+CONST.DEFAULT_PAGE_SIZE+"/1");
	}
	
	/**
	 * 	合作伙伴
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/partner/{page_size}/{page_no}", method = RequestMethod.GET)
	public String partner(ModelMap param, @PathVariable("page_size") String pSize, @PathVariable("page_no") String currentPage) {

		int pageNumber;
		int pageSize;
		
		try {
			pageSize = Integer.parseInt(pSize);
		} catch (NumberFormatException e) {
			pageSize = CONST.DEFAULT_PAGE_SIZE;
		}
		
		try {
			pageNumber = Integer.parseInt(currentPage);
		} catch (NumberFormatException e) {
			pageNumber = 1;
		}
		
		Page<Partner> partnerList = this.partnerService.page(pageNumber, pageSize);
		
		param.addAttribute("list", partnerList.getContent());
		
		param.addAttribute("elementsCount", partnerList.getTotalElements());
		param.addAttribute("currentPage", currentPage);
		param.addAttribute("pageSize", pageSize);

		return "partner";
	}

	/**
	 * detail页面详情展示
	 * 
	 * @param param
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/partner/detail", method = RequestMethod.GET)
	public String partnerDetail(ModelMap param, String id) {

		Partner pt = partnerService.getDetail(Integer.parseInt(id));
		param.addAttribute("title", pt.getTitle());
		param.addAttribute("detail", pt.getDetail());

		return "detail";
	}
	
	/**
	 * 	企业动态
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(path = "/recent")
	public void defaultRecent(HttpServletResponse response) throws IOException {
		response.sendRedirect("/recent/"+CONST.DEFAULT_PAGE_SIZE+"/1");
	}
	
	/**
	 * 	合作伙伴
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/recent/{page_size}/{page_no}", method = RequestMethod.GET)
	public String recent(ModelMap param, @PathVariable("page_size") String pSize, @PathVariable("page_no") String currentPage) {

		int pageNumber;
		int pageSize;
		
		try {
			pageSize = Integer.parseInt(pSize);
		} catch (NumberFormatException e) {
			pageSize = CONST.DEFAULT_PAGE_SIZE;
		}
		
		try {
			pageNumber = Integer.parseInt(currentPage);
		} catch (NumberFormatException e) {
			pageNumber = 1;
		}
		
		Page<Recent> recentList = this.recentService.page(pageNumber, pageSize);
		
		param.addAttribute("list", recentList.getContent());
		
		param.addAttribute("elementsCount", recentList.getTotalElements());
		param.addAttribute("currentPage", currentPage);
		param.addAttribute("pageSize", pageSize);

		return "recent";
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
	
	/* 经典案件*/
	@RequestMapping(path = "/classic")
	public void defaultClassic(HttpServletResponse response) throws IOException {
		response.sendRedirect("/classic/"+CONST.DEFAULT_PAGE_SIZE+"/1");
	}
	
	/**
	 *	经典案件
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/classic/{page_size}/{page_no}", method = RequestMethod.GET)
	public String classic(ModelMap param, @PathVariable("page_size") String pSize, @PathVariable("page_no") String currentPage) {

		int pageNumber;
		int pageSize;
		
		try {
			pageSize = Integer.parseInt(pSize);
		} catch (NumberFormatException e) {
			pageSize = CONST.DEFAULT_PAGE_SIZE;
		}
		
		try {
			pageNumber = Integer.parseInt(currentPage);
		} catch (NumberFormatException e) {
			pageNumber = 1;
		}
		
		Page<Classic> classicList = this.classicService.page(pageNumber, pageSize);
		
		param.addAttribute("list", classicList.getContent());
		
		param.addAttribute("elementsCount", classicList.getTotalElements());
		param.addAttribute("currentPage", currentPage);
		param.addAttribute("pageSize", pageSize);

		return "classic";
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
	
	/**
	  *关于我们
	 * 
	 * @param param
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public void defaultAbout(HttpServletResponse response) throws IOException {
		response.sendRedirect("/about/"+CONST.DEFAULT_PAGE_SIZE+"/1");
	}
	
	/**
	  * 关于我们
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/about/{page_size}/{page_no}", method = RequestMethod.GET)
	public String about(ModelMap param, @PathVariable("page_size") String pSize, @PathVariable("page_no") String currentPage) {

		int pageNumber;
		int pageSize;
		
		try {
			pageSize = Integer.parseInt(pSize);
		} catch (NumberFormatException e) {
			pageSize = CONST.DEFAULT_PAGE_SIZE;
		}
		
		try {
			pageNumber = Integer.parseInt(currentPage);
		} catch (NumberFormatException e) {
			pageNumber = 1;
		}
		
		Page<About> aboutList = this.aboutService.page(pageNumber, pageSize);
		
		param.addAttribute("list", aboutList.getContent());
		
		param.addAttribute("elementsCount", aboutList.getTotalElements());
		param.addAttribute("currentPage", currentPage);
		param.addAttribute("pageSize", pageSize);

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
	 * 留言建议
	 */
	/**
	  * 联系我们
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value = "/counsel", method = RequestMethod.POST, produces = "application/json;charset=utf-8")
	@ResponseBody
	@Transactional(rollbackFor = { Exception.class })
	public Counsel counsel(@RequestBody Counsel counsel) {
		try {
			//1存数据库
			Counsel c = counelService.save(counsel);
			
			//2发邮件
			String title = "网站咨询 ["+DateUtils.getDate("yyyy-MM-dd HH:mm:ss")+"]";
			
			StringBuffer content = new StringBuffer();
			content.append("姓名："+c.getName());
			content.append(System.getProperty("line.separator"));
			content.append("手机："+c.getTel());
			content.append(System.getProperty("line.separator"));
			content.append("邮箱："+c.getMail());
			content.append(System.getProperty("line.separator"));
			content.append("时间："+DateUtils.formatDate(c.getCreate_time(), "yyyy-MM-dd HH:mm:ss"));
			content.append(System.getProperty("line.separator"));
			content.append("内容："+c.getDetail());
			
			String from = "service@dmaoipr.com";
			String to = "zhangsk@dmaoipr.com";
			
			
			SimpleMailMessage mail = new SimpleMailMessage();
			mail.setTo(to);
			mail.setFrom(from);
			mail.setSubject(title);
			mail.setText(content.toString());
			mailService.send(mail);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3返回状态值
		return null;
	}
}