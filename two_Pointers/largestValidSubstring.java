package two_Pointers;
import java.util.*;


//  Find the largest valid substring - Valid string is a string where any pair of characters have diff<=k
// notes :https://docs.google.com/document/d/1LW_-9d7vv1QAWDt2hZ5YxWxUrqVc6H9CZxNQlylk1ws/edit?tab=t.0

public class largestValidSubstring {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // length of string    -> 5
        int k = sc.nextInt(); // maximum allowed difference   -> 2
        sc.nextLine();
        String s = sc.nextLine();   // -> abdzd

        TreeMap<Character, Integer> map = new TreeMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            char c = s.charAt(right);

            // add character
            map.put(c, map.getOrDefault(c, 0) + 1);

            // shrink while invalid
            while (map.lastKey() - map.firstKey() > k) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }

            // update max length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println( "The length of the largest valid substring is: " + maxLength);
    }

    
    /*  Pseudo-code
    
            Sorted set g     
            ll diff = 0 ;
            for (int i = 0, j = 0; j < n; j++) {
                    g.insert(s[j]) 
                    while (diff>k){
                        g.remove(s[i]) 
                        diff = largest(b) - smallest(b) -> O(logn.)  
                        i++;
                    }
                    ll length = (j-i+1) ; //[i.....j] <= k -> checking its length. 
                    
                    
                    p = max(p,length);
                    
            }

     
    
    
     */

    

    /*  using wrapper-class  (study it once)

            // TreeMultiSet implementation using TreeMap
            static class TreeMultiSet<T extends Comparable<T>> {
                private final TreeMap<T, Integer> map;
        
                // Constructor
                public TreeMultiSet() {
                    map = new TreeMap<>();
                }
        
                // Method to add an element to the multiset
                public void add(T t) {
                    map.put(t, map.getOrDefault(t, 0) + 1);
                }
        
                // Method to remove an element from the multiset
                public void remove(T t) {
                    if (map.containsKey(t)) {
                        int count = map.get(t);
                        if (count > 1) {
                            map.put(t, count - 1);
                        } else {
                            map.remove(t);
                        }
                    }
                }
        
                // Method to get the smallest element
                public T first() {
                    return map.firstKey();
                }
        
                // Method to get the largest element
                public T last() {
                    return map.lastKey();
                }
        
                // Iterator to iterate over the elements in the multiset
                public Iterator<T> iterator() {
                    return new Iterator<T>() {
                        private final Iterator<Map.Entry<T, Integer>> iter = map.entrySet().iterator();
        
                        @Override
                        public boolean hasNext() {
                            return iter.hasNext();
                        }
        
                        @Override
                        public T next() {
                            return iter.next().getKey();
                        }
                    };
                }
            }
        
            public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
        
                int n = sc.nextInt(); // Length of string
                int k = sc.nextInt(); // Maximum difference allowed
                sc.nextLine(); // Consume the newline character
                String s = sc.nextLine(); // The string
        
                TreeMultiSet<Character> multiset = new TreeMultiSet<>();
        
                int maxLength = 0;
                int left = 0;
        
                // Sliding window using two pointers
                for (int right = 0; right < n; right++) {
                    // Add character at 'right' to the multiset
                    multiset.add(s.charAt(right));
        
                    // Shrink the window if the difference between max and min exceeds k
                    while (multiset.last() - multiset.first() > k) {
                        // Remove character at 'left' from the multiset
                        multiset.remove(s.charAt(left));
                        left++;
                    }
        
                    // Update the maxLength of valid substring
                    maxLength = Math.max(maxLength, right - left + 1);
                }
        
                System.out.println(maxLength);
            }

     */

}
