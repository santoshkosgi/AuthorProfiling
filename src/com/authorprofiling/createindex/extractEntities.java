package com.authorprofiling.createindex;

import com.authorprofiling.createindex.tokenizer;
import com.authorprofiling.apicall.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class extractEntities {
	static APIRequest req = new APIRequest();
	static tokenizer t = new tokenizer();
//	static String filelist = "/home/santosh/Downloads/AP/fileList.txt";
//	static String sourcePath = "/home/santosh/Downloads/pan_author_profiling_training_data/en/";
	static String filelist = "/root/Downloads";
	static String sourcePath = "/root/data/";
	static String destPath = "/root/entites_new/";
	static String filePath;
//	static String destPath = "/home/santosh/Downloads/AP/Entities/";
	static int countConversations = 0;
	public static void main(String argv[]){
		try {
			
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			
			DefaultHandler handler = new DefaultHandler() {
			boolean bconverse = false;
			String content;
			
			
			public void startElement(String uri, String localName,String qName, 
		                Attributes attributes) throws SAXException {
				if (qName.equalsIgnoreCase("conversation")) {
					countConversations = countConversations + 1 ;
					bconverse = true;
					content = "";
				}
		 
		 
			}
		 
			public void endElement(String uri, String localName,
				String qName) throws SAXException {
				if (qName.equalsIgnoreCase("conversation")) {
					Writer output;
					try {
						output = new BufferedWriter(new FileWriter(destPath+filePath+"@"+countConversations, true));
						output.append(req.doPost(t.tokenize(content)));
						output.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
//					System.err.println(t.tokenize(content));
					
					bconverse = false;
					
				}
				if (qName.equalsIgnoreCase("conversations")) {
					
					countConversations = 0;
					
				}
		 
			}
		 
			public void characters(char ch[], int start, int length) throws SAXException {
		 
				if (bconverse) {
				
					content = content+new String(ch, start, length);

				}
		 
			
			}
		
			};
			FileInputStream fis = new FileInputStream(filelist);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			int i = 0;
			while((filePath=br.readLine())!=null){
				System.out.println(i++);
				saxParser.parse(sourcePath+filePath, handler);

			}
			br.close();
			fis.close();
	
		} 
			 
			catch (Exception e) {
					e.printStackTrace();
		     }
		
	   }
}
