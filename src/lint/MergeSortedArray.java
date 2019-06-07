package kata.leet;

public class MergeSortedArray {
	public static void main(String[] args) {
		int[] A= {1,2,3};
		int[] B= {1,2,3,4,5};
		for(int a:mergeSortedArray(A,B)) {
			System.out.println(a);
		}
	}
	 public static int[] mergeSortedArray(int[] A, int[] B) {
		 int[] c=new int[A.length+B.length];
		 int i=0,j=0,k=0;
		 while(i<A.length&&j<B.length) {
			 if(A[i]<B[j]) {
				 c[k]=A[i];
				 i++;
				 k++;
			 }else {
				 c[k]=B[j];
				 j++;
				 k++;
			 }
		 }
		 while(i<A.length) {
			 c[k]=A[i];
			 i++;
			 k++;
		 }
		 while(j<B.length) {
			 c[k]=B[j];
			 j++;
			 k++;
		 }
		 	return c;
	    }
}
