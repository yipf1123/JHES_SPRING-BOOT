package com.study.springboot;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatBotController {

	@RequestMapping("/chat_test")
	@ResponseBody
	public JSONObject chatTest(
			@RequestBody	// post 방식을 저장
			Map map
	) {
		System.out.println(map);
//		System.out.println( map.get("action") );
		
		Map map_action = (Map) map.get("action");
	
		Map map_detailParams = (Map) map_action.get("detailParams");
		Map map_meat = (Map) map_detailParams.get("meat");
		String meat = (String) map_meat.get("origin");

//		String meat = (String) ((Map) ( (Map)map_action.get("detailParams") ).get("meat")).get("origin");
		System.out.println("meat : "+ meat);
		
		Map map_sys_number = (Map) map_detailParams.get("sys_number");
		String sys_number = (String) map_sys_number.get("origin");
		System.out.println("sys_number : "+ sys_number);
		
		
		
		JSONObject received = new JSONObject(map);
		
		
		
		
//		String result = "{"
//				+ "    \"version\": \"2.0\","
//				+ "    \"template\": {"
//				+ "        \"outputs\": ["
//				+ "            {"
//				+ "                \"simpleText\": {"
//				+ "                    \"text\": \""+"meat : "+ meat+""+ "sys_number : "+ sys_number +"\""
//				+ "                }"
//				+ "            }"
//				+ "        ]"
//				+ "    }"
//				+ "}";
		
		
		
		
		JSONObject send = new JSONObject();
		send.put("version", "2.0");
		
		JSONObject simpleText = new JSONObject();
		String text = "meat : "+ meat +", 양 : "+ sys_number;
		simpleText.put("text", text);
		
		JSONObject outputs1 = new JSONObject();
		outputs1.put("simpleText", simpleText);
		
		JSONArray arr = new JSONArray();
		arr.add(outputs1);
		
		JSONObject template = new JSONObject();
		template.put("outputs", arr);
		
		send.put("template", template);
		return send;
	}
	
	
	@RequestMapping("/gpt")
	@ResponseBody
	public String gpt() {
		
		final String KEY = "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";
		
			try {
				URL url = new URL("https://api.openai.com/v1/completions");
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				// 접속 후 받은 결과물을
				// 출력할 수 있는 상태로 변경
				conn.setDoOutput(true);
				conn.setRequestMethod("POST");
				
				// 헤더 영역
				conn.setRequestProperty("Content-type", "application/json");
				conn.setRequestProperty("Accept", "application/json");
				conn.setRequestProperty("Authorization", "Bearer " + KEY);
				
				// payload 영역
				// StringBuffer는 String보다 메모리를 효율으로 사용할 수 있다
				StringBuffer param = new StringBuffer();
				param.append("model=gpt-3.5-turbo");
				param.append("&temperature=0.5"); // 0.0 ~ 2.0 높을 수록 창의적
				param.append("&frequency_penalty=0"); // -2.0 ~ 2.0
				param.append("&max_tokens=2048"); // token : 분석하는 실제 최소 단위
				param.append("&user=1");
				param.append("&prompt="+"안녕");
				
				OutputStream os = conn.getOutputStream();
				os.write(param.toString().getBytes("utf-8"));
				os.flush(); // 보통 꽉 차야 나가는데.. 짜투리를 강제로 내보내기 
				os.close();
				
				
				// gpt 결과 받기
				// 결과 코드
				int code = conn.getResponseCode();
				System.out.println("html code : " + code);
				
				// 메시지 받기
				InputStream is = null;
				if(code >= 200 && code <= 300) {
					is = conn.getInputStream();
				} else {
					is = conn.getErrorStream();
				}
				
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				StringBuffer sb = new StringBuffer();
//				String result = "";
				
//				String line = null;
//				while( (line = br.readLine()) != null ) {
//					sb.append(line);
//				}
				
				while(true) {
					String line = br.readLine();
					
					if(line == null) {
						break;
					}
					
//					result += line;
					sb.append(line);
				}
				br.close();
				conn.disconnect();
				
				System.out.println("결과 : "+ sb);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		return "";
	}
	
}


