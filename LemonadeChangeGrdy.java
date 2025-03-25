public class LemonadeChangeGrdy {
    // here we are greedy about the "5$"

    public static boolean lemonadeChange(int[] bills) {
        int  d5=0, d10=0, d20=0;

        for(int i=0; i<bills.length; i++) {
            if(bills[i] == 5) {
                d5++;
            } else if(bills[i] == 10) {
                if(d5 > 0) {
                    d5--;
                    d10++;
                }else{
                    return false;
                }
            }else{
                if(d10 > 0 && d5 > 0) {
                    d10--;
                    d5--;
                    d20++;
                }else if(d5 >= 3) {
                    d5 -= 3;
                    d20++;
                }else{
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // int[] bills = {5,5,5,5,10,20,10};
        int[] bills = {5,5,10,10,20};
        boolean res = lemonadeChange(bills);
        System.out.println(res);
    }
}


// the overall time complexity is O(n)
// the space complexity is O(1)