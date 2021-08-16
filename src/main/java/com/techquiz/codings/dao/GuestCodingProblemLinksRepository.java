package com.techquiz.codings.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techquiz.codings.dao.entity.CodingProblmesLinkEntity;

/**
 * 
 * @author nagendra
 * @since 07-Aug-2018
 * 
 * 
 */
@Repository
public interface GuestCodingProblemLinksRepository extends CrudRepository<CodingProblmesLinkEntity, Long> {
	
	public List<CodingProblmesLinkEntity> findByGeneratedCodeLink(String generatedCodeLink);
	
	@Query("SELECT p FROM CodingProblmesLinkEntity p WHERE  p.userSessionId IS NULL")
	public List<CodingProblmesLinkEntity> findCodingProblemWithSessionIDNull();

}

