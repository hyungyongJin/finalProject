package com.ai.fishdr.user.controller.aiservice;



import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.vo.MemberVO;
/**
 * @Class Name :AIServiceController.java
 * @Description : 
 * @Modification Information
 * @author 진형용
 * @since  2018. 11. 21.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 21.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/user/aiService/")
public class AIServiceController {
	
	@Autowired
	private IFacePictureService facePictureService;
	

	@RequestMapping("aiService")
	public Model aiService(Model model, HttpSession session, Map<String, String> params) throws Exception {
		
		
		model.addAttribute("welcome","안녕하세요"+((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_nickname()+"님 자동응답서비스입니다. 무엇을 도와드릴까요?");
		return model;
	}
	
}
