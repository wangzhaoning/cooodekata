package kata.leet;

public class trailingZero {
		  public long trailingZeros(long n) {
		        long res=trail(n);
		        long result=0;
		        while(res%10==0){
		            result++;
		            res=res/10;
		        }
		        return result;
		    }
		    public  long trail(long n){
		           if(n==0){
		            return 1;
		        }else{
		            return trailingZeros(n-1)*n;
		        }
		    }
		    //best solution
	/*
	 * long ans=0; while(n>=5){ ans+=n/5; n/=5; }
	 */
}
