package com.ai.fishdr.user.controller.fishgram.facepicture;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.ai.fishdr.nouser.service.member.IMemberService;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;


import com.ai.fishdr.utils.AttachFileMapperFacePicture;
import com.ai.fishdr.vo.FacePictureVO;
import com.ai.fishdr.vo.MemberVO;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


/**
 * 
 * @Class Name : FacePictureController.java
 * @Description :  피쉬그램 프로필 사진 관련 컨트롤러
 * @Modification Information
 * @author 
 * @since  2018. 11. 13.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    ------------      -------     -------------------
 *    2018. 11. 13.     심재형      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

@Controller
@RequestMapping("/user/fishgram/facepicture/")
public class FacePictureController {
	
	public static String tempSaveFileName = null; 
	
	@Autowired
	private IFacePictureService service;
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private AttachFileMapperFacePicture fileMapper;
	
	@RequestMapping("idPicFileUpload")
	public void fileUploadForm(){}
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 프로필 사진 업로드
	 * @Method : fileUpload
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : files (@RequestParam("idPic") MultipartFile 타입)
	 * @return : "redirect:/user/fishgram/facepicture/idPicFileUpload.do?encodingName=" + encodingName (String 타입)
	 * @throws : Exception
	 */
	@RequestMapping("idFileUpload")
	public String fileUpload(@RequestParam("idPic") MultipartFile files) throws Exception {
		
		FacePictureVO fpv = fileMapper.mappingFacePicture(files);
		
		String encodingName = URLEncoder.encode(fpv.getFp_file_save_name(), "UTF-8");
		
		fpv.setFp_file_save_name(encodingName);
		
		service.insertFacePictureInfo(fpv);
		
		return "redirect:/user/fishgram/facepicture/idPicFileUpload.do?encodingName=" + encodingName;
		
	}
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 프로필 사진 수정 Ajax 처리
	 * @Method : imageAjax
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : jsonMap (Map<String, String> 타입)
	 * 			 files (@RequestParam("idPic") MultipartFile 타입)
	 * @return : jsonData (String 타입)
	 * @throws : Exception
	 */
	@RequestMapping("imageAjax")
	@ResponseBody
	public String imageAjax(Map<String, String> jsonMap, @RequestParam("idPic") MultipartFile files) throws Exception {
		
		FacePictureVO fpv = fileMapper.mappingFacePicture(files);
		
		String encodingName = URLEncoder.encode(fpv.getFp_file_save_name(), "UTF-8");
		
		tempSaveFileName = encodingName;
		
		fpv.setFp_file_save_name(encodingName);
		
		service.insertFacePictureInfo(fpv);
		
		jsonMap.put("encodingName", encodingName);
		
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonData = mapper.writeValueAsString(jsonMap);
		
		return jsonData;
		
	}
	
	
	/**
	 * 
	 *    의미 : 피쉬그램 프로필 수정 완료 위한 데이터 전달
	 * @Method : profileModifyComplete
	 * @author : 심재형
	 * -----------------------------------
	 * @param  : params (Map<String, String> 타입)
	 * 			 mav (ModelAndView 타입)
	 *			 session (Httpsession 타입)
	 * @return : "forward:/user/fishgram/fishgramMeMain.do" (String 타입)
	 * @throws : 
	 */
	@RequestMapping("profileModifyComplete")
	public String profileModifyComplete(Map<String, String> params, ModelAndView mav, HttpSession session) throws Exception {
		
		String fp_mem_id = ((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		
		params.put("fp_mem_id", fp_mem_id);
		params.put("mem_id", fp_mem_id);
		
		
		int count = service.facePictureCount(params);
		
		if (count == 1) {
			
			service.deleteFacePictureInfo(params);
			
		}
				
		String fp_file_save_name = tempSaveFileName;
				
		params.put("fp_file_save_name", fp_file_save_name);
		session.setAttribute("FILE_SAVE_NAME", fp_file_save_name);	
		service.updateFacePictureInfo(params);
		
		memberService.changeProfileStatusY(params);
		
		
		MemberVO mv = (MemberVO)session.getAttribute("LOGIN_MEMBER");
		
		mv.setProfile_status("y");
		
//		session.setAttribute("LOGIN_MEMBER", mv);
				
		return "forward:/user/fishgram/fishgramMeMain.do"; 
				
	}
	
}
