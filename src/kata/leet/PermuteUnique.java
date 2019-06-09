package kata.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wangzn
 * @date 2019Äê6ÔÂ9ÈÕ  
 */
public class PermuteUnique {
	public List<List<Integer>> permuteUnique(int[] nums) {
        // write your code here
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		if (nums == null) {
            return res; 
        }
        
        if (nums.length == 0) {
           res.add(new ArrayList<Integer>());
           return res;
        }
		List<Integer> re=new ArrayList<Integer>();
		Set<Integer> set = new HashSet<>();
		Arrays.sort(nums);
		dfs(nums,new boolean[nums.length], re, res);  
        return res;
        }
	 private void dfs(int[] nums,
             boolean[] visited,
             List<Integer> permutation,
             List<List<Integer>> results) {
				if (nums.length == permutation.size()) {
				    results.add(new ArrayList<Integer>(permutation));
				    return;
				}
				
				for (int i = 0; i < nums.length; i++) {
				    if (visited[i]) {
				        continue;
				    }
				    if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
				        continue;
				    }
				    
				    permutation.add(nums[i]);
				    visited[i] = true;
				    dfs(nums, visited, permutation, results);
				    visited[i] = false;
				    permutation.remove(permutation.size() - 1);
				}
			}
				

}
