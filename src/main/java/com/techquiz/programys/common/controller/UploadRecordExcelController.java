package com.techquiz.programys.common.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.synergisitic.it.navigation.CommonNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.service.TechnolgyCategoryService;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.util.ApplicationMessageConstant;
import com.synergisitic.it.web.form.QuestionAndAnswers;
import com.synergisitic.it.web.form.QuestionsForm;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.info.jdbc.service.UploadRecordExcelService;
import com.techquiz.programys.common.controller.model.QuestionsBankForm;
import com.techquiz.programys.common.vo.ExcelSheetData;

@Controller
/**
 * @author  nagendra.yadav
 */
public class UploadRecordExcelController {
	
	@Autowired
	@Qualifier("UploadRecordExcelServiceImpl")
	private UploadRecordExcelService uploadRecordExcelService;
	
	
	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(UploadRecordExcelController.class);
	
	@Autowired
	@Qualifier("TechnolgyCategoryServiceImpl")
	private TechnolgyCategoryService technolgyCategoryService;
	
	
	/**
	 * Method will display the form for upload the image.
	 * 
	 * @param model
	 * @return name of view to be rendered for uploading the image
	 * @Override protected Object formBackingObject(HttpServletRequest request)
	 */
	@RequestMapping(value = "questions-bank", method = RequestMethod.GET)
	public String showQuetionsBank(Model model,HttpSession session) {
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		List<QuestionsBankForm> questionsBankFormList=uploadRecordExcelService.findQuestionsBankByUserid(userId.getLoginId());
		if(questionsBankFormList==null || questionsBankFormList.size()==0){
			model.addAttribute(ApplicationMessageConstant.APPLICATION_MESSAGE,
					ApplicationMessageConstant.SORRY_YOU_HAVE_NOT_CONFIGURED_ANY_QUESTION_BANK_SO_FAR);
			return CommonNavigationPage.COMMON_BASE + CommonNavigationPage.SUCCESS_STATUS_PAGE;
		}
		model.addAttribute("questionsBankFormList", questionsBankFormList);
		// Fetch data for all users.
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.QUESTIONS_BANK_PAGE;
	}
	
	
	@RequestMapping(value = "show-questions-in-bank", method = RequestMethod.GET)
	public String showQuetionsInBank(@RequestParam("qbankName") String qbankName,@RequestParam("techName") String techName,Model model,HttpSession session) {
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		List<QuestionsForm> questionsInBankList=uploadRecordExcelService.findQuestionsInBankByTech(qbankName,techName);
		model.addAttribute("questionsInBankList", questionsInBankList);
		// Fetch data for all users.
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.QUESTIONS_IN_BANK_PAGE;
	}

	/**
	 * Method will display the form for upload the image.
	 * 
	 * @param model
	 * @return name of view to be rendered for uploading the image
	 * @Override protected Object formBackingObject(HttpServletRequest request)
	 */
	@RequestMapping(value = "upload-questions-answers", method = RequestMethod.GET)
	public String uploadQuestionAnswers(Model model) {
		ExcelSheetData excelSheetData = new ExcelSheetData();
		model.addAttribute("excelSheetData", excelSheetData);
		List<com.synergisitic.it.web.form.Technology> technologies=technolgyCategoryService.findAllTechnolgy();
		model.addAttribute("technologies", technologies);
		// Fetch data for all users.
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.UPLOAD_QUESTIONS_ANSWERS_PAGE;
	}
	

	/**
	 * This will load the image at the server
	 * 
	 * @param sharedMedia
	 * @return
	 */

	@RequestMapping(value = "upload-questions-answers", method = RequestMethod.POST)
	public/* @ResponseBody JSONResponse */String onSubmit(
			HttpServletRequest request,
			@ModelAttribute("excelSheetData") ExcelSheetData excelSheetData,
			@RequestParam("fileData") MultipartFile file, Model model) {
		if (!file.isEmpty()) {
			excelSheetData.setFileName(file.getOriginalFilename());
			excelSheetData.setMediaPath(file.getName());
		}
		try {
			saveExcelSheetIntoFileSystem(request.getSession(),excelSheetData);
			String assignedUrl=assignUrlToExcelSheet(request,excelSheetData);
			excelSheetData.setAssignedUrl(assignedUrl);
			saveExcelRecordIntoDB(request.getSession(), excelSheetData);
			model.addAttribute("message",file.getOriginalFilename()+" excel question bank sheet is uploaded successfully to database and given URL.");
			model.addAttribute("url",assignedUrl);
			
			
		} catch (Exception e) {
			model.addAttribute("message",null);
			model.addAttribute("url",file.getOriginalFilename()+" is already uploaded into the database, please confirm.");
			e.printStackTrace();
		}
		List<com.synergisitic.it.web.form.Technology> technologies=technolgyCategoryService.findAllTechnolgy();
		model.addAttribute("technologies", technologies);
		return UserNavigationPage.TRAINER_BASE + UserNavigationPage.UPLOAD_QUESTIONS_ANSWERS_PAGE;
	}
	
	
	
	/**
	 * This method will assign a unique URL to uploaded image.
	 * @param request
	 * @param sharedMedia
	 * @return
	 *  assign URL to the uploaded image  
	 *  http://localhost:70707
	 */
	private String assignUrlToExcelSheet(HttpServletRequest request,ExcelSheetData excelSheetData){
		StringBuilder assignedUrl=new StringBuilder("http://");
		assignedUrl.append(request.getServerName()+":");
		assignedUrl.append(request.getServerPort());
		assignedUrl.append(request.getContextPath()+"/dexcel"+"/");
		assignedUrl.append("QB_"+new Date().getTime()+"_"+excelSheetData.getFileName());
		return assignedUrl.toString();
	}
	
	/**
	 * 
	 * @param session
	 * @param excelSheetData
	 * @throws IOException 
	 */
	private void saveExcelRecordIntoDB(HttpSession session,ExcelSheetData excelSheetData) throws IOException{
			String afileName=session.getServletContext().getRealPath("/dexcel/"+excelSheetData.getFileName());
			UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
			FileInputStream file = new FileInputStream(new File(afileName));
			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			List<List<String>> rowdataList=new ArrayList<List<String>>();
			int count=0;
			while (rowIterator.hasNext()) {
				List<String> rowdata=new ArrayList<String>(16);
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext())	{
					Cell cell = cellIterator.next();
					//Check the cell type and format accordingly
					switch (cell.getCellType())	{
						case Cell.CELL_TYPE_NUMERIC:
							String temp=cell.toString();
							if(temp!=null){
								temp=temp.trim();
							}
							if(temp.contains("/") || temp.contains("-")){
								rowdata.add(temp);
							}else {
								long ll=(long)cell.getNumericCellValue();
								//System.out.print("1."+ll + "\t");
								rowdata.add(ll+"");
							}
							break;
						case Cell.CELL_TYPE_STRING:
							//System.out.print(cell.getStringCellValue() + "\t");
							String cellValue=cell.getStringCellValue();
						    if(cellValue!=null){
						    	cellValue=cellValue.trim();
						    }
							rowdata.add(cellValue);
							break;
						default:
							//System.out.print("-----\t");
							//commented since it was adding blank!
							//rowdata.add("");
							break;	
					}
				}
				//Code to push the data into the database				
				if(count>0)
				rowdataList.add(rowdata);
				
				count++;
				System.out.println("");
				///reading only one row
				/*count++;
				if(count==2)
				break;*/
			}
			file.close();
			if(excelSheetData.getExcelSheetType().equalsIgnoreCase("QuestionBank")) {
				excelSheetData.setUserid(userId.getLoginId());
				uploadRecordExcelService.uploadQuestionBank(rowdataList,excelSheetData);
			}
			else if(excelSheetData.getExcelSheetType().equalsIgnoreCase("wwwwwwdata")) {
				//adminExcelSheetService.insertFacultyRecordExcelToDB(rowdataList);
			}
			else if(excelSheetData.getExcelSheetType().equalsIgnoreCase("techdata")) {
				//adminExcelSheetService.insertSubjectRecordExcelToDB(rowdataList);
			}else if(excelSheetData.getExcelSheetType().equalsIgnoreCase("assignsubwww")) {
				//adminExcelSheetService.insertAssignSubjectsRecordExcelToDB(rowdataList);
			}else if(excelSheetData.getExcelSheetType().equalsIgnoreCase("wwwww")) {
				//adminExcelSheetService.updateStudentsUPTURollExcelToDB(rowdataList);
			}
	}
	
	 /**
     * Method will persist image into the file system
     * using java io.
     * @param sharedMedia
     *  this is input data uploaded by client. 
     */
    private void saveExcelSheetIntoFileSystem(HttpSession session,ExcelSheetData excelSheetData){
   	// let's see if there's content therefffffggjjjjjjjjjkl.mmbcxzzaasdffghjklqwerttyuiopg
	        byte[] fileBytes = excelSheetData.getFileData();
	        BufferedOutputStream bos=null;
	        FileOutputStream fos=null;
	        String afileName=session.getServletContext().getRealPath("/dexcel/"+excelSheetData.getFileName());
	        try {
	        	File fileName=new File(afileName);
	        	fos= new FileOutputStream(fileName);
	        	bos = new BufferedOutputStream(fos);
	        	bos.write(fileBytes);
	        }catch (Exception e) {
		       e.printStackTrace();
	        } 
	        finally{
	        	if(bos!=null){
	        		try {
						bos.flush();
						bos.close();
						if(fos!=null)
						fos.close();
	        		} catch (IOException e) {
						e.printStackTrace();
					}
	        	}
	        }
	        if (fileBytes == null) {
	             // hmm, that's strange, the user did not upload anything
	        	
	        }

    }

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// to actually be able to convert Multipart instance to byte[]
		// we have to register a custom editor
		binder.registerCustomEditor(byte[].class,
				new ByteArrayMultipartFileEditor());
		// now Spring knows how to handle multipart object and convert them
	}

}
