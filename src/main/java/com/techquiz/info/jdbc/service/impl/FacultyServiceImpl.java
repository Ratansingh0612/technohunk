package com.techquiz.info.jdbc.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.techquiz.info.jdbc.dao.FacultyJdbcDao;
import com.techquiz.info.jdbc.dao.entity.BatchAssignmentEntity;
import com.techquiz.info.jdbc.service.FacultyService;
import com.techquiz.programys.common.BatchAssignmentVO;

/**
 * 
 * @author nagendra.yadav
 *
 */
@Service("FacultyServiceImpl")
public class FacultyServiceImpl  implements FacultyService  {
	
	@Autowired
	@Qualifier("FacultyJdbcDaoImpl")
	private  FacultyJdbcDao facultyDao;
	
	@Override
	public List<String> findGroupNamesByTrainerId(int trainerid) {
		return facultyDao.findGroupNamesByTrainerId(trainerid);
	}
	
	@Override
	public List<BatchAssignmentVO> findGroupBatchNamesByTrainerId(int trainerid) {
		List<BatchAssignmentVO> batchAssignmentList=new ArrayList<BatchAssignmentVO>();
		List<BatchAssignmentEntity> assignmentEntityList=facultyDao.findGroupBatchNamesByTrainerId(trainerid);
		for(BatchAssignmentEntity batchAssignment:assignmentEntityList) {
			BatchAssignmentVO  batchAssignmentVO=new BatchAssignmentVO();
			BeanUtils.copyProperties(batchAssignment, batchAssignmentVO);
			batchAssignmentList.add(batchAssignmentVO);
		}
		return batchAssignmentList;
	}
	
	@Override
	public List<BatchAssignmentVO> findAllGroupBatchNamesByTrainerId() {
		List<BatchAssignmentVO> batchAssignmentList=new ArrayList<BatchAssignmentVO>();
		List<BatchAssignmentEntity> assignmentEntityList=facultyDao.findAllGroupBatchNamesByTrainerId();
		for(BatchAssignmentEntity batchAssignment:assignmentEntityList) {
			BatchAssignmentVO  batchAssignmentVO=new BatchAssignmentVO();
			BeanUtils.copyProperties(batchAssignment, batchAssignmentVO);
			batchAssignmentList.add(batchAssignmentVO);
		}
		return batchAssignmentList;
	}

	@Override
	public String associateBatchWithTrainer(BatchAssignmentVO batchAssignmentVO) {
		BatchAssignmentEntity batchAssignmentEntity=new BatchAssignmentEntity();
		BeanUtils.copyProperties(batchAssignmentVO, batchAssignmentEntity);
		String status=facultyDao.associateBatchWithTrainer(batchAssignmentEntity);
		return status;
	}
	
}
