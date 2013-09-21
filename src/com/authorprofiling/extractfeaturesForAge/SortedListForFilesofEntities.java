package com.authorprofiling.extractfeaturesForAge;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class SortedListForFilesofEntities {

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
	
	public void createSortedListForFilesofEntities(String sourceFolderPath,String outputFile) throws IOException{
		File directory = new File(sourceFolderPath);
		File[] listOfFiles = directory.listFiles();
		int length = listOfFiles.length;
		Arrays.sort(listOfFiles);
		Writer output;
		output = new BufferedWriter(new FileWriter(outputFile, true));
		for (int i = 0; i < length; i++) {
			output.write((listOfFiles[i].getName()));
			output.write("\n");
		}
		output.close();
	}

}
