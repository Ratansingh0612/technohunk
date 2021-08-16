package com.techquiz.control.panel.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.synergisitic.it.navigation.UserNavigationPage;
import com.synergisitic.it.util.ApplicationContant;
import com.synergisitic.it.web.form.UserId;
import com.techquiz.control.panel.controller.model.CompanyBusinessVO;
import com.techquiz.control.panel.controller.model.MainSliderVO;
import com.techquiz.control.panel.controller.model.PopularJavaInterviewVO;
import com.techquiz.control.panel.service.LandingPageService;

/**
 *
 * @author Nagendra
 *
 */
@Controller
public class LandingPageController {
	

	/**
     *Initiate Logger for this class
     */
	private static final Log logger = LogFactory.getLog(LandingPageController.class);
	
	@Autowired
	@Qualifier("LandingPageServiceImpl")
	private LandingPageService landingPageService;
	
	@RequestMapping("thome")
	public String techHomePage(Model model,HttpSession session){
		session.invalidate();
		List<MainSliderVO> mainSliderVOs=landingPageService.findSliderItems();
		model.addAttribute("sliderItems",mainSliderVOs);
		
		List<PopularJavaInterviewVO> popularJavaInterviewVOs=landingPageService.findPopularInterviewItems();
		model.addAttribute("popularJavaInterviewVOs",popularJavaInterviewVOs);
		
		List<CompanyBusinessVO> companyBusinessVOs=landingPageService.findCompanyBusinessItems();
		model.addAttribute("companyBusinessVOs",companyBusinessVOs);
		return UserNavigationPage.ADMIN_BASE + UserNavigationPage.MAIN_LANDING__PAGE;
	}
	
	
	
	@RequestMapping("edit-landing-page")
	public String editLandingPage(Model model){
		
		List<MainSliderVO> mainSliderVOs=landingPageService.findSliderItems();
		model.addAttribute("sliderItems",mainSliderVOs);
		
		List<PopularJavaInterviewVO> popularJavaInterviewVOs=landingPageService.findPopularInterviewItems();
		model.addAttribute("popularJavaInterviewVOs",popularJavaInterviewVOs);
		
		List<CompanyBusinessVO> companyBusinessVOs=landingPageService.findCompanyBusinessItems();
		model.addAttribute("companyBusinessVOs",companyBusinessVOs);
		
		return UserNavigationPage.ADMIN_BASE + UserNavigationPage.LANDING_PAGE__PAGE;
	}
	
	@PostMapping("edit-landing-page")
	public String editLandingPagePost(@ModelAttribute MainSliderVO mainSliderVO,HttpSession session,Model model){
		if(logger.isDebugEnabled()){
			logger.debug("editLandingPagePost method is called............");
		}
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		mainSliderVO.setUserid(userId.getLoginId());
		MainSliderVO umainSliderVO=landingPageService.updateSliderItems(mainSliderVO);
		if(mainSliderVO.getPsliderImage()!=null && mainSliderVO.getPsliderImage().length>10) {
			saveImageIntoFileSystem(session,mainSliderVO.getPsliderImage(),mainSliderVO.getSliderImage());
		}
		if(mainSliderVO.getPicon()!=null && mainSliderVO.getPicon().length>10){
			saveImageIntoFileSystem(session,mainSliderVO.getPicon(),mainSliderVO.getIcon());
		}
		if(logger.isDebugEnabled()){
			logger.debug(umainSliderVO);
		}
		return "redirect:/action/edit-landing-page";
	}
	
	@RequestMapping("find-main-slider")
	@ResponseBody public MainSliderVO findMainSliderVO(@RequestParam("lpid") int lpid,Model model){
		MainSliderVO mainSliderVO=landingPageService.findMainSliderVOById(lpid);
		return mainSliderVO;
	}
	
	
	@PostMapping("edit-pop-interviewq")
	public String editPopularJavaInterviewVO(@ModelAttribute PopularJavaInterviewVO popularJavaInterviewVO,HttpSession session,Model model){
		if(logger.isDebugEnabled()){
			logger.debug("editLandingPagePost method is called............");
		}
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		popularJavaInterviewVO.setUserid(userId.getLoginId());
		PopularJavaInterviewVO dpopularJavaInterviewVO=landingPageService.updatePopularJavaInterviewItem(popularJavaInterviewVO);
		if(popularJavaInterviewVO.getPimage()!=null && popularJavaInterviewVO.getPimage().length>10) {
			saveImageIntoFileSystem(session,popularJavaInterviewVO.getPimage(),popularJavaInterviewVO.getImage());
		}
		if(popularJavaInterviewVO.getPicon()!=null && popularJavaInterviewVO.getPicon().length>10){
			saveImageIntoFileSystem(session,popularJavaInterviewVO.getPicon(),popularJavaInterviewVO.getIcon());
		}
		if(logger.isDebugEnabled()){
			logger.debug(dpopularJavaInterviewVO);
		}
		return "redirect:/action/edit-landing-page";
	}
	
	@RequestMapping("ffind-popular-interview")
	@ResponseBody public PopularJavaInterviewVO findPopularInterviewItem(@RequestParam("pjiid") int pjiid,Model model){
		PopularJavaInterviewVO popularJavaInterviewVO=landingPageService.findPopularJavaInterviewEntityById(pjiid);
		return popularJavaInterviewVO;
	}
	
	@PostMapping("edit-company-business-info")
	public String editCompanyBusinessInfo(@ModelAttribute CompanyBusinessVO pcompanyBusinessVO,HttpSession session,Model model){
		if(logger.isDebugEnabled()){
			logger.debug("editCompanyBusinessInfo method is called............");
		}
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		pcompanyBusinessVO.setUserid(userId.getLoginId());
		CompanyBusinessVO dCompanyBusinessVO=landingPageService.updateCompanyBusiness(pcompanyBusinessVO);
		if(pcompanyBusinessVO.getPimage()!=null && pcompanyBusinessVO.getPimage().length>10) {
			saveImageIntoFileSystem(session,pcompanyBusinessVO.getPimage(),pcompanyBusinessVO.getImage());
		}
		if(logger.isDebugEnabled()){
			logger.debug(dCompanyBusinessVO);
		}
		return "redirect:/action/edit-landing-page";
	}
	
	@RequestMapping("find-company-business-info")
	@ResponseBody public CompanyBusinessVO findCompanyBusinessInfoItem(@RequestParam("cbid") int cbid,Model model){
		CompanyBusinessVO companyBusinessVO=landingPageService.findCompanyBusinessEntityById(cbid);
		return companyBusinessVO;
	}
	
	/**
	 *  this method will help to upload image to the server
	 * @param binder
	 */
	@InitBinder
    public void initBinder(WebDataBinder binder) {
             // to actually be able to convert Multipart instance to byte[]
             // we have to register a custom editor
             binder.registerCustomEditor(byte[].class,
                                new ByteArrayMultipartFileEditor());
             // now Spring knows how to handle multipart object and convert them
    }
	
	 /**
     * Method will persist image into the file system
     * using java io.
     * @param sharedMedia
     *  this is input data uploaded by client. 
     */
    private void saveImageIntoFileSystem(HttpSession session,final byte[] fileBytes,final String pfileName){
   	// let's see if there's content therefffffggjjjjjjjjjkl.mmbcxzzaasdffghjklqwerttyuiopg
	        BufferedOutputStream bos=null;
	        FileOutputStream fos=null;
	        String afileName=session.getServletContext().getRealPath("/"+pfileName);
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


}
