package com.tywy.sc.controller.back;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tywy.sc.base.controller.BaseController;

@Controller
public class WebSocketController extends BaseController{
	
	@RequestMapping(value="back/websocket" , method={RequestMethod.GET , RequestMethod.POST})
	public String websocket(HttpServletRequest request , Model model) {
		return "forward:/WEB-INF/views/websocket.jsp";
	}
}
