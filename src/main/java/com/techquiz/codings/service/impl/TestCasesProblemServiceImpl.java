package com.techquiz.codings.service.impl;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synergisitic.it.util.DateUtils;
import com.techquiz.codings.dao.CodingProblemsRepository;
import com.techquiz.codings.dao.TestCasesRepository;
import com.techquiz.codings.dao.entity.CodingProblemsEntity;
import com.techquiz.codings.dao.entity.TestCasesEntity;
import com.techquiz.codings.service.TestCasesProblemService;
import com.techquiz.codings.web.controller.vo.CodingProblemsVO;

@Service("TestCasesProblemServiceImpl")
public class TestCasesProblemServiceImpl implements TestCasesProblemService {
	
	@Autowired
	private TestCasesRepository testCasesRepository;
	
	@Autowired
	private CodingProblemsRepository codingProblemsDao;
	
	@Override
	public CodingProblemsVO  addTestCaseForProblem(long cpid,String input,String output,String comment){
		CodingProblemsEntity codingProblemsEntity=codingProblemsDao.findOne(cpid);
		TestCasesEntity testCasesEntity=new TestCasesEntity();
		testCasesEntity.setCodingProblems(codingProblemsEntity);
		testCasesEntity.setComment(comment);
		Timestamp currenttime=DateUtils.getCurrentTimeIntoTimestamp();
		testCasesEntity.setDoe(currenttime);
		testCasesEntity.setDom(currenttime);
		testCasesEntity.setExpectedInput(input);
		testCasesEntity.setExpectedOutput(output);
		CodingProblemsVO codingProblemsVO=new CodingProblemsVO();
		TestCasesEntity dtestCasesEntity=testCasesRepository.save(testCasesEntity);
		BeanUtils.copyProperties(dtestCasesEntity, codingProblemsVO);
		return codingProblemsVO;
	}
	
	@Override
	public String  deleteTestCaseForProblem(long cpid,String input,String output){
		List<TestCasesEntity> testCasesEntityList=testCasesRepository.findTestCaseByPidInputOutput(cpid, input, output);
		if(testCasesEntityList!=null && testCasesEntityList.size()>0){
			testCasesRepository.delete(testCasesEntityList.get(0).getTcid());
		}
		return "success";
	}
	
	

}
