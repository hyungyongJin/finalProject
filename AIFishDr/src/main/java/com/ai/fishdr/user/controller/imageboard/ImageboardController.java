package com.ai.fishdr.user.controller.imageboard;

import java.net.URLEncoder;
import java.sql.Clob;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.board.IBoardService;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.user.service.imageboard.IImageboardService;
import com.ai.fishdr.user.service.imageboardcomment.IImageboardCommentService;
import com.ai.fishdr.user.service.imageboardfile.IImageboardFileService;
import com.ai.fishdr.utils.ClobToString;
import com.ai.fishdr.utils.RoleCommentPagingUtil;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.BoardCommentVO;
import com.ai.fishdr.vo.BoardFileVO;
import com.ai.fishdr.vo.BoardManageVO;
import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.SttemntVO;


/**
 * 
 * @Class Name :ImageboardController.java
 * @Description : 이미지게시판  컨트롤러
 * @Modification Information
 * @author 
 * @since  2018. 11. 15.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일            수정자      수정내용
 *    ------------      -------     -------------------
 *    2018. 11. 15.     임범학      최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */

@Controller
@RequestMapping("/user/imageboard/")
public class ImageboardController {
	
	
	@Autowired
	private IImageboardFileService fileService;
	
	@Resource
	private IImageboardService service;
	
	@Resource
	private IImageboardCommentService commentService;
	
	@Autowired
	private IBoardService boardService;
	
	@Autowired
	private IFacePictureService facePictureService;
	
	/**
	 * 
	 *    의미 : 이미지게시판 해당 게시글 화면
	 * @Method : imageboardView
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : 
	*		String currentPage,
	*		String search_keycode,
	*		String search_keyword,
	*		String bo_no,
	*		Map<String, String> params
	 * @return :modelandview(ModelAndView 타입)
	 * @throws : IOException
	 */
	
	@RequestMapping(value="imageboardView", method = { RequestMethod.GET, RequestMethod.POST } )
	public ModelAndView imageboardView(
			ModelAndView modelendview,
			String currentPage,
			String search,
			String keyword,
			String bo_no,
			Map<String, String> params,
			HttpServletRequest request,
			String commentPage,
			HttpSession session
			
			) throws Exception{
		
		
		///////댓글 페이징 처리//////////////////////
		
		Map<String, String> param= new HashMap<String, String>();

		if(commentPage==null||commentPage.intern() =="".intern()){
			commentPage = "1";
		}
		
		int totalCount = 0;
		
		param.put("bo_no", bo_no);
		totalCount = commentService.commendTotalcount(param);
		RoleCommentPagingUtil paginUtil = new RoleCommentPagingUtil(Integer.parseInt(commentPage), totalCount, request, bo_no,currentPage,keyword,search);
		
		//조회수증가
		service.updateHit(param);
		
		
		/////////////////////////////////////////
		
		params.put("board_code", "board003");
		BoardManageVO bmVO =  boardService.getBoardInfo(params);
		modelendview.addObject("bmVO",bmVO);
		params.put("startCount", String.valueOf(paginUtil.getStartCount()));
		params.put("endCount", String.valueOf(paginUtil.getEndCount()));
		
		params.put("bo_no", bo_no);
		
		List<Map<String,BoardCommentVO>> imageboardCommentList = commentService.getBoardCommentList(params);
		
		Map<String,Object> boardVOInfo= service.getBBSInfo(params);
		List<BoardFileVO> fileList = fileService.getBoardFileInfo(params);
		
		String mem_id =((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		params.put("mem_id", mem_id);
		
		boolean result  = service.getBlack(params);
		Clob content = (Clob) boardVOInfo.get("BO_CONTENT");
		String bo_content = ClobToString.convertClobToString(content);
		
		
		modelendview.addObject("checkBlack",result);
		modelendview.addObject("bo_content",bo_content);
		modelendview.addObject("checkBlack",result);
		modelendview.addObject("keyword", keyword);
		modelendview.addObject("search", search);
		modelendview.addObject("commentPaging", paginUtil.getPagingHtmls());
		modelendview.addObject("imageboardCommentList", imageboardCommentList);
		modelendview.addObject("viewInfo", boardVOInfo);
		modelendview.addObject("currentPage", currentPage);
		modelendview.addObject("fileList", fileList);
		modelendview.setViewName("user/imageboard/imageboardView");
		
		return modelendview;
		
	}
	
	/**
	 * 
	 *    의미 : 이미지게시판 게시글 등록화면
	 * @Method : imageboardForm
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : 
	 * 		ModelAndView modelendview
	 * @return :ModelAndView
	 * @throws Exception 
	 * @throws : IOException
	 */
	
	@RequestMapping("imageboardForm")
	public ModelAndView imageboardForm(ModelAndView modelendview
//										, String bo_no
										, String board_code
										, Map<String, String> params
										) throws Exception{
		
		params.put("board_code", board_code);
		BoardManageVO vo = boardService.getBoardInfo(params);
		
		modelendview.addObject("boardInfo",vo);
//		modelendview.addObject("bo_no", bo_no);
		modelendview.setViewName("user/imageboard/imageboardForm");
		
		return modelendview;
	}
	
	/**
	 * 
	 *    의미 : 이미지게시판 게시글 등록
	 * @Method : insertImageForm
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : 
	 * 		odelAndView modelandview,
*			BoardVO boardVO,
	*	@RequestParam("files") MultipartFile[] files
	*
	 * @return :ModelAndView
	 * @throws Exception 
	 * @throws : Exception
	 */
	
	@RequestMapping("insertImageForm")
	public ModelAndView insertImageForm(ModelAndView modelandview,
										BoardVO boardVO,
										@RequestParam("files") MultipartFile[] files,
										String commentPage,
										String currentPage,
										String keyword,
										String search
									) throws Exception{
		
		service.insertBBS(boardVO, files);
		
		modelandview.setViewName("redirect:/user/imageboard/imageboardList.do");
		return modelandview;
	}
	
	/**
	 * 
	 *    의미 : 이미지게시판 게시글 수정
	 * @Method : insertImageForm
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : 
	 * 		ModelAndView model,
									BoardVO boardVO,
									String commentPage,
									
									
	*	
	*
	 * @return :ModelAndView
	 * @throws Exception 
	 * @throws : Exception
	 */
	
	@RequestMapping("updateBoard")
	public ModelAndView updateBoard(ModelAndView model,
									BoardVO boardVO,
									@RequestParam("files") MultipartFile[] files
									) throws Exception{
		
		service.updateBBS(boardVO);
		
		model.setViewName("jsonConvertView");
		
		return model;
	}
	
	/**
	 * 
	 *    의미 : 이미지게시판 리스트 화면
	 * @Method : imageboardList
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : 
	*				Model model,
	*				String currentPage,
	*				String search_keycode,
	*				String search_keyword,
	*				HttpServletRequest request,
	*				Map<String, String> params,
	*				BoardVO boardVO 
	 * @return :String(String타입)
	 * @throws : IOException
	 */
	
	
	@RequestMapping("imageboardList")
	public String imageboardList(
					Model model,
					String currentPage,
					String search,
					String keyword,
					HttpServletRequest request,
					Map<String, String> params,
					BoardVO boardVO,
					String message,
					HttpSession session
				) throws Exception {
		
		
		if(currentPage==null||currentPage.intern() =="".intern()){
			currentPage = "1";
		}

		params.put("search", search);
		params.put("keyword", keyword);
		
	
		 
		//총 게시글의 갯수
		int totalCount;
	
			try {
				totalCount = service.totalCount(params);
				RolePagingUtil paginUtil = new RolePagingUtil(Integer.parseInt(currentPage),totalCount,request);
				
				params.put("startCount", String.valueOf(paginUtil.getStartCount()));
				params.put("endCount", String.valueOf(paginUtil.getEndCount()));
				
				List<BoardVO> imageBBSList = service.getBBS(params);
				
				
				model.addAttribute("message", message);
				model.addAttribute("currentPage", currentPage);
				model.addAttribute("imageboardList",imageBBSList);
				model.addAttribute("pagingHtmls", paginUtil.getPagingHtmls());
				model.addAttribute("boardName",  "이미지");
			} catch (Exception e) {
				e.printStackTrace();
			}
		return "user/imageboard/imageboardList";
	}
	
	/**
	 * 
	 *    의미 : 이미지게시판 게시물 삭제
	 * @Method : imageboardList
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : 
	 *				String bo_no,
									String currentPage,
									ModelAndView model,
									Map<String,String> params
	 * @return :ModelAndView
	 * @throws : Exception
	 */
	@RequestMapping("deleteBoard")
	public ModelAndView deleteBoard(String bo_no,
									String currentPage,
									ModelAndView model,
									Map<String,String> params
										) throws Exception{	
		params.put("bo_no", bo_no);
		service.deleteBBS(params);
		
		
		
		
		model.setViewName("forward:/user/imageboard/imageboardList.do");
		
		
		return model;
		
	}
	
	
	/**
	 * 
	 *    의미 : 이미지게시판 게시물 댓글등록
	 * @Method : imageboardList
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : 
	 *				ModelAndView model, Map<String,String> result, BoardCommentVO vo
	 * @return :ModelAndView
	 * @throws : IOException
	 */
	@RequestMapping("insertComment")
	public @ResponseBody ModelAndView insertComment(String commentPage, ModelAndView model, Map<String,String> result, BoardCommentVO vo, String currentPage,
														String search, String keyword		
														) throws Exception{
		commentService.insertBoardComment(vo);
		if (keyword!=null) {
			keyword = URLEncoder.encode(keyword, "UTF-8");
		}
		model.setViewName("redirect:/user/imageboard/imageboardView.do?commentPage="+commentPage+"&bo_no="+vo.getBo_no()+"&currentPage="+currentPage+"&search="+search+"&keyword="+keyword);
		return model;
		
	}
	
	/**
	 * 
	 *    의미 : 이미지게시판 게시물 댓글삭제
	 * @Method : imageboardList
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : 
	 * 	`		String comment_no,Map<String,String>params,ModelAndView model
	 * @return :ModelAndView(String타입)
	 * @throws : IOException
	 */
	
	@RequestMapping("deleteComment")
	public  ModelAndView deleteComment(String comment_no,Map<String,String>params,ModelAndView model) throws Exception{
		
		params.put("comment_no", comment_no);
		boolean result = commentService.deleteBoardComment(params);
		
		model.addObject("result", result);
//		model.setViewName("forward:/user/imageboard/imageboardView.do");
		model.setViewName("jsonConvertView");
		return model;
		
		
	}
	
	/**
	 * 
	 *    의미 : 이미지게시판 게시물 댓글수정
	 * @Method : imageboardList
	 * @author : 임범학
	 * -----------------------------------
	 * @param  : 
	 * 	`		String comment_no,Map<String,String>params,ModelAndView model
	 * @return :ModelAndView(String타입)
	 * @throws Exception 
	 * @throws : IOException
	 */
	@RequestMapping("updateComment")
	public ModelAndView updateComment(ModelAndView model, String comment_no,
										String comment_content,
										Map<String, String> params
										) throws Exception{
		
		
		params.put("comment_no", comment_no);
		params.put("comment_content", comment_content);
		
		commentService.updateBoardComment(params);
		
		model.setViewName("jsonConvertView");
		
		return model;
	}
	/**
	 *  개요 : 게시글 좋아요
	 * @Method Name : boardrecommend
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("imageboardrecommend")
	public ModelAndView boardrecommend(String bo_no, ModelAndView model) throws Exception{
		service.updateGoodHit(bo_no);
		model.setViewName("jsonConvertView");
		return model;
	}
	
	
	/**
	 *  개요 : 게시글 신고
	 * @Method Name : imageboardblack
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("imageboardblack")
	public ModelAndView boardblack(ModelAndView model,
							SttemntVO vo) throws Exception{
		
		service.insertBadHit(vo);
		model.setViewName("jsonConvertView");
		return model;
		
	}
	
	/**
	 *  개요 : 쪽지보내기
	 * @Method Name : message
	 * @author : 임범학
	 * -----------------------------------
	 * @param : String id,Model model
	 * @return : String
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("messageModal")
	public String message(String id,Model model){
		model.addAttribute("id",id); 
		
		return "/commonModal/boardMessageModal";
		
	} 
	
	
}
