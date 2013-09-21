package com.authorprofiling.extractfeatureswordsForAge;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map.Entry;

import java.util.Iterator;
public class sortFeatures {
	static <K,V extends Comparable<? super V>> SortedSet<Map.Entry<K,V>> entriesSortedByValues(Map<K,V> map) {
        SortedSet<Map.Entry<K,V>> sortedEntries = new TreeSet<Map.Entry<K,V>>(
            new Comparator<Map.Entry<K,V>>() {
                @Override public int compare(Map.Entry<K,V> e1, Map.Entry<K,V> e2) {
                    int res = e2.getValue().compareTo(e1.getValue());
                    return res != 0 ? res : 1; // Special fix to preserve items with equal values
                }
            }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }
	static String sourcePath = "/home/santosh/Downloads/AP/Experiment1/index/Age/female.txt";
	static String destFolder = "/home/santosh/Downloads/AP/Experiment1/index/Age/female/";
	public static void main(String[] s) throws IOException {
		BufferedReader br;
		FileInputStream fis = new FileInputStream(sourcePath);
		br = new BufferedReader(new InputStreamReader(fis));
		String line;
		int i = 1;
		int c = 1;
		TreeMap<String,Double> sort = new TreeMap<String,Double>();
		SortedSet<Entry<String,Double>> s1;
		Iterator<Entry<String,Double>> it;
		while((line = br.readLine())!=null){
			sort.put(line.split("\\|")[0], Double.parseDouble(line.split("\\|")[1]));
			if(c%10000 == 0){
				BufferedWriter output = new BufferedWriter(new FileWriter(destFolder+i+++".txt", true));
				s1 =entriesSortedByValues(sort);
				it = s1.iterator();
				while(it.hasNext())
				{
					output.write(it.next().toString());
					output.write("\n");
				}
				output.close();
				sort.clear();
			}
			System.out.println(c);
			c++;
		}
		BufferedWriter output = new BufferedWriter(new FileWriter(destFolder+i+++".txt", true));
		s1 =entriesSortedByValues(sort);
		it = s1.iterator();
		while(it.hasNext())
		{
			output.write(it.next().toString());
			output.write("\n");
		}
		output.close();
		sort.clear();
		br.close();
	}
	
	public void SortFeatures(String sourcePath,String destFolder) throws IOException{
		BufferedReader br;
		FileInputStream fis = new FileInputStream(sourcePath);
		br = new BufferedReader(new InputStreamReader(fis));
		String line;
		int i = 1;
		int c = 1;
		TreeMap<String,Double> sort = new TreeMap<String,Double>();
		SortedSet<Entry<String,Double>> s1;
		Iterator<Entry<String,Double>> it;
		Entry<String,Double> it_temp;
		while((line = br.readLine())!=null){
			sort.put(line.split("\\|")[0], Double.parseDouble(line.split("\\|")[1]));
			if(c%10000 == 0){
				BufferedWriter output = new BufferedWriter(new FileWriter(destFolder+i+++".txt", true));
				s1 =entriesSortedByValues(sort);
				it = s1.iterator();
				while(it.hasNext())
				{
					it_temp = it.next();
					output.write(it_temp.getKey()+"#"+it_temp.getValue());
					output.write("\n");
				}
				output.close();
				sort.clear();
			}
			System.out.println(c);
			c++;
		}
		BufferedWriter output = new BufferedWriter(new FileWriter(destFolder+i+++".txt", true));
		s1 =entriesSortedByValues(sort);
		it = s1.iterator();
		while(it.hasNext())
		{
			it_temp = it.next();
			output.write(it_temp.getKey()+"#"+it_temp.getValue());
			output.write("\n");
		}
		output.close();
		sort.clear();
		br.close();

	}
}
