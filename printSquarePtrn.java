public class printSquarePtrn {

    public static void printSquare(int n) {
        // code here
        
        int total = (2 * n) -1;
        
        //upper-part
        for (int i = 0; i < (total / 2) + 1; i++) {
            //left
            for (int j = 0; j <= i - 1; j++) {
                System.out.print(n - j + " ");
            }

            //middle
            for (int j = total - 2 * i; j >=1; j--) {
                System.out.print(n - i + " ");
            }

            //right
            for (int j = i - 1; j >= 0; j--) {
                System.out.print(n - j + " ");
            }

            System.out.println();
        }
        

        //lower-part
        int x= total/2;
        for(int i=0; i<x; i++){
            for (int j = 0; j <= x - i - 2; j++) {
                System.out.print(n - j + " ");
            }
            
            for (int j = 0; j < 2 * i + 3; j++) {
                System.out.print(i + 2 + " ");
            }
            
            for (int j = x - i - 2; j >= 0; j--) {
                System.out.print(n - j + " ");
            }
            
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        printSquare(4);
    }
}
