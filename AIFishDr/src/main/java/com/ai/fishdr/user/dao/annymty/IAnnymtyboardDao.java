package com.ai.fishdr.user.dao.annymty;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.SttemntVO;

public interface IAnnymtyboardDao {
	/**
	 * 
	 *  개요 :게시글 등록
	 * @Method Name :insertBoard
	 * @author :유재훈
	 * -----------------------------------
	 * @param :BoardVO vo
	 * @return :String
	 * @throws :Exception
	 */
	public String insertBoard(BoardVO vo) throws Exception;
	/**
	 * 
	 *  개요 :게시글 수정
	 * @Method Name :updateBoard
	 * @author :유재훈
	 * -----------------------------------
	 * @param :BoardVO vo
	 * @return :int
	 * @throws :Exception
	 */
	public int updateBoard(BoardVO vo)throws Exception;
	
	/**
	 * 
	 *  개요 :게시글 삭제
	 * @Method Name :deleteBoard
	 * @author :유재훈
	 * -----------------------------------
	 * @param :Map<String,String>params
	 * @return :int
	 * @throws :Exception
	 */
	public int deleteBoard(Map<String,String>params) throws Exception;

	/**
	 * 
	 *  개요 :게시글 리스트
	 * @Method Name :getBoardList
	 * @author :유재훈
	 * -----------------------------------
	 * @param :Map<String,String>params
	 * @return :List<Map<String,BoardVO>>
	 * @throws :Exception
	 */
	public List<Map<String,String>> getBoardList(Map<String,String>params)throws Exception;
	
	/**
	 * 
	 *  개요 :게시글 상세정보
	 * @Method Name :boardInfo
	 * @author :유재훈
	 * -----------------------------------
	 * @param :Map<String,String>params
	 * @return :Map<String, Object> 
	 * @throws :Exception
	 */
	public Map<String, Object> boardInfo(Map<String,String>params) throws Exception;
	/**
	 * 
	 *  개요 :전체 게시글 갯수
	 * @Method Name :getTotalCount
	 * @author :유재훈
	 * -----------------------------------
	 * @param :Map<String,String> params
	 * @return :int
	 * @throws :Exception
	 */
	public int getTotalCount(Map<String,String>params) throws Exception;
	/**
	 * 
	 *  개요 :한 게시글에 대한 조회수
	 * @Method Name :updateHit
	 * @author :유재훈
	 * -----------------------------------
	 * @param :Map<String, String> params
	 * @return :void
	 * @throws :Exception
	 */
	public void updateHit(Map<String, String> params)throws Exception;
	/**
	 * 
	 *  개요 :한 게시글에 대한 좋아요 수
	 * @Method Name :updateGoodHit
	 * @author :유재훈
	 * -----------------------------------
	 * @param :String bo_no
	 * @return :int
	 * @throws :Exception
	 */
	public int updateGoodHit(String bo_no)throws Exception;
	/**
	 * 
	 *  개요 :게시글 신고
	 * @Method Name :updateBadHit
	 * @author :유재훈
	 * -----------------------------------
	 * @param :SttemntVO vo
	 * @return :Object
	 * @throws :Exception
	 */
	public Object insertBadHit(SttemntVO vo)throws Exception;
	/**
	 *  개요 :로그인을 한 사람이 신고한 것인지 체크
	 * @Method Name :getBlack
	 * @author :유재훈
	 * -----------------------------------
	 * @param :Map<String, String> params 
	 * @return :int
	 * @throws :Exception
	 */
	public int getBlack(Map<String, String> params)throws Exception;
	/**
	 *  개요 : 공지사항만 불러오는 리스트
	 * @Method Name : getAdminWriteList
	 * @author : 유재훈
	 * -----------------------------------
	 * @param : 
	 * @return : List<Map<String,BoardVO>>
	 * @throws :
	 */
	public List<Map<String, BoardVO>> getAdminWriteList() throws Exception;
}
