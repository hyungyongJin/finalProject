package com.ai.fishdr.user.controller.annymty;

import java.io.Console;
import java.io.File;
import java.net.URLEncoder;
import java.sql.Clob;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import oracle.net.aso.i;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.board.IBoardService;
import com.ai.fishdr.admin.serivce.boardFile.IBoardFileService;
import com.ai.fishdr.admin.serivce.boardcomment.IBoardCommentService;
import com.ai.fishdr.user.service.annymty.IAnnymtyboardService;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.utils.AttachFileMapper;
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
 * @Class Name :AnnymtyboardController.java
 * @Description : 게시판 컨트롤러
 * @Modification Information
 * @author 유재훈
 * @since  2018. 11. 15.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 15.     유재훈             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Controller
@RequestMapping("/user/annymtyboard/")
public class AnnymtyController {
	
	@Autowired
	private IAnnymtyboardService service;
	@Autowired
	private IBoardCommentService commentService;
	@Autowired
	private IBoardFileService fileService;
	@Autowired
	private IBoardService boardService;
	@Autowired
	private IFacePictureService facePictureService;
	
	
	/**
	 *  개요 : 게시판 글 상세보기
	 * @Method Name : annymtyboardView
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 */
	@RequestMapping("annymtyboardView")
	public ModelAndView annymtyboardView(String commentPage,
										 Map<String,String> params,
										 ModelAndView model,
										 String bo_no,
										 String currentPage,
										 String search,
										 String keyword ,
										 HttpServletRequest request,
										 HttpSession session) throws Exception{
		params.put("bo_no", bo_no);
		service.updateHit(params);
		if (commentPage==null) {
			commentPage="1";
		}
		int totalCount = commentService.getTotalCount(bo_no);
		if (keyword!=null) {
			keyword = URLEncoder.encode(keyword, "UTF-8");
		}
		model.addObject("keyword", keyword);
		RoleCommentPagingUtil page= new RoleCommentPagingUtil(Integer.parseInt(commentPage), totalCount, request, bo_no,currentPage,keyword,search);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		String[] fishName = {"광어","도미","참돔","연어","감성돔","우럭","농어","홍어","대구","쉬리","송사리","산천어","돗돔","빙어","가시고기","고등어"};
		List<Map<String, Object>> viewInfo =  service.boardInfo(params);
		List<Map<String,String>> comment =  (List<Map<String, String>>) viewInfo.get(1).get("commentInfo");
		for (int i = 0; i < comment.size(); i++) {
			String random = (fishName[new Random().nextInt(fishName.length)]);
			comment.get(i).put("MEM_NICKNAME", random);
		}
//		System.out.println(viewInfo.get(2));
		model.addObject("currentPage", currentPage);
		model.addObject("search", search);
		model.addObject("commentPage", commentPage);
		model.addObject("paging",page.getPagingHtmls()); 
		model.addObject("viewInfo",viewInfo);
		String mem_id =((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id();
		params.put("mem_id", mem_id);
		boolean result  = service.getBlack(params);
		model.addObject("checkBlack",result);
		Clob content = (Clob) viewInfo.get(0).get("BO_CONTENT");
		if (content!=null) {
			String viewContent = ClobToString.convertClobToString(content);
			model.addObject("content",viewContent);
		}
		return model;
		
	}
	/**
	 * 
	 *  개요 : 글쓰기 폼이동
	 * @Method Name : annymtyboardForm
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : void
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("annymtyboardForm")
	public void annymtyboardForm(Model model,
								 Map<String,String>params,
								 String board_code) throws Exception{
		params.put("board_code", board_code);
		BoardManageVO vo = boardService.getBoardInfo(params);
		model.addAttribute("boardInfo",vo);
	}
	
	/**
	 * 
	 *  개요 : 게시판 글 리스트
	 * @Method Name : annymtyboardList
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : void
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("annymtyboardList")
	public ModelAndView annymtyboardList(ModelAndView model ,
										 HttpServletRequest request,
										 Map<String,String>params,
										 String search,
										 String keyword,
										 String currentPage,
										 HttpSession session) throws Exception{
		
		if (currentPage==null) {
			currentPage="1";
		}
		params.put("search", search);
		params.put("keyword", keyword);
		int totalCount= service.getTotalCount(params);
		RolePagingUtil page= new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		
		
		
		List<Map<String,String>> writeList =  service.getBoardList(params);
		String[] fishName = {"광어","도미","참돔","연어","감성돔","우럭","농어","홍어","대구","쉬리","송사리","산천어","돗돔","빙어","가시고기","고등어"};
		for (int i = 0; i < writeList.size(); i++) {
			String random = (fishName[new Random().nextInt(fishName.length)]);
			writeList.get(i).put("MEM_NICKNAME", random);
		}
		
		model.addObject("currentPage", currentPage);
		model.addObject("search", search);
		if (keyword!=null) {
			keyword = URLEncoder.encode(keyword, "UTF-8");
		}
		
		List<Map<String,BoardVO>> noticeList = service.getAdminWriteList();
		model.addObject("keyword", keyword);
		model.addObject("noticeList", noticeList);
		model.addObject("paging",page.getPagingHtmls());
		model.addObject("writeList",writeList);
		return model;
	}
	/**
	 * 
	 *  개요 : 글등록
	 * @Method Name : insertannymtyboard
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("insertannymtyboard")
	public ModelAndView insertBoard(ModelAndView model,
									BoardVO vo,
									@RequestParam("files") MultipartFile[] files ) throws Exception{
		
		service.insertBoard(vo,files);
		model.setViewName("redirect:/user/annymtyboard/annymtyboardList.do");
		return model;
	}
	/**
	 * 
	 *  개요 : 댓글등록
	 * @Method Name : insertComment
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("insertComment")
	public ModelAndView insertComment(String commentPage, String currentPage,String keyword,String search, ModelAndView model, BoardCommentVO vo) throws Exception{
		commentService.insertBoardComment(vo);
		if (keyword!=null) {
			keyword = URLEncoder.encode(keyword, "UTF-8");
		}
		model.setViewName("redirect:/user/annymtyboard/annymtyboardView.do?commentPage="+commentPage+"&bo_no="+vo.getBo_no()+"&currentPage="+currentPage+"&search="+search+"&keyword="+keyword);
		return model;
		
	}
	/**
	 * 
	 *  개요 : 글삭제
	 * @Method Name : deleteannymtyboard
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("deleteannymtyboard")
	public ModelAndView deletebBoard(ModelAndView model, String bo_no, Map<String,String>params) throws Exception{
		params.put("bo_no", bo_no);
		boolean result = service.deleteBoard(params);
		
		String message="";
		if (result) {
			message = URLEncoder.encode("삭제 완료 되었습니다.", "UTF-8");
			model.setViewName("redirect:/user/annymtyboard/annymtyboardList.do?message="+message);
		}else{
			model.setViewName("redirect:/user/annymtyboard/annymtyboardList.do");
		}
		return model;
		
	}
	/**
	 * 
	 *  개요 :파일 다운로드 
	 * @Method Name : fileDownlaod
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("fileDownload")
	public ModelAndView fileDownlaod(String file_no , ModelAndView andView,Map<String,String>params) throws Exception{
		params.put("file_no", file_no);
		BoardFileVO file = fileService.getFileInfo(params);
		String fileName = file.getFile_save_name();
		String originalName = file.getFile_name();
		File targetFile = new File(AttachFileMapper.FILE_PATH, fileName);
		andView.addObject("downloadFile", targetFile);
		andView.addObject("downloadFileName", fileName);
		andView.addObject("originalName", originalName);
		andView.setViewName("downloadView");
		return andView;
	}
	/**
	 * 
	 *  개요 : 쪽지보내기 화면이동
	 * @Method Name : string
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : String
	 * @throws :
	 */
	@RequestMapping("messageModal")
	public String message(String id,Model model){model.addAttribute("id",id); return "/commonModal/boardMessageModal";} 
	/**
	 * 
	 *  개요 : 채팅화면 화면이동
	 * @Method Name : string
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : String
	 * @throws :
	 */
	@RequestMapping("chatModal")
	public String chat(String id,Model model){model.addAttribute("id",id); return "/commonModal/chatMessageModal";} 
	/**
	 * 
	 *  개요 : 댓글삭제 
	 * @Method Name : deleteComment
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("delComment")
	public ModelAndView deleteComment(ModelAndView model, Map<String,String>params, String comment_no) throws Exception{
		params.put("comment_no", comment_no);
		boolean result = commentService.deleteBoardComment(params);
		model.addObject("result",result);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 게시판 수정
	 * @Method Name : updateBoard
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("updateBoard")
	public ModelAndView updateBoard(ModelAndView model,BoardVO vo,@RequestParam("files") MultipartFile[] files, String file_no) throws Exception{
		service.updateBoard(vo, files);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 * 
	 *  개요 : 파일 삭제 
	 * @Method Name : deleteFile
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("deleteFile")
	public ModelAndView deleteFile(ModelAndView model,String file_no,Map<String,String>params) throws Exception{
		params.put("file_no", file_no);
		fileService.deleteBoardFile(params);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 댓글 수정
	 * @Method Name : updateComment
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("updateComment")
	public ModelAndView updateComment(ModelAndView model, BoardCommentVO vo) throws Exception{
		commentService.updateBoardComment(vo);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 좋아요 기능
	 * @Method Name : boardrecommend
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("boardrecommend")
	public ModelAndView boardrecommend(String bo_no, ModelAndView model) throws Exception{
		service.updateGoodHit(bo_no);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 게시글 신고
	 * @Method Name : boardblack
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("boardblack")
	public ModelAndView boardblack(ModelAndView model, SttemntVO vo) throws Exception{
		service.insertBadHit(vo);
		model.setViewName("jsonConvertView");
		return model;
	}
	
}
