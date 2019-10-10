package com.oracle.labs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.oracle.labs.dao.InterpreterRepository;
import com.oracle.labs.persistances.InterpreterEntity;

@SpringBootApplication
public class NoteBookServerApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(NoteBookServerApplication.class, args);
	}

}
