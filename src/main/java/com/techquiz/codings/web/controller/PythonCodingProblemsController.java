package com.techquiz.codings.web.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergisitic.it.navigation.CodingsNavigationPage;
import com.synergisitic.it.navigation.UserNavigationPage;
import com.techquiz.codings.service.CodingProblemsService;
import com.techquiz.codings.web.controller.vo.CodingProblemsVO;
import com.techquiz.codings.web.controller.vo.JavaCodeResponse;
import com.techquiz.codings.web.controller.vo.JavaCodeResponseWrapper;
import com.techquiz.codings.web.controller.vo.TestCasesVO;


/**
 * 
 * @author VC1
 *
 */
@Controller
@RequestMapping("/codings")
public class PythonCodingProblemsController {
	
	@Autowired
	private CodingProblemsService codingProblemsService;
	
	@Value("${coding.problem.pageSize}")
	private int pageSize;
	
	@Value("${app.base.url}")
	private String appBaseUrl;
	
	private byte[] loadMasterMainMethod(){
		String masterCode="import java.io.File;"
		+"import java.io.FileInputStream;"
		+"import java.io.FileNotFoundException;"
		+"import java.io.FileWriter;"
		+"import java.io.PrintStream;"
		+"import java.io.PrintWriter;"
		+""
		+"public class DataLoader {"
		+"public static void main(String[] args) throws Exception {"
				 +"FileInputStream fileInputStream;"
					+"try {"
						+"fileInputStream = new FileInputStream(args[0]);"
						+"System.setIn(fileInputStream);"
						+"PrintStream output = new PrintStream(new File(args[1]));"
				        +"PrintStream console = System.out;"
						+"System.setOut(output);"
					+"} catch (FileNotFoundException e) {"
						 +"e.printStackTrace();"
					+"}  "
					+"Main.main(args);"
			 +"}"
		+"}";
		return masterCode.getBytes();
	}
	

	 private static String cprintLines(InputStream ins) throws Exception {
	    	StringBuilder builder=new StringBuilder();
	        String line = null;
	        BufferedReader in = new BufferedReader(
	            new InputStreamReader(ins));
	        while ((line = in.readLine()) != null) {
	            System.out.println(line);
	            builder.append(line+"\n");
	        }
	        return builder.toString();
	      }

	      private static String   crunProcess(String command) throws Exception {
	        Process pro = Runtime.getRuntime().exec(command);
	        String output="no";
	        try {
	         output=printLines(pro.getInputStream());
	        if(output==null ||  output.length()==0){
	        	output=printLines(pro.getErrorStream());
	        }
	        pro.waitFor();
	        System.out.println(command + " exitValue() " + pro.exitValue());
	        }catch(Exception e){
	        	System.out.println("@@(@(@(");
	        	e.printStackTrace();
	        }
	        return output;
	      }
	
	      
	      /**
	  	 * 
	  	 * @param model
	  	 * @return
	  	 */
	  	@PostMapping("/java/compile-code")
	  	@ResponseBody public synchronized JavaCodeResponse compileCodeOnline(Model model,@RequestParam("javacode") String javacode,@RequestParam("cpid") int cpid,HttpSession session){
	  		System.out.println("javacode");
	  		System.out.println(javacode);
	  		System.out.println("cpid = "+cpid);
	  		//Writing input into input.txt
	  		String generatedOutput="NA";
	  		String codeOutput="";
	  		 try {
	  			 
	  			 	System.out.println("nagendra- "+Paths.get("Main.java"));
	  	            Files.write(Paths.get("Main.java"), javacode.getBytes());
	  	            System.out.println("**********");
	  	        	//String afileName=session.getServletContext().getRealPath("/helper/dataloader.java");
	      	      	///Path path = Paths.get(afileName);
	      	       //	byte[] data = Files.readAllBytes(path);
	  	            byte[] data=loadMasterMainMethod();
	      	       	Files.write(Paths.get("DataLoader.java"), data);
	      	        System.out.println("**********");
	      	        String image="<img src=\""+appBaseUrl+"/images/codings/success-compile-error.png\" style=\"height: 35px;\">&nbsp;";
	      	        codeOutput=crunProcess("javac -d . -cp . Main.java DataLoader.java");
	      	       
	      	        if(codeOutput==null || codeOutput.length()==0){
	      	        	codeOutput="Cool! Your code has been compiled successfully!";
	      	        	codeOutput="<span style=\"color:green;\">"+codeOutput+"</span>";
	      	        	image="<img src=\""+appBaseUrl+"/images/codings/success-error.png\" style=\"height: 35px;\">&nbsp;";
	      	        }else{
	      	        	codeOutput="<span style=\"color:red;\">"+codeOutput+"</span>";
	      	        }
	      	        System.out.println(codeOutput);
	      	      codeOutput=image+codeOutput;
	  	        } catch (Exception e) {
	  	            e.printStackTrace();
	  	        }
	  		
	  		JavaCodeResponse codeResponse=new JavaCodeResponse();
	  		codeResponse.setInput("");
	  		codeResponse.setOutput(generatedOutput);
	  		codeResponse.setStatus("success");
	  		codeResponse.setDescription(codeOutput);
	  		System.out.println("_________________________");
	  		System.out.println(codeResponse);
	  		System.out.println("_________________________");
	  		return codeResponse;
	  	}    
	      

		/**
		 * 
		 * @param model
		 * @return
		 */
		@PostMapping("/java/compile-execute-with-nocustominput")
		@ResponseBody synchronized public JavaCodeResponse codingProblemsCompileExecuteWithNoCustomInput(Model model,@RequestParam("javacode") String javacode,@RequestParam("cpid") int cpid,HttpSession session){
			System.out.println("javacode");
			System.out.println(javacode);
			System.out.println("cpid = "+cpid);
			//Writing input into input.txt
			String generatedOutput="NA";
			String codeOutput="";
			FileWriter fileWriter=null;
			FileReader fileReader=null;
			BufferedReader bufferedReader=null;
			 try {
				 	fileWriter=new FileWriter("input.txt");
				 	fileWriter.write("NA");
				 	fileWriter.flush();
				 	fileWriter.close();
				 	Thread.sleep(1000);
				 	System.out.println("nagendra- "+Paths.get("Main.java"));
		            Files.write(Paths.get("Main.java"), javacode.getBytes());
		            System.out.println("**********");
		        	//String afileName=session.getServletContext().getRealPath("/helper/dataloader.java");
	    	      	//Path path = Paths.get(afileName);
	    	       	//byte[] data = Files.readAllBytes(path);
		            byte[] data=loadMasterMainMethod();
	    	       	Files.write(Paths.get("DataLoader.java"), data);
	    	        System.out.println("**********");
	    	        String image="<img src=\""+appBaseUrl+"/images/codings/success-compile-error.png\" style=\"height: 35px;\">&nbsp;";
	    	        codeOutput=crunProcess("javac -d . -cp . Main.java DataLoader.java");
	    	        
	    	        if(codeOutput==null || codeOutput.length()==0){
	      	        	codeOutput="Cool! Your code has been compiled successfully!";
	      	        	codeOutput="<span style=\"color:green;\">"+codeOutput+"</span>";
	      	        	image="<img src=\""+appBaseUrl+"/images/codings/success-error.png\" style=\"height: 35px;\">&nbsp;Code Output is :=";
	      	        	codeOutput=crunProcess("java -cp .  DataLoader input.txt output.txt");
	      	        	 //Reading the output from the file generated by another program! 
		    			fileReader=new FileReader("output.txt");
		    			bufferedReader=new BufferedReader(fileReader);
		    			String line="";
		    			StringBuilder output=new StringBuilder();
		    			output.append("<hr/>");
		    			while((line=bufferedReader.readLine())!=null){
		    				output.append(line+"<br/>");
		    			}
		    			generatedOutput=output.toString();
		    			codeOutput=""+image+generatedOutput;
	      	        }else{
	      	        	codeOutput="<span style=\"color:red;\">"+codeOutput+"</span>";
	      	        	codeOutput=image+codeOutput;
	      	        }
	    	        System.out.println(codeOutput);
	    	       // codeOutput=image+codeOutput;
		        } catch (Exception e) {
		            e.printStackTrace();
		        }finally{
		        	try {
			        	if(bufferedReader!=null){
		    				bufferedReader.close();
		    			}
		    			if(fileReader!=null){
		    				fileReader.close();
		    			}if(fileWriter!=null){
		    				fileWriter.close();
		    			}
		        	}catch(Exception ex){
		        		ex.printStackTrace();
		        	}
		        }
			
			JavaCodeResponse codeResponse=new JavaCodeResponse();
			codeResponse.setInput("NA");
			codeResponse.setOutput(generatedOutput);
			codeResponse.setStatus("custom");
			codeResponse.setDescription(codeOutput);
			System.out.println("_________________________");
			System.out.println(codeResponse);
			System.out.println("_________________________");
			return codeResponse;
		}
	  	
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping("/java/compile-execute-with-custominput")
	@ResponseBody synchronized public JavaCodeResponse codingProblemsCompileExecuteWithCustomInput(Model model,@RequestParam("custominput") String custominput,@RequestParam("javacode") String javacode,@RequestParam("cpid") int cpid,HttpSession session){
		System.out.println("javacode");
		System.out.println(javacode);
		System.out.println("cpid = "+cpid);
		System.out.println("custominput = "+custominput);
		Date cdate=new Date();
		//Writing input into input.txt
		String generatedOutput="NA";
		String codeOutput="";
		String dinputfileName="";
		String doutputfileName="";
		FileWriter fileWriter=null;
		FileReader fileReader=null;
		BufferedReader bufferedReader=null;
		 try {
			 	long currentTimeStamp=cdate.getTime();
			 	dinputfileName="input_"+currentTimeStamp+".txt";
			 	fileWriter=new FileWriter(dinputfileName);
			 	fileWriter.write(custominput);
			 	fileWriter.flush();
			 	fileWriter.close();
			 	Thread.sleep(1000);
			 	System.out.println("nagendra- "+Paths.get("Main.java"));
	            Files.write(Paths.get("Main.java"), javacode.getBytes());
	            System.out.println("**********");
	            String image="<img src=\""+appBaseUrl+"/images/codings/success-compile-error.png\" style=\"height: 35px;\">&nbsp;";
	        	//String afileName=session.getServletContext().getRealPath("/helper/dataloader.java");
    	      	//Path path = Paths.get(afileName);
    	       	//byte[] data = Files.readAllBytes(path);
	            byte[] data=loadMasterMainMethod();
    	       	Files.write(Paths.get("DataLoader.java"), data);
    	        System.out.println("**********");
    	        codeOutput=crunProcess("javac -d . -cp . Main.java DataLoader.java");
    	        doutputfileName=	"output_"+currentTimeStamp+".txt";
    	        if(codeOutput==null || codeOutput.length()==0) {
    	        	codeOutput="Cool! Your code has been compiled successfully!";
      	        	codeOutput="<span style=\"color:green;\">"+codeOutput+"</span>";
      	        	image="<img src=\""+appBaseUrl+"/images/codings/success-error.png\" style=\"height: 35px;\">&nbsp;Code Output is :=";
      	        	String runCodeCommand="java -cp .  DataLoader "+dinputfileName+" " +doutputfileName;
    	            codeOutput=crunProcess(runCodeCommand);
    	         
    	        System.out.println(codeOutput);
    	      //Reading the output from the file generated by another program! 
    			fileReader=new FileReader(doutputfileName);
    			bufferedReader=new BufferedReader(fileReader);
    			String line="";
    			StringBuilder output=new StringBuilder();
    			output.append("<hr/>");
    			while((line=bufferedReader.readLine())!=null){
    				output.append(line+"<br/>");
    			}
    			generatedOutput=output.toString();
    			codeOutput=""+image+generatedOutput;
		 	  }else{
    	        	codeOutput="<span style=\"color:red;\">"+codeOutput+"</span>";
    	        	codeOutput=image+codeOutput;
    	        }
		 		  
	        } catch (Exception e) {
	            e.printStackTrace();
	        }finally{
		        	try {
			        	if(bufferedReader!=null){
		    				bufferedReader.close();
		    			}
		    			if(fileReader!=null){
		    				fileReader.close();
		    			}if(fileWriter!=null){
		    				fileWriter.close();
		    			}
		        	}catch(Exception ex){
		        		ex.printStackTrace();
		        	}
	        	//Deleting both the files!
	        	File difile=new File(dinputfileName);
	        	File dofile=new File(doutputfileName);
	        	boolean bi=difile.delete();
	        	System.out.println("------Input coding file is deleted = "+bi);
	        	boolean bo=dofile.delete();
	        	System.out.println("------Output coding file is deleted = "+bo);
	        	
	        	
	        }
		
		JavaCodeResponse codeResponse=new JavaCodeResponse();
		codeResponse.setInput(custominput);
		codeResponse.setOutput(generatedOutput);
		codeResponse.setStatus("custom");
		codeResponse.setDescription(codeOutput);
		System.out.println("_________________________");
		System.out.println(codeResponse);
		System.out.println("_________________________");
		return codeResponse;
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping("/java/compile-execute-all-tests")
	@ResponseBody synchronized public JavaCodeResponseWrapper codingProblemsCompileExecute(Model model,@RequestParam("javacode") String javacode,@RequestParam("cpid") int cpid){
		List<JavaCodeResponse> testCasesResponse=new ArrayList<JavaCodeResponse>();
		JavaCodeResponseWrapper javaCodeResponseWrapper=new JavaCodeResponseWrapper();
		System.out.println("javacode");
		System.out.println(javacode);
		System.out.println("cpid = "+cpid);
		String codeOutput="";
		int totalTestCasePassed=0;
		int totalTestCaseFailed=0;
		 try {
	            Files.write(Paths.get("Main.java"), javacode.getBytes());
	            System.out.println("**********");
	            codeOutput=crunProcess("javac -cp . Main.java");
	            if(codeOutput!=null && codeOutput.trim().length()>0) { //means this programs cotains compilation error!
	            	javaCodeResponseWrapper.setStatus("fail");
	            	javaCodeResponseWrapper.setComment(codeOutput);
		        }
	            //Loading the problem details....
	            CodingProblemsVO codingProblemsVO=codingProblemsService.findCodingProblemsByProbId(cpid);
	            String mainClassName=codingProblemsVO.getMainClassName();
	            //Loading the Main.class definition inside current JVM
		        //Loading the class definition
				File file = new File("."); 
				//convert the file to URL format
				URL url = file.toURI().toURL(); 
				URL[] urls = new URL[]{url}; 
	            //load this folder into Class loader
				ClassLoader cl = new URLClassLoader(urls); 
				/*Class  clazz = cl.loadClass("Main");*/
			    Class  clazz = cl.loadClass(mainClassName);
				//logging the loaded class informations
				System.out.println(clazz.getDeclaredMethods());
				Method[] methods=clazz.getDeclaredMethods();
				for(Method m:methods){
					System.out.println(m);
					System.out.println(m.getName());
				}
				//Executing all the test cases available inside the database
				// Class<?> params[] = new Class[obj.length];
				Class[] paramArgs = new Class[1];	
				//dealing with only one parameter
				String methodInputType=codingProblemsVO.getMethodInputType();
	
				//Class<?> params[] = new Class[1];
				if(methodInputType!=null && methodInputType.split("[, ]+").length>1){
					paramArgs = new Class[methodInputType.split("[, ]+").length];
					String[] inputTypeTokens=methodInputType.split("[, ]+");
					int i=0;
					for(String itoken:inputTypeTokens){
						if("String".equalsIgnoreCase(itoken)){
							paramArgs[i] = String.class;
						}else if("int".equalsIgnoreCase(itoken)){
							paramArgs[i] = Integer.TYPE;
						}else if("long".equalsIgnoreCase(itoken)){
							paramArgs[i] = Long.TYPE;
						}else if("float".equalsIgnoreCase(itoken)){
							paramArgs[i] = Float.TYPE;
						}else if("double".equalsIgnoreCase(itoken)){
							paramArgs[i] = Double.TYPE;
						}else if("char".equalsIgnoreCase(itoken)){
							paramArgs[i] = Character.TYPE;
						}else if("int[]".equalsIgnoreCase(itoken)){
							paramArgs[i] = int[].class;
						}else if("String[]".equalsIgnoreCase(itoken)){
							paramArgs[i] = String[].class;
						}else if("float[]".equalsIgnoreCase(itoken)){
							paramArgs[i] = float[].class;
						}else if("double[]".equalsIgnoreCase(itoken)){
							paramArgs[i] = double[].class;
						}
						i++;
					}
					methodInputType="MI";//When input is more than one parameters
				}
				else if("int".equalsIgnoreCase(methodInputType)){
					paramArgs[0] = Integer.TYPE;	
				}else if("long".equalsIgnoreCase(methodInputType)){
					paramArgs[0] = Long.TYPE;
				}else if("String".equalsIgnoreCase(methodInputType)){
					paramArgs[0] = String.class;	
				}else if("float".equalsIgnoreCase(methodInputType)){
					paramArgs[0] = Float.TYPE;	
				}
				else if("double".equalsIgnoreCase(methodInputType)){
					paramArgs[0] = Double.TYPE;	
				}else if("String[]".equalsIgnoreCase(methodInputType)){
					paramArgs[0] = String[].class;	
				}else if("int[]".equalsIgnoreCase(methodInputType)){
					paramArgs[0] = int[].class;	
				}else if("double[]".equalsIgnoreCase(methodInputType)){
					paramArgs[0] = double[].class;	
				}else if("float[]".equalsIgnoreCase(methodInputType)){
					paramArgs[0] = float[].class;	
				}
				
				Method method = clazz.getDeclaredMethod(codingProblemsVO.getSubMethodName(), paramArgs);
				method.setAccessible(true);
				List<TestCasesVO> testCasesVOs=codingProblemsVO.getTestCasesVOs();
				for(TestCasesVO x:testCasesVOs){
					Object output=null;
					if("int".equalsIgnoreCase(methodInputType)){
						output = (Object)method.invoke(null, Integer.parseInt(x.getExpectedInput().trim()));
					}else if("long".equalsIgnoreCase(methodInputType)){
						output = (Object)method.invoke(null, Long.parseLong(x.getExpectedInput().trim()));
					}else if("String".equalsIgnoreCase(methodInputType)){
						output = (Object)method.invoke(null, x.getExpectedInput().trim());
					}else if("float".equalsIgnoreCase(methodInputType)){
						output = (Object)method.invoke(null, Float.parseFloat(x.getExpectedInput().trim()));
					}else if("double".equalsIgnoreCase(methodInputType)){
						output = (Object)method.invoke(null, Double.parseDouble(x.getExpectedInput().trim()));
					}else if("String[]".equalsIgnoreCase(methodInputType)){
						String expectedInput=x.getExpectedInput();
						if(expectedInput!=null){
							String tokens[]=expectedInput.split("[, ]+");
							output = (Object)method.invoke(null, new Object[] { tokens });
						}
					}else if("int[]".equalsIgnoreCase(methodInputType)){
						String expectedInput=x.getExpectedInput();
						if(expectedInput!=null){
							String tokens[]=expectedInput.split("[, ]+");
							int intarr[]=new int[tokens.length];
							int i=0;
							for(String t:tokens){
								intarr[i++]=Integer.parseInt(t);
							}
							output = (Object)method.invoke(null, new Object[] { intarr });
						}
					}else if("double[]".equalsIgnoreCase(methodInputType)){
						String expectedInput=x.getExpectedInput();
						if(expectedInput!=null){
							String tokens[]=expectedInput.split("[, ]+");
							double doublearr[]=new double[tokens.length];
							int i=0;
							for(String t:tokens){
								doublearr[i++]=Double.parseDouble(t);
							}
							output = (Object)method.invoke(null, new Object[] { doublearr });
						}
					}else if("float[]".equalsIgnoreCase(methodInputType)){
						String expectedInput=x.getExpectedInput();
						if(expectedInput!=null){
							String tokens[]=expectedInput.split("[, ]+");
							float floatarr[]=new float[tokens.length];
							int i=0;
							for(String t:tokens){
								floatarr[i++]=Float.parseFloat(t);
							}
							output = (Object)method.invoke(null, new Object[] { floatarr });
						}
					}else if("MI".equalsIgnoreCase(methodInputType)){
							Object[] customExpectedInput ={};
							String expectedInput=x.getExpectedInput();
							//SPECIAL CODE TO HANDLE more than one array as a parameter
							//then both the inputs are separated by triple ###
							String expectedInputDatas[]={};
							boolean whenOnePlusArrayInput=false;
							if(expectedInput.contains("###")){
								 expectedInputDatas=expectedInput.split("###");
								 whenOnePlusArrayInput=true;
							}else{
								expectedInputDatas=expectedInput.split("[, ]+");
							}
							String cmethodInputType=codingProblemsVO.getMethodInputType();
							String[] inputTypeTokens=cmethodInputType.split("[, ]+");
							customExpectedInput=new Object[inputTypeTokens.length];
							int i=0;
							int arraycount=0;
							//below code is modified on 16-JAN-2019
							//argBeforeArray is introduce in order to handle
							//the use case = datatype,datatype,array
							//where datatype,array was already implemented
							int argBeforeArray=0;
							for(String itoken:inputTypeTokens){
								//new code @ 15-JAN-2019
								//to deal with two or more array as an input
								if(whenOnePlusArrayInput){
										String arrayInput=expectedInputDatas[arraycount];
										String arrayInputTokens[]=arrayInput.split("[, ]+");
										
										if("int[]".equalsIgnoreCase(itoken)){
											int[] intarr=new int[arrayInputTokens.length];
											for(int dv=0;dv<arrayInputTokens.length;dv++){
												intarr[dv]=Integer.parseInt(arrayInputTokens[dv]);
											}
											customExpectedInput[i] = intarr;
									 	}else if("String[]".equalsIgnoreCase(itoken)){
											String[] stringarr=new String[arrayInputTokens.length];
											for(int dv=0;dv<arrayInputTokens.length;dv++){
												stringarr[dv]=arrayInputTokens[dv];
											}
											customExpectedInput[i] = stringarr;
										}else if("float[]".equalsIgnoreCase(itoken)){
											float[] floatarr=new float[arrayInputTokens.length];
											for(int dv=0;dv<arrayInputTokens.length;dv++){
												floatarr[dv]=Float.parseFloat(arrayInputTokens[dv]);
											}
											customExpectedInput[i] = floatarr;
										}else if("double[]".equalsIgnoreCase(itoken)){
											double[] doublearr=new double[arrayInputTokens.length];
											for(int dv=0;dv<arrayInputTokens.length;dv++){
												doublearr[dv]=Double.parseDouble(arrayInputTokens[dv]);
											}
											customExpectedInput[i] = doublearr;
										}
										arraycount++;
								}else {
										    //Old code when more than one array was not input for the coding exercise
											if("String".equalsIgnoreCase(itoken)){
												customExpectedInput[i] =expectedInputDatas[i];
												argBeforeArray++;
											}else if("int".equalsIgnoreCase(itoken)){
												customExpectedInput[i] =Integer.parseInt(expectedInputDatas[i]);
												argBeforeArray++;
											}else if("long".equalsIgnoreCase(itoken)){
												customExpectedInput[i] =Long.parseLong(expectedInputDatas[i]);
												argBeforeArray++;
											}else if("float".equalsIgnoreCase(itoken)){
												customExpectedInput[i] =Float.parseFloat(expectedInputDatas[i]);
												argBeforeArray++;
											}else if("double".equalsIgnoreCase(itoken)){
												customExpectedInput[i] =Double.parseDouble(expectedInputDatas[i]);
												 argBeforeArray++;
											}else if("int[]".equalsIgnoreCase(itoken)){
												//below code is modified on 16-JAN-2019
												//When input format is int,int,array
												//where array will be always last elements
												int[] intarr=new int[expectedInputDatas.length-argBeforeArray];
												for(int d=argBeforeArray,row=0;d<expectedInputDatas.length;d++,row++){
													intarr[row]=Integer.parseInt(expectedInputDatas[d]);
												}
												customExpectedInput[i] = intarr;
												break;
											}else if("String[]".equalsIgnoreCase(itoken)){
												String[] stringarr=new String[expectedInputDatas.length-argBeforeArray];
												for(int d=argBeforeArray,row=0;d<expectedInputDatas.length;d++,row++){
													stringarr[row]=expectedInputDatas[d];
												}
												customExpectedInput[i] = stringarr;
												break;
											}else if("float[]".equalsIgnoreCase(itoken)){
												float[] floatarr=new float[expectedInputDatas.length-argBeforeArray];
												for(int d=argBeforeArray,row=0;d<expectedInputDatas.length;d++,row++){
													floatarr[row]=Float.parseFloat(expectedInputDatas[d]);
												}
												customExpectedInput[i] = floatarr;
												break;
											}else if("double[]".equalsIgnoreCase(itoken)){
												double[] doublearr=new double[expectedInputDatas.length-argBeforeArray];
												for(int d=argBeforeArray,row=0;d<expectedInputDatas.length;d++,row++){
													doublearr[row]=Double.parseDouble(expectedInputDatas[d]);
												}
												customExpectedInput[i] = doublearr;
												break;
											}
											i++;
										}
							}//end of the for loop.................
							
							output = (Object)method.invoke(null, customExpectedInput);
					}
					//				
					JavaCodeResponse codeResponse=new JavaCodeResponse();
					codeResponse.setInput(x.getExpectedInput());
					codeResponse.setJunitResult(output!=null?output.toString():null);
					codeResponse.setOutput(x.getExpectedOutput()+"");
					if(output!=null && output.toString().trim().equalsIgnoreCase(x.getExpectedOutput().trim())){
						codeResponse.setStatus("pass");	
						totalTestCasePassed++;
					}else {
						codeResponse.setStatus("fail");
						totalTestCaseFailed++;
					}
					testCasesResponse.add(codeResponse);
				}
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        
		System.out.println("_________________________");
		System.out.println(javaCodeResponseWrapper);
		javaCodeResponseWrapper.setJavaCodeResponseList(testCasesResponse);
		javaCodeResponseWrapper.setTotalTestCaseFailed(totalTestCaseFailed);
		javaCodeResponseWrapper.setTotalTestCasePassed(totalTestCasePassed);
		System.out.println("_________________________");
		return javaCodeResponseWrapper;
	}
	
	/**
	 * 
	 * @param code
	 * @return
	 * @throws IOException 
	 */
	private String compileAndExecuteCode(String javacode) throws IOException{
		Files.write(Paths.get("Main.java"), javacode.getBytes());
	    ProcessBuilder pbc = new ProcessBuilder("javac -cp . Main.java");
		String output = IOUtils.toString(pbc.start().getInputStream());
		String error = IOUtils.toString(pbc.start().getErrorStream());
		if(error!=null && error.length()>0){
			return error;
		}
		 ProcessBuilder pbr = new ProcessBuilder("java -cp .  Main Hi Nagendra");
	     output = IOUtils.toString(pbr.start().getInputStream());
	     error = IOUtils.toString(pbr.start().getErrorStream());
	     if(error!=null && error.length()>0){
				return error;
		 }
		return output;
	}
	

    private static String printLines(InputStream ins) throws Exception {
    	StringBuilder builder=new StringBuilder();
        String line = null;
        BufferedReader in = new BufferedReader(
            new InputStreamReader(ins));
        while ((line = in.readLine()) != null) {
            System.out.println(line);
            builder.append(line+"\n");
        }
        return builder.toString();
      }

      private String  runProcess(String command) throws Exception {
    	  
    	if(command.startsWith("java")) { 
    	FileInputStream fileInputStream=new FileInputStream(new File("E:/yesha/techquiz/codes/facts/inputs.txt"));  
    	System.setIn(fileInputStream);
    	}
        Process pro = Runtime.getRuntime().exec(command);
        String output="no";
        try {
         output=printLines(pro.getInputStream());
        if(output==null ||  output.length()==0){
        	output=printLines(pro.getErrorStream());
        }
        pro.waitFor();
        System.out.println(command + " exitValue() " + pro.exitValue());
        }catch(Exception e){
        	System.out.println("@@(@(@(");
        	e.printStackTrace();
        }
        return output;
      }



}
