package com.oracle.labs.interpreters;

import javax.servlet.http.HttpServletRequest;

public interface ICodeFormatter {
	
	public String saveCode(String code, String sessionId);
}
