package com.techquiz.info.jdbc.dao;

import java.util.List;

import com.techquiz.info.jdbc.dao.entity.BatchAssignmentEntity;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface FacultyJdbcDao {

	public List<String> findGroupNamesByTrainerId(int trainerid);
	public List<BatchAssignmentEntity> findGroupBatchNamesByTrainerId(int trainerid);
	public List<BatchAssignmentEntity> findAllGroupBatchNamesByTrainerId();
	public String associateBatchWithTrainer(BatchAssignmentEntity batchAssignmentVO);
}
