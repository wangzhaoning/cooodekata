package practice;

/**
 * @author wangzn
 * @date 2019��6��2��  
 */
public class KthLargestElement {
	 public int kthLargestElement(int k, int[] nums) {

	        // write your code here
	        int low = 0, high = nums.length -1;
	        while(low <= high){
	            int index = low-1;
	            for(int i = low; i < high; i++){
	                if(nums[i] > nums[high]){
	                    swap(nums, i, ++index);
	                }
	            }
	            swap(nums, ++index, high);
	            if(index == k - 1){
	                return nums[index];
	            }
	            if(index < k -1){
	                low = index + 1;
	            }else{
	                high = index - 1;
	            }
	        }
	        return -1;
	    }
	    
	    private void swap(int[] nums, int a, int b){
	        int temp = nums[a];
	        nums[a] = nums[b];
	        nums[b] = temp;
	    }
}
