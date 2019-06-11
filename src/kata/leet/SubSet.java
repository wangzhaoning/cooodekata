package kata.leet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
	public static List<List<Integer>> subset(int[] nums){
		List<List<Integer>> res=new ArrayList<List<Integer>>();
		List<Integer> re=new ArrayList<Integer>();
		int index=0;
		Arrays.sort(nums);
		dfs(nums,res,re,index);
		return res;
	}

	private static void dfs(int[] nums,List<List<Integer>> res, List<Integer> re, int index) {
		
		if(index==nums.length) {
			res.add(new ArrayList<Integer>(re));
			return ;
		}
				re.add(nums[index]);
				dfs(nums,res,re,index+1);
				re.remove(re.get(re.size()-1));
				dfs(nums,res,re,index+1);
	}
	public static void main(String[] args) {
		int[] nums= {1,2,3,4};
		System.out.println(subset(nums));
	}
}
