package DP;

//a catalan number is a number that can be expressed as a sum of two smaller catalan numbers, and the product of two smaller catalan numbers (widely used in combinatorics i.e counting problems).
public class catalanNum {


    public static int catalan(int n){
        int catalan[] = new int[n+2];
        catalan[0] = 1;
        catalan[1] = 1;

        for(int i =2; i<=n; i++){
            catalan[i] = 0;
            for(int j=0; j<i; j++){
                catalan[i] += catalan[j]*catalan[i-j-1];
            }
        }

        return catalan[n];
    }

    public static void main(String[] args) {
        int n1 = 3;
        System.out.println("catalan number at index "+n1+" is: "+catalan(n1));
        
        int n = 4;
        System.out.println("catalan number at index "+n+" is: "+catalan(n));

    }
    
}




/*                  ⭐ CATALAN NUMBERS ⭐
    ====================================================================

    Catalan numbers count many recursive structures such as:
    - Number of unique BSTs with n keys
    - Number of valid parentheses strings of length 2n
    - Number of ways to triangulate a polygon
    - Number of full binary trees with n+1 leaves
    - Many more...

    The key idea:
        Any structure counted by Catalan numbers can be split into
        a "left part" and a "right part", and both parts are 
        themselves smaller Catalan structures.

    ====================================================================
                    ⭐ RECURSIVE DEFINITION (STRUCTURAL) ⭐
    ====================================================================

    Let C[n] = number of Catalan structures using n elements.

    To build a structure of size n:

        Pick each element as root/split point.
        Suppose we pick position j as the root (0 ≤ j < n):

            - Left side has j elements  → contributes   C[j]
            - Right side has (n - 1 - j) elements → contributes C[n-1-j]

    For each root position j:
            Total structures = C[j] * C[n-1-j]

    We add this over all possible root/split choices:

            C[n] = Σ ( C[j] * C[n-1-j] ), for j = 0 to n-1

    This is the famous Catalan recurrence.

    ====================================================================
                        ⭐ BASE CASES ⭐
    ====================================================================

    C[0] = 1  → empty structure (valid)
    C[1] = 1  → only one structure

    ====================================================================
                        ⭐ DP IMPLEMENTATION ⭐
    ====================================================================

    We fill C[0], C[1], C[2], ..., C[n] in increasing order.
    For each C[i], we compute:

            C[i] = C[0]*C[i-1] +
                    C[1]*C[i-2] +
                    ...
                    C[i-1]*C[0]

    This is exactly what the nested loop computes:

        for (int i = 2; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

    ====================================================================
                    ⭐ CLOSED-FORM FORMULA (MATHEMATICAL) ⭐
    ====================================================================

    Catalan number also has a combinatorial formula:

            C[n] = (2n)! / ( (n+1)! * n! )

    But this formula DOES NOT help with intuition.
    The DP version shows *why* Catalan numbers arise.

    ====================================================================
                        ⭐ SUMMARY TO REMEMBER ⭐
    ====================================================================

    1. Catalan structures split naturally into Left and Right parts.
    2. For each split:
            Total = LeftCount × RightCount
    3. Add over all possible splits.
    4. That multiplication + summation pattern creates the Catalan recurrence.

    ====================================================================
*/
