public class PermutaionOfString {

    public static String swap(String str,int i,int j){
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[i];
        charArray[i]=charArray[j];
        charArray[j] =temp;

        return String.valueOf(charArray);
    }

    public static void allpermutations(String str,int l,int r){
        if(l==r){
            System.out.println(str);
        }
        else{
            for(int i=l; i<=r;i++){
                str = swap(str, l, i);
                allpermutations(str, l+1, r);
                // backtrack
                str= swap(str, l, i);
            }
        }
    }

    public static void main(String[] args) {
        String str= "ABC";
        //System.out.println(swap(str, 0, 1));
        
        allpermutations(str, 0, str.length()-1);
    }
}
