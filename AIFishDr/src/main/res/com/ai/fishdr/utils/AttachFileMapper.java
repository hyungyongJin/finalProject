package com.ai.fishdr.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.ai.fishdr.vo.BoardFileVO;

@Component
public class AttachFileMapper {
	public final static String FILE_PATH = "D:\\temp\\images\\";
	
	public List<BoardFileVO> mapping(MultipartFile[] files, String bo_no){
		List<BoardFileVO> fileItemList = new ArrayList<BoardFileVO>();
		if (files!=null) {
			BoardFileVO fileItemInfo = null;
			for (MultipartFile file : files) {
				if (file.getSize()>0) {
					fileItemInfo = new BoardFileVO();
					fileItemInfo.setBo_no(bo_no);
					
					//getName() : [찾아보기]클릭 선택한 파일의 패스/파일명.확장자
					//			  [찾아보기]클릭 선택한 파일의 파일명.확장자
					//file.getOriginalFilename() :  [찾아보기]클릭 선택한 파일의 파일명.확장자
					//file.getOriginalFilename();
					String fileName = FilenameUtils.getName(file.getOriginalFilename());
					fileItemInfo.setFile_name(fileName);
					String baseName = FilenameUtils.getBaseName(fileName);   //베이스이름
					String extension = FilenameUtils.getExtension(fileName); //확장자
					String genID = UUID.randomUUID().toString().replace("-","");
					
					String saveFileName = baseName+genID+"."+extension;
					
					fileItemInfo.setFile_save_name(saveFileName);
					fileItemInfo.setFile_content_type(file.getContentType());
					fileItemInfo.setFile_size(String.valueOf(file.getSize()));
					fileItemList.add(fileItemInfo);
					saveFile(saveFileName,file);
					
				}
			}
		}
		return fileItemList;
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
