package kata.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangzn
 * @date 2019Äê5ÔÂ11ÈÕ  
 */
public class ThreeSum15 {
	public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
		List<List<Integer>> result=new ArrayList<>();
        for (int i=0;i<nums.length-2;i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i-1])){
                int target=-nums[i];
                int start=i+1;
                int end=nums.length-1;
        	while(start<end) {
        		int sum=nums[start]+nums[end];
        		if(sum==target) {
        			List<Integer> res=new ArrayList<Integer>();
        			res.add(nums[start]);
        			res.add(nums[end]);
        			res.add(-target);
        			result.add(res);
        			while (start<end&&nums[start]==nums[start+1]) start++;
        			while (start<end&&nums[end]==nums[end-1]) end--;
        			start++;
        			end--;
        		}
                else if(sum<target) start++;
        		else end--;
        		
        	  }
            }
        }
        return result;
    }
}
