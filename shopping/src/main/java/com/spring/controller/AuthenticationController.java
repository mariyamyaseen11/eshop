package com.spring.controller;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.constants.ResponseCode;
import com.spring.dto.LoginRequest;
import com.spring.model.User;
import com.spring.repository.UserRepository;
import com.spring.response.serverResp;
import com.spring.util.jwtUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	private static Logger logger = Logger.getLogger(UserController.class.getName());

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private jwtUtil jwtutil;
	
	@PostMapping("/login")
	public ResponseEntity<serverResp> verifyUser(@Valid @RequestBody LoginRequest credential) {
		String email = credential.getEmail();
		String password = credential.getPassword();
		User loggedUser = userRepo.findByEmailAndPassword(email, password);
		serverResp resp = new serverResp();
		if (loggedUser != null) {
			//String jwtToken = jwtutil.createToken(email, password, WebConstants.USER_CUST_ROLE);
			String jwtToken = jwtutil.createToken(email, password, loggedUser.getUsertype());
			resp.setStatus(ResponseCode.SUCCESS_CODE);
			resp.setMessage(ResponseCode.SUCCESS_MESSAGE);
			resp.setAUTH_TOKEN(jwtToken);
			resp.setUserType(loggedUser.getUsertype());
		} else {
			resp.setStatus(ResponseCode.FAILURE_CODE);
			resp.setMessage(ResponseCode.FAILURE_MESSAGE);
		}
		return new ResponseEntity<serverResp>(resp, HttpStatus.OK);
	}
}
