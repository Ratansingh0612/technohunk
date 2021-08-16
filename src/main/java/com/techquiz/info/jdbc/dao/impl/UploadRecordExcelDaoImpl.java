package com.techquiz.info.jdbc.dao.impl;

import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergisitic.it.dao.impl.QuestionAndAnswerDaoImpl;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.web.form.QuestionAndAnswers;
import com.techquiz.info.jdbc.dao.UploadRecordExcelDao;
import com.techquiz.info.jdbc.dao.entity.QuestionsBankEntity;
import com.techquiz.programys.common.vo.ExcelSheetData;


/**
 * 
 * @author Nagendra
 *
 */
@Repository("UploadRecordExcelDaoImpl")
@Scope("singleton")
@Transactional(propagation = Propagation.REQUIRED)
public class UploadRecordExcelDaoImpl   extends JdbcDaoSupport implements UploadRecordExcelDao{
	
	
	
	@Autowired
	@Qualifier("QuestionAndAnswerDaoImpl")
	private QuestionAndAnswerDaoImpl questionAndAnswerDao;
	
	
	@Autowired
	@Qualifier("javaTechDataSource-ds")
	public void intitJdbcTemplate(DataSource dataSource) {
		super.setDataSource(dataSource);
	}	
	
	
	/**
	 * 
	 * @return
	 */
	@Override
	public List<QuestionsBankEntity> findQuestionsBankByUserid(String userid){
		String query="select sno,qbankname,techName,noq,ownerName,excelSheetName,doe,url from questions_bank_tbl where ownerName=? or visibleAll='YES'";
		List<QuestionsBankEntity> questionsBankEntityList=super.getJdbcTemplate().query(query,new Object[]{userid},new BeanPropertyRowMapper(QuestionsBankEntity.class));
		return questionsBankEntityList;
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public List<QuestionsBankEntity> findAllQuestionsBank(){
		String query="select sno,qbankname,techName,noq,ownerName,excelSheetName,doe,url from questions_bank_tbl";
		List<QuestionsBankEntity> questionsBankEntityList=super.getJdbcTemplate().query(query,new BeanPropertyRowMapper(QuestionsBankEntity.class));
		return questionsBankEntityList;
	}
	
	/**
	 * logic to upload excel sheet data into the database
	 */
	@Override
	public String uploadQuestionBank(final List<List<String>> rowdataList,ExcelSheetData excelSheetData){
		System.out.println("***********************************************");
		System.out.println("-____))(*_____ "+rowdataList);
		//String findCurrentQuestionIndexNo="select max(currentIndex) from questionid_gen_tbl where techid="+excelSheetData.getTechid();	
		//String updateCurrentQuestionIndexNo="update questionid_gen_tbl set currentIndex=? where techid="+excelSheetData.getTechid();	
		
		//Integer currentIndex=getJdbcTemplate().queryForObject(findCurrentQuestionIndexNo,Integer.class);
		//String sqlQuery = "select tname from  technology_tbl where id="+excelSheetData.getTechid();
		//Integer tname=getJdbcTemplate().queryForObject(sqlQuery,String.class);
		
		int nqcount=0;
		String techname="";
		String ownerName="";
		for(List<String> rowdata: rowdataList){
			if(rowdata==null || rowdata.get(0).trim().length() == 0 ){
				break;
			}
			nqcount++;
			QuestionAndAnswers qa=new QuestionAndAnswers();
			qa.setCategory(rowdata.get(1));
			if(excelSheetData.getTechid()==null || excelSheetData.getTechid().length()==0)
			qa.setTechnology(rowdata.get(2));
			else
				qa.setTechnology(excelSheetData.getTechid());
			techname=qa.getTechnology();
			qa.setQuestionText(rowdata.get(3));
			qa.setQuestionComplexity(rowdata.get(4));
			qa.setQuestionType(rowdata.get(5));
			qa.setTopic(rowdata.get(6));
			qa.setLastModifyBy(excelSheetData.getUserid());
			qa.setCorrectAnsDescription(rowdata.get(7));
			if(rowdata.get(8)!=null && rowdata.get(8).length()>0){
				qa.setQuestionOwner(excelSheetData.getUserid());
				ownerName=excelSheetData.getUserid();
			}
			
			if(rowdata.get(9)!=null && rowdata.get(9).length()>0){
				qa.setAnswerText1(rowdata.get(9));
			}
			
			if(rowdata.get(10)!=null && rowdata.get(10).length()>0){
				qa.setAnswerText2(rowdata.get(10));
			}
			
			if(rowdata.size()>11 && rowdata.get(11)!=null && rowdata.get(11).length()>0){
				qa.setAnswerText3(rowdata.get(11));
			}
			
			if(rowdata.size()>12  && rowdata.get(12)!=null && rowdata.get(12).length()>0){
				qa.setAnswerText4(rowdata.get(12));
			}
			
			if(rowdata.size()>13 && rowdata.get(13)!=null && rowdata.get(13).length()>0){
				qa.setAnswerText5(rowdata.get(13));
			}
			
			if(rowdata.size()>14 &&rowdata.get(14)!=null && rowdata.get(14).length()>0){
				qa.setAnswerText6(rowdata.get(14));
			}
			
			if(rowdata.size()>15 && rowdata.get(15)!=null && rowdata.get(15).length()>0){
				qa.setAnswerText7(rowdata.get(15));
			}
			qa.setCorrect1("R");
			qa.setCorrect("R");
			qa.setDateOfEntry(new Date());
			qa.setDescription("New User!");
			qa.setQuestionType("Objective");
			//qa.setCategory("java");
			qa.setChoiceType("Single");
			qa.setMarks(1);
			//qa.setQuestionComplexity("Medium");
			qa.setNumberOfAnswers(1);
			qa.setLastModifyOn(new Date());
			qa.setQbankName(excelSheetData.getQuestionBankName());
			//Adding new qestions and answers
			questionAndAnswerDao.addQuestionAndAnswers(qa,false);
			
		}
		if(ownerName.length()==0){
			ownerName=excelSheetData.getUserid();
		}
		String insertQuestionBank="insert into questions_bank_tbl(qbankname,techName,noq,ownerName,excelSheetName,doe,url) values(?,?,?,?,?,?,?)";
		Object data[]=new Object[]{excelSheetData.getQuestionBankName(),techname,nqcount,ownerName,excelSheetData.getFileName(),DateUtils.getCurrentTimeIntoTimestamp(),excelSheetData.getAssignedUrl()};
		getJdbcTemplate().update(insertQuestionBank,data);
		return "done";
	}


}
