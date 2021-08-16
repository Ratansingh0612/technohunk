package com.techquiz.codings.service;

import java.util.List;

import com.techquiz.codings.web.controller.vo.CodingProblemsVO;

/**
 * 
 * @author VC1
 *
 */
public interface CodingProblemsService {

	public List<CodingProblemsVO> findCodingProblemsByTech(String techName);
	public CodingProblemsVO findCodingProblemsByProbId(long cpid);
	public CodingProblemsVO addCodingProblem(CodingProblemsVO codingProblemsVO);
	public List<CodingProblemsVO> findCodingProblemsByTech(String techName, int startIndex, int pageSize);
	public int totalCodingProblems();
	public List<CodingProblemsVO> findCodingProblemsByCategory(String categoryName);
	public List<CodingProblemsVO> findCodingProblemsByCategory(String categoryName, String level);
	public String updateCodingProblem(CodingProblemsVO codingProblemsVO);
	public List<CodingProblemsVO> findCodingProblemsByLevel(String level);

}
