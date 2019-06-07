package kata.leet;

public class Digit {
	 public static int digitCounts(int k, int n) {
		 int count =0;
		 for(int i=k;i<=n;i++) {
			 count+=singleCount(i,k);
		 }
		return count;
		 
	    }
	    
	    public static int singleCount(int i, int k) {
	    	int ans=0;
	    	if(i==0 && k==0) {
	    		return 1;
	    	}
	    	while(i>0) {
	    		if(i%10==k) {
	    			ans++;
	    		}
	    		i=i/10;
	    	}
	    	return ans;
	    }
	public static void main(String[] args) {
		System.out.println(digitCounts(7,6));
		System.out.println(digitCounts(9,11));
		System.out.println(digitCounts(0,999));
		System.out.println(digitCounts(0,9999));
	}

}
