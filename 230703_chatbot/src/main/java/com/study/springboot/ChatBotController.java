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
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ChatBotController {

	@RequestMapping("/gpt")
	@ResponseBody
	public JSONObject gpt(
			@RequestBody // post 방식을 저장
			Map map
			) {
		
		Map userRequest = (Map)map.get("urserRequest");
		String prompt = (String) userRequest.get("utterance");
		
		long start = System.currentTimeMillis();
		
		// 보통 변수명이 대문자이면 바꿀 필요가 없는 읽기전용이구나 라고 생각하셈
		final String KEY = "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";
		
		//URL은 try/catch를 꼭 써야함. 단독 사용시 빨간줄
    	StringBuffer sb = new StringBuffer();
    	String text = "잠시후 다시 질문해주세요";
		try {
			//gpt 주소
			URL url = new URL("https://api.openai.com/v1/completions");
			
											//자식                //부모
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			//접속 후 받은 결과물을 출력할 수 있는 상태로 변경
			//없으면 System.out.println(); 사용 불가
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			
			// 헤더 영역
	        							//key				//value	
			conn.setRequestProperty("Content-type", "application/json");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setRequestProperty("Authorization", "Bearer " + KEY);
		
			// payload 영역
	        //String으로 붙여(+=) 쓰는 것 보다 메모리를 효율적으로 사용 가능
	        //보기 편하게 나눠서 적음
	        //https://platform.openai.com/playground 조정중
			StringBuffer param = new StringBuffer();
			   param.append("{");
	            param.append("\"model\": \"text-davinci-003\",");
	            param.append("\"temperature\": 0.5,"); // 창의성
	            param.append("\"frequency_penalty\": 0,"); // 반복도
	            param.append("\"max_tokens\": 2048,"); 
	            param.append("\"user\": \"1\","); // 접속 고유 아이디
	            param.append("\"prompt\": \""+prompt+"\"");
	            param.append("}");
            OutputStream os = conn.getOutputStream(); // 출력스트림
            os.write(param.toString().getBytes("utf-8")); // param을 UTF-8문자열로 변환하여 바이트 배열로해서 서버로 전송
            os.flush(); // 버퍼에 가득차야 나가는데 가득차기전에 끝나면 강제 전송
            os.close(); // 출력 스트림 닫기
	        
            // gtp 결과 받기
            // 결과 코드
            int code = conn.getResponseCode();
            System.out.println("html code :" + code);

            // 메세지 받기
            InputStream is = null;
            if(code >= 200 && code <= 300) {
            	is = conn.getInputStream();
            } else {
            	is = conn.getErrorStream();
            }
            	InputStreamReader isr = new InputStreamReader(is);
            	BufferedReader br = new BufferedReader(isr);
            

//            	String result = "";
//            	String line = null;
//           	while((line = br.readLine()) != null) {
//            	sb.append(line);
//            	}
            	
            	while(true) {
            		String line = br.readLine();
            		
            		if(line == null) {
            			break;
            		}
            		
//            		result += line;
            		sb.append(line);
            	}
            
            	br.close();
            	conn.disconnect();
            	System.out.println("결과 :" + sb);
	        
            	//StringBuffrer를 String으로
            	String result = sb.toString();
            	
            	JSONParser parser = new JSONParser();
            	JSONObject json = (JSONObject) parser.parse(result);
            	JSONArray arr = (JSONArray)json.get("choices");
            	JSONObject choice = (JSONObject) arr.get(0);
            	text = (String) choice.get("text");
            	text = text.replaceAll("\n","");
            	System.out.println("gpt 답변 : " + text);           	
            	
		} catch (Exception e) { //최상위 예외 객체
			e.printStackTrace();
		}
				
		long end = System.currentTimeMillis();
		System.out.println("걸린시간 : " + (end-start) + "ms");
		

		JSONObject send = new JSONObject();
		send.put("version", "2.0");
			
		JSONObject simpleText = new JSONObject();
		simpleText.put("text",text);
		
		JSONObject outputs1 = new JSONObject();
		outputs1.put("simpleText",simpleText);
		
		JSONArray outputs = new JSONArray();
		outputs.add(outputs1);
		
		JSONObject template = new JSONObject();
		template.put("outputs",outputs);
		
		send.put("template", template);
		
		
		
		return send;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/chat_test")
	@ResponseBody
	public JSONObject chatTest(@RequestBody // post 방식을 저장
	Map map
	) {

		
		System.out.println(map);
		
//		System.out.println(map.get("action"));
			
		Map map_action = (Map)map.get("action");
		String meat = (String)((Map)((Map)map_action.get("detailParams")).get("meat")).get("origin");
		System.out.println("meat : " + meat);
		
		Map map_detailParams = (Map)map_action.get("detailParams");
		Map map_sys_number = (Map)map_detailParams.get("sys_number");
		String sys_number = (String)map_sys_number.get("origin");
		System.out.println("sys_number : " + sys_number);

		
		
//		String result = "{"
//		+ "    \"version\": \"2.0\","
//		+ "    \"template\": {"
//		+ "        \"outputs\": ["
//		+ "            {"
//		+ "                \"simpleText\": {"
//		+ "                    \"text\"  : \" " +" meat : " + meat + "sys_number : " + sys_number + " \" "
//		+ "                }"
//		+ "            }"
//		+ "        ]"
//		+ "    }"
//		+ "}";	

		
		
		
		JSONObject received = new JSONObject(map);

		JSONObject send = new JSONObject();
		send.put("version", "2.0");
			
		JSONObject simpleText = new JSONObject();
		String text = "meat: " + meat +"sys_number " + sys_number;
		simpleText.put("text",text);
		
		JSONObject outputs1 = new JSONObject();
		outputs1.put("simpleText",simpleText);
		
		JSONArray outputs = new JSONArray();
		outputs.add(outputs1);
		
		JSONObject template = new JSONObject();
		template.put("outputs",outputs);
		
		send.put("template", template);
		
		return send;
	}
	

}


