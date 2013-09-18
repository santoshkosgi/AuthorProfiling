package com.authorprofiling.createindex;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
 
public class ParseJSON {
     
	public static void main(String[] args) throws IOException {
		
		ParseJSON parseJSON = new ParseJSON();
		parseJSON.parse("/home/santosh/Downloads/AP/Experiment1/Entities/1/");
		MergerGender mergerGender = new MergerGender();
		MergerAge mergerAge = new MergerAge();
//		mergerAge.mergeAge("/home/santosh/Downloads/AP/sampleIndex/ageIndex/");
//		mergerGender.mergeGender("/home/santosh/Downloads/AP/sampleIndex/genderIndex/");
     }
     
     public void parse(String sourcePath){
    	
    	 JSONParser parser = new JSONParser();
    	 
 		try {
 			File folder = new File(sourcePath);
			File[] listOfFiles = folder.listFiles(); 
 			int len = listOfFiles.length;
 			String filePath,fileName;
 			ParseJSON parseJson = new ParseJSON();
 			CreateIndex createIndex = new CreateIndex();
 			FileInputStream fis = new FileInputStream(new File(listOfFiles[0].getAbsolutePath()));
 			String title;
 			int b;
 			for(int i = 0; i<len; i++){
				filePath = listOfFiles[i].getAbsolutePath();
				fileName = listOfFiles[i].getName();
				fis = new FileInputStream(new File(filePath));  
				b = fis.read();  
				if (b != -1)  
				{
				Object obj = parser.parse(new FileReader(filePath));
	 			JSONObject jsonObject = (JSONObject) obj;
	 			JSONArray msg = (JSONArray) jsonObject.get("annotations");
	 			Iterator<JSONObject> iterator = msg.iterator();
	 			while (iterator.hasNext()) {
	 				if((title=(String)iterator.next().get("title"))!=null)
					{
	 					createIndex.createIndex(title, parseJson.getGender(fileName), parseJson.getAge(fileName), i);
	 				}
	 			}
				}
				System.out.println(i);
				if((i+1)%1000 == 0){
		 			createIndex.print_age();
		 			createIndex.print_gender();
		 		}
	 			
 			}
 			fis.close();
 			createIndex.print_age();
 			createIndex.print_gender();
 			
 	 
 		} catch (FileNotFoundException e) {
 			e.printStackTrace();
 		} catch (IOException e) {
 			e.printStackTrace();
 		} catch (ParseException e) {
 			e.printStackTrace();
 		}

    	 
     }
     
     public String getGender(String fileName){
    	 
    	 String[] title = fileName.split("[_.]");
    	 if(title[title.length-2].compareToIgnoreCase("MALE") ==0){
    		 return "m";
    	 }
    	 else{
    		 return "f";
    	 }
     }
     
     public String getAge(String fileName){
    	 
    	 String[] title = fileName.split("[_.]");
    	 if(title[title.length-3].compareToIgnoreCase("10s") ==0){
    		 return "10s";
    	 }
    	 else if(title[title.length-3].compareToIgnoreCase("20s") ==0){
    		 return "20s";
    	 }
    	 else{
    		 return "30s";
    	 }
     }
}

