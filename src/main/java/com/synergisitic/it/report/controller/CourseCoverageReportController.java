package com.synergisitic.it.report.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.report.model.CourseCoveredStatusKey;
import com.synergisitic.it.report.model.CourseCoveredStatusVO;
import com.techquiz.programys.common.service.IContentsService;

@Controller
public class CourseCoverageReportController {
	
	private static final Log logger = LogFactory.getLog(CourseCoverageReportController.class);

	@Autowired
	@Qualifier("ContentsService")
	private IContentsService contentsService;
	
	@RequestMapping(value = "findCourseCoverageForBatch", method = RequestMethod.GET)
	@ResponseBody public Map<CourseCoveredStatusKey, List<CourseCoveredStatusVO>> findCourseCoverageForBatch(@RequestParam("batchId") String batchName){
		Map<CourseCoveredStatusKey, List<CourseCoveredStatusVO>>  courseCoveredStatusMap=contentsService.findCourseCoveredStatusForBatch(batchName);
		System.out.println("courseCoveredStatusMap = "+courseCoveredStatusMap);
		return courseCoveredStatusMap;
	}
	
}
