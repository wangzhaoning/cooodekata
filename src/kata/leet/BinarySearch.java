package kata.leet;

/**
 * @author wangzn
 * @date 2019Äê6ÔÂ7ÈÕ  
 */
public class BinarySearch {
	 public static int binarySearch(int[] nums, int target) {
	        // write your code here
		 if(nums.length==0||nums==null)return -1;
		 	int i=0,j=nums.length-1;
		 	while(i+1<j) {
		 		int mid=(i+j)/2;
		 		if(nums[mid]==target) {
		 			j= mid;
		 		}else if(nums[mid]<target) {
		 			i=mid;
		 		}else {
		 			j=mid;
		 		}
		 	}
		 	if(nums[i]==target) return i;
		 	if(nums[j]==target) return j;
		 	return -1;
	    }
	 public static void main(String[] args) {
		 int[] nums= {3,4,5,8,8,8,8,10,13,14};
		System.out.println(binarySearch(nums,8));
	}
}
