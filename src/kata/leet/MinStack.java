package kata.leet;

public class MinStack {
	
	private static  Integer[] stack;
	private Integer size=5;
	 public MinStack() {
	        // do intialization if necessary
		 stack=new Integer[size];
	    }

	    /*
	     * @param number: An integer
	     * @return: nothing
	     */
	    public void push(int number) {
	        // write your code here
	    	for(int i=0;i<stack.length;i++) {
	    		if(stack[i]==null) {
	    			stack[i]=number;
	    			break;
	    		}else if(i==stack.length-1){
	    			size=size+5;
	    			stack=new Integer[size];
	    		}
	    	}
	    }

	    /*
	     * @return: An integer
	     */
	    public int pop() {
	        // write your code here
	    	for(int i=stack.length-1;i>=0;i--) {
	    		if(stack[i]!=null) {
	    			int res=stack[i];
	    			stack[i]=null;
	    			return res;
	    		}
	    	}
	    	return (Integer) null;
	    }

	    /*
	     * @return: An integer
	     */
	    public int min() {
	    	if(stack[0]==null) return (Integer) null;
	    	int min=stack[0];
	    	for(int i=1;i<stack.length;i++) {
	    		if(stack[i]==null) return min;
	    		if(min>stack[i]) {
	    			min=stack[i];
	    		}
	    	}
	    	return min;
	    }
	    public static void main(String[] args) {
	    	MinStack s=new MinStack();
	    	s.push(3);
	    	s.push(2);
	    	s.push(1);
	    	System.out.println(s.min());
	    	System.out.println(s.pop());
	    	System.out.println(s.min());
		}
	    
	    //new method
//	    private Stack<Integer> stack;
//	    private Stack<Integer> minStack;
//	    
//	    public MinStack() {
//	        stack = new Stack<Integer>();
//	        minStack = new Stack<Integer>();
//	    }
//
//	    public void push(int number) {
//	        stack.push(number);
//	        if (minStack.isEmpty()) {
//	            minStack.push(number);
//	        } else {
//	            minStack.push(Math.min(number, minStack.peek()));
//	        }
//	    }
//
//	    public int pop() {
//	        minStack.pop();
//	        return stack.pop();
//	    }
//
//	    public int min() {
//	        return minStack.peek();
//	    }
}
