package com.ai.fishdr.user.dao.diseaseboard;                                                          
                                                                                                   
import java.util.List;                                                                             
import java.util.Map;                                                                              
                                                                                                   
import org.springframework.beans.factory.annotation.Autowired;                                     
import org.springframework.stereotype.Repository;                                                  
                                                                                                   
import com.ai.fishdr.vo.BoardVO;                                                                   
import com.ai.fishdr.vo.SttemntVO;                                                                 
import com.ibatis.sqlmap.client.SqlMapClient;                                                      
                                                                                                   
@Repository                                                                                        
public class IDiseaseboardDaoImpl implements IDiseaseboardDao{                                           
	@Autowired                                                                                       
	private SqlMapClient smc;                                                                        
                                                                                                   
	@Override                                                                                        
	public String insertBoard(BoardVO vo) throws Exception {                                         
		return (String) smc.insert("diseaseboard.insertBoard",vo);                                    
	}                                                                                                
                                                                                                   
	@Override                                                                                        
	public int updateBoard(BoardVO vo) throws Exception {                                            
		return smc.update("diseaseboard.updateBoard",vo);                                             
	}                                                                                                
                                                                                                   
	@Override                                                                                        
	public int deleteBoard(Map<String, String> params) throws Exception {                            
		return smc.delete("diseaseboard.deleteBoard",params);                                         
	}                                                                                                
                                                                                                   
	@Override                                                                                        
	public List<Map<String, BoardVO>> getBoardList(Map<String, String> params)                       
			throws Exception {                                                                       
		return smc.queryForList("diseaseboard.getBoardList",params);                                  
	}                                                                                                
                                                                                                   
	@Override                                                                                        
	public Map<String, Object> boardInfo(Map<String, String> params)                                 
			throws Exception {                                                                       
		return (Map<String, Object>) smc.queryForObject("diseaseboard.getBoardInfo",params);          
	}                                                                                                
                                                                                                   
	@Override                                                                                        
	public int getTotalCount(Map<String, String> params) throws Exception {                          
		return (int) smc.queryForObject("diseaseboard.getTotalCount",params);                         
	}                                                                                                
                                                                                                   
	@Override                                                                                        
	public void updateHit(Map<String, String> params) throws Exception {                             
		smc.update("diseaseboard.updateHit",params);                                                  
	}                                                                                                
                                                                                                   
	@Override                                                                                        
	public int updateGoodHit(String bo_no) throws Exception {                                        
		return smc.update("diseaseboard.updateGoodHit",bo_no);                                        
	}                                                                                                
                                                                                                   
	@Override                                                                                        
	public Object insertBadHit(SttemntVO vo) throws Exception {                                      
		return smc.insert("diseaseboard.insertBadHit",vo);                                            
	}                                                                                                
                                                                                                   
	@Override                                                                                        
	public int getBlack(Map<String, String> params) throws Exception {                               
		return (int) smc.queryForObject("diseaseboard.getBlack",params);                              
	}                                                                                                
	@Override                                                                                        
	public List<Map<String, BoardVO>> getAdminWriteList() throws Exception {                         
	return smc.queryForList("diseaseboard.getAdminWriteList");                                          
 }                                                                                                 
	                                                                                                 
}