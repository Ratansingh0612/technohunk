package com.techquiz.info.jdbc.dao;

import java.util.List;

import com.techquiz.info.jdbc.dao.entity.QuestionsBankEntity;
import com.techquiz.programys.common.vo.ExcelSheetData;


/**
 * 
 * @author Nagendra
 *
 */
public interface UploadRecordExcelDao {

	
	public String uploadQuestionBank(List<List<String>> rowdataList,ExcelSheetData excelSheetData);

	public List<QuestionsBankEntity> findQuestionsBankByUserid(String userid);

	public List<QuestionsBankEntity> findAllQuestionsBank();

}
