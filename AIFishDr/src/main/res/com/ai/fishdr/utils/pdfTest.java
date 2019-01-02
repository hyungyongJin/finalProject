package com.ai.fishdr.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType0Font;

import com.ai.fishdr.global.GlobalConstant;
import com.ai.fishdr.vo.HospitalVO;

public class pdfTest {
	
	public pdfTest(HospitalVO hospitalInfo, HttpServletRequest request, HttpServletResponse response) {
		try {
//			System.out.println(request.getSession().getServletContext().getResource("/images/prescription.pdf").getPath());
//			file = new File(request.getSession().getServletContext().getResource("/images/prescription.pdf").getPath());
			String path = request.getSession().getServletContext().getRealPath("/images/prescription.pdf");
			System.out.println(path);
			File file = new File(path);
			PDDocument doc = PDDocument.load(file);
			PDPage myPage = doc.getPage(0);
			
			//Error 시작
			InputStream fontStream = new FileInputStream(request.getSession().getServletContext().getRealPath("/font/MALGUN.TTF"));
			PDType0Font font = PDType0Font.load(doc, fontStream);
			
			PDPageContentStream cont = new PDPageContentStream(doc, myPage ,true, true);
			
			cont.beginText();
            cont.setFont(font, 10);
            cont.setLeading(14.5f);
            
            String hospital_name = hospitalInfo.getHospital_name();
			cont.newLineAtOffset(70, 500);
			cont.showText(hospital_name);
			cont.endText();
			
			cont.close();
			
			
			
			doc.save(GlobalConstant.SAVA_PATH + "imbumhakthregi.pdf");
			doc.close();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (InvalidPasswordException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
