package com.ai.fishdr.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.ai.fishdr.vo.FishgramFileVO;

@Component
public class AttachFileMapperProfile {
	
	private final static String FILE_PATH = "D:\\temp\\images\\";
	
	public List<FishgramFileVO> mappingProfile(MultipartFile[] files, String bo_no){
		
		List<FishgramFileVO> fishgramFileList = new ArrayList<FishgramFileVO>();
		
		if (files != null) {
			
			FishgramFileVO ffv = null;
			
			for (MultipartFile file : files) {
				
				if (file.getSize() > 0) {
					
					ffv = new FishgramFileVO();
					ffv.setBo_no(bo_no);
					
					//getName() : [찾아보기]클릭 선택한 파일의 패스/파일명.확장자
					//			  [찾아보기]클릭 선택한 파일의 파일명.확장자
					//file.getOriginalFilename() :  [찾아보기]클릭 선택한 파일의 파일명.확장자
					//file.getOriginalFilename();
					String fileName = file.getOriginalFilename();
					
					ffv.setFile_name(fileName);
					
					String baseName = FilenameUtils.getBaseName(fileName);   //베이스이름
					String extension = FilenameUtils.getExtension(fileName); //확장자
					String genID = UUID.randomUUID().toString().replace("-", "");
					
					String saveFileName = baseName + genID + "." + extension;
					
					ffv.setFile_save_name(saveFileName);
					
					ffv.setFile_content_type(file.getContentType());
					
					ffv.setFile_size(String.valueOf(file.getSize()));
					
					fishgramFileList.add(ffv);
					
					saveFile(saveFileName,file);
					
				}
				
			}
			
		}
		
		return fishgramFileList;
	}

	private void saveFile(String saveFileName, MultipartFile file) {
		
		File saveFile = new File(FILE_PATH,saveFileName);
		
		try {
			
			file.transferTo(saveFile);
			
		} catch (IllegalStateException e) {
			
			e.printStackTrace();
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
		
	}
	
}
