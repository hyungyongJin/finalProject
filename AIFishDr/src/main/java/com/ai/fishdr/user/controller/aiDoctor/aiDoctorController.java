package com.ai.fishdr.user.controller.aiDoctor;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ai.fishdr.admin.serivce.capacity.ICapacityService;
import com.ai.fishdr.admin.serivce.disease.IDiseaseService;
import com.ai.fishdr.admin.serivce.fish.IFishService;
import com.ai.fishdr.admin.serivce.hospital.IHospitalMgrService;
import com.ai.fishdr.admin.serivce.mdcin_diss.IMdcin_diss_Service;
import com.ai.fishdr.admin.serivce.symptms.ISymptmsService;
import com.ai.fishdr.admin.serivce.whthDrawal.IWithDrawalService;
import com.ai.fishdr.global.GlobalConstant;
import com.ai.fishdr.nouser.service.member.IMemberService;
import com.ai.fishdr.user.service.conversation.IConversationService;
import com.ai.fishdr.user.service.doctor.IDoctorService;
import com.ai.fishdr.user.service.facepicture.IFacePictureService;
import com.ai.fishdr.user.service.fish_symptms.IFish_symptmsService;
import com.ai.fishdr.user.service.mdcin.IMdcinService;
import com.ai.fishdr.user.service.mdcinPrscrptn.IMdcinPrscptnService;
import com.ai.fishdr.user.service.prescription.IPrescriptionService;
import com.ai.fishdr.vo.CapacityUsageVO;
import com.ai.fishdr.vo.ConversationVO;
import com.ai.fishdr.vo.DiseaseVO;
import com.ai.fishdr.vo.DoctorVO;
import com.ai.fishdr.vo.FishVO;
import com.ai.fishdr.vo.HospitalVO;
import com.ai.fishdr.vo.MdcinDissVO;
import com.ai.fishdr.vo.MedicineVO;
import com.ai.fishdr.vo.MemberVO;
import com.ai.fishdr.vo.PrescriptionVO;

@Controller
@RequestMapping("/user/aiDoctor/")
public class aiDoctorController {
	
	private static Map<String, String> map = new HashMap<String, String>();
	private static String prescription_name = "prescription";
	private static List<String> diss_code_List = new ArrayList<String>();
	
	@Autowired
	private IConversationService converService;
	
	@Autowired
	private IDoctorService service;
	
	@Autowired
	private IMdcinService mdcinService;
	
	@Autowired
	private ISymptmsService symptmsService;
	
	@Autowired
	private IFish_symptmsService fish_symptmsService;
	
	@Autowired
	private IHospitalMgrService hospitalService;
	
	@Autowired
	private IFacePictureService facePictureService;
	
	@Autowired
	private IMemberService memberService;
	
	@Autowired
	private IPrescriptionService prescriptionService;
	
	@Autowired
	private IWithDrawalService withService;
	
	@Autowired
	private IMdcinPrscptnService mdcinPrsService;
	
	@Autowired
	private IDiseaseService dissService;
	
	@Autowired
	private IMdcin_diss_Service mdcinDissService;
	
	@Autowired
	private ICapacityService capaService;
	
	@Autowired
	private IFishService fishService;
	
	
	@RequestMapping("aiDoctor")
	public ModelAndView aiDoctor(ModelAndView model, Map<String, String> params, HttpSession session) throws Exception {
		
		model.setViewName("user/aiDoctor/aiDoctor");
		return model;
	}
	
	@RequestMapping("sendText")
	public ModelAndView sendText(ModelAndView model
				,String sendText
				,String[] symptoms
				,String mem_id
				,String hospitalName
				,ConversationVO conversationInfo
				,DoctorVO doctorInfo
				,Map<String, String> params
				,Map<String, String> yourParams
				,HospitalVO hospitalInfo
				,HttpServletRequest request) throws Exception{
		String value = "";
		String dataInfo = "";
		if (sendText != null && sendText != "") {
			value = sendText.trim().substring(0, 3);
			dataInfo = sendText.substring(3).trim();
			
		}
		
		hospitalInfo = hospitalService.converHospitalInfo(hospitalName);
		
		if (hospitalInfo != null){
			
			conversationInfo = converService.conversationInfo("fish");
			model.addObject("aiText", conversationInfo.getCon_content());
			model.addObject("hospital", hospitalName);
			
			map.put("hospital_code", hospitalInfo.getHospital_code());
			map.put("hospital_name", hospitalInfo.getHospital_name());
			map.put("hospital_addr", hospitalInfo.getHospital_addr());
			map.put("hospital_phone", hospitalInfo.getHospital_phone());
			map.put("hospital_fax", hospitalInfo.getHospital_fax());
			map.put("hospital_mail", hospitalInfo.getHospital_mail());
			map.put("hospital_agp_code", hospitalInfo.getHospital_agp_code());
			map.put("hospital_license", hospitalInfo.getHospital_license());
			
		}else if (value.equals("어종:")) {
			map.put("fish_name", dataInfo);
			FishVO fishInfo = fishService.fishInfo(map);
			if (fishInfo == null) {
				model.addObject("aiText", "다른 어종을 입력해주세요.");
			}else {
				conversationInfo = converService.conversationInfo("weight");
				model.addObject("aiText", conversationInfo.getCon_content());
			}
			
			
			
		}else if (value.equals("중량:")) {
			
			conversationInfo = converService.conversationInfo("count");
			model.addObject("aiText", conversationInfo.getCon_content());
			
			map.put("weight", dataInfo);
			
		}else if (value.equals("미수:")) {
			
			conversationInfo = converService.conversationInfo("symptms");
			
			model.addObject("symptmsList", symptmsService.prsSymptmsList(map));
			model.addObject("aiText", conversationInfo.getCon_content());
			
			map.put("number", dataInfo);
			
		}else if (symptoms.length != 0) {
			doctorInfo.setFish_name(map.get("fish_name"));
			doctorInfo.setFish_weight(map.get("weight"));
			doctorInfo.setFish_number(map.get("number"));
			doctorInfo.setMem_id(mem_id);
			
			service.insertDoctor(doctorInfo);

			// 증상을 split으로 배열 형태로 변경하여 db에 저장
			
			map.put("mem_id", mem_id);
			MemberVO memberInfo = memberService.memberInfo(map);
			
			String treat_code_seq = service.getTreat_code();
			
			map.put("treat_code", "tr"+treat_code_seq);
			
			// 증상과 어종에 따른 증상 코드 
			
			List<DiseaseVO> dissInfo = new ArrayList<DiseaseVO>();
			for (int i = 0; i < symptoms.length; i++) {
				map.put("symptms_content", symptoms[i]);
				dissInfo = dissService.getDissCode(map);
				if (dissInfo.size() != 0) {
					for (int j = 0; j < dissInfo.size(); j++) {
						diss_code_List.add(dissInfo.get(j).getDiss_code());
					}
				}
				fish_symptmsService.fish_symptms_Insert(map);
			}
			
			// 질병 코드를 랜덤하게 하나를 출력한 후 의약품 정보 뽑아오는 로직
			int cnt = (int)(Math.random()*diss_code_List.size());
			String diss_code = diss_code_List.get(cnt);
			List<MdcinDissVO> mdcinDissInfo = mdcinDissService.getMdcinCode(diss_code);
			cnt = (int)(Math.random()*mdcinDissInfo.size());
			String mdcin_code = mdcinDissInfo.get(cnt).getMdcin_code();
			
			// 질병 코드를 가지고 질병 정보 뽑아오는 로직
			map.put("diss_code", diss_code);
			String diss_name = dissService.diseaseInfo(map).getDiss_name();
			model.addObject("diss_name",diss_name);
			// 의약품 코드와 어종명을 입력하여 휴약일수 추출하는 로직
			map.put("mdcin_code", mdcin_code);
			System.out.println(map.get("fish_name"));
			System.out.println(map.get("mdcin_code"));
			String withdrawal_period = withService.getWithInfo(map).getWithdrawal_period();
			
			// 처방전 insert 
			PrescriptionVO prescriptionInfo = new PrescriptionVO();
			
			prescriptionInfo.setHospital_code(map.get("hospital_code"));
			prescriptionInfo.setMem_id(mem_id);
			prescriptionInfo.setPrscrptn_name(prescription_name);
			
			prescriptionService.prscrptn_Insert(prescriptionInfo);
			
			// 방금 등록된 처방전 code 추출해오기
			String prscrptn_code =  prescriptionService.prscrptn_getCodeNumber();
			
			// mdcin_prscrptn insert 로직
			map.put("prscrptn_code", "pr"+prscrptn_code);
			mdcinPrsService.mdcinPrscrptnInsert(map);
			
			String last_mdcin_code = mdcinPrsService.getMdcinCode("pr"+prscrptn_code).getMdcin_code();
			
			// mdcinInfo -> 어종과 증상에 따른 의약품 1개 데이터
			MedicineVO mdcinInfo = mdcinService.getMdcinInfo(last_mdcin_code);
			
			// 용법 및 용량 데이터 출력해오기
			CapacityUsageVO capaInfo = capaService.prsCapacityInfo(map);
			
			
			
			model.addObject("aiText", "처방전 작성 중 입니다. 잠시만 기다려 주세요.....");
			model.addObject("fish_name",map.get("fish_name"));
			// 처방전 작성 로직 -> pdf 등 .... 
			
			if (map.keySet().size() >= 14) {
				
				try {
//				System.out.println(request.getSession().getServletContext().getResource("/images/prescription.pdf").getPath());
//				file = new File(request.getSession().getServletContext().getResource("/images/prescription.pdf").getPath());
					String path = request.getSession().getServletContext().getRealPath("/images/prescription.pdf");
					System.out.println(path);
					File file = new File(path);
					PDDocument doc = PDDocument.load(file);
					PDPage myPage = doc.getPage(0);
					
					InputStream fontStream = new FileInputStream(request.getSession().getServletContext().getRealPath("/font/MALGUN.TTF"));
					PDType0Font font = PDType0Font.load(doc, fontStream);
					
					PDPageContentStream cont = new PDPageContentStream(doc, myPage ,true, true);
					
					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);
					
					// 교부 년/월/일
					Date today = new Date();
					
					SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
					
					String[] dateInfo = date.format(today).split("/");
					String year = dateInfo[0];
					String month = dateInfo[1];
					String day = dateInfo[2];
					
					// 교부 년
					cont.newLineAtOffset(136, 686);
					cont.showText(year);
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 교부 월
					cont.newLineAtOffset(193, 686);
					cont.showText(month);
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 교부 일
					cont.newLineAtOffset(240, 686);
					cont.showText(day);
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);
					
					// 회원 이름
					cont.newLineAtOffset(165, 646);
					cont.showText(memberInfo.getMem_name());
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 회원 휴대폰
					cont.newLineAtOffset(165, 598);
					cont.showText(memberInfo.getMem_phone());
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 회원 이메일
					cont.newLineAtOffset(165, 577);
					cont.showText(memberInfo.getMem_mail());
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);
					
					// 품종
					cont.newLineAtOffset(165, 557);
					cont.showText(map.get("fish_name"));
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);
					
					// 병명
					cont.newLineAtOffset(165, 541);
					cont.showText(diss_name);
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);
					
					// 중량
					cont.newLineAtOffset(165, 525);
					cont.showText(map.get("weight"));
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);
					
					// 미수
					cont.newLineAtOffset(165, 509);
					cont.showText(map.get("number"));
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);
					
					// 특징
					cont.newLineAtOffset(165, 494);
					cont.showText(symptoms[0]);
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 관리원 명칭
					cont.newLineAtOffset(417, 645);
					cont.showText(map.get("hospital_name"));
					cont.newLine();

					// 관리원 주소
					cont.showText(map.get("hospital_addr"));
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 관리원 전화/휴대폰
					cont.newLineAtOffset(417, 610);
					cont.showText(map.get("hospital_phone"));
					cont.newLine();
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 관리원 팩스
					cont.newLineAtOffset(417, 590);
					cont.showText(map.get("hospital_fax"));
					cont.newLine();
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 관리원 e-mail
					cont.newLineAtOffset(417, 575);
					cont.showText(map.get("hospital_mail"));
					cont.newLine();
					cont.endText();

					cont.beginText();
					cont.setFont(font, 14);
					cont.setLeading(18.5f);

					// 어의사 사인
					cont.newLineAtOffset(395, 534);
					cont.showText(map.get("hospital_agp_code"));
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 어의사 면허번호
					cont.newLineAtOffset(464, 494);
					cont.showText(map.get("hospital_license"));
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 성분명
					cont.newLineAtOffset(70, 423);
					cont.showText(mdcinInfo.getMdcin_prduct_name());
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 수량
					cont.newLineAtOffset(230, 423);
					cont.showText("");
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 용법 및 용량
					cont.newLineAtOffset(300, 423);
					cont.showText(capaInfo.getUscp_content());
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 유효기간
					cont.newLineAtOffset(370, 423);
					cont.showText("");
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 휴약기간
					cont.newLineAtOffset(440, 423);
					cont.showText(withdrawal_period);
					cont.endText();

					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);

					// 사용기간
					cont.newLineAtOffset(268, 132);
					cont.showText("7");
					cont.endText();
					
					cont.beginText();
					cont.setFont(font, 8);
					cont.setLeading(14.5f);
					
					// 교부번호
					cont.newLineAtOffset(402, 686);
					cont.showText(prscrptn_code);
					cont.endText();

					
					cont.close();
					
					// 처방전 code를 이용해서 pdf 저장명 불러오기 
					String prscrptn_name = prescriptionService.prscrptnInfo("pr"+prscrptn_code).getPrscrptn_name();
					String contentType = prescriptionService.prscrptnInfo("pr"+prscrptn_code).getPrscrptn_content_type();
					doc.save(GlobalConstant.SAVA_PATH + prscrptn_name+contentType);
					doc.close();
					
					model.addObject("pdfName", prscrptn_name+contentType);
					
					
				} catch (MalformedURLException e) {
					e.printStackTrace();
				} catch (InvalidPasswordException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} else {
			model.addObject("aiText","예시에 맞게 작성해주세요.");
		}
		
		String fp_mem_id = null;
		String profile_status = null;
		String mem_nickname = null;
		
		fp_mem_id = mem_id;
				
		yourParams.put("fp_mem_id", fp_mem_id);
		yourParams.put("mem_id", fp_mem_id);
		
		MemberVO mv = memberService.getSelectIdInfo(yourParams);
		
		profile_status = mv.getProfile_status();
		yourParams.put("profile_status", profile_status);
		
		mem_nickname = mv.getMem_nickname();
		yourParams.put("mem_nickname", mem_nickname);
		
		String yourfp_file_save_name = null;
		
		if(profile_status.equals("y")) {
			yourfp_file_save_name = facePictureService.facePictureInfo(yourParams).getFp_file_save_name();
		}
		
		yourParams.put("yourfp_file_save_name", yourfp_file_save_name);
				
		model.addObject("message", sendText);
		model.setViewName("jsonConvertView");
		
		return model;
	}
	
	@RequestMapping("pdfDownload")
	public ModelAndView pdfDownload(ModelAndView model
				,String pdfName) throws Exception{
		File targetFile = new File(GlobalConstant.SAVA_PATH, pdfName);
		
		model.addObject("downloadFile", targetFile);
		model.addObject("originalName", pdfName);
		model.setViewName("downloadView");
		return model;
	}
}
