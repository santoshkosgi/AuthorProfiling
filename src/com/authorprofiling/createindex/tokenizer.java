package com.authorprofiling.createindex;

public class tokenizer {
  public String tokenize(String str){ 
		  str = str.replaceAll("\\s+", " ");
		  str = str.replaceAll("(?i)(<script .*?>)(.*?)(</script>)"," ");
		  str = str.replaceAll("(?i)(<)(.+?)(>;)"," ");
		  str = str.replaceAll("(?i)(</)(.+?)(>;)"," ");
		  str = str.replaceAll("(?i)(http://)(.+?)(/)"," ");
		  str=str.replaceAll("[^a-zA-Z0-9]", " ");
		  str = str.replace(";","");
		  str = str.replaceAll("\\s+", " ");
		  str = str.replaceAll("[^\\x00-\\x7F]", "");
		  return str;
  }  	   

	public static void main(String[] ar) {
	  tokenizer t = new tokenizer();
	  System.out.println(t.tokenize("http://fgsf/"));
	  
	}
}