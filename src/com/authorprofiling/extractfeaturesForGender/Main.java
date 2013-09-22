package com.authorprofiling.extractfeaturesForGender;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws IOException, ParseException {
		// TODO Auto-generated method stub
//		arguments to be passed
//		1. the path to the source folder of the entities 
//		2. the path to the sorted file list of the entities file
//		3. the destination path for the features file
//		4. the path to the feature word list 
//		String sourceFolderPath = "/home/santosh/Downloads/AP/Experiment1/Entities/1/";
//		String outputFile = "/home/santosh/Downloads/AP/Experiment1/Entities/1.txt";
		SortedListForFilesofEntities sortedListForFilesofEntities = new SortedListForFilesofEntities();
		sortedListForFilesofEntities.createSortedListForFilesofEntities(args[0],args[1]);
		ExtractFeatures extractFeatures = new ExtractFeatures();
		extractFeatures.extractFeatures(args[0], args[1], args[2], args[3]);
		
	}

}
