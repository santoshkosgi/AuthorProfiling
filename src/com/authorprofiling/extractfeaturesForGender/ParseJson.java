package com.authorprofiling.extractfeaturesForGender;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ParseJson {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public Hashtable<String,Integer> parseJson(String sourceFolder,ArrayList<String> fileArrayList) throws IOException, ParseException{
		Hashtable<String,Integer> featuresTable = new Hashtable<String, Integer>(100000,0.75f);
		int fileArraySize = fileArrayList.size();
		FileInputStream fis = new FileInputStream(new File(sourceFolder+fileArrayList.get(0)));
		int checkFIleisEmpty,temp;
		String filePath,title;
		JSONParser parser = new JSONParser();
		for(int i = 0; i<fileArraySize ;i++){
			filePath = fileArrayList.get(i);
			fis = new FileInputStream(new File(sourceFolder+filePath));  
			checkFIleisEmpty = fis.read();  
			if (checkFIleisEmpty != -1)  
			{
				Object obj = parser.parse(new FileReader(sourceFolder+filePath));
	 			JSONObject jsonObject = (JSONObject) obj;
	 			JSONArray msg = (JSONArray) jsonObject.get("annotations");
	 			Iterator<JSONObject> iterator = msg.iterator();
	 			while (iterator.hasNext()) {
	 				if((title=(String)iterator.next().get("title"))!=null)
					{
	 					if(featuresTable.containsKey(title)){
	 						temp = featuresTable.get(title);
	 						featuresTable.remove(title);
	 						featuresTable.put(title, ++temp);
	 					}
	 					else{
	 						featuresTable.put(title, 1);
	 					}
					}
	 			}
			}
			fis.close();
		}
		return featuresTable;
	}
	

}
