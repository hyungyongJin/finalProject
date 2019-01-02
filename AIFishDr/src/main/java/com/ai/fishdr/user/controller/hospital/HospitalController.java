package com.ai.fishdr.user.controller.hospital;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.user.service.facepicture.IFacePictureService;

@Controller
@RequestMapping("/user/hospital/")
public class HospitalController {
	
	@Autowired
	private IFacePictureService facePictureService;

	@RequestMapping("hospitalService")
	public ModelAndView hospital(ModelAndView model, HttpSession session, Map<String, String> params) throws Exception{
		
		
		model.setViewName("user/hospital/daumMap");
		
		return model;
	}
	
	
}
