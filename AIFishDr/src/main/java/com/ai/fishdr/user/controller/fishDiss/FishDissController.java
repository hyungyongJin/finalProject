package com.ai.fishdr.user.controller.fishDiss;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.disease.IDiseaseService;
import com.ai.fishdr.utils.RolePagingUtilFishgramComment;
import com.ai.fishdr.vo.DiseaseFileVO;

@Controller
@RequestMapping("/user/fishDiss")
public class FishDissController {
	@Autowired
	private IDiseaseService service;
	
	
	@RequestMapping("fishDiss")
	public ModelAndView fishDissList(ModelAndView model, String search, String keyword, String cnt,Map<String,String>params,
			String commentCurrentPage, HttpServletRequest request) throws Exception{
		if (commentCurrentPage==null||commentCurrentPage=="") {
			commentCurrentPage="1";
		}
		request.setAttribute("cnt", cnt);
		params.put("search", search);
		params.put("keyword", keyword);
		int totalCount = service.getShowDissCnt(params); 
		RolePagingUtilFishgramComment page = new RolePagingUtilFishgramComment(Integer.parseInt(commentCurrentPage), totalCount, request);
		
		params.put("startCount", String.valueOf(page.getStartCount()));
		params.put("endCount", String.valueOf(page.getEndCount()));
		List<Map<String,String>> data = service.getShowDissList(params);
		model.addObject("dissList",data);
		model.addObject("paging",page.getPagingHtmls());
		return model;
	}
	@RequestMapping("fileInfo")
	public ModelAndView fileInfo (ModelAndView model,String diss_code) throws Exception{
		List<DiseaseFileVO> info = service.getDissFileInfo(diss_code);
		model.addObject("info",info);
		model.setViewName("jsonConvertView");
		return model;
	}
	
	
}
