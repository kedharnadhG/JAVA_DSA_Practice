import java.util.*;;
public class FirstOccurance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String");
        String str = sc.nextLine();

        HashMap<Character,Integer> map = new HashMap<>();

        //creating hashtable having key as the character and the value as the frequency of that character
        for(int i=0; i<str.length(); i++){
            //here it is CASE_SENSITIVE
            if(map.containsKey(str.charAt(i))){
                //if it is already present, so incrementing the count
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }
            else{
                //if it's a new one
                map.put(str.charAt(i), 1);
            }
        }


        int result =-1;

        for(int i=0; i<str.length();i++){
            if(map.get(str.charAt(i))==1){
                System.out.println("The first non-repeating character index is: " +i);
                result=1;
                break;
            }
        }

        if(result==-1){
            System.out.println("No non-repating character is present inside the string");
        }
    }
}
