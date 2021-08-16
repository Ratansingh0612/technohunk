package com.techquiz.codings.service;

import com.techquiz.codings.web.controller.vo.CodingProblemsVO;

/**
 * 
 * @author Nagendra
 * @since 14-Aug-2018
 *
 */
public interface TestCasesProblemService {

	public CodingProblemsVO addTestCaseForProblem(long cpid, String input, String output, String comment);

	public String deleteTestCaseForProblem(long cpid, String input, String output);

}
