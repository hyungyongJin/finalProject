package com.ai.fishdr.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ai.fishdr.vo.FacePictureVO;
import com.ai.fishdr.vo.FishgramFileVO;

@Component
public class AttachFileMapperFacePicture {
	
	private final static String FILE_PATH = "D:\\temp\\images\\";
	
	public FacePictureVO mappingFacePicture(MultipartFile file) {
		
		FacePictureVO fpv = null;
		
		if (file != null) {
									
			fpv = new FacePictureVO();
			
			String fileName = file.getOriginalFilename();
							
			String baseName = FilenameUtils.getBaseName(fileName);   //베이스이름
			String extension = FilenameUtils.getExtension(fileName); //확장자
			String genID = UUID.randomUUID().toString().replace("-", "");
			
			String saveFileName = baseName + genID + "." + extension;
							
			fpv.setFp_file_save_name(saveFileName);
			
			saveFile(saveFileName,file);
			
		}
		
		return fpv;
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
