package com.techquiz.codings.service;

import java.util.List;

import com.techquiz.codings.web.controller.vo.CodingProblmesLinkVO;

/**
 * 
 * @author nagendra
 * @Since 07-Aug-2018
 *
 */
public interface GuestCodingProblemLinksService {

	public String saveCodingProblemLink(CodingProblmesLinkVO codingProblmesLinkVO);
	public CodingProblmesLinkVO findCodingLinkDetailsByCodingLink(String generatedCodeLink);
	public String updateCodingProblemLinkStatus(long gid);
	public String updateCodingProblemLinkUserSessionId(long gid, String userSessionId);
	public List<CodingProblmesLinkVO> findCodingProblemWithSessionIDNull();
	public String deleteCodingProblemLinkWithGid(long gid);

}
