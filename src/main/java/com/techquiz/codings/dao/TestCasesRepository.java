package com.techquiz.codings.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.techquiz.codings.dao.entity.TestCasesEntity;

/**
 * 
 * @author nagendra.yadav
 *
 */
@Repository
public interface TestCasesRepository extends CrudRepository<TestCasesEntity, Long> {
	
	
	//custom query to fetch data from Spring Data with JPA
	@Query("SELECT p FROM TestCasesEntity p WHERE p.codingProblems.cpid = :pid AND p.expectedInput= :input AND p.expectedOutput= :output")
    public List<TestCasesEntity> findTestCaseByPidInputOutput(@Param("pid") long pid,@Param("input") String input,@Param("output") String output);

}
