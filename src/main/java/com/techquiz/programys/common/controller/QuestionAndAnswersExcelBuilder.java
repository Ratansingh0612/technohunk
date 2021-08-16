package com.techquiz.programys.common.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.synergisitic.it.web.form.QuestionAndAnsTestDataVO;

public class QuestionAndAnswersExcelBuilder extends AbstractExcelView {
	 
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<QuestionAndAnsTestDataVO> listQuestionAndAnswers = (List<QuestionAndAnsTestDataVO>) model.get("listQuestionAndAnswers");
        if(listQuestionAndAnswers==null){
        	listQuestionAndAnswers=new ArrayList<QuestionAndAnsTestDataVO>();
        }
        String qbankName  = (String) model.get("qbankName");
        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("Questions Bank with Answers");
        sheet.setDefaultColumnWidth(30);
        // create style for header cells
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.ORANGE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);
         
        // create header row
        HSSFRow header = sheet.createRow(0);
        header.createCell(0).setCellValue("Technology");
        header.getCell(0).setCellStyle(style);
         
        header.createCell(1).setCellValue("Q. Bank Name");
        header.getCell(1).setCellStyle(style);
         
        header.createCell(2).setCellValue("Question Text");
        header.getCell(2).setCellStyle(style);
         
        header.createCell(3).setCellValue("Correct Option");
        header.getCell(3).setCellStyle(style);
         
        header.createCell(4).setCellValue("Option A");
        header.getCell(4).setCellStyle(style);
        
        header.createCell(5).setCellValue("Option B");
        header.getCell(5).setCellStyle(style);
        
        header.createCell(6).setCellValue("Option C");
        header.getCell(6).setCellStyle(style);
        
        header.createCell(7).setCellValue("Option D");
        header.getCell(7).setCellStyle(style);
        
        header.createCell(8).setCellValue("Option E");
        header.getCell(8).setCellStyle(style);
        
        header.createCell(9).setCellValue("Option F");
        header.getCell(9).setCellStyle(style);
        
        header.createCell(10).setCellValue("Option G");
        header.getCell(10).setCellStyle(style);
        
        header.createCell(11).setCellValue("Explaination");
        header.getCell(11).setCellStyle(style);
        
        header.createCell(12).setCellValue("Owner");
        header.getCell(12).setCellStyle(style);
         
        // create data rows
        int rowCount = 1;
         
        for (QuestionAndAnsTestDataVO questionAndAnswers : listQuestionAndAnswers) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            aRow.createCell(0).setCellValue(questionAndAnswers.getTechnology());
            aRow.createCell(1).setCellValue(qbankName);
            if(questionAndAnswers.getQuestionText()!=null && questionAndAnswers.getQuestionText().length()>0 && questionAndAnswers.getQuestionText().contains("MsoNormal")) {
            	String parseQuestionText= questionAndAnswers.getQuestionText().substring( questionAndAnswers.getQuestionText().indexOf(">")+1);
            	aRow.createCell(2).setCellValue(parseQuestionText);
            }else{
            	aRow.createCell(2).setCellValue(questionAndAnswers.getQuestionText());
            }
            aRow.createCell(3).setCellValue(findCurrectAnswerText(questionAndAnswers));
            aRow.createCell(4).setCellValue(questionAndAnswers.getAnswerText1());
            aRow.createCell(5).setCellValue(questionAndAnswers.getAnswerText2());
            aRow.createCell(6).setCellValue(questionAndAnswers.getAnswerText3());
            aRow.createCell(7).setCellValue(questionAndAnswers.getAnswerText4());
            aRow.createCell(8).setCellValue(questionAndAnswers.getAnswerText5());
            aRow.createCell(9).setCellValue(questionAndAnswers.getAnswerText6());
            aRow.createCell(10).setCellValue(questionAndAnswers.getAnswerText7());
            aRow.createCell(11).setCellValue(questionAndAnswers.getCorrectAnsDescription());
            aRow.createCell(12).setCellValue(questionAndAnswers.getDescription());
        }
    }
    
    private String findCurrectAnswerText(QuestionAndAnsTestDataVO questionAndAnsTestDataVO){
    	String correctAnswerText="";
    	if(questionAndAnsTestDataVO.getAnswerId1()!=null) {
    		  if(questionAndAnsTestDataVO.getAnswerId1().equals(questionAndAnsTestDataVO.getCorrectOption())){
    			  correctAnswerText="Option A";
    		  }
    	}
    	if(questionAndAnsTestDataVO.getAnswerId2()!=null) {
    		  if(questionAndAnsTestDataVO.getAnswerId2().equals(questionAndAnsTestDataVO.getCorrectOption())){
    			 // correctAnswerText=questionAndAnsTestDataVO.getAnswerText2();
    			  correctAnswerText="Option B";
    		  }
    	}
    	if(questionAndAnsTestDataVO.getAnswerId3()!=null) {
    		  if(questionAndAnsTestDataVO.getAnswerId3().equals(questionAndAnsTestDataVO.getCorrectOption())){
    			  //correctAnswerText=questionAndAnsTestDataVO.getAnswerText3();
    			  correctAnswerText="Option C";
    		  }
    	}
    	if(questionAndAnsTestDataVO.getAnswerId4()!=null) {
    		  if(questionAndAnsTestDataVO.getAnswerId4().equals(questionAndAnsTestDataVO.getCorrectOption())){
    			  //correctAnswerText=questionAndAnsTestDataVO.getAnswerText4();
    			  correctAnswerText="Option D";
    		  }
    	}
    	if(questionAndAnsTestDataVO.getAnswerId5()!=null) {
    		if(questionAndAnsTestDataVO.getAnswerId5().equals(questionAndAnsTestDataVO.getCorrectOption())){
  			  //correctAnswerText=questionAndAnsTestDataVO.getAnswerText5();
    			correctAnswerText="Option E";
  		  }
    	}
    	if(questionAndAnsTestDataVO.getAnswerId6()!=null) {
    		if(questionAndAnsTestDataVO.getAnswerId6().equals(questionAndAnsTestDataVO.getCorrectOption())){
    			 // correctAnswerText=questionAndAnsTestDataVO.getAnswerText6();
    			correctAnswerText="Option F";
    		}
    	}
    	if(questionAndAnsTestDataVO.getAnswerId7()!=null) {
    		if(questionAndAnsTestDataVO.getAnswerId7().equals(questionAndAnsTestDataVO.getCorrectOption())){
    			//correctAnswerText=questionAndAnsTestDataVO.getAnswerText7();
    			correctAnswerText="Option G";
    		}
    	}
    	return correctAnswerText;
    }
 
}