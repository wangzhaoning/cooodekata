package kata.leet;

import java.util.HashMap;
import java.util.Map;

public class add {
	// 递归写法
	int add(int num1, int num2){
	    if(num2 == 0)
	        return num1;
	    int sum = num1 ^ num2;
	    int carry = (num1 & num2) << 1;
	    return add(sum, carry);
	}
}
