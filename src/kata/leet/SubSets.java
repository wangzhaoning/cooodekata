package kata.leet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangzn
 * @date 2019��6��9��  
 */
public class SubSets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		helper(nums);
		return res;
	}

	/**
	 * @param nums
	 */
	private void helper(int[] nums) {
		
	}
}
