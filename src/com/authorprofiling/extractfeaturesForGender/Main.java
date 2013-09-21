package com.authorprofiling.extractfeaturesForGender;

import java.io.IOException;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		String sourceFolderPath = "/home/santosh/Downloads/AP/Experiment1/Entities/1/";
		String outputFile = "/home/santosh/Downloads/AP/Experiment1/Entities/1.txt";
		SortedListForFilesofEntities sortedListForFilesofEntities = new SortedListForFilesofEntities();
		sortedListForFilesofEntities.createSortedListForFilesofEntities(sourceFolderPath,outputFile);
		
	}

}
