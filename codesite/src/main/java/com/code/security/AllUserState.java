package com.code.security;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AllUserState {

	@Autowired
	private SessionRegistry sessionRegistry;
	
	@ResponseBody
	@GetMapping("/userstate")
	public Map<String, UserExtend> userList() {
		Map<String, UserExtend> result = new HashMap<>();
		List<Object> obList = sessionRegistry.getAllPrincipals();
		
		for(Object ob : obList) {
			UserExtend user = (UserExtend) ob;
			List<SessionInformation> sessionInfo = sessionRegistry.getAllSessions(ob, false);
			System.out.println("ob : " + user.toString());
			result.put(sessionInfo.get(0).getSessionId(), user);
		}
		
		return result;
	}
}
