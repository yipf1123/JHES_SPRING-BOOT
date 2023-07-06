package com.study.springboot;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class MyController {



	@RequestMapping("/uploadForm")
	public String uploadForm(Model model) {
		String path = "c:/file";
		List list = getFiles(path);
		model.addAttribute("list", list);
		
//		List list1 = new ArrayList();
//		List list2 = new ArrayList();
//		
//		list1.add(1);
//		list1.add(2);
//		list1.add(3);
//		
//		list2.add(4);
//		list2.add(5);
//		list2.add(6);
//		
//		list1.addAll(list2);
//		for (int i = 0; i < list1.size(); i++) {
//			System.out.println(list1.get(i));
//		}
		
		return "fileForm";
	}

	// 파일 목록을 가져오기
	List getFiles(String path) {

		File file = new File(path);

		// TODO
		// 실제 파일이나 디렉토리(폴더)가 있는지 검사 필요

		// 파일이나 디렉토리 목록들
		String[] files = file.list(); // 이름만 가져오기

		File[] listFiles = file.listFiles(); // File 객체로 가져오기

		List list = new ArrayList();
		
		for (int i = 0; i < listFiles.length; i++) {
			File tmpFile = listFiles[i];
			// 폴더라면
			if (tmpFile.isDirectory()) {
				System.out.println("폴더이고 이름은 : " + tmpFile.getName());
				System.out.println("폴더이고 경로는: " + tmpFile.getPath());
				// 재귀호출; 내가 나를 다시 부르기
				List subList = getFiles(tmpFile.getPath());
				list.addAll(subList);
				System.out.println("-------오늘 폴더 완료");
			} else {
				System.out.println("파일이고");
				System.out.println("이름: " + tmpFile.getName());
				System.out.println("크기: " + tmpFile.length());
				System.out.println("경로: " + tmpFile.getPath());
				Map map = new HashMap();
				map.put("name",tmpFile.getName());
				map.put("size",tmpFile.length()/1024);
				map.put("path",tmpFile.getPath());
				list.add(map);
			}
		}
		return list;
	}

	@RequestMapping("/uploadOk")
	@ResponseBody
	public String uploadOk(@RequestParam("filename") MultipartFile multipartFile) {

		try {
			// 방어
			// filename이 비어있는지 확인
			if (multipartFile.isEmpty()) {
				return "need file";
			}

			// 절대 주소 : 내 컴퓨터에 내가 지정한 폴더 : 다른 pc에서는 다른 경로일 수 있다
			String path = "c:/file/upload";

			File dir = new File(path);
			if (dir.exists()) {// 존재하느냐?
				System.out.println(path + ": 디렉토리가 존재합니다.");
			} else {
				boolean isMake = dir.mkdir();
				if (isMake) {
					System.out.println(path + ": 디렉토리를 생성했습니다.");
				} else {
					System.out.println(path + ": 디렉토리를 생성에 실패했습니다.");
				}
			}

			// 상대적인 주소 classpath를 이용하는 방법
//	        String path = ResourceUtils.getFile("classpath:static/upload/").toPath().toString();
//	        System.out.println("상대주소 path" + path);

			String fileName = multipartFile.getOriginalFilename();
			long now = System.currentTimeMillis();
			fileName = now + "_" + fileName;
			System.out.println("filename :" + fileName);

			// file 객체 만들기
			File file = new File(path + File.separator + fileName);

			// 그 file 객체에 쓰기
			FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());

		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}

		return "success";
	}

	@RequestMapping("/download")
	@ResponseBody
	public String download(
			HttpServletResponse response,
			@RequestParam("path") String path,
			@RequestParam("fileName") String fileName
			) {
//		String repo = "c:/file/upload/";
	System.out.println(path);
		
		try {
			File file = new File(path);

			// 읽는거니까 input stream을 열어서
			// 실제 파일을 메모리에 로딩
			FileInputStream is = new FileInputStream(file);

	        // 브라우저가 전달받은 내용을 파일로 인식하게 만듦
	        response.setHeader("Content-disposition", "attachment; fileName="+fileName);
			
	         // 브라우저가 cache를 사용하지 않도록; 매번 다운로드 되도록
	         response.addHeader("Cache-Control", "no-cache");
	         
	         //파일을 내보낼 수 있는 흐름을 열어서 준비
	         OutputStream out = response.getOutputStream();
			 
	         byte[] buffer = new byte[4* 1024];   // 4KB
	         
//	         while(is.read(buffer) != 1) {
				while(true) {
					// inputStream에서 buffer만큼 읽어서
					int count = is.read(buffer);
					System.out.println("읽은 크기 : count : "+ count);
					
					// 읽은 내용이 없으면 -1
					if(count == -1) {
						break;
					}
					
					// 응답 흐름에 읽은 만큼 내보내기
					out.write(buffer, 0, count);
				}	         
	         
	         is.close();
			 out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "success";
	}

}
