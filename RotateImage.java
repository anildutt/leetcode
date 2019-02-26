package leetcode;

public class Solution {
    
    //Approach 1
    //O(n) Extra space: {i, j} will go into {j, N-i-1} 
    public void rotateExtraSpace(int[][] matrix) {
    	int N = matrix.length;
        int[][] result = new int[N][N];
        
        for(int i=0;i<N;i++)
        	for(int j=0; j<N; j++){
        		result[j][N-1-i] = matrix[i][j];
        	}
        
        for(int i=0;i<N;i++)
        	for(int j=0; j<N; j++){
        		matrix[i][j] = result[i][j];
        	}
    }
    
    //Approach 2
    //rotate spirally - in place
    public static void rotate(int[][] matrix){
    	int N = matrix.length;
		for (int i = 0; i < N / 2; i++) { /* Rows: 0 to N/2 */
			for (int j = i; j < N - i - 1; j++) { /* Columns: row -> N - row - 1 */
				int row = i, col = j;
				int toBeInserted = matrix[row][col];
        
        //For each rim, going from perimeter to center
				for (int count = 0; count < 4; count++) { /* Transitively rotate 4 elements */
					int tmpX = col;
					int tmpY = N - 1 - row;
					
					int tmp = matrix[tmpX][tmpY];
					matrix[tmpX][tmpY] = toBeInserted;
					toBeInserted = tmp;

					row = tmpX;
					col = tmpY;
				}
			}
		}
    }
    
    public void rotateInPlace(int[][] matrix){
        
    }
}
