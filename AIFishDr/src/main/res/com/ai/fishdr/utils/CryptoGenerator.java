package com.ai.fishdr.utils;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

/**
 * 
 * @Class Name :CryptoGenerator.java
 * @Description : 로그인 암복호화
 * @Modification Information
 * @author 
 * @since  2018. 11. 12.
 * @version 1.0
 * @see
 * <pre>
 * << 개정이력(Modification Information) >>
 *    수정일             수정자             수정내용
 *    -------        -------     -------------------
 *    2018. 11. 12.     진형용             최초작성
 *    ------------------------------------------------
 * Copyright (c) 2018 AI Fish Dr.  All right reserved
 * </pre>
 */
@Component
public class CryptoGenerator {
	// 공개키(클라이언트에 제공 암호화 키), 비밀키(서버에 존재하는 복호화 키)
	//  쌍으로 작성하고, 1회 사용 후 폐기 후 재작성 활용
	public static Map<String, String> getGeneratePairKey(HttpSession session){
		// 공개키, 비밀키 작성
		KeyPairGenerator generator = null;
		// 공개키, 비밀키 저장
		KeyPair keyPair = null;
		// 공개키 : 가수부, 지수부 분리
		KeyFactory keyFactory = null;
		// 공개키
		PublicKey publicKey = null;
		// 비밀키
		PrivateKey privateKey = null;
		// KeyFactory를 활용한 공개키의 가수부 지수부가 저장되고,
		// 클라이언트에 제공
		Map<String, String> publicKeyMap = new HashMap<String, String>();
		
		try {
			generator = KeyPairGenerator.getInstance("RSA");
			// default : 1kb
			generator.initialize(2048);
			// 공개키, 비밀키를 취득
			keyPair = generator.generateKeyPair();
			// 공개키 취득
			publicKey = keyPair.getPublic();
			// 비밀키 취득
			privateKey = keyPair.getPrivate();
			session.setAttribute("privateKey", privateKey);
			
			// -345.1234
			// 지수(exponent) : 소수점 자릿수 표현
			// 가수(modulus) : 해당 값의 비트 표현
			// 단정도(32bit) - float  : 부호[1bit](양수:0,음수:1) + 지수(8bit)  + 가수(23bit)
			// 배정도(64bit) - double : 부호[1bit](양수:0,음수:1) + 지수(11bit) + 가수(52bit)
			keyFactory = KeyFactory.getInstance("RSA");
			
			RSAPublicKeySpec publicKeySpec = 
					(RSAPublicKeySpec)keyFactory.getKeySpec(publicKey, RSAPublicKeySpec.class);
			// 가수
			String publicModulus = publicKeySpec.getModulus().toString(16);
			// 지수
			String publicExponent = publicKeySpec.getPublicExponent().toString(16);
			
			publicKeyMap.put("publicModulus", publicModulus);
			publicKeyMap.put("publicExponent", publicExponent);
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
		}
		
		return publicKeyMap;
	}
	
	public static String decryptRSA(HttpSession session, String secureValue){
		PrivateKey privateKey = (PrivateKey) session.getAttribute("privateKey");
		String returnValue = "";
		try {
			Cipher cipher = Cipher.getInstance("RSA");
			// 암호문(16진수) -> byte
			byte[] targetByte = hexToByteArray(secureValue);
			// Cipher 복호화용도의 비밀키 설정
			cipher.init(Cipher.DECRYPT_MODE, privateKey);
			// 암호문(16진수) -> byte -> 문자열 변환이 가능한 byte[] 반환
			byte[] beforeStringByte = cipher.doFinal(targetByte);
			// 문자열 변환 가능 byte값을 문자열로 변환
			returnValue = new String(beforeStringByte, "UTF-8");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return returnValue;
	}

	private static byte[] hexToByteArray(String secureValue) {
		if(secureValue == null || secureValue.length() %2 != 0){
			return new byte[]{};
		}
		// 암호문(짝수 16진수값) -> byte 변환
		byte[] bytes = new byte[secureValue.length()/2];
		
		for(int i=0; i<secureValue.length(); i+=2){
			byte value = (byte)Integer.parseInt(secureValue.substring(i, i+2), 16);
			// ceil(1.2), floor(1.2)
			bytes[(int)Math.floor(i/2)] = value;
		}
		return bytes;
	}
}














