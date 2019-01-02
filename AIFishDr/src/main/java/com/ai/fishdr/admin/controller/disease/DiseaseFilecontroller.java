package com.ai.fishdr.admin.controller.disease;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.disease.IDiseaseService;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.DiseaseFileVO;
import com.ai.fishdr.vo.DiseaseVO;
/**
 * @Class Name :DiseaseFilecontroller.java
 * @Description : 질병사진 관련 컨트롤러
 * @Modification Information
 * @author 진형용
 * @since  2018. 11. 22.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 22.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/admin/diseaseFile/")
public class DiseaseFilecontroller {
	@Autowired
	private IDiseaseService service;
	/**
	 *  개요 : 질병명과 사진갯수를 불러오는 메서드
	 * @Method Name : getDiseaseList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("diseaseFileList")
	public ModelAndView getDiseaseList(ModelAndView model,String currentPage, Map<String,String>params,String keyword
			,String search,String noPics,HttpServletRequest request) throws Exception{
		if (currentPage==null||currentPage=="".intern()) {
			currentPage="1";
		}
		params.put("search", search);
		params.put("keyword", keyword);
		params.put("noPics", noPics);
		int totalCount= service.getTotalFileCount(params);
		RolePagingUtil page= new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		List<Map<String,DiseaseVO>> list =  service.getDisaseFileList(params);
		model.addObject("paging",page.getPagingHtmls());
		model.addObject("dissList",list);
		model.addObject("keyword",keyword);
		model.addObject("search",search);
		return model;
	}
	/**
	 *  개요 : 질병사진 등록
	 * @Method Name : insertDissFile
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("insertDissFile")
	public ModelAndView insertDissFile(ModelAndView model, String diss_code, @RequestParam("files") MultipartFile[] files) throws Exception{
		service.insertDissFile(diss_code,files);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 질병사진을 불러오는 메서드
	 * @Method Name : dissFileView
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("dissFileView")
	public ModelAndView dissFileView(ModelAndView model, String diss_code) throws Exception{
		List<DiseaseFileVO> fileList = service.getDissFileInfo(diss_code);
		model.addObject("fileList",fileList);
		model.setViewName("jsonConvertView");
		return model;
	}
	@RequestMapping("delDissFile")
	public ModelAndView delDissFile(ModelAndView model,String file_no) throws Exception{
		boolean result = service.deleteDissFile(file_no);
		model.addObject(result);
		model.setViewName("jsonConvertView");
		return model;
		
	}
}
