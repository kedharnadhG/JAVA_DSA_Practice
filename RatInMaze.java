public class RatInMaze {

    public static void printSolution(int[][] output, int n){
        for(int[] x:output){
            for(int v: x){
                System.out.print(v +" ");
            }
            System.out.println();
        }
    }

    public static boolean  isSafe(int[][] maze, int i, int j, int n){
        if(i>=0 && i<n && j>=0 && j<n && maze[i][j]==1){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean solveMaze(int[][]maze, int[][] output, int i, int j, int n){
        //if you reached the destination, you have to return i.e Base Case
        if(i==n-1 && j==n-1 && maze[i][j]==1){
            output[i][j] =1;
            return true;
        }

        if(isSafe(maze, i, j, n) == true){
            //check if this path is already part of solution or not
            if(output[i][j]==1){
                return false;
            }
            //if it's not part, need to include it right
            output[i][j]=1;

            //Bottom direction
            if(solveMaze(maze, output, i+1, j, n) == true){
                return  true;
            }

            //Right direction
            if(solveMaze(maze, output, i, j+1, n)==true){
                return true;
            }

            //backtrack
            output[i][j]=0;
            return false;
        }
        return false;
    }
    public static void main(String[] args) {
     
        int[][] maze= {{1,0,1,0},
                        {1,1,0,0},
                        {0,1,1,0},
                        {0,0,1,1}};
        int n= maze.length;
        int output[][] = new int[n][n];
        if(solveMaze(maze, output, 0, 0, n)==true){
            printSolution(output, n);
        }
        else{
            System.out.println("Solution doesn't exist");
        }

        

    }
}
