package STK;
// TC : O(n)  ('n' is the size of the string)
// SC : O(n) 


import java.util.*;
public class validParanthesis {

    public static boolean isValid(String str){
        char[] chars = str.toCharArray();

        if(str.length()==0){
            return false;
        }

        Stack<Character> stack1 = new Stack<>();

        for(char ele: chars){
            if(ele=='(' || ele=='{' || ele=='[' ){
                stack1.push(ele);
                continue;    //it skips the rest of the loop
            }

            else if(stack1.empty()){
                return false;
            }
            
            char top = stack1.pop();

            //there is no mapping
            if(top=='[' && ele!=']'){
                return false;
            }
            else if(top=='(' && ele!=')'){
                return false;
            }
            else if(top=='{' && ele!='}'){
                return false;
            }
        }
        return (stack1.empty()== true);
    }

    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the string");

        String str= sc.nextLine();

        System.out.println("Is the string contains valid paranthesis? : "+isValid(str));
    }
}
