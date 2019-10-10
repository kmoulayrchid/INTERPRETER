package com.oracle.labs.persistances;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.web.ResourceProperties.Strategy;

@Entity
public class InterpreterEntity implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String code;
	private String language;
	private String body;
	private String result;
	private Date creationDate;
	private String sessionId;
	public InterpreterEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InterpreterEntity(String code, String language, String body, String result,String sessionId) {
		super();
		this.code = code;
		this.language = language;
		this.body = body;
		this.result = result;
		this.creationDate=new Date();
		this.sessionId=sessionId;
	}
	public InterpreterEntity(String code, String language, String body, String result, Date creationDate,String sessionId) {
		super();
		this.code = code;
		this.language = language;
		this.body = body;
		this.result = result;
		this.creationDate = creationDate;
		this.sessionId=sessionId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
}
