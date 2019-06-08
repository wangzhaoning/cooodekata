package kata.leet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wangzn
 * @date 2019Äê6ÔÂ8ÈÕ  
 */
public class Permute {
	public List<List<Integer>> permute(int[] nums) {
        // write your code here
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if (nums == null) {
            return res; 
        }
        
        if (nums.length == 0) {
           res.add(new ArrayList<Integer>());
           return res;
        }

        List<Integer> permutation = new ArrayList<Integer>();
        Set<Integer> set = new HashSet<>();
        helper(nums, permutation, set, res);
        
        return res;
   }
   public void helper(int[] nums,
                      List<Integer> permutation,
                      Set<Integer> set,
                      List<List<Integer>> res) {
       if (permutation.size() == nums.length) {
           res.add(new ArrayList<Integer>(permutation));
           return;
       }
       for (int i = 0; i < nums.length; i++) {
           if (!set.contains(nums[i])) {
           permutation.add(nums[i]);
           set.add(nums[i]);
           helper(nums, permutation, set, res);
           set.remove(nums[i]);
           permutation.remove(permutation.size() - 1);
           }
       }
       
   }
}
