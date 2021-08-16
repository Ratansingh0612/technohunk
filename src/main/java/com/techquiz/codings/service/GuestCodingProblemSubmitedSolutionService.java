package com.techquiz.codings.service;

import java.util.List;

import com.techquiz.codings.web.controller.vo.ConsultantsSubmittedCodeVO;
import com.techquiz.codings.web.controller.vo.GuestCodingProbSolutionVO;

/**
 * 
 * @author nagendra
 *
 */

public interface GuestCodingProblemSubmitedSolutionService {
	public String saveCodingProblemSolution(ConsultantsSubmittedCodeVO guestCodingProbSolutionVO);
	public List<ConsultantsSubmittedCodeVO> findCodingProblemSubmittedSolutionByEmail(String consultantid);
	public ConsultantsSubmittedCodeVO findConsultantsSubmittedCodeById(long id);
}
