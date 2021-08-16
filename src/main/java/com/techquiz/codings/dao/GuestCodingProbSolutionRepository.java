package com.techquiz.codings.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techquiz.codings.dao.entity.GuestCodingProbSolutionEntity;

/**
 * 
 * @author nagendra
 * @since 27-Jul-2018
 *
 */
@Repository
public interface GuestCodingProbSolutionRepository extends CrudRepository<GuestCodingProbSolutionEntity, Long> { 

}
