package com.techquiz.info.jdbc.service;

import java.util.List;

import com.synergisitic.it.web.form.QuestionsForm;
import com.techquiz.programys.common.controller.model.QuestionsBankForm;
import com.techquiz.programys.common.vo.ExcelSheetData;

/**
 * 
 * @author Nagendra
 *
 */
public interface UploadRecordExcelService {

	public String uploadQuestionBank(List<List<String>> rowdataList,ExcelSheetData excelSheetData);

	public List<QuestionsBankForm> findQuestionsBankByUserid(String userid);

	public List<QuestionsForm> findQuestionsInBankByTech(String qbankName, String userid);

	public List<QuestionsForm> findAllQuestionInByBankTechAndUserId(String qbankName, String userid, String techName);

	public List<QuestionsBankForm> findAllQuestionsBank();

}
