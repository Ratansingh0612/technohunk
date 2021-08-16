package com.techquiz.codings.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.techquiz.codings.dao.GuestCodingProblemLinksRepository;
import com.techquiz.codings.dao.entity.CodingProblmesLinkEntity;
import com.techquiz.codings.service.GuestCodingProblemLinksService;
import com.techquiz.codings.web.controller.vo.CodingProblmesLinkVO;

/**
 * 
 * @author nagendra.yadav
 *
 */
@Service("GuestCodingProblemLinksServiceImpl")
@Transactional
public class GuestCodingProblemLinksServiceImpl implements GuestCodingProblemLinksService {
	
	@Autowired
	private GuestCodingProblemLinksRepository codingProblemLinksRepository;

	@Override
	public String saveCodingProblemLink(CodingProblmesLinkVO codingProblmesLinkVO){
		CodingProblmesLinkEntity entity=new CodingProblmesLinkEntity();
		BeanUtils.copyProperties(codingProblmesLinkVO, entity);
		CodingProblmesLinkEntity dentity=codingProblemLinksRepository.save(entity);
		return dentity.getGid()+"";
	}
	
	@Override
	public String updateCodingProblemLinkStatus(long gid){
		CodingProblmesLinkEntity dentity=codingProblemLinksRepository.findOne(gid);
		dentity.setCodingStatus("FINISHED");
		codingProblemLinksRepository.save(dentity);
		return "success";
	}
	
	@Override
	public String updateCodingProblemLinkUserSessionId(long gid,String userSessionId){
		CodingProblmesLinkEntity dentity=codingProblemLinksRepository.findOne(gid);
		dentity.setUserSessionId(userSessionId);
		codingProblemLinksRepository.save(dentity);
		return "success";
	}
	
	@Override
	public CodingProblmesLinkVO findCodingLinkDetailsByCodingLink(String generatedCodeLink){
		CodingProblmesLinkVO codingProblmesLinkVO=new CodingProblmesLinkVO();
		List<CodingProblmesLinkEntity> codingProblmesLinkEntityList=codingProblemLinksRepository.findByGeneratedCodeLink(generatedCodeLink);
		if(codingProblmesLinkEntityList!=null && codingProblmesLinkEntityList.size()>0){
			BeanUtils.copyProperties(codingProblmesLinkEntityList.get(0), codingProblmesLinkVO);
		}
		return codingProblmesLinkVO;
	}
	
	@Override
	public List<CodingProblmesLinkVO> findCodingProblemWithSessionIDNull(){
		List<CodingProblmesLinkEntity> codingProblmesLinkEntityList=codingProblemLinksRepository.findCodingProblemWithSessionIDNull();
		List<CodingProblmesLinkVO> problmesLinkVOs=new ArrayList<CodingProblmesLinkVO>();
		for(CodingProblmesLinkEntity entity:codingProblmesLinkEntityList){
			CodingProblmesLinkVO codingProblmesLinkVO=new CodingProblmesLinkVO();
			BeanUtils.copyProperties(entity, codingProblmesLinkVO);
			problmesLinkVOs.add(codingProblmesLinkVO);
		}
		return problmesLinkVOs;
	}
	
	@Override
	public String deleteCodingProblemLinkWithGid(long gid){
		codingProblemLinksRepository.delete(gid);
		return "success";
	}
	
	
}
