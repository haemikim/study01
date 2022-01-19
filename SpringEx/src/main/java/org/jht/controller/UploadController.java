package org.jht.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;


import org.jht.domain.AttachFileDTO;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import net.coobird.thumbnailator.Thumbnailator;

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
	public void uploadAction(MultipartFile[] uploadFile) {// 한개의 클래스에 여러가지를 저장할려면 배열을 사용해야하쥬 (객체[] 객체명)
		
		// 파일업로드 종료지점
		String uplaodFolder="D:\\study\\upload";
		    // 매개변수(파일 업로드) 변수명      :  배열 이름
		for(MultipartFile multipartFile : uploadFile){ 
			// 사용자가 업로드 한 실제 파일의 이름
			System.out.println("업로드 파일이름 ="+multipartFile.getOriginalFilename()); // 변수명.파일이름들고오는 메서드
			// 사용자가 업로드 한 실제 파일 크기
			System.out.println("업로드 파일 크기 ="+multipartFile.getSize());
			// 사용자가 업로드 한 실제 파일의 형식
			System.out.println("업로드 파일 형식 ="+multipartFile.getContentType());			
			//                   uploadFolder에 저장되어있는 경로. 실제 파일명으로 저장 
			File saveFile=new File(uplaodFolder,multipartFile.getOriginalFilename()); //saveFile에 uploadFolder주소에있는 업로드 되는 파일의이름을 저장한다
			
			try {// saveFile변수에 저장되어 있는 폴더명으로 파일을 보내라
				multipartFile.transferTo(saveFile); // transferTo사용시 반드시 예외를 작성해야한다
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace(); // 에러 메세지의 발생 근원지를 찾아서 단계별로 에러를 출력한다.

			}// end try
			
		} // for문 end
	}
	// 년/월/일 폴더의 생성하기 위한 폴더 이름 추출하여 리턴
	private String getFolder() {
		// 현재날짜를 추출 (요일 달 시간 KST 년도)
		Date date = new Date(); // import는 java.util선택
		// 요일 달 시간 KST 년도 -> 2022-01-18형식으로 변경
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //소문자 m으로 하면안됨
		// 2022-01-18 
		String str=sdf.format(date);
		System.out.println("date="+date);
		System.out.println(str.replace("-", File.separator));
		// 2022-01-18 -> 2022\01\18
		return str.replace("-", File.separator); // replace(앞,뒤)는 앞에있는 형식으로 뒤에껄 변경시크는 것 
	}
	// 썸네일 이미지 생성을 할 것인지(true) 안할것인지(false) 판단하는 메서드 (사용자가 업로드 한 파일이 이미지이면 생성, 그렇지 않으면 생성안함)
	private boolean checkImage(File file) {
		try {
			// 파일의 타입을 알아내는 prodeContentType메서드 호출하여 사용
			String contentType=Files.probeContentType(file.toPath());
			// 그 파일의 타ㄴ입이 image이면 true, 그렇지 않으면 false
			return contentType.startsWith("image");
		}catch(IOException e) { //IOException - 파일이 없을 때 발생할 에러. 호출함수인 xml의 DispatcherServlet class로 예외처리 전가
			
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	// uploadAjax.jsp에서 ajax를 이용해서 파일 업로드 controller
	@PostMapping(value="uploadAjaxAction", produces= {MediaType.APPLICATION_JSON_UTF8_VALUE})
	public ResponseEntity<ArrayList<AttachFileDTO>> uploadAjaxAction(MultipartFile[] uploadFile) { // ResponseEntity의 정확한 쓸모 이건 비동기식이 아닌데>>?>? 
		// AttachFileDTO에 저장되는 값이 여러파일에 대한 값이면 배열로 처리가 되어야 하므로 ArrayList타입이 되어야함
		ArrayList<AttachFileDTO> list = new ArrayList<>();
		// 파일업로드 종료지점
		String uploadFolder="D:\\study\\upload";
		
		// 폴더생성					(기존폴더,		현재폴더)를 결합
		File uploadPath = new File(uploadFolder,getFolder());
		System.out.println("uploadPath="+uploadPath);
		
		// 설명 있어야함>>?????
		String uploadFolderPath=getFolder();
		
		// 현재만들려고 하는 폴더가 없으면
		if(uploadPath.exists()==false) {
			// 폴더생성
			uploadPath.mkdirs(); // exists(), mkdirs() 인스턴스 매서드
		}
		
		
		for(MultipartFile multipartFile : uploadFile){
			
			// UpLoadController에 있는 uploadAjaxAction에서 AttachFileDTO를 사용해서 값을 저장해야 되는데
			// 이럴경우 UploadController에 AttachFileDTO가 없으면 사용할수 없습니다
			// 그래서uploadcontroller에  AttachFileDTO 포함시켜서 사용하여 값을 저장
			AttachFileDTO attachdto = new AttachFileDTO();
			
			
			// 사용자가 업로드 한 실제 파일의 이름
			System.out.println("업로드 파일이름 ="+multipartFile.getOriginalFilename());
			// 사용자가 업로드 한 실제 파일 크기
			System.out.println("업로드 파일 크기 ="+multipartFile.getSize());
			// 사용자가 업로드 한 실제 파일의 형식
			System.out.println("업로드 파일 형식 ="+multipartFile.getContentType());	// sysout하고 cnt+space누르면 자동완성 ㅅㅂ 이제알았다,,		
//			// uploadFolder에 저장되어있는 경로. 실제 파일명으로 저장 
//			File saveFile=new File(uploadPath,multipartFile.getOriginalFilename());
			String uploadFileName = multipartFile.getOriginalFilename();
			// 실제 파일명(uploadFileName)을 AttachFileDTO클래스(attrachdto)에 fileName에 저장(setFileName)
			attachdto.setFileName(uploadFileName); 
			
			// 중복이 되지않는 임의의 문자열을 생성
			UUID uuid = UUID.randomUUID(); // 클래스 매서드
			// UUID + "_" + getOriginalFilename()의 조합으로 파일명 생성
			uploadFileName=uuid.toString()+"_"+uploadFileName;
			
			File saveFile = new File(uploadPath,uploadFileName);
			
			try {
				// saveFile변수에 저장되어 있는 폴더명으로 파일을 보내라
				multipartFile.transferTo(saveFile); // 사용시 반드시 예외처리를 해야한다
				// 실제 업로드경로(uploadPath)을 AttachFileDTO클래스(attachdto)에 uploadPath에 저장(setuploadPath)
				attachdto.setUploadPath(uploadFolderPath);
				// uuid값(UUID)을 AttachFileDTO클래스(attachdto)에 uploadPath에 저장(setuploadPath)
				attachdto.setUuid(uuid.toString()); // uuid타입이 string으로 되어있어 같은 타입으로 통일시켜줌
				
				
				//이미지파일이면
				if(checkImage(saveFile)) {
					// FileType값(image)을 AttachFileDTO클래스(attachdto)에 uploadPath에 저장(setImage)
					attachdto.setImage(true);
					// 썸네일 파일을 생성하기 전에 썸네일 파일이름 추출
					FileOutputStream thumbnail = new FileOutputStream(new File(uploadPath,"s_"+uploadFileName)); // FileOutputStram 밖으로 뺸다
					// 썸네일 파일을 생성함
					Thumbnailator.createThumbnail(multipartFile.getInputStream(),thumbnail, 100,100);
					// 썸네일 종료(메모리 공간 함수)
					thumbnail.close();
				}
				
				list.add(attachdto); // add를 해서 각각[0]부터 저장이 된다
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}// end try
			
		} // for문 end 
		// 통신상태가 정상적이면(HttpStatus.OK)하면 ArrayList(list)에 저장되어있는 값을 uploadAjax.js에 있는 ajax에 success로 보내라
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	// 파일 업로듷나 파일 타입이 이미지일때 웹브라우저에 이미지를 띄우기 위해서
	@GetMapping("display")
	public ResponseEntity<byte[]> getfile(String fileName) { // getFile()은 문자열로 파일의 경로가 포함된 fileName을 매개변수 받고 이전수(byte[](이진수)를 전송) 
		System.out.println("url주소를 통한 fileName="+fileName);
		
		File file = new File("D:\\study\\upload\\"+fileName);
		
		System.out.println("file="+file);
		
		ResponseEntity<byte[]> result = null;
		// byte[]로 이미지 파일의 데이터를 전송할때 브라우저에 보내는MIME타입이 파일의 종류(JPG, PNG, XLS, PPT)에 따라 달라집나다
		// 이 부분을 패걀하기 위해서  prodeContentType()을 이용하여 적절한mime 타입 데이터를Http의 헤더 메세지에 포함할수 있도록 처리
		try {
			HttpHeaders header = new HttpHeaders();
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file),header,HttpStatus.OK);
		}catch(IOException e){
			e.printStackTrace();
			
		}
		return result;
	}
	// 파일 업로드나 파일 타입이 이미지가 아닐때(.xls, .ppt, .txt) 웹브라우저를 통해서 download할수 있도록
	// 댓글쓰기를 하기 위한 reqeustMapping
	// mapping을 할때 우리가 원하는 데이터 다입을 강제함으로써 오류상황을 줄일수있다
	// comsumes : 들어오는 데이터 타입 정의(생략가능)
	// produces : 뱐환하는 데이터 타입의 정의(셍략가능)
	// * 생략을 하게되면, 웹브라우저가 알아서 타입을 판단 *
	// 웹브라우저가 이파일을 download해야하는 파일입니다 라는 것을 인지할 수있도록 반환이 되야함
	// 그러기 우히애서는 AAPPLICATION_OCTET_STREAM_VALUE 타입으로 반환데이터 타입을 선언합니다
	@GetMapping(value="download",  produces=MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public ResponseEntity<Resource> downloadFile(String fileName) {
		System.out.println("download fileName="+fileName);
		
		Resource resource = new FileSystemResource("D:\\study\\upload\\"+fileName);
		
		System.out.println("download resource="+resource);
		
		String resourceName = resource.getFilename();
		
		HttpHeaders header = new HttpHeaders();
		
		try {
			header.add("Content-Dispostion","attachment: filename"+ new String(resourceName.getBytes("UTF-8"),"iso-8859-1")); 
		}catch(Exception e){
			e.printStackTrace();
		}
		return new ResponseEntity<Resource>(resource,header,HttpStatus.OK);
	}
}
	
