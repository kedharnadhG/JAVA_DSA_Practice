import java.util.*;
public class typesOfMap {
    public static void main(String[] args) {
        HashMap<Integer,String> map =new HashMap<>();   //for HashMap insertion order isn't preserved
        map.put(4, "Priya");
        map.put(2, "shivam");
        map.put(9, "Yammi");
        map.put(1, "Kedhar");

        System.out.println("HashMap class map output is: "+map);
       
       
       
        LinkedHashMap<Integer,String> map1 =new LinkedHashMap<>();   //for LinkedHashMap insertion order is preserved
        map1.put(4, "Priya");
        map1.put(2, "shivam");
        map1.put(9, "Yammi");
        map1.put(1, "Kedhar");

        System.out.println("LinkedHashMap class map1 output is: "+map1);
     
     
        TreeMap<Integer,String> map2 =new TreeMap<>();   //for TreeMap we get Sorted data based on the key
        map2.put(4, "Priya");
        map2.put(2, "shivam");
        map2.put(9, "Yammi");
        map2.put(1, "Kedhar");
        map2.put(10, "Rama");
        map2.put(5, "sham");

        System.out.println("TreeMap class map2 output is: "+map2);

    }
}
