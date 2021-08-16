package com.techquiz.control.panel.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DynamicImageLoaderController {

	@GetMapping(value="/dimage")
    public void loadDynamicImage(@RequestParam("imagePath") String imageFileWithPath,HttpSession session,HttpServletResponse response){
   	// let's see if there's content therefffffggjjjjjjjjjkl.mmbcxzzaasdffghjklqwerttyuiopg
		response.setContentType("application/png");
		String afileName=session.getServletContext().getRealPath("/"+imageFileWithPath);
		ServletOutputStream servletOutputStream=null;
		try {
	      	Path path = Paths.get(afileName);
	       	byte[] data = Files.readAllBytes(path);
	       	if(data!=null && data.length>0){
	       		servletOutputStream=response.getOutputStream();
	       		servletOutputStream.write(data);
	       		servletOutputStream.flush();
	       	}
	   }catch (Exception e) {
		       e.printStackTrace();
	   } finally{
		   if(servletOutputStream!=null){
			   try {
				servletOutputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		   }
	   }
    }
}
