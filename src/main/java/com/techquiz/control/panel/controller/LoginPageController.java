package com.techquiz.control.panel.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
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
import com.techquiz.control.panel.controller.model.LoginSliderVO;
import com.techquiz.control.panel.controller.model.MainSliderVO;
import com.techquiz.control.panel.service.LoginPageControlService;

/**
 * This class is used to modify the login contents 
 * @author Nagendra
 * @since 19-may-2018
 *
 */
@Controller
public class LoginPageController {

	/**
     * Initiate Logger for this class...................
     */
	private static final Log logger = LogFactory.getLog(LoginPageController.class);
	
	@Autowired
	@Qualifier("LoginPageControlServiceImpl")
	private LoginPageControlService loginPageControlService;
	
	@RequestMapping("edit-login-page")
	public String editLoginPage(Model model,HttpSession session){
		if(logger.isDebugEnabled()){
			logger.debug("techHomePage is called......................");
		}
		List<LoginSliderVO> loginSliderVOs=loginPageControlService.findLoginPageContents();
		if(loginSliderVOs!=null && loginSliderVOs.size()>0)
		model.addAttribute("loginContentVO",loginSliderVOs.get(0));
		return UserNavigationPage.ADMIN_BASE + UserNavigationPage.LOGIN_LANDING__PAGE;
	}
	
	@PostMapping("edit-login-page")
	public String editLoginPagePost(@ModelAttribute LoginSliderVO loginSliderVO,HttpSession session,Model model){
		if(logger.isDebugEnabled()){
			logger.debug("editLandingPagePost method is called............");
		}
		UserId userId=(UserId)session.getAttribute(ApplicationContant.USER_SESSION_DATA);
		loginSliderVO.setUserid(userId.getLoginId());
		LoginSliderVO umainSliderVO=loginPageControlService.updateLoginPageItem(loginSliderVO);
		if(loginSliderVO.getPsliderImage()!=null && loginSliderVO.getPsliderImage().length>10) {
			saveImageIntoFileSystem(session,loginSliderVO.getPsliderImage(),loginSliderVO.getSliderImage());
		}
		if(logger.isDebugEnabled()){
			logger.debug(umainSliderVO);
		}
		return "redirect:/action/edit-login-page";
	}
	
	
	@RequestMapping("find-login-content")
    @ResponseBody	public LoginSliderVO findLoginContentByLpid(@RequestParam("lpid") int lpid) {
		LoginSliderVO loginSliderVO=loginPageControlService.findLoginPageVOById(lpid);
		 return loginSliderVO;
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
}
