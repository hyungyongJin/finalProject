package com.ai.fishdr.admin.controller.board;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
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
import com.ai.fishdr.admin.serivce.boardFile.IBoardFileService;
import com.ai.fishdr.admin.serivce.boardcomment.IBoardCommentService;
import com.ai.fishdr.admin.serivce.member.IMemberMgrService;
import com.ai.fishdr.admin.serivce.stats.IStatsService;
import com.ai.fishdr.utils.AttachFileMapper;
import com.ai.fishdr.utils.Generator;
import com.ai.fishdr.utils.GeneratorImpl;
import com.ai.fishdr.utils.RolePagingUtil;
import com.ai.fishdr.vo.BoardCommentVO;
import com.ai.fishdr.vo.BoardFileVO;
import com.ai.fishdr.vo.BoardManageVO;
import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.MessageVO;
import com.ai.fishdr.vo.SttemntVO;
/**
 * 
 * @Class Name :BoardController.java
 * @Description : 관리자 게시판 전체관리 컨트롤러 
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
@RequestMapping("/admin/board/")
public class BoardController {
	@Autowired
	private IBoardCommentService commentService;
	@Autowired
	private IBoardService boardService;
	@Autowired
	private IBoardFileService fileService;
	@Autowired
	private IMemberMgrService memService;
	@Autowired
	private IStatsService statService;
	
	/**
	 * 
	 *  개요 :  게시판 제너레이터
	 * @Method Name : insertBoard
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("insertBoard")
	public ModelAndView insertBoard(ModelAndView model, BoardManageVO vo) throws Exception{
		String boardName = vo.getBoard_eng_name();
		String boardKrName = vo.getBoard_name();
		String boardCode = boardService.insertBoard(vo);
		Generator gen = new GeneratorImpl();
		gen.xmlFileMaker(boardName, boardCode);
		gen.controllerMaker(boardName);
		gen.serviceMaker(boardName);
		gen.daoMaker(boardName);
		gen.jspFileMaker(boardName,boardKrName, boardCode);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 * 
	 *  개요 : 
	 * @Method Name : updateBoard
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("updateBoard")
	public ModelAndView updateBoard(BoardManageVO board, ModelAndView model) throws Exception{
		boardService.updateBoard(board);
		model.setViewName("redirect:/admin/board/boardList.do");
		return model;
	}
	/**
	 * 
	 *  개요 : 
	 * @Method Name : getBoardList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("boardList")
	public Model getBoardList(Model model,String cnt,  String search, HttpServletRequest request,String currentPage,Map<String,String>params) throws Exception{
		List<BoardManageVO> board = boardService.getBoardList();
		model.addAttribute("boardList",board);
		List<BoardManageVO> boardList =  boardService.getBoardList();
		List<String> board_code = new ArrayList<String>();
		for (int i = 0; i < boardList.size(); i++) {
			String fish_code = boardList.get(i).getBoard_code();
			if (fish_code.intern()!="board004".intern()) {
				board_code.add(boardList.get(i).getBoard_code());
			}
		}
		List<Object> eachCount = statService.getEachBoardCount(board_code);
		if (currentPage==""||currentPage==null) {
			currentPage="1";
		}
		params.put("search", search);
		params.put("cnt", cnt);
		int totalCount = boardService.getListOfMemesPrscrptnCnt(params);
		RolePagingUtil page = new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("startCount", String.valueOf(page.getStartCount()));
		params.put("endCount", String.valueOf(page.getEndCount()));
		List<Map<String,String>> prs_cntList = boardService.getListOfMemesPrscrptn(params);
		model.addAttribute("paging",page.getPagingHtmls());
		model.addAttribute("prs_cntList",prs_cntList);
		
		model.addAttribute("eachBoardcount",eachCount);
		return model;
	}
	/**
	 * 
	 *  개요 : 
	 * @Method Name : getBoardInfo
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping(value="boardView.do",method=RequestMethod.GET)
	public @ResponseBody BoardManageVO getBoardInfo(BoardManageVO vo, String board_code,ModelAndView model, Map<String,String>params) throws Exception{
		params.put("board_code", board_code);
		vo = boardService.getBoardInfo(params);
		return vo;
	}
	/**
	 * 
	 *  개요 : 게시판 삭제
	 * @Method Name : deleteBoard
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping(value="deleteBoard")
	public ModelAndView deleteBoard(String board_code, ModelAndView model, Map<String,String>params) throws Exception{
		String[] code_key = board_code.split(",");
		boolean result = boardService.deleteBoard(code_key);
		if (result) {
			model.addObject("message",code_key.length+"개의 게시판 삭제완료");
			model.setViewName("forward:/admin/board/boardList.do");
		}else{
			model.setViewName("redirect:/admin/board/boardList.do");
		}
		return model;
	}
	/**
	 * 
	 *  개요 : 
	 * @Method Name : getBoardWriteList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("writeList")
	public ModelAndView getBoardWriteList(ModelAndView model,Map<String,String>params,
			HttpServletRequest request,String search, String keyword,String currentPage, String boardCategory) throws Exception{
		if (currentPage==null||currentPage=="".intern()) {
			currentPage="1";
		}
		params.put("boardCategory", boardCategory);
		params.put("search", search);
		params.put("keyword", keyword);
		int totalCount= boardService.getTotalCount(params);
		RolePagingUtil page= new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		
		List<Map<String,BoardVO>> writeList =  boardService.getBoardWriteList(params);
		List<BoardManageVO> boardList = boardService.getBoardList();
		Map<String,String> searchMap = new HashMap<String, String>();
		searchMap.put("keyword", keyword);
		searchMap.put("search", search);
		searchMap.put("currentPage", currentPage);
		searchMap.put("boardCategory", boardCategory);
		model.addObject("searchInfo",searchMap);
		model.addObject("paging",page.getPagingHtmls());
		model.addObject("writeList",writeList);
		model.addObject("boardName",boardList);
		return model;
	}
	/**
	 * 
	 *  개요 : 
	 * @Method Name : getBoardWriteInfo
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("writeView")
	public @ResponseBody Map<String,Object> getBoardWriteInfo(ModelAndView model, Map<String,String>params,String bo_no) throws Exception{
		params.put("bo_no", bo_no);
		Map<String, Object> vo =  boardService.getBoardWriteInfo(params);
		List<Map<String,SttemntVO>> blackReason =  boardService.getBlackReason(bo_no);
		vo.put("reason", blackReason);
		return vo;
	}
	/**
	 * 
	 *  개요 : 
	 * @Method Name : insertBoardWrite
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("insertWrite")
	public ModelAndView insertBoardWrite(ModelAndView model, @RequestParam("files") MultipartFile[] files, BoardVO vo) throws Exception{
		boardService.insertBoardWrite(vo,files);
		model.setViewName("redirect:/admin/board/writeList.do");
		return model;
	}
	/**
	 * 
	 *  개요 : 
	 * @Method Name : updateBoardWrite
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("updateWrite")
	public ModelAndView updateBoardWrite(ModelAndView model, BoardVO vo ) throws Exception{
		boardService.updateBoardWrite(vo);
		
		model.setViewName("redirect:/admin/board/writeList.do");
		return model;
	}
	/**
	 * 
	 *  개요 : 
	 * @Method Name : deleteBoardWrite
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("deleteWrite")
	public ModelAndView deleteBoardWrite( ModelAndView model, String bo_no, String type) throws Exception{
		String[] num = bo_no.split(",");
		boolean result = boardService.deleteBoardWrite(num);
		String message = "";
		boolean page = false;
		if (type==null) {
			page = true;
		}	
		if (result) {
			message = URLEncoder.encode(num.length+"건의 게시글 삭제완료", "UTF-8");
		}
		if (page) {
			model.setViewName("redirect:/admin/board/writeList.do?message="+message);
		}else{
			model.setViewName("redirect:/admin/board/blackList.do?message="+message);
		}
		return model;
	}
	/**
	 * 
	 *  개요 : 신고게시글 리스트불러오는 메서드
	 * @Method Name : getBlackWriteList
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("blackList")
	public ModelAndView getBlackWriteList(Map<String,String>params, ModelAndView model,String search, String keyword,String currentPage
			,HttpServletRequest request,String boardCategory) throws Exception{
		if (currentPage==null||currentPage=="".intern()) {
			currentPage="1";
		}
		params.put("boardCategory", boardCategory);
		params.put("search", search);
		params.put("keyword", keyword);
		int totalCount= boardService.getBlackTotalCount(params);
		RolePagingUtil page= new RolePagingUtil(Integer.parseInt(currentPage), totalCount, request);
		params.put("endCount", String.valueOf(page.getEndCount()));
		params.put("startCount", String.valueOf(page.getStartCount()));
		
		List<Map<String,BoardVO>> blackList = boardService.getBlackWriteList(params);
		List<BoardManageVO> boardList = boardService.getBoardList();
		Map<String,String> searchMap = new HashMap<String, String>();
		searchMap.put("keyword", keyword);
		searchMap.put("search", search);
		searchMap.put("currentPage", currentPage);
		searchMap.put("boardCategory", boardCategory);
		model.addObject("searchInfo",searchMap);
		model.addObject("paging",page.getPagingHtmls());
		model.addObject("blackList",blackList);
		model.addObject("boardName",boardList);
		
		
		return model;
	}
	/**
	 * 
	 *  개요 : 글쓰기폼이동
	 * @Method Name : writeForm
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : void
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("writeForm")
	public Model writeForm(Model model) throws Exception{
		List<BoardManageVO> boardList = boardService.getBoardList();
		return model.addAttribute("boardName",boardList);
	}
	/**
	 * 
	 *  개요 : 댓글등록
	 * @Method Name : insertComment
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : String
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("insertComment")
	public @ResponseBody ModelAndView insertComment(ModelAndView model, Map<String,String>result, BoardCommentVO vo) throws Exception{
		String comment_no = commentService.insertBoardComment(vo);
		BoardCommentVO commentVO =  commentService.getBoardCommentInfo(comment_no);
		model.addObject("commentIfo",commentVO);
		model.setViewName("jsonConvertView");
		return model;
		
	}
	/**
	 * 
	 *  개요 : 댓글 수정
	 * @Method Name : updateComment
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("updateComment")
	public ModelAndView updateComment(BoardCommentVO vo, ModelAndView model){
		
		return model;
		
	}
	/**
	 * 
	 *  개요 :  댓글 삭제
	 * @Method Name : deleteComment
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("deleteComment")
	public  ModelAndView deleteComment(String comment_no,Map<String,String>params,ModelAndView model) throws Exception{
		params.put("comment_no", comment_no);
		commentService.deleteBoardComment(params);
		model.addObject("comment_no",comment_no);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 파일 다운로드
	 * @Method Name : downloadFile
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("downloadFile")
	public ModelAndView downloadFile(ModelAndView model,Map<String,String>params ,String file_no) throws Exception{
		params.put("file_no", file_no);
		BoardFileVO file = fileService.getFileInfo(params);
		String fileName = file.getFile_save_name();
		String originalName = file.getFile_name();
		File targetFile = new File(AttachFileMapper.FILE_PATH, fileName);
		model.addObject("downloadFile", targetFile);
		model.addObject("originalName", originalName);
		model.addObject("downloadFileName", fileName);
		model.setViewName("downloadView");
		return model;
	}
	/**
	 *  개요 : 회원에게 경고메세지 보내기(게시글 신고 다수 시)
	 * @Method Name : warnMember
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws Exception 
	 * @throws :
	 */
	@RequestMapping("warnMember")
	public ModelAndView warnMember(ModelAndView model,Map<String,String>params, String id_bo_no,MessageVO vo,
		HttpSession session) throws Exception{
		String mem_id = id_bo_no.split(",")[0];
		String bo_no = id_bo_no.split(",")[1];
		params.put("bo_no", bo_no);
		Map<String, Object> getInfo =  boardService.getBoardWriteInfo(params);
		String headMsg ="회원님이 작성하신 \"["+getInfo.get("BOARD_NAME").toString()+" 내 \""+getInfo.get("BO_TITLE").toString()+"\"] 게시글은 ";
		
		List<Map<String,SttemntVO>> blackReason =  boardService.getBlackReason(bo_no);
		String message = "";
		for (Map<String, SttemntVO> map : blackReason) {
			message += map.get("REASON")+",\n";
		}
		message +="(과)와 같은 사유로 신고가 접수되어 삭제 되었습니다.";
		String msg = headMsg+message;
		vo.setMe_get_id(mem_id);
		vo.setMs_content(msg);
		vo.setMs_send_id(((MemberVO)session.getAttribute("LOGIN_MEMBER")).getMem_id());
		boolean result =  memService.warningMsg(vo);
		boolean res = memService.updateSttemnt(mem_id);
		model.addObject("result",result);
		model.addObject("res",res);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 신고 해당 게시글 삭제
	 * @Method Name : deleteboardWrite
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("deleteboardWrite")
	public ModelAndView deleteboardWrite(ModelAndView model, String bo_no) throws Exception{
		String[] num = {bo_no}; 
		boolean result = boardService.deleteBoardWrite(num);
		model.addObject("result",result);
		model.setViewName("jsonConvertView");
		return model;
	}
	/**
	 *  개요 : 게시판 생성시 중복체크
	 * @Method Name : boardCheck
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : ModelAndView
	 * @throws :
	 */
	@RequestMapping("boardCheck")
	public ModelAndView boardCheck(ModelAndView model,String board_name,String board_eng_name,Map<String,String>params) throws Exception{
		params.put("board_name",board_name);
		params.put("board_eng_name",board_eng_name);
		BoardManageVO vo = boardService.getBoardInfo(params);
		boolean result = false;
		if (vo!=null) {
			result = true;
		}
		model.addObject("result",result);
		model.setViewName("jsonConvertView");
		return model;
	}
}
