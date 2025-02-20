public class printPaths {

    public static void printpats(int curr, int dest, String ans){
        if(curr==dest){
            System.out.println(ans);
            return;
        }
        if(curr>dest){
            return;
        }
        printpats(curr+1, dest, ans+'1');
        printpats(curr+2, dest, ans+'2');
        printpats(curr+3, dest, ans+'3');
        printpats(curr+4, dest, ans+'4');
        printpats(curr+5, dest, ans+'5');
        printpats(curr+6, dest, ans+'6');

    }

    public static void main(String[] args) {
        printpats(0, 6, "");
    }
}
