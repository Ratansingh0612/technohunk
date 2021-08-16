package com.techquiz.info.jdbc.service;

import java.util.List;

import com.techquiz.programys.common.BatchAssignmentVO;

/**
 * 
 * @author Nagendra
 *
 */
public interface FacultyService {
	public List<String> findGroupNamesByTrainerId(int trainerid);
	public List<BatchAssignmentVO> findGroupBatchNamesByTrainerId(int trainerid);
	public List<BatchAssignmentVO> findAllGroupBatchNamesByTrainerId();
	public String associateBatchWithTrainer(BatchAssignmentVO batchAssignmentVO);
}
