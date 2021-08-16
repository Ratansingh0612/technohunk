package com;

import java.io.FileInputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;

public class ParsingMsWordDoc {
	
	public static void main(String[] args) {
		try {
		FileInputStream fileInputStream=new FileInputStream("Question.docx");
		XWPFDocument document = new XWPFDocument(fileInputStream);
         List<XWPFParagraph> paragraphs = document.getParagraphs();
         for (XWPFParagraph para : paragraphs) {
        	 List<XWPFPictureData> datas=para.getDocument().getAllPictures();
        	 for(XWPFPictureData xwpfPictureData:datas){
        		 
        		 System.out.println(xwpfPictureData.getFileName());
        		 System.out.println(xwpfPictureData.getData());
        	 }
             System.out.println(para.getText());
         }
         fileInputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}