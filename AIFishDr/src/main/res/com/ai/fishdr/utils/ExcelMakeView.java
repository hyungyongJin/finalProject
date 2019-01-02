package com.ai.fishdr.utils;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;

import com.ai.fishdr.vo.MemberVO;

@Component("downloadExcel")
public class ExcelMakeView extends AbstractView {
	private static final String CONTENT_TYPE = "application/vnd.ms-excel"; // Content
																			// Type
																			// 설정

	public ExcelMakeView() {
		setContentType(CONTENT_TYPE);
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			Calendar c1 = Calendar.getInstance();
			String yyyymmdd = sdf.format(c1.getTime());
			String fileName = yyyymmdd + "_회원명단.xlsx";
			fileName = URLEncoder.encode(fileName, "UTF-8"); 

			response.setHeader("Content-Disposition", "attachment; filename=\""
					+ fileName + "\"");

			XSSFWorkbook workbook1 = new XSSFWorkbook();
			XSSFSheet sheet = workbook1.createSheet();

			List<MemberVO> listExcel = (List<MemberVO>) model.get("list");

			// Cell 스타일 값
			sheet.setDefaultColumnWidth(30);
			CellStyle style = workbook1.createCellStyle();
			Font font = workbook1.createFont();
			font.setFontName("Arial");
			style.setFillForegroundColor(HSSFColor.BLUE.index);
			style.setFillPattern(CellStyle.SOLID_FOREGROUND);
			font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
			font.setColor(HSSFColor.WHITE.index);
			style.setFont(font);

			// header 생성
			XSSFRow header = sheet.createRow(0);
			setHeaderCellValue(header); // 헤더 칼럼명 설정
			setHeaderStyle(header, style); // 헤더 스타일 설정

			// 행 데이터 생성
			int rowCount = 1;
			if (listExcel != null) {
				for (MemberVO mem : listExcel) {
					XSSFRow aRow = sheet.createRow(rowCount++);
					setEachRow(aRow, mem);
				}
			}
			ServletOutputStream out = response.getOutputStream();
			workbook1.write(out);
			if (out != null)
				out.close();

		} catch (Exception e) {
			throw e;
		}
	}

	private void setHeaderCellValue(XSSFRow header) {
		header.createCell(0).setCellValue("회원ID");
		header.createCell(1).setCellValue("회원명");
		header.createCell(2).setCellValue("닉네임");
		header.createCell(3).setCellValue("핸드폰");
		header.createCell(4).setCellValue("메일주소");
		header.createCell(5).setCellValue("가입일");
	}

	private void setHeaderStyle(XSSFRow header, CellStyle style) {
		header.getCell(0).setCellStyle(style);
		header.getCell(1).setCellStyle(style);
		header.getCell(2).setCellStyle(style);
		header.getCell(3).setCellStyle(style);
		header.getCell(4).setCellStyle(style);
		header.getCell(5).setCellStyle(style);
	}

	private void setEachRow(XSSFRow aRow, MemberVO mem) {
		aRow.createCell(0).setCellValue(mem.getMem_id());
		aRow.createCell(1).setCellValue(mem.getMem_name());
		aRow.createCell(2).setCellValue(mem.getMem_nickname());
		aRow.createCell(3).setCellValue(mem.getMem_phone());
		aRow.createCell(4).setCellValue(mem.getMem_mail());
		aRow.createCell(5).setCellValue(mem.getMem_reg_date());
	}


}
