package com.techquiz.codings.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.techquiz.codings.dao.entity.CodingProblemsEntity;

@Repository
public interface CodingProblemsRepository extends  PagingAndSortingRepository<CodingProblemsEntity, Long> {
	
	public List<CodingProblemsEntity> findByTechName(String techName, Pageable pageable);
	
    @Query("SELECT count(*) from CodingProblemsEntity")
	public  int totalCodingProblems();
    
    public List<CodingProblemsEntity> findByProblemType(String problemType);
    
    public List<CodingProblemsEntity> findByProblemTypeAndLevel(String problemType,String level);
    
    public List<CodingProblemsEntity> findByLevel(String level);

}

