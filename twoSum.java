//  TC : O(n)
// SC : O(n)


import java.util.*;;
public class twoSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //size of an array
        System.out.println("Enter no.of elements");
        int n=sc.nextInt();

        System.out.println("Enter array elements");

        //array elements
        int[] arr= new int[n];
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
        }
        
        //target value
        System.out.println("Enter the target value");
        int target=sc.nextInt();
        
        //create the hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(arr[i], i);
        }

        int result[] = new int[2];

        //if the current element is equal to the target
        //Main logic of TwoSum Problem
        for(int i=0; i<n;i++){
            if(arr[i]==target && map.containsKey(0)){
                result[0]=i;
                result[1]=map.get(0);
                break;
            }
            else if(map.containsKey(target-arr[i])){
                //the element is not repeatable
                if(map.get(target-arr[i])>i){
                    result[0]=i;
                    result[1]=map.get(target-arr[i]);
                    break;
                }
            }
        }
        
        //display the final result
        System.out.println("The resultant array index is: ["+result[0]+","+result[1]+"]");


    }
}
