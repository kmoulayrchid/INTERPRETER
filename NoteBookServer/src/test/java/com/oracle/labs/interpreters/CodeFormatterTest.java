package com.oracle.labs.interpreters;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import javax.servlet.http.HttpServletRequest;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.oracle.labs.dao.InterpreterRepository;
import com.oracle.labs.interpreters.CodeFormatter;

import javassist.compiler.MemberResolver.Method;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeFormatterTest {
	@Autowired
	private InterpreterRepository interpreterRepository;
	
	
	@Test
	public void SaveCodeTest(){
		CodeFormatter codeformatter = new CodeFormatter();
		String result1 =codeformatter.saveCode("%python print 1+1", "123");
		assertEquals(result1, "2");
		String result2 =codeformatter.saveCode("%python a = 1", "123");
		assertEquals(result2, "");
		String result3 =codeformatter.saveCode("%python print a+1", "123");
		assertEquals(result3, "2");
		
		System.out.println(result1+"  "+result2+"  "+result3);
		
	}
}
