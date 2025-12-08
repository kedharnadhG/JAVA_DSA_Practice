package DP;

import java.util.Arrays;

public class MCM {

    // p[]: dimensions array of length n
    // Number of matrices = n - 1
    // Matrix Ai has dimensions p[i-1] x p[i]

    public static int matrixChainOrder(int[] p) {
        int n = p.length;          // number of entries in p
        int N = n - 1;             // number of matrices

        int[][] m = new int[n][n]; // we will use m[1..N][1..N]

        // Base case: cost is 0 when multiplying one matrix (Ai..Ai)
        for (int i = 1; i <= N; i++) {
            m[i][i] = 0;
        }

        // l = chain length (number of matrices in the chain)
        for (int l = 2; l <= N; l++) {         // l from 2 to N
            for (int i = 1; i <= N - l + 1; i++) { // starting index
                int j = i + l - 1;             // ending index

                m[i][j] = Integer.MAX_VALUE;

                // Try all possible split points k
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k]                // cost of left side
                          + m[k + 1][j]            // cost of right side
                          + p[i - 1] * p[k] * p[j];// cost to multiply the results

                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }

        return m[1][N]; // minimal cost to multiply A1...AN
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 4, 1};
        System.out.println("Min scalar multiplications = " + matrixChainOrder(arr));
    }
}




/*          ⭐ MATRIX CHAIN MULTIPLICATION (MCM) ⭐
        ====================================================================

        Problem:
            Given a chain of matrices:
                A1, A2, ..., An
            where:
                A1 is p0 x p1
                A2 is p1 x p2
                ...
                An is p(n-1) x pn

            The input is an array p[] of length (n+1):
                p = {p0, p1, p2, ..., pn}

            Number of matrices = N = p.length - 1

        Goal:
            Find the minimum number of scalar multiplications needed to compute:
                A1 x A2 x ... x AN
            Parentheses can change the multiplication cost, but not the result.

        --------------------------------------------------------------------
                        ⭐ COST OF MULTIPLYING TWO MATRICES ⭐
        --------------------------------------------------------------------

        If we multiply a matrix of size (a x b) with (b x c),
        the number of scalar multiplications is:

                a * b * c

        --------------------------------------------------------------------
                        ⭐ DP STATE DEFINITION ⭐
        --------------------------------------------------------------------

        We define:
            m[i][j] = minimum cost to multiply matrices Ai..Aj

            i, j are matrix indices in [1..N].

        Base case:
            When i == j, there is only ONE matrix Ai.
            No multiplication is needed:

                m[i][i] = 0

        --------------------------------------------------------------------
                        ⭐ RECURSIVE RELATION (SPLITTING) ⭐
        --------------------------------------------------------------------

        To compute m[i][j]:

            We try all possible split points k between i and j-1:

                (Ai ... Ak)  x  (A(k+1) ... Aj)

            Cost if we split at k:

                cost_left   = m[i][k]
                cost_right  = m[k+1][j]

                After multiplying Ai..Ak, the result is a matrix of size:
                    p[i-1] x p[k]

                After multiplying A(k+1)..Aj, the result is size:
                    p[k] x p[j]

                Cost to multiply these two result matrices:
                    p[i-1] * p[k] * p[j]

            So total cost for split at k:

                q = m[i][k] + m[k+1][j] + p[i-1] * p[k] * p[j]

            We take the minimum over all k:

                m[i][j] = min over k in [i..j-1] of q

        --------------------------------------------------------------------
                        ⭐ ITERATIVE DP (TABULATION) ⭐
        --------------------------------------------------------------------

        We fill the table in order of increasing chain length l:

            l = 1 → single matrix (already 0)
            l = 2 → chains of length 2
            l = 3 → chains of length 3
            ...
            l = N → full chain A1..AN

        Outer loop: l = chain length
        Inner loop: i = starting index
                    j = i + l - 1 = ending index

        For each (i, j) and valid k in [i..j-1], we update:

            m[i][j] = min(
                            m[i][j],
                            m[i][k] + m[k+1][j] + p[i-1]*p[k]*p[j]
                        )

        Answer:
            Minimum cost to multiply A1..AN is stored in:

                m[1][N]

        ====================================================================
*/
