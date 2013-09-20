package com.authorprofiling.extractfeaturesForGender;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;

public class MaxOccurence{
	static String sourcePath = "/home/santoshkosgi/Desktop/index/Gender/3.txt";
	static String outMale = "/home/santoshkosgi/Desktop/index/Gender/male.txt";
	static String outFemale = "/home/santoshkosgi/Desktop/index/Gender/female.txt";
	public static void main(String[] argv) throws IOException{
		InputStream    fis;
		BufferedReader br;
		Writer output1,output2;
		fis = new FileInputStream(sourcePath);
		br = new BufferedReader(new InputStreamReader(fis));
		output1 = new BufferedWriter(new FileWriter(outMale, true));
		output2 = new BufferedWriter(new FileWriter(outFemale, true));
		String line;
		while((line = br.readLine())!=null){
			double x = Double.parseDouble(line.split("\\|")[1].split("@")[0]);
			double y = Double.parseDouble(line.split("\\|")[1].split("@")[1]);
				if(x>y){
					if(y==0.0){
						output1.write(line.split("\\|")[0]+"|"+x+"\n");
					}
					else{
					output1.write(line.split("\\|")[0]+"|"+x/y+"\n");
					}
				}
				else{
					if(x==0.0){
						output2.write(line.split("\\|")[0]+"|"+y+"\n");
					}
					else{
					output2.write(line.split("\\|")[0]+"|"+y/x+"\n");
					}
				}			
		}
		br.close();
		output1.close();
		output2.close();
	}
	
	
	public void maxOccurence(String sourcePath,String outMale,String outFemale) throws IOException{
		InputStream    fis;
		BufferedReader br;
		Writer output1,output2;
		fis = new FileInputStream(sourcePath);
		br = new BufferedReader(new InputStreamReader(fis));
		output1 = new BufferedWriter(new FileWriter(outMale, true));
		output2 = new BufferedWriter(new FileWriter(outFemale, true));
		String line;
		while((line = br.readLine())!=null){
			double x = Double.parseDouble(line.split("\\|")[1].split("@")[0]);
			double y = Double.parseDouble(line.split("\\|")[1].split("@")[1]);
				if(x>y){
					if(y==0.0){
						output1.write(line.split("\\|")[0]+"|"+x+"\n");
					}
					else{
					output1.write(line.split("\\|")[0]+"|"+x/y+"\n");
					}
				}
				else{
					if(x==0.0){
						output2.write(line.split("\\|")[0]+"|"+y+"\n");
					}
					else{
					output2.write(line.split("\\|")[0]+"|"+y/x+"\n");
					}
				}			
		}
		br.close();
		output1.close();
		output2.close();
	}
}