public class Solution{

  //For each result element, find elements from A, B that contribute and compute Sum(products)
  public int[][] multiply(int[][]A, int[][]B){
    for(int i=0; i<numRowsA; i++)
      for(int j=0; j<numColsB; j++)
        for(int k=0; k<numColsA; k++)
          res[i][j] += A[i][k]*B[k][j];
  }
  
  // For each element of A, if it's not zero, then multiply with elements from B
  public int[][] sparseMultiply(int[][]A, int[][]B){
    // for each element of A, if it's not zero
    for(int i=0; i<numRowsA; i++)
      for(int j=0; j<numColsA; j++) // for each element of A
        if(A[i][j] != 0){	//if not 0
          for(int k=0; k<numColsB; k++){	//multiply with all applicable associates to update applicable result element
            res[i][k] += A[i][j] * B[j][k];
          }
        }
    }
}
