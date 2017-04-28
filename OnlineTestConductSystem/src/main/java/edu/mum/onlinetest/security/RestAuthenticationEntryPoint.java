package edu.mum.onlinetest.security;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.mum.onlinetest.model.Credential;
import edu.mum.onlinetest.model.Role;
import edu.mum.onlinetest.service.LoginService;
import edu.mum.onlinetest.serviceImpl.CredentialServiceImpl;
import edu.mum.onlinetest.utils.Based64Util;

public class RestAuthenticationEntryPoint extends HandlerInterceptorAdapter {

	@Autowired
	LoginService loginService;
	
	@Autowired
	CredentialServiceImpl credentialService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("######################  PRE HANDLE BEGIN  ######################");
		List<Credential> credentials = credentialService.getAllCredentials();
		if(credentials.size() <= 0){
			System.out.println("*********************************");
			generateCredentials();
		}else{
			System.out.println("not null");
		}
		List<String> uriResource = Arrays.asList(request.getRequestURI().split("/"));

		//can access without credential
		if (uriResource.contains("students") || uriResource.contains("home")){
			System.out.println("ACCESS GRANTED >> no need credential, ");
			System.out.println("uri = "+request.getRequestURI());
			return true;
			
		}

		String authParam = request.getHeader("authorization");

		if (null == authParam || !authParam.contains("Basic ")){
			System.out.println("AUTHENTICATION FAILED >> authentication parameters not found");
			return false;
		}
		String[] authTokens = decodeLoginParam(authParam).split(":");

		Credential credential = loginService.login(authTokens[0], Based64Util.md5(authTokens[1]));
		if (null == credential){
			System.out.println("AUTHENTICATION FAILED >> User not found");
			return false;
		}
		
		if(!credential.isEnabled()){
			System.out.println("AUTHENTICATION FAILED >> User is not enable");
			return false;
		}

		// checking role wise access
		if (uriResource.contains("admin") && credential.getRole().equals(Role.ADMIN)){
			System.out.println("ACCESS GRANTED >> resource = admin, Role = ADMIN");
			return true;
		}
		if (uriResource.contains("dataadmin") && credential.getRole().equals(Role.DATAADMIN)){
			System.out.println("ACCESS GRANTED >> resource = dataadmin, Role = DATAADMIN");
			return true;
		}
		if (uriResource.contains("coach") && credential.getRole().equals(Role.COACH)){
			System.out.println("ACCESS GRANTED >> resource = coach, Role = COACH");
			return true;
		}
		System.out.println("AUTHORIZATION FAILED >> resource ="+ request.getRequestURI()+", "+ credential.getRole().toString());
		System.out.println("######################  PRE HANDLE END  ######################");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	private String decodeLoginParam(String str) {
		// Authentication = Basic YnNlamF3YWw6MTIz; //
		// String based64Str = str.split(" ")[1];
		return Based64Util.decode(str.split(" ")[1]);

	}

	private void generateCredentials() {		
		Credential credential = new Credential();
		credential.setUsername("bsejawal");
		credential.setPassword("123");
		credential.setRole(Role.ADMIN);
		credential.setEnabled(true);
		credentialService.saveCredential(credential);
	}

}
