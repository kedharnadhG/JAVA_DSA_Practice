package DP;

public class MCM {

    //TODO: Deep-dive and do it one more time, Didn't get it

    //dimension - > p[i-1]*p[i]
    //i -> in range [1,n]

    public static int matrixChainOrder(int[] p, int n) {
        int[][] m = new int[n][n];

        int i, j, k, l, q;    //i,j,k,l,q are indices

        //cost is 0 when you are multiplying 1 matrix
        for (i = 1; i < n; i++) {
            m[i][i] = 0;
        }

        //l is chain length
        for(l=2; l<n; l++){ //l=2 to n-1 ( n is the number of matrices)
            for(i=1; i<n-l+1; i++){ //i=1 to n-l+1( n is the number of matrices , l is the chain length, i is the starting index of the chain)
                j=i+l-1; //j=i+l-1 ( j is the last matrix in the chain)

                
                if(n==j){  //
                    
                    continue;
                }

                m[i][j] = Integer.MAX_VALUE; //initializing with MAX_VALUE
                for(k=i; k<=j-1; k++){ //k=i to j-1
                    //q - cost of scaler multiplication
                    q = m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j];

                    if(q<m[i][j]){
                        m[i][j] = q;
                    }
                }

            }
        }

        return m[1][n-1];

    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4}; 
        int n = arr.length;

        System.out.println("Number of scalar multiplications required: "+matrixChainOrder(arr, n));
    }
        
}
