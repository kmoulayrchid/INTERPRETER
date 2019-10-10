package com.oracle.labs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.oracle.labs.persistances.InterpreterEntity;

@Repository
public interface InterpreterRepository extends JpaRepository<InterpreterEntity, Integer> {
	
	@Query("select e from InterpreterEntity e where e.sessionId = :x order by e.creationDate desc")
	public List<InterpreterEntity> getLastBySession(@Param("x") String sessionId);
}
