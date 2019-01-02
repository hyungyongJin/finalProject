package com.ai.fishdr.nouser.controller.join;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ai.fishdr.nouser.service.join.INoUserJoinService;
import com.ai.fishdr.nouser.service.member.IMemberService;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.utils.CryptoGenerator;
import com.ai.fishdr.vo.MemberVO;

/**
 * 
 * @Class Name :NoUserJoinController.java
 * @Description : 비회원 회원가입 컨트롤러
 * @Modification Information
 * @author 
 * @since  2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 12.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/nouser/")
public class NoUserJoinController{

	@Autowired
	private INoUserJoinService joinService;
	
	@Autowired
	private CryptoGenerator cryptoGen;
    
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IFacePictureService facePictureService;
    
	
	/**
	 * 
	 *  개요 : 회원가입후 로그인체크 회원메인화면으로 포워딩
	 * @Method Name : loginCheck
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("join/loginCheck")
	public ModelAndView loginCheck(Map<String,String> params,
							 Map<String, String> profileParams,
							 ModelAndView modelendview,
							 String mem_id,
							 String mem_pwd,
							 MemberVO paramVO,
							 HttpSession session ) throws Exception{
		
		String id = cryptoGen.decryptRSA(session, mem_id);
		String pass = cryptoGen.decryptRSA(session, mem_pwd);
	
		profileParams.put("fp_mem_id", id);
		
		params.put("mem_id", id);
		params.put("mem_pwd", pass);
		
		MemberVO memberInfo = memberService.memberInfo(params);
		
		if(memberInfo == null){
			
			String message = "";
			
			try {
				
				message = "회원이 아닙니다";
				message = URLEncoder.encode(message,"UTF-8");
				
			} catch (UnsupportedEncodingException e) {
				
				e.printStackTrace();
				
			}
			
			modelendview.setViewName("redirect:/nouser/join/loginForm.do?message="+message);
			
		} else{
			
			session.setAttribute("LOGIN_MEMBER", memberInfo);
			
 			String fp_file_save_name = null;
			
			String profileStatus = memberInfo.getProfile_status();
			
			if(profileStatus.equals("y")) {
				
				fp_file_save_name = facePictureService.facePictureInfo(profileParams).getFp_file_save_name();
				session.setAttribute("FILE_SAVE_NAME", fp_file_save_name);
				
			}
					
			if (memberInfo.getMem_position().intern() == "mem".intern()) {
				
//				RedirectView rv = new RedirectView("../../user/noticeboard/noticeList.do?profileStatus=" + profileStatus + "&fp_file_save_name=" + fp_file_save_name);
				
				RedirectView rv = new RedirectView("../../main.do?profileStatus=" + profileStatus + "&fp_file_save_name=" + fp_file_save_name);
				
				rv.setExposeModelAttributes(false);
				
				modelendview = new ModelAndView(rv);
				
//				modelendview.setViewName("redirect:/main.do?profileStatus=" + profileStatus + "&fp_file_save_name=" + fp_file_save_name);
				
				return modelendview;
				
			}else{
				
				RedirectView admin_rv = new RedirectView("../../admin/stats/statsList.do");
				
				admin_rv.setExposeModelAttributes(false);
				
				modelendview = new ModelAndView(admin_rv);
				
				return modelendview;
				
			}
			
		}
		
		return modelendview;
		
	}
	
	
	/**
	 * 로그인버튼 클릭시 로그인 폼으로 이동
	 *  개요 : 
	 * @Method Name : loginForm
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : String
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("join/loginForm")
	public String loginForm(HttpSession session,Model model, Map<String, String> params) throws Exception{
		
	      Map<String, String> publickeyMap= cryptoGen.getGeneratePairKey(session);
	      session.setAttribute("publicKeyMap", publickeyMap);
	      
	      return "loginForm";
	      
	}
	
	
	/**
	 * 회원가입 로직처리 개요 :
	 * 
	 * @Method Name : insertMember
	 * @author : 유재훈 -----------------------------------
	 * @param : ModelAndView model,
	 * 		    MemberVO memberInfo,
	 * 			Map<String, MemberVO> params
	 * @return : ModelAndView
	 * @throws : Exception
	 */
	@RequestMapping("join/insertMember")
	public ModelAndView insertMember(ModelAndView model, MemberVO memberInfo,
			Map<String, MemberVO> params) throws Exception {

		params.put("memberInfo", memberInfo);
		int count = memberService.insertMemberInfo(memberInfo);
		String message = "";

		if (count >= 1) {
			message = "회원 가입이 완료되었습니다.";
		} else {
			message = "회원 가입이 실패하였습니다.";
		}
		if (message!=null) {
			message = URLEncoder.encode(message,"UTF-8");
			
		}
		model.setViewName("redirect:/main.do?message="+message);

		return model;
	}
	
	
	/**
	 * 의미 :  회원가입Form으로 이동
	 * 
	 * @Method Name : insertMemberForm
	 * @author : 유재훈 -----------------------------------
	 * @throws : Exception
	 */
	@RequestMapping("insertMember/insertMemberForm")
	public void insertMemberForm() throws Exception {
		
	}
	
	
	/**
	 * 아이디 중복확인 
	 * 
	 * @Method Name : idCheck
	 * @author : 유재훈 -----------------------------------
	 * @param : String mem_id,
	 * 		    Map<String, String> params,
	 *			ModelAndView andView
	 * @return : ModelAndView
	 * @throws : Exception
	 */
	@RequestMapping("idCheck")
	public ModelAndView idCheck(String mem_id, Map<String, String> params,
			ModelAndView andView) throws Exception {
		params.put("mem_id", mem_id);

		MemberVO memberInfo = memberService.memberInfo(params);
		int message =0;
		if (memberInfo!=null) {
			message = 0;
		}else{
			message = 1;
			
		}
		andView.addObject("message", message);
		
		andView.setViewName("jsonConvertView");

		return andView;
		
	}
	
	
	/**
	 * 닉네임 중복확인 
	 * 
	 * @Method Name : nickNameCheck
	 * @author : 유재훈 -----------------------------------
	 * @param : String mem_nickname,
	 *			Map<String, String> params,
	 *		    ModelAndView andView
	 * @return : ModelAndView
	 * @throws : Exception
	 */
	@RequestMapping("nickNameCheck")
	public ModelAndView nickNameCheck(String mem_nickname,
			Map<String, String> params, ModelAndView andView) throws Exception {
		params.put("mem_nickname", mem_nickname);

		MemberVO memberInfo = memberService.memberInfo(params);
		
		
		int message = 0;
		if (memberInfo!=null) {
			
			message = 0;
			
		}else{
			
			message = 1;
			
		}
		
		andView.addObject("message", message);
		
		andView.setViewName("jsonConvertView");
		
		return andView;
	}
	
	
	/**
	 * 로그아웃처리
	 * 
	 * @Method Name : logout
	 * @author : 임범학 -----------------------------------
	 * @param : String
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("join/logOut")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/main.do";
		
	}

}
