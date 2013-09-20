package com.authorprofiling.extractfeaturesForAge;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

public class MaxOccurence{
//	static String sourcePath = "/home/santosh/Downloads/AP/Experiment1/index/Age/3.txt";
//	static String out10s = "/home/santosh/Downloads/AP/Experiment1/index/Age/10s.txt";
//	static String out20s = "/home/santosh/Downloads/AP/Experiment1/index/Age/20s.txt";
//	static String out30s = "/home/santosh/Downloads/AP/Experiment1/index/Age/30s.txt";
	public static void main(String[] argv) throws IOException{
//		MaxOccurence maxOccurence = new MaxOccurence();
//		maxOccurence.maxOccurence(sourcePath, out10s, out20s, out30s);
	}
	
	
	public void maxOccurence(String sourcePath,String out10s,String out20s,String out30s) throws IOException{
		InputStream    fis;
		BufferedReader br;
		Writer output1,output2,output3;
		fis = new FileInputStream(sourcePath);
		br = new BufferedReader(new InputStreamReader(fis));
		output1 = new BufferedWriter(new FileWriter(out10s, true));
		output2 = new BufferedWriter(new FileWriter(out20s, true));
		output3 = new BufferedWriter(new FileWriter(out30s, true));
		String line;
		while((line = br.readLine())!=null){
			double x = Double.parseDouble(line.split("\\|")[1].split("@")[0]);
			double y = Double.parseDouble(line.split("\\|")[1].split("@")[1]);
			double z = Double.parseDouble(line.split("\\|")[1].split("@")[2]);
			if(x>y && x>z){
				if(y==0.0 && z==0.0){
					output1.write(line.split("\\|")[0]+"|"+x+"\n");
				}
				else{
				output1.write(line.split("\\|")[0]+"|"+x/(y+z)+"\n");
				}
			}
			else if(y>z){
				if(x==0.0 && z == 0.0){
					output2.write(line.split("\\|")[0]+"|"+y+"\n");
				}
				else{
				output2.write(line.split("\\|")[0]+"|"+y/(x+z)+"\n");
				}
			}
			else {
				if(x==0.0 && y == 0.0){
					output3.write(line.split("\\|")[0]+"|"+z+"\n");
				}
				else{
				output3.write(line.split("\\|")[0]+"|"+z/(x+y)+"\n");
				}
			}		
		}
		br.close();
		output1.close();
		output2.close();
		output3.close();
		
	}
}