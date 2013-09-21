package com.authorprofiling.extractfeatureswordsForAge;


import java.io.IOException;


public class Main {
	static String sourcePath = "/home/santosh/Downloads/AP/Experiment1/index/Age/3.txt";
	static String sourcePathFor10s = "/home/santosh/Downloads/AP/Experiment1/index/Age/10s.txt";
	static String destFolderFor10s = "/home/santosh/Downloads/AP/Experiment1/index/Age/10s/";
	static String sourcePathFor20s = "/home/santosh/Downloads/AP/Experiment1/index/Age/20s.txt";
	static String destFolderFor20s = "/home/santosh/Downloads/AP/Experiment1/index/Age/20s/";
	static String sourcePathFor30s = "/home/santosh/Downloads/AP/Experiment1/index/Age/30s.txt";
	static String destFolderFor30s = "/home/santosh/Downloads/AP/Experiment1/index/Age/30s/";
	public static void main(String argv[]) throws IOException {
		
		MaxOccurence maxOccurence = new MaxOccurence();
		sortFeatures Sortfeatures =  new sortFeatures();
		maxOccurence.maxOccurence(sourcePath,sourcePathFor10s,sourcePathFor20s,sourcePathFor30s);
		Sortfeatures.SortFeatures(sourcePathFor10s,destFolderFor10s);
		Sortfeatures.SortFeatures(sourcePathFor20s,destFolderFor20s);
		Sortfeatures.SortFeatures(sourcePathFor30s,destFolderFor30s);
		MergeBasedOnFrequency mergeBasedOnFrequency = new MergeBasedOnFrequency();
		mergeBasedOnFrequency.mergeBasedOnFrequency(destFolderFor10s);
		mergeBasedOnFrequency.mergeBasedOnFrequency(destFolderFor20s);
		mergeBasedOnFrequency.mergeBasedOnFrequency(destFolderFor30s);
	}
}
