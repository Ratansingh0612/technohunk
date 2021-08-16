package com.techquiz.codings.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techquiz.codings.dao.entity.ConsultantsSubmittedCodeEntity;

/**
 * Specifies methods used to obtain and modify ConsultantsSubmittedCodeEntity related information
 * which is stored in the database.
 * @author Nagendra
 * @Since 06-Aug-2018
 */
@Repository
public interface GuestCodingProblemSubmitedSolutionRespository extends CrudRepository<ConsultantsSubmittedCodeEntity, Long> {  

	 /**
     * Finds ConsultantsSubmittedCodeEntity by using the consultantid as a search criteria.
     * @param consultantid  
     * @return  A list of ConsultantsSubmittedCodeEntity which consultantid is an exact match with the given consultantid.
     *   If no ConsultantsSubmittedCodeEntity is found, this method returns an empty list.
     */
	public List<ConsultantsSubmittedCodeEntity> findByConsultantid(String consultantid);
	
	 /*@Query("SELECT p FROM Person p WHERE LOWER(p.lastName) = LOWER(:lastName)")
	    public List<Person> find(@Param("lastName") String lastName);*/
}
