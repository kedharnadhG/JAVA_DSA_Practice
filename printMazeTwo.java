public class printMazeTwo {

    public static void PrintMazeTwo(int cr, int cc, int dr, int dc, String ans){
        
        // (-ve) Base condition
        if(cr>dr || cc>dc){
            return;
        }

        // (+ve) Base condition
        if(cr == dr && cc == dc){
            System.out.println(ans);
            return;
        }

        PrintMazeTwo(cr, cc+1, dr, dc, ans+'H');
        PrintMazeTwo(cr+1, cc, dr, dc, ans+'V');
    }

    public static void main(String[] args) {
        PrintMazeTwo(0,0,2,2,"");
    }
}
