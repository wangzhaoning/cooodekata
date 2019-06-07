package com.test.spring.boot.blog;

/**
 * @author wangzn
 * @date 2019年6月6日  
 */
public class StrStr {
	 public int strStr(String source, String target) {
         // Write your code here
         if(source.equals(target)) return 0;
   	for(int i=0;i<source.length()-target.length()+1;i++) {
			String s=source.substring(i,i+target.length());
			if(s.equals(target)) {
				return i;
			}
		}
			return -1;
   }
}
