package kata.leet;

import java.util.ArrayList;
import java.util.List;

public class Flatten {
	 public List<Integer> flatten(List<NestedInteger> nestedList) {
		 List<Integer> res=new ArrayList<Integer>();
		 for(NestedInteger n: nestedList) {
			 if(n.isInteger()) {
				 res.add(n.getInteger());
			 }else {
				 res.addAll(flatten(n.getList()));
			 }
		 }
		return res;
	    }
}
