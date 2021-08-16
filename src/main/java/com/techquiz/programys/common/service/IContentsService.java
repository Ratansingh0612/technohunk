package com.techquiz.programys.common.service;

import java.util.List;
import java.util.Map;

import com.synergisitic.it.report.model.CourseCoveredStatusKey;
import com.synergisitic.it.report.model.CourseCoveredStatusVO;
import com.techquiz.trainer.web.controller.vo.CourseContentsDetailVO;

public interface IContentsService {

	public String addTopicsCourse(List<CourseContentsDetailVO> courseContentsDetailVOs);

	public Map<CourseCoveredStatusKey, List<CourseCoveredStatusVO>> findCourseCoveredStatusForBatch(
			String batchName);

}
