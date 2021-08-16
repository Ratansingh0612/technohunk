package com.techquiz.codings.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techquiz.codings.dao.GuestCodingProblemSubmitedSolutionRespository;
import com.techquiz.codings.dao.entity.CodingProblemsEntity;
import com.techquiz.codings.dao.entity.CodingProblmesLinkEntity;
import com.techquiz.codings.dao.entity.ConsultantsSubmittedCodeEntity;
import com.techquiz.codings.service.GuestCodingProblemSubmitedSolutionService;
import com.techquiz.codings.web.controller.vo.CodingProblemsVO;
import com.techquiz.codings.web.controller.vo.CodingProblmesLinkVO;
import com.techquiz.codings.web.controller.vo.ConsultantsSubmittedCodeVO;

/**
 * 
 * @author nagendra
 * @since 06-Aug-2018
 *
 */
@Service("GuestCodingProblemSubmitedSolutionServiceImpl")
public class GuestCodingProblemSubmitedSolutionServiceImpl implements GuestCodingProblemSubmitedSolutionService {
	
	@Autowired
	private GuestCodingProblemSubmitedSolutionRespository codingProblemSubmitedSolutionDao;
	
	@Override
	public String saveCodingProblemSolution(ConsultantsSubmittedCodeVO guestCodingProbSolutionVO){
		
		ConsultantsSubmittedCodeEntity entity=new ConsultantsSubmittedCodeEntity();
		BeanUtils.copyProperties(guestCodingProbSolutionVO, entity);
		
		CodingProblmesLinkEntity codingProblemLink=new CodingProblmesLinkEntity();
		if(guestCodingProbSolutionVO.getCodingProblmesLinkVO()!=null)
		BeanUtils.copyProperties(guestCodingProbSolutionVO.getCodingProblmesLinkVO(), codingProblemLink);
		entity.setCodingProblemLink(codingProblemLink);
		
		CodingProblemsEntity codingProblemsEntity=new CodingProblemsEntity();
		if(guestCodingProbSolutionVO.getCodingProblemsVO()!=null)
		BeanUtils.copyProperties(guestCodingProbSolutionVO.getCodingProblemsVO(), codingProblemsEntity);
		entity.setCodingProblemsEntity(codingProblemsEntity);
		
		ConsultantsSubmittedCodeEntity oentity=codingProblemSubmitedSolutionDao.save(entity);
		return oentity.getCid()+"";
	}
	
	
	
	@Override
	public List<ConsultantsSubmittedCodeVO> findCodingProblemSubmittedSolutionByEmail(String consultantid){
		List<ConsultantsSubmittedCodeVO> consultantsSubmittedCodeVOs=new ArrayList<ConsultantsSubmittedCodeVO>();
		List<ConsultantsSubmittedCodeEntity> codeEntities=new ArrayList<ConsultantsSubmittedCodeEntity>();
		if(consultantid.length()>0){
			codeEntities=codingProblemSubmitedSolutionDao.findByConsultantid(consultantid);
			for(ConsultantsSubmittedCodeEntity entity:codeEntities){
				ConsultantsSubmittedCodeVO consultantsSubmittedCodeVO=new ConsultantsSubmittedCodeVO();
				BeanUtils.copyProperties(entity, consultantsSubmittedCodeVO);
				CodingProblmesLinkVO codingProblmesLinkVO=new CodingProblmesLinkVO();
				if(entity.getCodingProblemLink()!=null) {
				 BeanUtils.copyProperties(entity.getCodingProblemLink(), codingProblmesLinkVO);
				}
				consultantsSubmittedCodeVO.setCodingProblmesLinkVO(codingProblmesLinkVO);
				CodingProblemsVO codingProblemsVO=new CodingProblemsVO();
				BeanUtils.copyProperties(entity.getCodingProblemsEntity(), codingProblemsVO);
				consultantsSubmittedCodeVO.setCodingProblemsVO(codingProblemsVO);
				consultantsSubmittedCodeVOs.add(consultantsSubmittedCodeVO);
			}
		}	
		else{
			Iterable<ConsultantsSubmittedCodeEntity> iterable=codingProblemSubmitedSolutionDao.findAll();
			 Iterator<ConsultantsSubmittedCodeEntity> iterator=iterable.iterator();
			while (iterator.hasNext()) {
				ConsultantsSubmittedCodeEntity entity=iterator.next();
				ConsultantsSubmittedCodeVO consultantsSubmittedCodeVO=new ConsultantsSubmittedCodeVO();
				BeanUtils.copyProperties(entity, consultantsSubmittedCodeVO);
				CodingProblmesLinkVO codingProblmesLinkVO=new CodingProblmesLinkVO();
				if(entity.getCodingProblemLink()!=null) {
					BeanUtils.copyProperties(entity.getCodingProblemLink(), codingProblmesLinkVO);
				}
				consultantsSubmittedCodeVO.setCodingProblmesLinkVO(codingProblmesLinkVO);
				
				CodingProblemsVO codingProblemsVO=new CodingProblemsVO();
				BeanUtils.copyProperties(entity.getCodingProblemsEntity(), codingProblemsVO);
				consultantsSubmittedCodeVO.setCodingProblemsVO(codingProblemsVO);
				consultantsSubmittedCodeVOs.add(consultantsSubmittedCodeVO);
			}
		}	
		return consultantsSubmittedCodeVOs;
	}
	
	@Override
	public ConsultantsSubmittedCodeVO findConsultantsSubmittedCodeById(long id){
		ConsultantsSubmittedCodeEntity entity=codingProblemSubmitedSolutionDao.findOne(id);
		ConsultantsSubmittedCodeVO consultantsSubmittedCodeVO=new ConsultantsSubmittedCodeVO();
		BeanUtils.copyProperties(entity, consultantsSubmittedCodeVO);
		return consultantsSubmittedCodeVO;
	}
	
}
