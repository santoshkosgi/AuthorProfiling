package com.authorprofiling.createindex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
public class MergerGender{
	static String sourcPath = "/home/santosh/Downloads/AP/Experiment1/index/Gender/";
	public static void main(String argv[]) throws IOException{
		//InputStream is = new BufferedInputStream(new FileInputStream("/home/santoshkosgi/Downloads/Wiki/out2/1.txt"));
		MergerGender mergeGender = new MergerGender();
		mergeGender.mergeGender(sourcPath);
	}

	public void mergeGender(String sourcePath) throws IOException{
		InputStream    fis;
		BufferedReader br;
		InputStream    fis1;
		BufferedReader br1;
		String         line;
		String first,second;
		int first_check,second_check;
		
		while(true){
			
			File folder = new File(sourcePath);
			File[] listOfFiles = folder.listFiles(); 

			if(listOfFiles.length==1){
				break;
			}
			
			
			String firstPath,secondPath;
			System.out.println("number "+ listOfFiles.length);
			
			if(listOfFiles.length%2 == 0){ //if number of files are even
				for (int i = 0; i <listOfFiles.length; i=i+2) {
						second_check = 0;
						first_check = 0;
						System.out.println(i);
						firstPath = listOfFiles[i].getAbsolutePath();
						secondPath = listOfFiles[i+1].getAbsolutePath();
						fis = new FileInputStream(firstPath);
						br = new BufferedReader(new InputStreamReader(fis));
						fis1 = new FileInputStream(secondPath);
						br1 = new BufferedReader(new InputStreamReader(fis1));
						Writer output;
						output = new BufferedWriter(new FileWriter(sourcePath+"temp", true));
						first = br.readLine();
						second = br1.readLine();
						while(true){
							if(first.split("\\|")[0].compareTo(second.split("\\|")[0])<0){
								output.append(first+"\n");
								if((first=br.readLine())!=null)
								{
								}
								else{
									second_check = 1;
									break;
								}
							}
							else if(first.split("\\|")[0].compareTo(second.split("\\|")[0])>0){
								output.append(second+"\n");
								if((second=br1.readLine())!=null)
								{
								}
								else{
									first_check = 1;
									break;
								}
							}
							else if(first.split("\\|")[0].compareTo(second.split("\\|")[0])==0){
								String first_str = first.split("\\|")[1];
								String second_str = second.split("\\|")[1];
								int first_int = Integer.parseInt(first_str.split("@")[0])+Integer.parseInt(second_str.split("@")[0]);
								int second_int = Integer.parseInt(first_str.split("@")[1])+Integer.parseInt(second_str.split("@")[1]);
								output.append(first.split("\\|")[0]+"|"+first_int+"@"+second_int+"\n");
								first=br.readLine();
								second=br1.readLine();
								if((first==null && second==null))
								{
									break;
								}
								if((first)!=null)
								{
								}
								else{
									second_check = 1;
									break;
								}
								if((second)!=null)
								{
								}
								else{
									first_check = 1;
									break;
								}
							}
						}
						if(first_check == 1){
							output.append(first+"\n");
							while((line=br.readLine())!=null)
							{
								output.append(line+"\n");
							}
						}
						if(second_check == 1)
						{
							output.append(second+"\n");
							while((line=br1.readLine())!=null)
							{
								output.append(line+"\n");
							}
						}
						br.close();
						br1.close();
						
						output.close();
						File f1=new File(firstPath);
						f1.delete();
						File f2=new File(secondPath);
						f2.delete();
						File old = new File(sourcePath+"temp");
						File new1 = new File(firstPath);
						old.renameTo(new1);
					}
				
			}
			else{
				for (int i = 0; i <listOfFiles.length-1; i=i+2) {
						second_check = 0;
						first_check = 0;
						System.out.println(i);
						firstPath = listOfFiles[i].getAbsolutePath();
						secondPath = listOfFiles[i+1].getAbsolutePath();
						fis = new FileInputStream(firstPath);
						br = new BufferedReader(new InputStreamReader(fis));
						fis1 = new FileInputStream(secondPath);
						br1 = new BufferedReader(new InputStreamReader(fis1));
						Writer output;
						output = new BufferedWriter(new FileWriter(sourcePath+"temp", true));
						first = br.readLine();
						second = br1.readLine();
						while(true){
							if(first.split("\\|")[0].compareTo(second.split("\\|")[0])<0){
								output.append(first+"\n");
								if((first=br.readLine())!=null)
								{
								}
								else{
									second_check = 1;
									break;
								}
							}
							else if(first.split("\\|")[0].compareTo(second.split("\\|")[0])>0){
								output.append(second+"\n");
								if((second=br1.readLine())!=null)
								{
								}
								else{
									first_check = 1;
									break;
								}
							}
							else if(first.split("\\|")[0].compareTo(second.split("\\|")[0])==0){
								String first_str = first.split("\\|")[1];
								String second_str = second.split("\\|")[1];
								int first_int = Integer.parseInt(first_str.split("@")[0])+Integer.parseInt(second_str.split("@")[0]);
								int second_int = Integer.parseInt(first_str.split("@")[1])+Integer.parseInt(second_str.split("@")[1]);
								output.append(first.split("\\|")[0]+"|"+first_int+"@"+second_int+"\n");
								first=br.readLine();
								second=br1.readLine();
								if((first==null && second==null))
								{
									break;
								}
								if((first)!=null)
								{
								}
								else{
									second_check = 1;
									break;
								}
								if((second)!=null)
								{
								}
								else{
									first_check = 1;
									break;
								}
							}
						}
						if(first_check == 1){
							output.append(first+"\n");
							while((line=br.readLine())!=null)
							{
								output.append(line+"\n");
							}
						}
						if(second_check == 1)
						{
							output.append(second+"\n");
							while((line=br1.readLine())!=null)
							{
								output.append(line+"\n");
							}
						}
						br.close();
						br1.close();
						
						output.close();
						File f1=new File(firstPath);
						f1.delete();
						File f2=new File(secondPath);
						f2.delete();
						File old = new File(sourcePath+"temp");
						File new1 = new File(firstPath);
						old.renameTo(new1);
					}
			}
			
			
		}

		
	}//end of function
}