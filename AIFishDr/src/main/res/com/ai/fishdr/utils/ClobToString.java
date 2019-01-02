package com.ai.fishdr.utils;

import java.io.BufferedReader;
import java.sql.Clob;
/**
 * @Class Name :ClobToString.java
 * @Description : clob를 String으로 변환 게시판 뷰에 활용
 * @Modification Information
 * @author 진형용
 * @since  2018. 11. 26.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 26.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
public class ClobToString {
	public static String convertClobToString(Clob target) throws Exception{
		StringBuffer buffer = new StringBuffer();
		BufferedReader reader = null;
		reader = new BufferedReader(target.getCharacterStream());
		String temp = "";
		while((temp = reader.readLine()) != null){
			buffer.append(temp + "\n");
		}
		
		reader.close();
		
		return buffer.toString();
	}
}
