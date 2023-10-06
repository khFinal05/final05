package com.kh.okkh.member.controller;

import java.net.http.HttpHeaders;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.kh.okkh.member.model.service.MemberService;
import com.kh.okkh.member.model.service.MemberServiceImpl;
import com.kh.okkh.member.model.vo.Member;

@Controller
public class MemberController {

	@Autowired
	private MemberServiceImpl mService;
	
	@RequestMapping("login.me")
	public String login(Member m, HttpSession session) {
		
		Member mem = mService.login(m);
		
		session.setAttribute("mem", mem);
		
		return "redirect:/";
	}
	
	
	@GetMapping("/callback")
	public ResponseEntity<String> getUserInfo(@RequestParam String code) {
	    String accessToken = getAccessToken(code);
	    String userName = getUserName(accessToken);
	    return ResponseEntity.ok(userName);
	}

	private String getAccessToken(String code) {
	    return RestTemplate.postForObject(
	            "https://github.com/login/oauth/access_token",
	            new OAuthAccessTokenRequest(clientId, clientSecret, code),
	            OAuthAccessTokenResponse.class
	    ).getAccessToken();
	}

	public String getUserName(String accessToken) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setBearerAuth(accessToken);
	    HttpEntity<Void> request = new HttpEntity<>(headers);

	    return restTemplate.exchange(
	            MEMBER_INFO_URL,
	            HttpMethod.GET,
	            request,
	            OAuthMemberInfoResponse.class
	    ).getBody().getName();
	}
	
	
}
