package com.techquiz.trainer.web.controller;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergisitic.it.report.model.CourseCoveredStatusKey;
import com.synergisitic.it.report.model.CourseCoveredStatusVO;
import com.synergisitic.it.util.DateUtils;
import com.techquiz.programys.common.service.IContentsService;

	@Controller
	public class ConsultantAssesmentReportController {
		
		@Autowired
		@Qualifier("ContentsService")
		private IContentsService contentsService;

	@RequestMapping(value="courseCoveredPercentageBarStatus",method=RequestMethod.GET)
	public void findAvgStudentAttInClass(HttpServletRequest request,HttpServletResponse response,Model model) throws MalformedURLException {
		String batchName=request.getParameter("batchId");
		Map<CourseCoveredStatusKey, List<CourseCoveredStatusVO>>  courseCoveredStatusMap=contentsService.findCourseCoveredStatusForBatch(batchName);
		response.setContentType("image/png");
		DefaultCategoryDataset  categoryDataset = new DefaultCategoryDataset();
	    Set<Map.Entry<CourseCoveredStatusKey,  List<CourseCoveredStatusVO>>> courseCoveredStatusSets=courseCoveredStatusMap.entrySet();
		for(Map.Entry<CourseCoveredStatusKey,  List<CourseCoveredStatusVO>> entry:courseCoveredStatusSets) {
				categoryDataset.setValue(entry.getKey().getTotalCoursePer(), entry.getKey().getConsultantId(),entry.getKey().getName());
		}
		JFreeChart chart = ChartFactory.createBarChart3D
                    ("Consultant Course  Covered Report.", // Title
                     "UserId",              // X-Axis label
                     "Consultant Course %",// Y-Axis label
                     categoryDataset,         // Dataset
                     PlotOrientation.VERTICAL,
                     true,                     // Show legend
                 true,
                 false
                   );
	chart.setTitle(
      		   new org.jfree.chart.title.TextTitle("Consultant Course  Covered Report",
       		       new java.awt.Font("SansSerif", java.awt.Font.BOLD, 14)
       		   ));
		
		 String imagePath=DateUtils.getImageContextPath(request);
        ImageIcon icon = new ImageIcon(new URL(imagePath+"nhbg.jpg"));
       Image image = icon.getImage();
	         chart.setBackgroundImage(image);
      chart.getCategoryPlot().setBackgroundPaint(Color.white);
         chart.getCategoryPlot().setRangeGridlinePaint(Color.black);
try {
	/*    final ChartRenderingInfo info = new ChartRenderingInfo
	                (new StandardEntityCollection());
                final File file1 = new File("../webapps/jspchart/web/barchart.png");
	                ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);*/
               
           	ChartUtilities.writeChartAsPNG(response.getOutputStream(), chart, 1220, 450);
	            } catch (Exception e) {
            	 e.printStackTrace();
	            }
		
	}
}
