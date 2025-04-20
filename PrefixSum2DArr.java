public class PrefixSum2DArr {


    //to caluculate the co-ord sum
    public static int SumRegion(int[][] prefMatrix, int r1, int r2, int c1, int c2){
        int sum = 0, up=0, left=0, repeated =0;


        sum = prefMatrix[r2][c2];
        up = (r1 > 0) ? prefMatrix[r1-1][c2] : 0;
        left = (c1 > 0) ? prefMatrix[r2][c1-1] : 0;
        repeated = (r1 > 0 && c1 > 0) ? prefMatrix[r1-1][c1-1] : 0;

        return sum-up-left+repeated;

    }


    public static void main(String[] args) {
        int[][] matrix = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }};

        //we need to do 3-steps

        //1. for each row, we need to calculate prefix sum
        //2. for each column, we need to calculate prefix sum
        //3. for the given co-ordinates, we need to calculate the sum

        //1. for each row, we need to calculate prefix sum
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        //2. col-prefix sum
        for(int j=0; j<matrix.length; j++){
            for(int i=1; i<matrix.length; i++){
                matrix[i][j] += matrix[i-1][j];
            }
        }

        // printing the arr after pref-sum
        for(int[] r: matrix){
            for(int c: r){
                System.out.print(c + " ");
            }
            System.out.println();
        }

        //3. for the given co-ordinates, we need to calculate the sum
        // int r1 = 2, r2 = 3, c1 = 2, c2 = 3;
        // System.out.println("The sum is: "+SumRegion(matrix, r1, r2, c1, c2));

        int r1= 0, r2=2, c1=0, c2=2;
        System.out.println("The sum is: "+SumRegion(matrix, r1, r2, c1, c2));

    }
}
