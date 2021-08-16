package com.techquiz.trainer.web.rest.api;

import java.awt.Color;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergisitic.it.service.impl.UsererviceImpl;
import com.synergisitic.it.util.DateUtils;
import com.synergisitic.it.web.form.UserOnlineExamStatusForm;
import com.techquiz.trainer.service.IConsultantAssesmentService;

@Controller
@RequestMapping("/chart")
public class StudentReportBarCharController {
	
	@Autowired
	@Qualifier("ConsultantAssesmentService")
	private IConsultantAssesmentService consultantAssesmentService;
	
	@Autowired
	@Qualifier("usererviceImpl")
	private UsererviceImpl userService;
	
	@RequestMapping(value="/studentTestReportAsBarChart",method=RequestMethod.GET)
	public void studentTestReportAsBarChart(HttpServletRequest request,HttpServletResponse response,Model model) throws MalformedURLException {
		 String consultantId=request.getParameter("consultantId");	
		 response.setContentType("image/png");
		 List<UserOnlineExamStatusForm> userOnlineExamStatusList = userService.findAllUserOnlineExamStatus(consultantId);
		 DefaultCategoryDataset  categoryDataset =
			 new DefaultCategoryDataset();
			  
			         //<span class="IL_AD" id="IL_AD1">Enrollment</span> in Bachelors level
			        /* categoryDataset.setValue(2003, "Bachelors", "2005");
			         categoryDataset.setValue(1350, "Bachelors", "2006");
			         categoryDataset.setValue(2408, "Bachelors", "2007");
			         categoryDataset.setValue(2607, "Bachelors","2008");*/
			  
			         //Enrollment in <span class="IL_AD" id="IL_AD7">Masters</span> level
			        /* categoryDataset.setValue(985, "Masters", "2005");
			         categoryDataset.setValue(1400, "Masters", "2006");
			         categoryDataset.setValue(1634, "Masters", "2007");
			         categoryDataset.setValue(978, "Masters", "2008");*/
			  
			         //Enrollment in PhD level
		 			  DecimalFormat df = new DecimalFormat("##.##");
		 			  int count=1;
		 		      for(UserOnlineExamStatusForm examStatusForm:userOnlineExamStatusList){
		 		    	 float secureMarks=(float)examStatusForm.getSecureMarks();  
		 		    	 float percent=(float)secureMarks/examStatusForm.getTotalMarks();
		 				//double percent = (((double)*100) / examStatusForm.getSecureMarks());
		 				String formattedPercent = df.format(percent*100);
		 				System.out.println("----formattedPercent--- "+formattedPercent);
		 		        categoryDataset.setValue(Float.parseFloat(formattedPercent), examStatusForm.getTechName()+"-"+examStatusForm.getSecureMarks(),count+". "+ examStatusForm.getTestName());
		 		        count++;
		 		      }
			         JFreeChart chart = ChartFactory.createBarChart3D
			                      ("", // Title
			                       "Test Name",              // X-Axis label
			                       "Marks%",// Y-Axis label
			                       categoryDataset,         // Dataset
			                       PlotOrientation.VERTICAL,
			                       true,                     // Show legend
			                       true,
			                       false
			                      );
			         CategoryPlot plot = chart.getCategoryPlot();
			         BarRenderer render = (BarRenderer)plot.getRenderer();
			         render.setMaximumBarWidth(.4);
			         java.awt.Paint paint = new Color(249,150,250,255);
			         java.awt.Paint paint2 = new Color(0,150,250,255);
			         render.setSeriesPaint(0, paint); // color for "Finished" values
			         render.setSeriesPaint(1, paint2); // color for "Started" values
			        
			         String imagePath=DateUtils.getImageContextPath(request);
			         ImageIcon icon = new ImageIcon(new URL(imagePath+"nhbg.jpg"));
			         Image image = icon.getImage();
			         chart.setBackgroundImage(image);
			         chart.getCategoryPlot().setBackgroundPaint(Color.white);
			         chart.getCategoryPlot().setRangeGridlinePaint(Color.black);
			         try {
			               /* final ChartRenderingInfo info = new ChartRenderingInfo
			                (new StandardEntityCollection());
			                final File file1 = new File("../webapps/jspchart/web/barchart.png");
			                ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);
			               */ 
			            	ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 1170, 450);
			            } catch (Exception e) {
			            	 e.printStackTrace();
			            }
			  
	}	 
	
	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat("##.##");
		double percent = (((double)41) / 50)*100;
		String formattedPercent = df.format(percent);
		System.out.println(formattedPercent);
	}
}
