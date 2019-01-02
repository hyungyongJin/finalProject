package com.ai.fishdr.user.dao.mdcin_category;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ai.fishdr.vo.MedicineCategoryVO;
import com.ibatis.sqlmap.client.SqlMapClient;

@Repository
public class IMdcinCategoryDaoImpl implements IMdcinCategoryDao {
	
	@Autowired
	private SqlMapClient smc;
	
	@Override
	public List<MedicineCategoryVO> getMdcinCategoryList()
			throws Exception {
		return smc.queryForList("medicineCategory.getMdcinCategoryList");
	}

	@Override
	public MedicineCategoryVO getMdcinCategoryInfo(Map<String, String> params)
			throws Exception {
		return (MedicineCategoryVO) smc.queryForObject("medicineCategory.getMdcinCategoryInfo", params);
	}
	
}
