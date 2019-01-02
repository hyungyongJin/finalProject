package com.ai.fishdr.utils;
/**
 * 
 * @Class Name :Generator.java
 * @Description :게시판 자동생성 인터페이스 
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
public interface Generator {

	/**
	 * 
	 *  개요 : 자바 컨트롤러 파일 생성
	 * @Method Name : javaFileMaker
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : void
	 * @throws :
	 */
	public void controllerMaker(String boardName) throws Exception;
	/**
	 * 
	 *  개요 : 자바 service,serviceImpl 생성
	 * @Method Name : serviceMaker
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : void
	 * @throws :
	 */
	public void serviceMaker(String boardName) throws Exception;
	/**
	 * 
	 *  개요 : 자바 dao,daoImpl 생성
	 * @Method Name : daoMaker
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : void
	 * @throws :
	 */
	public void daoMaker(String boardName) throws Exception;
	/**
	 * 
	 *  개요 : jsp파일 생성
	 * @Method Name : jspFileMaker
	 * @author : 진형용
	 * -----------------------------------
	 * @param boardCode 
	 * @param boardCode 
	 * @param : 
	 * @return : void
	 * @throws :
	 */
	public void jspFileMaker(String boardName,String boardKrName, String boardCode) throws Exception;
	/**
	 * 
	 *  개요 :xml파일생성 
	 * @Method Name : xmlFileMaker
	 * @author : 진형용
	 * -----------------------------------
	 * @param : 
	 * @return : void
	 * @throws :
	 */
	public void xmlFileMaker(String boardName, String boardCode) throws Exception;
}
