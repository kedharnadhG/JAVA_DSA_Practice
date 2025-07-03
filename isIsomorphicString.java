public class isIsomorphicString {

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] mapS_t = new int[256];
        int[] mapT_s = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            //Case1. if no mapping in either of the maps, then add it to the map
            if (mapS_t[c1] == 0 && mapT_s[c2] == 0) {
                mapS_t[c1] = c2;
                mapT_s[c2] = c1;
            }
            //Case2. if there is a mapping in either of the maps, then check if it is the same
            else if (mapS_t[c1] != c2 || mapT_s[c2] != c1) {
                return false;
            }
            
        }

        return true;

    }
    public static void main(String[] args) {
        String s = "foo";
        String t = "bar";

        System.out.println(isIsomorphic(s, t));

       
        
    }
}
