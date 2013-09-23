package com.authorprofiling.extractfeaturesForAge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

import org.json.simple.parser.ParseException;

public class ExtractFeatures {

	/**
	 * @param args
	 * @throws Throwable 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException, Throwable {
		// TODO Auto-generated method stub
		String sourceFolder = "/home/santosh/Downloads/AP/Experiment1/Entities/1/";
		String sourceFileList = "/home/santosh/Downloads/AP/Experiment1/Entities/temp.txt";
		String FeatureWordsPath = "/home/santosh/Downloads/AP/Experiment1/1k+1.5k/featureList.txt";
		String destPath = "/home/santosh/Downloads/AP/Experiment1/1k+1.5k/features.txt";
		ExtractFeatures extractFeatures = new ExtractFeatures();
		extractFeatures.extractFeatures(sourceFolder, sourceFileList, destPath,FeatureWordsPath);
	}
	
	public void extractFeatures(String sourceFolder,String sourceFileList, String destPath,String FeatureWordsPath) throws IOException, ParseException{
		
		BufferedReader br;
		FileInputStream fis = new FileInputStream(sourceFileList);
		br = new BufferedReader(new InputStreamReader(fis));
		String fileName = br.readLine();
		String prevFileName = fileName ; //assigning previous file name to new one
		ArrayList<String> fileArrayList =  new ArrayList<String>();
		fileArrayList.add(prevFileName);
		ParseJson parse = new ParseJson();
		Hashtable<String,Integer> featuresTable = new Hashtable<String, Integer>(100000,0.75f);
		ExtractFeatures extractFeatures = new ExtractFeatures();
		while((fileName = br.readLine())!=null){
			if(fileName.substring(0, fileName.indexOf("@")).compareTo(prevFileName.substring(0, prevFileName.indexOf("@")))==0){
				fileArrayList.add(fileName);
				prevFileName = fileName;
			}
			else {
				featuresTable = parse.parseJson(sourceFolder, fileArrayList);
				extractFeatures.extractFeaturesValues(destPath, prevFileName, featuresTable,FeatureWordsPath);
				featuresTable.clear();
				fileArrayList.clear();
				prevFileName = fileName;
				fileArrayList.add(prevFileName);
//				featurestable processing
			}
		}
		featuresTable = parse.parseJson(sourceFolder, fileArrayList);
		extractFeatures.extractFeaturesValues(destPath, prevFileName, featuresTable,FeatureWordsPath);
//		featurestable processing
		br.close();
	}

	public void extractFeaturesValues(String destPath,String prevFileName,Hashtable<String,Integer> featuresTable,String featureWordsPath) throws IOException{
		ExtractFeatures extractFeatures = new ExtractFeatures();
		HashMap<String,Integer> words = new HashMap<String,Integer>();
		TreeMap<Integer,Integer> featuresTreeForSVM = new TreeMap<Integer, Integer>();
		InputStream    fis;
		BufferedReader br;
		fis = new FileInputStream(featureWordsPath);
		br = new BufferedReader(new InputStreamReader(fis));
		String line;
		int c=1;
		Writer output;
		output = new BufferedWriter(new FileWriter(destPath, true));
		while((line = br.readLine())!=null){
			words.put(line.split("#")[0],c++);
		}
		br.close();
		int index;
		String SVMString = "";
		Set<String> set=new HashSet<String>();
		set.addAll(featuresTable.keySet());
		for (String s: set){
			if(words.containsKey(s)){
				index = words.get(s);
				featuresTreeForSVM.put(index,featuresTable.get(s));
			}
		}
		for(Entry<Integer, Integer> entry : featuresTreeForSVM.entrySet()) {
			SVMString = SVMString+" "+entry.getKey()+":"+entry.getValue();
		}
		System.out.println(prevFileName);
		output.write(extractFeatures.getAge(prevFileName)+SVMString);
		output.write("\n");
		output.close();
	}
	
	public String getAge(String fileName){
    	 
    	 String[] title = fileName.split("[_.]");
    	 if(title[title.length-3].compareToIgnoreCase("10s") ==0){
    		 return "one";
    	 }
    	 else if(title[title.length-3].compareToIgnoreCase("20s") ==0){
    		 return "two";
    	 }
    	 else{
    		 return "three";
    	 }
     }
}
