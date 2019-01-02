package com.ai.fishdr.user.service.mdcin_category;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ai.fishdr.user.dao.mdcin_category.IMdcinCategoryDao;
import com.ai.fishdr.vo.MedicineCategoryVO;

@Repository
public class IMdcinCategoryServiceImpl implements IMdcinCategoryService {
	
	@Autowired
	private IMdcinCategoryDao dao;
	
	@Transactional(readOnly=true)
	@Override
	public List<MedicineCategoryVO> getMdcinCategoryList()
			throws Exception {
		return dao.getMdcinCategoryList();
	}

	@Override
	public MedicineCategoryVO getMdcinCategoryInfo(Map<String, String> params)
			throws Exception {
		return dao.getMdcinCategoryInfo(params);
	}
	
}
