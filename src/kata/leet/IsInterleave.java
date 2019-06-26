package kata.leet;

public class IsInterleave {
	public static boolean isInterleave(String s1, String s2, String s3) {
		/*
		 * int row=s1.length(); int len=s2.length(); int i=0,j=0; String tmp[][]=new
		 * String[row][len]; tmp[0][0]=""; for(int k=0;k<s3.length();k++) { String
		 * sub=s3.substring(0, i+j); while(i<row&&tmp[i][j].equals(sub)) { i++;
		 * tmp[i][j]=s1.substring(0,i)+s2.substring(0,j); continue; }
		 * while(j<len&&tmp[i][j].equals(sub)) { j++;
		 * tmp[i][j]=s1.substring(0,i)+s2.substring(0,j); continue; } if(k!=i+j) return
		 * false; } return true;
		 */
		 if (s1.length() + s2.length() != s3.length()) {
	            return false;
	        }
	        
	        boolean [][] interleaved = new boolean[s1.length() + 1][s2.length() + 1];
	        interleaved[0][0] = true;
	        for(int i=1;i<=s1.length();i++) {
	        	if(s3.charAt(i-1)==s1.charAt(i-1)&&interleaved[i-1][0]) {
	        		interleaved[i][0]=true;
	        	}
	        }
	        
	        for(int j=1;j<=s2.length();j++) {
	        	if(s3.charAt(j-1)==s1.charAt(j-1)&&interleaved[0][j-1]) {
	        		interleaved[0][j]=true;
	        	}
	        }
	        for(int i=1;i<=s1.length();i++) {
	        	for(int j=1;j<=s2.length();j++) {
	        		if((s3.charAt(i+j-1)==s1.charAt(i-1)&&interleaved[i-1][j])
	        				||(s3.charAt(i+j-1)==s2.charAt(j-1)&&interleaved[i][j-1])){
	        					interleaved[i][j]=true;
	        				}
	        	}
	        }
	        
	        return interleaved[s1.length()][s2.length()];
    }
	public static void main(String[] args) {
		String s1="acb";
		String s2="qwe";
		String s3="acqweb";
		System.out.println(isInterleave(s1,s2,s3));
	}
}
