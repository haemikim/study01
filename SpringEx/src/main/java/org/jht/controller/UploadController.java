package org.jht.controller;

import java.io.File;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@GetMapping("upload")
	public void uploadform() {
		System.out.println("파일 업로드 화면,,");
		
	}
	@GetMapping("uploadAjax")
	public void updloadAjaxForm() {
		System.out.println("파일 업로드 화면,,");
	}
	// upload.jsp에서 form태그를 이용해서 파일 업로드
	@PostMapping("uploadAction")
	public void uploadAction(MultipartFile[] uploadFile) {
		
		// 파일업로드 종료지점
		String uplaodFolder="D:\\study\\upload";
		
		for(MultipartFile multipartFile : uploadFile){
			// 사용자가 업로드 한 실제 파일의 이름
			System.out.println("업로드 파일이름 ="+multipartFile.getOriginalFilename());
			// 사용자가 업로드 한 실제 파일 크기
			System.out.println("업로드 파일 크기 ="+multipartFile.getSize());
			// 사용자가 업로드 한 실제 파일의 형식
			System.out.println("업로드 파일 형식 ="+multipartFile.getContentType());			
			//                   uploadFolder에 저장되어있는 경로. 실제 파일명으로 저장 
			File saveFile=new File(uplaodFolder,multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile); // 사용시 반드시 예외처리를 해야한다
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// end try
			
		} // for문 end
	}
	// uploadAjax.jsp에서 ajax를 이용해서 파일 업로드 controller
	@PostMapping("uploadAjaxAction")
	public void uploadAjaxAction(MultipartFile[] uploadFile) {
		
		// 파일업로드 종료지점
		String uplaodFolder="D:\\study\\upload";
		
		for(MultipartFile multipartFile : uploadFile){
			// 사용자가 업로드 한 실제 파일의 이름
			System.out.println("업로드 파일이름 ="+multipartFile.getOriginalFilename());
			// 사용자가 업로드 한 실제 파일 크기
			System.out.println("업로드 파일 크기 ="+multipartFile.getSize());
			// 사용자가 업로드 한 실제 파일의 형식
			System.out.println("업로드 파일 형식 ="+multipartFile.getContentType());			
			//                   uploadFolder에 저장되어있는 경로. 실제 파일명으로 저장 
			File saveFile=new File(uplaodFolder,multipartFile.getOriginalFilename());
			
			try {
				multipartFile.transferTo(saveFile); // 사용시 반드시 예외처리를 해야한다
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// end try
			
		} // for문 end
		
	}
}
	
