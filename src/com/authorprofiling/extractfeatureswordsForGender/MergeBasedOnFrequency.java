package com.authorprofiling.extractfeatureswordsForGender;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
public class MergeBasedOnFrequency{
	
	static String sourcePath = "/home/santoshkosgi/Downloads/nlp/usingFrequencies/index_ngrams/male/";
	public static void main(String argv[]) throws IOException{
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
			int file_index=1;
			if(listOfFiles.length==1){
				break;
			}
			for (int i = 1; i <=listOfFiles.length; i=i+2) {
				second_check = 0;
				first_check = 0;
				System.out.println(i);
				fis = new FileInputStream("/home/santoshkosgi/Downloads/nlp/usingFrequencies/index_ngrams/male/"+(i)+".txt");
				br = new BufferedReader(new InputStreamReader(fis));
				fis1 = new FileInputStream("/home/santoshkosgi/Downloads/nlp/usingFrequencies/index_ngrams/male/"+(i+1)+".txt");
				br1 = new BufferedReader(new InputStreamReader(fis1));
				Writer output;
				output = new BufferedWriter(new FileWriter("/home/santoshkosgi/Downloads/nlp/usingFrequencies/index_ngrams/male/temp.txt", true));
				first = br.readLine();
				second = br1.readLine();
				while(true){
					if(Double.parseDouble(first.split("=")[1])>Double.parseDouble(second.split("=")[1])){
						output.append(first+"\n");
						if((first=br.readLine())!=null)
						{
						}
						else{
							second_check = 1;
							break;
						}
					}
					else if(Double.parseDouble(first.split("=")[1])<Double.parseDouble(second.split("=")[1])){
						//System.out.println(second);
						output.append(second+"\n");
						if((second=br1.readLine())!=null)
						{
						//	second = second.split("\\{")[0];
						}
						else{
							first_check = 1;
							break;
						}
					}
					else if(Double.parseDouble(first.split("=")[1])==Double.parseDouble(second.split("=")[1])){
						//System.out.println(second.split("\\{")[0]);
						output.append(first+"\n");
						output.append(second+"\n");
						if((first=br.readLine())!=null)
						{
							//first = first.split("\\{")[0];
						}
						else{
							second_check = 1;
							break;
						}
						if((second=br1.readLine())!=null)
						{
							//second = second.split("\\{")[0];
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
				File f1=new File("/home/santoshkosgi/Downloads/nlp/usingFrequencies/index_ngrams/male/"+(i)+".txt");
				f1.delete();
				File f2=new File("/home/santoshkosgi/Downloads/nlp/usingFrequencies/index_ngrams/male/"+(i+1)+".txt");
				f2.delete();
				File old = new File("/home/santoshkosgi/Downloads/nlp/usingFrequencies/index_ngrams/male/temp.txt");
				File new1 = new File("/home/santoshkosgi/Downloads/nlp/usingFrequencies/index_ngrams/male/"+file_index+".txt");
				old.renameTo(new1);
				file_index++;
			}
		}
	}
	
	public void mergeBasedOnFrequency(String sourcePath) throws IOException{
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
			int file_index=1;
			if(listOfFiles.length==1){
				break;
			}
			String firstPath,secondPath;
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
					if(Double.parseDouble(first.split("#")[1])>Double.parseDouble(second.split("#")[1])){
						output.append(first+"\n");
						if((first=br.readLine())!=null)
						{
						}
						else{
							second_check = 1;
							break;
						}
					}
					else if(Double.parseDouble(first.split("#")[1])<Double.parseDouble(second.split("#")[1])){
						//System.out.println(second);
						output.append(second+"\n");
						if((second=br1.readLine())!=null)
						{
						//	second = second.split("\\{")[0];
						}
						else{
							first_check = 1;
							break;
						}
					}
					else if(Double.parseDouble(first.split("#")[1])==Double.parseDouble(second.split("#")[1])){
						output.append(first+"\n");
						output.append(second+"\n");
						if((first=br.readLine())!=null)
						{
							//first = first.split("\\{")[0];
						}
						else{
							second_check = 1;
							break;
						}
						if((second=br1.readLine())!=null)
						{
							//second = second.split("\\{")[0];
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
		}//if
		
		else { //if number of files are odd
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
					if(Double.parseDouble(first.split("#")[1])>Double.parseDouble(second.split("#")[1])){
						output.append(first+"\n");
						if((first=br.readLine())!=null)
						{
						}
						else{
							second_check = 1;
							break;
						}
					}
					else if(Double.parseDouble(first.split("#")[1])<Double.parseDouble(second.split("#")[1])){
						//System.out.println(second);
						output.append(second+"\n");
						if((second=br1.readLine())!=null)
						{
						//	second = second.split("\\{")[0];
						}
						else{
							first_check = 1;
							break;
						}
					}
					else if(Double.parseDouble(first.split("#")[1])==Double.parseDouble(second.split("#")[1])){
						//System.out.println(second.split("\\{")[0]);
						output.append(first+"\n");
						output.append(second+"\n");
						if((first=br.readLine())!=null)
						{
							//first = first.split("\\{")[0];
						}
						else{
							second_check = 1;
							break;
						}
						if((second=br1.readLine())!=null)
						{
							//second = second.split("\\{")[0];
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
		
		}//top while
		

	}
	
}
