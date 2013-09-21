package com.authorprofiling.preprocess;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class GetFileList {

	/**
	 * @author santosh
	 */
	static String sourceFolder = "/home/santoshkosgi/Downloads/pan_author_profiling_training_data/en/";
	static String outputFile = "/home/santoshkosgi/Downloads/AP/fileList.txt";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File directory = new File(sourceFolder);
		File[] listOfFiles = directory.listFiles();
		int length = listOfFiles.length;
		Writer output;
		output = new BufferedWriter(new FileWriter(outputFile, true));
		for (int i = 0; i < length; i++) {
			output.append(listOfFiles[i].getName()+"\n");
		}
		
		output.close();
	}

}
