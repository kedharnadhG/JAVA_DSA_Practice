package Hashing;
import java.util.*;
public class hashMapFunctions {
    public static void main(String[] args) {
        HashMap<Integer, String> map= new HashMap<>();
        
        //put() method
        map.put(1, "priya");
        map.put(2, "anjali");
        map.put(7, "Shiva");
        map.put(9, "Jeet");

        System.out.println("Hashmap of the given data is:" + map);

        //get() method
        String result = map.get(7);
        System.out.println("the value of given key is: "+ result);

        //remove() method
        map.remove(1);
        System.out.println("Updated hashmap is: "+ map);

        //containsKey() function
        System.out.println("Checking of whether key is present or not: "+ map.containsKey(1));


        //iterating using for loop
        for(Map.Entry<Integer,String> ele: map.entrySet()){
            System.out.println(ele.getKey() + " : " + ele.getValue());
        }
    }
}
