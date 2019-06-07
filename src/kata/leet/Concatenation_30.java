package kata.leet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concatenation_30 {
	 public static List<Integer> findSubstring(String s, String[] words) {
		 List<Integer> result=new ArrayList<Integer>();
		 System.out.println(s.length());
         if(s.isEmpty()||words.length==0||s.length()<words[0].length()) return result;
         if(s.length()==1&&words.length==1){
        	 if(s.equals(words[0])) {
        		 result.add(0);
        		 return result;
        	 }
         }
         Map<String,Integer> wordsMap=new HashMap<String,Integer>();
       int len=words[0].length();
		 for(String word:words) {
			 wordsMap.put(word,wordsMap.getOrDefault(word, 0)+1);
		 }
		 System.out.println(wordsMap);
		 for(int i=0;i<s.length()-len;i++) {
			 Map<String,Integer> sMap=new HashMap<String,Integer>();
			 for(int j=i;j<=s.length()-len;j++) {
				 System.out.println(j);
				 String word=s.substring(j,j+len);
				 System.out.println(word);
				 if(wordsMap.containsKey(word)) {
					 sMap.put(word,sMap.getOrDefault(word, 0)+1);
					 j+=len-1;
					 if(sMap.get(word)>wordsMap.get(word)) {
						 break;
					 }
				 }else {
					 break;
				 }
				 if(sMap.size()==wordsMap.size()&&sMap.equals(wordsMap)) {
					 result.add(i);
				 }
			 }
		 }
		return result;
	 }
	 public static void main(String[] args) {
		 String[] words= {"a"};
		 List<Integer> res= findSubstring("a",words);
		 System.out.println(res);
	}
	 
	 
}
