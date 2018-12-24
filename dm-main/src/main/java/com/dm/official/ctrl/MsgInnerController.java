
package com.dm.official.ctrl;

import java.util.Iterator;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dm.official.persistences.SpringBootJdbc;
import com.dm.official.util.StringUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 */
@Api(value = "主入口")
@Controller
@RequestMapping("/main/")
@EnableAutoConfiguration
public class MsgInnerController {

	@Autowired
	SpringBootJdbc dao;

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
		return "about"; 
	}

	@RequestMapping(value = "/classic", method = RequestMethod.GET)
	public String classic() {
		return "classic"; 
	}

	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
		return "contact"; 
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index"; 
	}

	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public String news() {
		return "news"; 
	}

	@RequestMapping(value = "/partner", method = RequestMethod.GET)
	public String partner() {
		return "partner"; 
	}

	@RequestMapping(value = "/recent", method = RequestMethod.GET)
	public String recent() {
		return "recent"; 
	}

	@RequestMapping(value = "/scope", method = RequestMethod.GET)
	public String scope() {
		return "scope"; 
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
	public String detail(ModelMap param, String id) {
		
		String title = "";
		String detail = "";

		try {
			String sql = "SELECT * FROM t_detail t where t.id = "+Integer.parseInt(id)+" LIMIT 1";
			Map<String, Object> xx = dao.queryForMap(sql);
			
			Iterator<Map.Entry<String, Object>> it = xx.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> entry = it.next();
				
				if("title".equals(entry.getKey()))
					title = (String)entry.getValue();
				if("detail".equals(entry.getKey()))
					detail = (String)entry.getValue();
			}
			
			if(StringUtils.isEmpty(title) || StringUtils.isEmpty(detail))
				throw new IllegalArgumentException();
			
		} catch (NumberFormatException e1) {
			title = "请求错误";
			detail = "服务器拒绝了您的非法请求！";
		} catch (IllegalArgumentException e) {
			title = "请求错误";
			detail = "服务器未返回有效的数据，请稍后再试或联系管理员！";
		} catch (Exception e) {
			title = "请求错误";
			detail = "服务器暂时出现了问题，请稍后再试或联系管理员！";
		}
			
		param.addAttribute("title",title);
		param.addAttribute("detail",detail);
		
		return "detail"; 
	}

	@ApiOperation(value = "")
	@RequestMapping(path = "/insertOne", method = RequestMethod.GET)
	@ResponseBody
	public void insertOne() {
		String sql = "INSERT INTO f_result ( task_id, status, response, create_time, update_time )"+
					 "VALUES (3,4,5,'2011-11-11 11:11:11','2011-11-11 11:11:11')";
		dao.execute(sql);
	}
	
	@ApiOperation(value = "")
	@RequestMapping(path = "/insertMore", method = RequestMethod.GET)
	@ResponseBody
	public void insertMore() {
		String sql = "INSERT INTO f_result ( task_id, status, response, create_time, update_time )"+
					 "VALUES (3,4,5,'2011-11-11 11:11:11','2011-11-11 11:11:11'), "+
					 " (3,4,5,'2011-11-11 11:11:11','2011-11-11 11:11:11'),"+
					 " (31,41,51,'2011-11-11 11:11:11','2011-11-11 11:11:11'),"+
					 " (333,444,555,'2011-11-11 11:11:11','2011-11-11 11:11:11')";
		dao.execute(sql);
	}
}