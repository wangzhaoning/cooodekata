package kata.leet;

/**
 * @author wangzn
 * @date 2019��6��14��  
 */
public class SearchMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null||matrix.length==0) {
			return false;
		}
		if(matrix[0]==null||matrix[0].length==0) {
			return false;
		}
		int row=matrix.length;
		int col=matrix[0].length;
		int i=0;
		int j=row*col-1;
		while(j>=i){
			int tmp=(i+j)/2;
			if(target==matrix[tmp/col][tmp%col]) {
				return true;
			}else if(target<matrix[tmp/col][tmp%col]) {
				j=tmp-1;
			}else{
				i=tmp+1;
			}
		}
		return false;
	}
}
