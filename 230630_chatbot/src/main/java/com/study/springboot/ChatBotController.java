package com.study.springboot;

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


