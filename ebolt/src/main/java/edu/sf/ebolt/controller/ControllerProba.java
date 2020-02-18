package edu.sf.ebolt.controller;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Api(tags = {"ebolt-handler"})
@RestController
public class ControllerProba {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public String getFoosBySimplePath() {
		//
		
//		UUID uuid = UUID.randomUUID();
//        String randomUUIDString = uuid.toString();
//
//        
//        System.out.println("Random UUID String = " + randomUUIDString);
//        System.out.println("UUID version       = " + uuid.version());
//        System.out.println("UUID variant       = " + uuid.variant());
		for (int i=1; i<5; i++) {
        
        String shortId = RandomStringUtils.randomAlphanumeric(24);
        
        System.out.println(shortId);
		}
		//
		return "Simple SAF starter project! ebolt";
	}

}
