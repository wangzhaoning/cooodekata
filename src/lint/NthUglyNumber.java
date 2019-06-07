package kata.leet;

import java.util.ArrayList;
import java.util.List;

public class NthUglyNumber {
	public static int nthUglyNumber(int n) {
		List<Integer> result=new ArrayList<>();
		result.add(1);
		int p2=0,p3=0,p5=0;
		for(int i=1;i<n;i++) {
			int last=result.get(i-1);
			while(result.get(p2)*2<=last)p2++;
			while(result.get(p3)*3<=last)p3++;
			while(result.get(p5)*5<=last)p5++;
			result.add(Math.min(Math.min(result.get(p2)*2,result.get(p3)*3),result.get(p5)*5));
		}
		return result.get(n-1);
	}
	
	
//	public static int nthUglyNumber(int n) {
//        // write your code here
//		if(n==1)return 1;
//		int res=0;
//		int i=2;
//       while(i>0){
//        	res=i;
//        	while(i>10&&(res%2==0||res%3==0||res%5==0)) {
//        		if(res%2==0){
//	            	res=res/2;
//	            }
//	            if(res%3==0) {
//	            	res=res/3;
//	            }
//	            if(res%5==0) {
//		            res=res/5;
//	            }
//        	}
//	        	if(res%7!=0&&res<=10) {
//	        		n--;
//	        		System.out.println(i+"  "+n);
//	        	}
//            if(n==1) return i;
//            i++;
//        } 
//        return 1;
//    }
	
	public static void main(String[] args) {
			System.out.println(nthUglyNumber(9));
	}
}
