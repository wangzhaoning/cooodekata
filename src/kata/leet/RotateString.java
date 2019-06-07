package kata.leet;

public class RotateString {
	public static void rotateString(char[] str, int offset) {
		 if(str.length==0) return;
		int off=offset%str.length;
		char[] tmp = new char[off];
		for(int i=0;i<off;i++) {
			tmp[i]=str[i+(str.length-off)];
		}
		for(int i=str.length-off-1;i>=0;i--) {
			str[i+off]=str[i];
		}
		for(int i=0;i<off;i++) {
			str[i]=tmp[i];
		}
    }
	public static void main(String[] args) {
		char[] str= {'a','b','c','d','e','f','g'};
		rotateString(str,6);
		System.out.println(str);
	}
}
