package com.ai.fishdr.user.service.diseaseboard;                          
                                                                      
import java.util.List;                                                
import java.util.Map;                                                 
                                                                      
import org.springframework.web.multipart.MultipartFile;               
                                                                      
import com.ai.fishdr.vo.BoardVO;                                      
import com.ai.fishdr.vo.SttemntVO;                                    
/**                                                                   
 *                                                                    
 * @Class Name :IDiseaseboardService.java                                
 * @Description : 게시판 관련 service                                 
 * @Modification Information                                          
 * @author 진형용                                                     
 * @since  2018. 11. 15.                                              
 * @version 1.0                                                       
 * @see                                                               
 * <pre>                                                              
 * << 개정이력(Modification Information) >>                           
 *    수정일             수정자             수정내용                  
 *    -------        -------     -------------------                  
 *    2018. 11. 15.     진형용             최초작성                   
 *    ------------------------------------------------                
 * Copyright (c) 2018 AI Fish Dr.  All right reserved                 
 * </pre>                                                             
 */                                                                   
public interface IDiseaseboardService {                                  
	/**                                                                 
	 *                                                                  
	 *  개요 : 게시글 등록                                              
	 * @Method Name : insertBoard                                       
	 * @author : 진형용                                                 
	 * -----------------------------------                              
	 * @param files                                                     
	 * @param :                                                         
	 * @return : String                                                 
	 * @throws :                                                        
	 */                                                                 
	public String insertBoard(BoardVO vo, MultipartFile[] files) throws Exception;  
	/**                                                                             
	 *                                                                              
	 *  개요 : 글 수정                                                              
	 * @Method Name : updateBoard                                                   
	 * @author : 진형용                                                             
	 * -----------------------------------                                          
	 * @param files                                                                 
	 * @param :                                                                     
	 * @return : int                                                                
	 * @throws :                                                                    
	 */                                                                             
	public boolean updateBoard(BoardVO vo, MultipartFile[] files)throws Exception;  
	                                                                                
	/**                                                                             
	 *                                                                              
	 *  개요 : 글 삭제                                                              
	 * @Method Name : deleteBoard                                                   
	 * @author : 진형용                                                             
	 * -----------------------------------                                          
	 * @param :                                                                     
	 * @return : int                                                                
	 * @throws :                                                                    
	 */                                                                             
	public boolean deleteBoard(Map<String,String>params) throws Exception;          
	                                                                                
	/**                                                                             
	 *                                                                              
	 *  개요 : 글 리스트                                                            
	 * @Method Name : getBoardList                                                  
	 * @author : 진형용                                                             
	 * -----------------------------------                                          
	 * @param :                                                                     
	 * @return : List<Map<String,BoardVO>>                                          
	 * @throws :                                                                    
	 */                                                                             
	public List<Map<String,BoardVO>> getBoardList(Map<String,String>params)throws Exception; 
	                                                                                         
	/**                                                                                      
	 *                                                                                       
	 *  개요 : 글 상세정보                                                                   
	 * @Method Name : boardInfo                                                              
	 * @author : 진형용                                                                      
	 * -----------------------------------                                                   
	 * @param :                                                                              
	 * @return : List<Map<String,Object>>                                                    
	 * @throws :                                                                             
	 */                                                                                      
	public List<Map<String, Object>> boardInfo(Map<String,String>params) throws Exception;   
	/**                                                                                      
	 *                                                                                       
	 *  개요 : 게시글 갯수                                                                   
	 * @Method Name : getTotalCount                                                          
	 * @author : 진형용                                                                      
	 * -----------------------------------                                                   
	 * @param :                                                                              
	 * @return : int                                                                         
	 * @throws :                                                                             
	 */                                                                                      
	public int getTotalCount(Map<String,String>params) throws Exception;                     
	/**                                                                                      
	 *                                                                                       
	 *  개요 : 조회수                                                                        
	 * @Method Name : updateHit                                                              
	 * @author : 진형용                                                                      
	 * -----------------------------------                                                   
	 * @param :                                                                              
	 * @return : void                                                                        
	 * @throws :                                                                             
	 */                                                                                      
	public void updateHit(Map<String, String> params)throws Exception;                       
	/**                                                                                      
	 *                                                                                       
	 *  개요 : 좋아요                                                                        
	 * @Method Name : updateGoodHit                                                          
	 * @author : 진형용                                                                      
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
	 * @author : 진형용                                                                      
	 * -----------------------------------                                                   
	 * @param :                                                                              
	 * @return : boolean                                                                     
	 * @throws :                                                                             
	 */                                                                                      
	public boolean insertBadHit(SttemntVO vo)throws Exception;                               
	/**                                                                                      
	 *  개요 : 로그인한사람이 게시글 신고했는지 체크 메서드                                  
	 * @Method Name : getBlack                                                               
	 * @author : 진형용                                                                      
	 * -----------------------------------                                                   
	 * @param :                                                                              
	 * @return : boolean                                                                     
	 * @throws :                                                                             
	 */
	public boolean getBlack(Map<String, String> params) throws Exception;  
	/**                                                                 
	 *  개요 : 공지사항만 불러오는 리스트                                   
	 * @Method Name : getAdminWriteList                                     
	 * @author : 진형용                                                     
	 * -----------------------------------                                  
	 * @param :                                                             
	 * @return : List<Map<String,BoardVO>>                                  
	 * @throws :                                                            
	 */                                                                     
	public List<Map<String, BoardVO>> getAdminWriteList() throws Exception; 
	                                                                       
}                                                                        