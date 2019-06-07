package kata.leet;

import java.util.ArrayList;
import java.util.List;

public class FuzzBuzz {
	  public static List<String> fizzBuzz(int n) {
		  List<String> res=new ArrayList<>();
		  for(Integer i=1;i<=n;i++) {
			 if(i%3==0&&i%5==0) {
				 res.add("fizz buzz");
			 }
			 else if(i%3==0) {
				 res.add("fizz");
			 }
			 else if(i%5==0) {
				 res.add("buzz");
			 }
			 else {
				 res.add(i.toString());
			 }
		  }
		  return res;
	  }
	  public static void main(String[] args) {
		  System.out.println(fizzBuzz(15));
	}
}
