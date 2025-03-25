public class MinSwpsToBalBrackts {
    public static int minSwaps(String s) {
        int countL =0,  countR =0,imbalance =0, swaps =0;

        char[] chars = s.toCharArray();

        for(int i=0; i<chars.length;i++){
            if(chars[i] == '['){
                countL++;
                if(imbalance > 0){
                    swaps += imbalance;
                    imbalance--;
                }
            }else if(chars[i]==']'){
                countR++;
                imbalance = (countR-countL);
            }
        }

        return swaps;

    }
    public static void main(String[] args) {
        String str = "[]][][";
        System.out.println(minSwaps(str));

        String str2 = "[[][]]";
        System.out.println(minSwaps(str2));

        String str3 = "[]]]][[[";
        System.out.println(minSwaps(str3));
    }
}
