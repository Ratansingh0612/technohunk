package com.techquiz.codings.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.techquiz.codings.dao.CodingProblemsRepository;
import com.techquiz.codings.dao.entity.CodingProblemsEntity;
import com.techquiz.codings.dao.entity.TestCasesEntity;
import com.techquiz.codings.service.CodingProblemsService;
import com.techquiz.codings.web.controller.vo.CodingProblemsVO;
import com.techquiz.codings.web.controller.vo.TestCasesVO;

/**
 * 
 * @author Nagendra Kumar
 *
 */
@Service("CodingProblemsServiceImpl")
public class CodingProblemsServiceImpl implements  CodingProblemsService {

	@Autowired
	private CodingProblemsRepository codingProblemsDao;
	
	@Override
	public  int totalCodingProblems() {
		return codingProblemsDao.totalCodingProblems();
	}
	
	@Override
	public List<CodingProblemsVO> findCodingProblemsByTech(String techName,int pageNo,int pageSize){
		List<CodingProblemsVO> codingProblemsVOs=new ArrayList<CodingProblemsVO>();
		Sort sort = new Sort(new Sort.Order(Direction.DESC, "level"));
		Pageable pageable = new PageRequest(pageNo, pageSize, sort);
		/*List<CodingProblemsEntity> codingProblemsEntityList=codingProblemsDao.findByTechName(techName, pageable);*/
		 Iterable<CodingProblemsEntity> codingProblemsEntityList=
				 codingProblemsDao.findAll(pageable); 
		// Iterable<CodingProblemsEntity> codingProblemsEntityList = repository.findAll(gotoPage(0));
		for(CodingProblemsEntity entity:codingProblemsEntityList){
			CodingProblemsVO codingProblemsVO=new CodingProblemsVO();
			BeanUtils.copyProperties(entity, codingProblemsVO);
			codingProblemsVO.setCategory(entity.getCodingProblemCategoryEntity().getName());
			codingProblemsVOs.add(codingProblemsVO);
		}
		return codingProblemsVOs;
	}
	
	@Override
	public List<CodingProblemsVO> findCodingProblemsByTech(String techName){
		List<CodingProblemsVO> codingProblemsVOs=new ArrayList<>();
		Iterable<CodingProblemsEntity> iterable=codingProblemsDao.findAll();
		for(CodingProblemsEntity item :iterable){
			CodingProblemsVO codingProblemsVO=new CodingProblemsVO();
			BeanUtils.copyProperties(item, codingProblemsVO);
			codingProblemsVO.setCategory(item.getCodingProblemCategoryEntity().getName());
			codingProblemsVOs.add(codingProblemsVO);
		}
		return codingProblemsVOs;
	}
	
	@Override
	public List<CodingProblemsVO> findCodingProblemsByCategory(String categoryName){
		List<CodingProblemsVO> codingProblemsVOs=new ArrayList<>();
		Iterable<CodingProblemsEntity> iterable=codingProblemsDao.findByProblemType(categoryName);
		for(CodingProblemsEntity item :iterable){
			CodingProblemsVO codingProblemsVO=new CodingProblemsVO();
			BeanUtils.copyProperties(item, codingProblemsVO);
			codingProblemsVO.setCategory(item.getCodingProblemCategoryEntity().getName());
			codingProblemsVOs.add(codingProblemsVO);
		}
		return codingProblemsVOs;
	}
	
	@Override
	public List<CodingProblemsVO> findCodingProblemsByLevel(String level){
		List<CodingProblemsVO> codingProblemsVOs=new ArrayList<>();
		Iterable<CodingProblemsEntity> iterable=codingProblemsDao.findByLevel(level);
		for(CodingProblemsEntity item :iterable){
			CodingProblemsVO codingProblemsVO=new CodingProblemsVO();
			BeanUtils.copyProperties(item, codingProblemsVO);
			codingProblemsVO.setCategory(item.getCodingProblemCategoryEntity().getName());
			codingProblemsVOs.add(codingProblemsVO);
		}
		return codingProblemsVOs;
	}
	
	@Override
	public List<CodingProblemsVO> findCodingProblemsByCategory(String categoryName,String level){
		List<CodingProblemsVO> codingProblemsVOs=new ArrayList<>();
		Iterable<CodingProblemsEntity> iterable=codingProblemsDao.findByProblemTypeAndLevel(categoryName,level);
		for(CodingProblemsEntity item :iterable){
			CodingProblemsVO codingProblemsVO=new CodingProblemsVO();
			BeanUtils.copyProperties(item, codingProblemsVO);
			codingProblemsVO.setCategory(item.getCodingProblemCategoryEntity().getName());
			codingProblemsVOs.add(codingProblemsVO);
		}
		return codingProblemsVOs;
	}
	
	@Override
	public CodingProblemsVO  addCodingProblem(CodingProblemsVO codingProblemsVO){
		CodingProblemsEntity entity=new CodingProblemsEntity();
		BeanUtils.copyProperties(codingProblemsVO, entity);
		CodingProblemsEntity pentity=codingProblemsDao.save(entity);
		CodingProblemsVO output=new CodingProblemsVO();
		BeanUtils.copyProperties(pentity, output);
		return output;
	}
	
	
	@Override
	public String  updateCodingProblem(CodingProblemsVO codingProblemsVO){
		CodingProblemsEntity pentity=codingProblemsDao.findOne(codingProblemsVO.getCpid());
		pentity.setDom(codingProblemsVO.getDom());
		pentity.setLevel(codingProblemsVO.getLevel());
		pentity.setDuration(codingProblemsVO.getDuration());
		pentity.setTitle(codingProblemsVO.getTitle());
		codingProblemsDao.save(pentity);
		return "success";
	}
	
	
	@Override
	public CodingProblemsVO findCodingProblemsByProbId(long cpid){
		CodingProblemsVO codingProblemsVO=new CodingProblemsVO();
		CodingProblemsEntity codingProblemsEntity=codingProblemsDao.findOne(cpid);
		BeanUtils.copyProperties(codingProblemsEntity, codingProblemsVO);
		codingProblemsVO.setCategory(codingProblemsEntity.getCodingProblemCategoryEntity().getName());
		List<TestCasesVO> testCasesVOs=new ArrayList<TestCasesVO>();
		List<TestCasesEntity> casesEntitityList=codingProblemsEntity.getTestCases();
		for(TestCasesEntity testCasesEntity:casesEntitityList){
			TestCasesVO testCasesVO=new TestCasesVO();
			BeanUtils.copyProperties(testCasesEntity, testCasesVO);
			testCasesVOs.add(testCasesVO);
		}
		codingProblemsVO.setTestCasesVOs(testCasesVOs);
		return codingProblemsVO;
	}
	
}
