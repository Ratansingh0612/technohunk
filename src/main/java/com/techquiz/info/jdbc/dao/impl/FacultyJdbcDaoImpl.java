package com.techquiz.info.jdbc.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.techquiz.info.jdbc.dao.FacultyJdbcDao;
import com.techquiz.info.jdbc.dao.entity.BatchAssignmentEntity;

/**
 * 
 * @author nagendra.yadav
 *
 */
@Repository("FacultyJdbcDaoImpl")
public class FacultyJdbcDaoImpl extends JdbcDaoSupport implements FacultyJdbcDao  {

	@Autowired
	@Qualifier("javaTechDataSource-ds")
	public void intitJdbcTemplate(DataSource dataSource) {
		super.setDataSource(dataSource);
	}	
	
	@Override
	public List<BatchAssignmentEntity> findGroupBatchNamesByTrainerId(int trainerid) {
		List<BatchAssignmentEntity> batchAssignmentList=new ArrayList<BatchAssignmentEntity>();
		String sql="select USER_ID as baid,SUB_CODE as batchid,BR_SEM_SEC as batch,DOE as doc from subject_assignment where USER_ID="+trainerid;
		batchAssignmentList=super.getJdbcTemplate().query(sql, new BeanPropertyRowMapper(BatchAssignmentEntity.class));	
		return batchAssignmentList;
	}
	
	@Override
	public List<BatchAssignmentEntity> findAllGroupBatchNamesByTrainerId() {
		String sql="select USER_ID as baid,SUB_CODE as batchid,BR_SEM_SEC as batch,DOE as doc from subject_assignment";
		List<BatchAssignmentEntity> batchAssignmentList=super.getJdbcTemplate().query(sql, new BeanPropertyRowMapper(BatchAssignmentEntity.class));	
		return batchAssignmentList;
	}
	
	@Override
	public List<String> findGroupNamesByTrainerId(int trainerid) {
		String sql="select BR_SEM_SEC from subject_assignment where USER_ID="+trainerid;
		List<String> groupList=super.getJdbcTemplate().queryForList(sql, String.class);	
		return groupList;
	}

	@Override
	public String associateBatchWithTrainer(BatchAssignmentEntity batchAssignmentVO) {
		String query="insert into subject_assignment(USER_ID,SUB_CODE,SUBJECT_NAME,BR_SEM_SEC,SUB_TYPE,F_SHORT_SUBJECT_NAME,DAY_PERIOD,DOE,DOM,E_USER_ID,LAB_NAME) values(?,?,?,?,?,?,?,?,?,?,?)";
		Object data[]=new Object[]{batchAssignmentVO.getBaid(),"TPA-100","NA",batchAssignmentVO.getBatch(),"L",batchAssignmentVO.getBatchid(),"NA",new Date(),new Date(),batchAssignmentVO.getAdminid(),"L"};
		try {
		super.getJdbcTemplate().update(query,data);
		}catch(Exception ex){
			 System.out.println(ex.getMessage());
			 return "fail";
		}
		return "success";
	}
	
}
