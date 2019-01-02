package com.ai.fishdr.user.service.imageboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.fileupload.FileItem;
import org.springframework.web.multipart.MultipartFile;

import com.ai.fishdr.vo.BoardVO;
import com.ai.fishdr.vo.SttemntVO;

public interface IImageboardService {

	/**
	 * 
	 *  개요 : 게시물 리스트 출력
	 * @Method Name : getBBS
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return :  List<BoardVO>
	 * @throws :
	 */
	public List<BoardVO> getBBS(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 게시물등록
	 * @Method Name : insertBBS
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean insertBBS(BoardVO vo, MultipartFile[] files) throws Exception;
	
	/**
	 * 
	 *  개요 : 조회수
	 * @Method Name : updateHit
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : void
	 * @throws :
	 */
	public void updateHit(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 해당 게시물 정보
	 * @Method Name : getBBSInfo
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : void
	 * @throws :
	 */
	public Map<String, Object> getBBSInfo(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 게시물 삭제
	 * @Method Name : deleteBBS
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : void
	 * @throws :
	 */
	public void deleteBBS(Map<String, String> params) throws Exception;
	/**
	 * 
	 *  개요 : 게시물 수정
	 * @Method Name : updateGoodHit
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int updateBBS(BoardVO vo) throws Exception;
	
	/**
	 * 
	 *  개요 : 총 게시물 갯수
	 * @Method Name : updateGoodHit
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public int totalCount(Map<String, String> params) throws Exception;
	
	/**
	 * 
	 *  개요 : 좋아요 
	 * @Method Name : updateGoodHit
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean updateGoodHit(String bo_no)throws Exception;
	/**
	 * 
	 *  개요 : 신고
	 * @Method Name : updateBadHit
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean insertBadHit(SttemntVO vo)throws Exception;
	/**
	 *  개요 : 로그인한사람이 게시글 신고했는지 체크 메서드
	 * @Method Name : getBlack
	 * @author : 임범학
	 * -----------------------------------
	 * @param : 
	 * @return : boolean
	 * @throws :
	 */
	public boolean getBlack(Map<String, String> params) throws Exception;	
	
}
