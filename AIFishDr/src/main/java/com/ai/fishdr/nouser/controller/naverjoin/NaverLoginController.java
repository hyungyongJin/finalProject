package com.ai.fishdr.nouser.controller.naverjoin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.ai.fishdr.nouser.service.member.IMemberService;
import com.ai.fishdr.utils.CryptoGenerator;
import com.ai.fishdr.vo.MemberVO;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.Response;

@Controller
@RequestMapping("/naver/")
public class NaverLoginController {
	
	
	@Autowired
	private CryptoGenerator cryptoGen;
	
	private MessageSourceAccessor messageAccessor;
	
	private JsonStringParse jsonparse = new JsonStringParse();
	
	@Autowired
	private IMemberService service;
	
	/* NaverLoginBO */
    private NaverLoginBO naverLoginBO;
    
    private String apiResult = null;
    
    @Autowired
    private void setNaverLoginBO(NaverLoginBO naverLoginBO) {
        this.naverLoginBO = naverLoginBO;
    }
	
	
	
	@RequestMapping(value ="login", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login(ModelAndView model, HttpSession session){
		
		 /* 네이버아이디로 인증 URL을 생성하기 위하여 naverLoginBO클래스의 getAuthorizationUrl메소드 호출 */
        String naverAuthUrl = naverLoginBO.getAuthorizationUrl(session);
        
        //https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=sE***************&
        //redirect_uri=http%3A%2F%2F211.63.89.90%3A8090%2Flogin_project%2Fcallback&state=e68c269c-5ba9-4c31-85da-54c16c658125
        System.out.println("네이버:" + naverAuthUrl);
        
        //네이버 
        model.addObject("url", naverAuthUrl);
        /* 생성한 인증 URL을 View로 전달 */
        
		
        model.setViewName("redirect:"+naverAuthUrl);
        
		
		return model;
	}
	
	
	@RequestMapping(value ="loginForm", method = { RequestMethod.GET, RequestMethod.POST })
	private String loginForm(
							String id,
							String name,
							String email,
							HttpSession session,
							Map<String,String> params,
							Model model,
							@RequestHeader("Accept-Language") String al,
							@RequestHeader("User-Agent") String ua
							){
		System.out.println("Accept-Language:" + al);
		System.out.println("User-Language:" + ua);
		
        /* 생성한 인증 URL을 View로 전달 */
		
	
        
//		<property name="prefix" value="/WEB-INF/views/"></property>
//		<property name="suffix" value=".jsp"></property>
//		return "user/join/loginForm";
		
		Map<String, String> publickeyMap= cryptoGen.getGeneratePairKey(session);
		session.setAttribute("publicKeyMap", publickeyMap);
		params.put("id", id);
		params.put("name", name);
		params.put("email", email);
		model.addAttribute("naverlogin", params);
		// 최초 ScheduleFactoryBean 빈 클래스가 인스턴스화 되면
		// 해당 스케줄러는 실행
		
		//해당 스케쥴러 영구 정지
//		schedulerFactory.destroy();
		//일시정지
//		schedulerFactory.stop();
		//재시작
//		schedulerFactory.start();
		
		
		return "user/member/memberForm";
	}
	
	
	
	
	
	
	@RequestMapping(value = "naverLoginCheck", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView naverLoginCheck(Map<String,String> params,
								HttpSession session,
								HttpServletRequest request,
								HttpServletResponse response,
								String id,
								String name,
								String email,
								String mem_hp,
								String mem_nickname,
								ModelAndView model
			
			) throws Exception{
		
		String mem_id = "social" + id.substring(0, 2);
		
		params.put("mem_id", mem_id);
		
		
		MemberVO memVO = new MemberVO();
		memVO.setMem_id(mem_id);
		memVO.setMem_pwd("1234");
		memVO.setMem_name(name);
		memVO.setMem_phone(mem_hp);
		memVO.setMem_mail(email);
		memVO.setMem_nickname(mem_nickname);
		memVO.setConect_way("social");
		
		
		MemberVO memberInfo = service.memberInfo(params);
		if (memberInfo != null) {
			session.setAttribute("LOGIN_MEMBER", memberInfo);
			
			RedirectView rv1 = new RedirectView("../main.do");
			
			rv1.setExposeModelAttributes(false);
			
			model = new ModelAndView(rv1);
		
		}else{
			service.insertMemberInfo(memVO);
			
			memberInfo = service.memberInfo(params);
			session.setAttribute("LOGIN_MEMBER", memberInfo);
			
			
			RedirectView rv2 = new RedirectView("../main.do");
			
			rv2.setExposeModelAttributes(false);
			
			model = new ModelAndView(rv2);
			
		}
		
		return model;
	}
	
	
	@RequestMapping(value = "callback", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView callback(ModelAndView model,
							@RequestParam String code,
							@RequestParam String state, 
							HttpServletRequest request,
							HttpServletResponse response,
							HttpSession session) throws Exception{
		
		
		
			Map<String, String> params = new HashMap<String, String>();
		    
		    System.out.println("여기는 callback");
	        OAuth2AccessToken oauthToken;
	        oauthToken = naverLoginBO.getAccessToken(session, code, state);
	        //로그인 사용자 정보를 읽어온다.
	        apiResult = naverLoginBO.getUserProfile(oauthToken);
	        
	        JSONObject jsonobj = jsonparse.stringToJson(apiResult, "response");
		    String snsId = jsonparse.JsonToString(jsonobj, "id");
		    
		    String mem_id = "social" + snsId.substring(0, 2);
		    
		    params.put("mem_id", mem_id);
		    MemberVO memberInfo = service.memberInfo(params);
	        
		    if (memberInfo != null) {
		    	model.addObject("id", snsId);
		    	model.setViewName("redirect:naverLoginCheck.do");
				return model;
			}else {
				model.addObject("result", apiResult);
				model.setViewName("nouser/naver/callback");
				return model;
			}
	        
	        
	        /* 네이버 로그인 성공 페이지 View 호출 */
	        
//	      JSONObject jsonobj = jsonparse.stringToJson(apiResult, "response");
//	      String snsId = jsonparse.JsonToString(jsonobj, "id");
//	      String name = jsonparse.JsonToString(jsonobj, "name");
	//
//	      UserVO vo = new UserVO();
//	      vo.setUser_snsId(snsId);
//	      vo.setUser_name(name);
	//
//	      System.out.println(name);
//	      try {
//	          vo = service.naverLogin(vo);
//	      } catch (Exception e) {
//	          // TODO Auto-generated catch block
//	          e.printStackTrace();
//	      }


//	      session.setAttribute("login",vo);
//	      return new ModelAndView("user/loginPost", "result", vo);
	        
		
		
		
	}
	
	
	
	
	
	
}
