package com.authorprofiling.extractfeatureswordsForGender;


import java.io.IOException;

import com.authorprofiling.createindex.MergerGender;

public class Main {

	static String sourcePathForFemale = "/home/santoshkosgi/Desktop/index/Gender/female.txt";
	static String destFolderForFemale = "/home/santoshkosgi/Desktop/index/Gender/female/";
	static String sourcePathForMale = "/home/santoshkosgi/Desktop/index/Gender/male.txt";
	static String destFolderForMale = "/home/santoshkosgi/Desktop/index/Gender/male/";
	public static void main(String argv[]) throws IOException {
		
//		maxocuurence and sortfeatures should be called first
//		MergerGender mergerGender = new MergerGender();
//		mergerGender.mergeGender(outMale);
//		mergerGender.mergeGender(outFemale);
		MaxOccurence maxOccurence = new MaxOccurence();
		sortFeatures Sortfeatures =  new sortFeatures();
//		maxOccurence.maxOccurence();
		Sortfeatures.SortFeatures(sourcePathForFemale,destFolderForFemale);
		Sortfeatures.SortFeatures(sourcePathForMale,destFolderForMale);
		MergeBasedOnFrequency mergeBasedOnFrequency = new MergeBasedOnFrequency();
		mergeBasedOnFrequency.mergeBasedOnFrequency(destFolderForMale);
		mergeBasedOnFrequency.mergeBasedOnFrequency(destFolderForFemale);
	}
}
