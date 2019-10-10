package com.oracle.labs.interpreters;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oracle.labs.dao.InterpreterRepository;
import com.oracle.labs.interpreters.python.JythonImpl;
import com.oracle.labs.persistances.InterpreterEntity;

@Service
public class CodeFormatter implements ICodeFormatter {
	@Autowired
	private InterpreterRepository interpreterRepository;

	private ICodeInterface codeInterface;

	private String formatCode(String code) {
		StringBuilder result = new StringBuilder();
		code = code.substring(code.indexOf(" ") + 1, code.length());
		result.append(code);
		return result.toString();
	}

	private String getLanguage(String code) {
		StringBuilder result = new StringBuilder();
		code = code.substring(1, code.indexOf(" "));
		result.append(code);
		return result.toString();
	}

	private InterpreterEntity execute(String code) {
		InterpreterEntity entity = null;
		StringBuilder result = new StringBuilder();
		String language = getLanguage(code);
		String formattedCode = formatCode(code);
		if (language.equals("python")) {
			codeInterface = new JythonImpl();
			result.append(codeInterface.executeCode(formattedCode));
		}
			entity = new InterpreterEntity();
			entity.setLanguage(language);
			entity.setBody(code);
			entity.setCode(formattedCode);
			entity.setResult(result.toString());
			entity.setCreationDate(new Date());
		return entity;
	}

	@Override
	public String saveCode(String code, HttpServletRequest httpRequest) {
		InterpreterEntity entity = execute(code);
		if (entity != null && !entity.getResult().equals("get Last Result")) {
			if (entity.getResult().equals(""))
				return "";
			else {
				entity.setSessionId(httpRequest.getSession().getId());
				if(!entity.getResult().contains("Exception") && entity.getResult().equals("")) {
					return interpreterRepository.save(entity).getResult();
				}
				else {
					return entity.getResult();
				}
			}
		} else {
			List<InterpreterEntity> interpreterEntities=interpreterRepository.getLastBySession(httpRequest.getSession().getId());
			if(interpreterEntities.size()>0) {
				entity = interpreterRepository.getLastBySession(httpRequest.getSession().getId()).get(0);
			}
			return entity!=null?entity.getResult():"No result found";
		}

	}
}
