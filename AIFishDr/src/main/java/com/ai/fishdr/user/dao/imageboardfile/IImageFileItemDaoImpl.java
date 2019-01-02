package com.ai.fishdr.user.dao.imageboardfile;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.BoardFileVO;
import com.ibatis.sqlmap.client.SqlMapClient;


@Repository
public class IImageFileItemDaoImpl implements IImageFileItemDao{

	@Resource
	private SqlMapClient smc;
	
	/*
	 * 이미지파일 등록 메서드
	 */
	@Override
	public Object insertBoardFile(BoardFileVO boardFile) throws Exception {
		return smc.insert("imageboardFile.insertBoardFile",boardFile);
	}

	/*
	 * 이미지파일 불러오는 메서드
	 */
	@Override
	public List<BoardFileVO> getBoardFileInfo(Map<String, String> params)
			throws Exception {
		return smc.queryForList("imageboardFile.getBoardFileList",params);
	}

	/*
	 * 이미지파일 삭제하는 메서드
	 */
	@Override
	public boolean deleteBoardFile(Map<String, String> params) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * 이미지파일 수정하는 메서드
	 */
	@Override
	public boolean updateBoardFile(BoardFileVO boardFile) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
