package com.oracle.labs;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.labs.interpreters.ICodeFormatter;
import com.oracle.labs.persistances.CodeRequest;
import com.oracle.labs.persistances.CodeResponse;

@RestController
public class CodeFormatterController {
	@Autowired
	private ICodeFormatter codeFormatter;
	
	@RequestMapping(value="/execute", method = RequestMethod.POST)
	public String exec(@RequestBody CodeRequest codeRequest, HttpServletRequest httpRequest) {
		CodeResponse codeResponse=new CodeResponse();
		codeResponse.setResult(codeFormatter.saveCode(codeRequest.getCode(),httpRequest));
		return codeResponse.getResult();
	}
}
