# Understanding Left & Right Contributions (Avoiding Double Counting)

We are analysing the contribution of each index when computing pairs `(i, j)` such that both belong to the same group `k`.  
The goal is to carefully split contributions into **left** (past elements) and **right** (future elements), without double counting the current index.

---

## Key Variables in Code

- `c1` → number of elements of group `k1` seen so far (left count).
- `p1` → total count of group `k1` elements **not yet processed** (right count).
- `sumr_k1[i]` → suffix sum of positions for group `k1`.
- `suml_k1[i]` → prefix sum of positions for group `k1`.

---

## Formula Breakdown

At each index `i`:

- **Left contribution**:  
  `d1 = i * c1 - suml_k1[c1]`

- **Right contribution**:  
  `d2 = sumr_k1[i] - i * p1`

Total contribution from index `i` = `d1 + d2`.

---

## Why Not Double Counting?

At first glance, it looks like we might double-count the current index because:

- It is included in `c1` (left side).
- It is also included in `p1` (right side).

But here’s the trick:

- `c1` is incremented **only after using current index `i`**.  
  → So, while computing left part, `c1` includes the current index correctly.
- After finishing with index `i`, we decrement `p1`.  
  → So, for the next iteration, right count reflects only _future_ elements.

---

## Walkthrough Example

Let’s take:  
`n = 5, b = [1, 3, 2, 1, 3]`  
Group `k1 = {1, 2, 4, 5}`, total = 4.

### Step i = 1

- Current = `b[1] = 1`, belongs to group `k1`.
- Left:
  - `c1 = 1`
  - `suml_k1[1] = 1`
  - `d1 = 1*1 - 1 = 0`
- Right:
  - `p1 = 4` (includes indices `{1,2,4,5}`)
  - `sumr_k1[1] = 12` (1+2+4+5)
  - `d2 = 12 - 1*4 = 8`
- Total = 8.
- Update: `p1-- → 3` (remaining `{2,4,5}`).

### Step i = 2

- Current = `b[2] = 3`, group `k1`.
- Left:
  - `c1 = 2`
  - `suml_k1[2] = 1+2 = 3`
  - `d1 = 2*2 - 3 = 1`
- Right:
  - `p1 = 3` (remaining `{2,4,5}`)
  - `sumr_k1[2] = 11` (2+4+5)
  - `d2 = 11 - 2*3 = 5`
- Total = 6.
- Update: `p1-- → 2` (remaining `{4,5}`).

### Step i = 3

- Current = `b[3] = 2`, **not in group**, skip.

### Step i = 4

- Current = `b[4] = 1`, group `k1`.
- Left:
  - `c1 = 3`
  - `suml_k1[3] = 1+2+4 = 7`
  - `d1 = 4*3 - 7 = 5`
- Right:
  - `p1 = 2` (remaining `{4,5}`)
  - `sumr_k1[4] = 9` (4+5)
  - `d2 = 9 - 4*2 = 1`
- Total = 6.
- Update: `p1-- → 1`.

### Step i = 5

- Current = `b[5] = 3`, group `k1`.
- Left:
  - `c1 = 4`
  - `suml_k1[4] = 1+2+4+5 = 12`
  - `d1 = 5*4 - 12 = 8`
- Right:
  - `p1 = 1` (remaining `{5}`)
  - `sumr_k1[5] = 5`
  - `d2 = 5 - 5*1 = 0`
- Total = 8.
- Update: `p1-- → 0`.

---

## Final Insight

- No double counting happens because:
  - Left always includes current (`c1`).
  - Right always excludes current (due to `p1` being decremented after use).
- The formulas ensure **every pair is counted exactly once**.

---
-- See this 

------------------------------------------------------------
The core formulas in the code (per i)
if (k1[i] > 0) c1++;                // include current in left-count
d1 = i * c1 - sum_k1[i];            // left contribution = sum_{k in L} (i - k)
d2 = sumr_k1[i] - i * p1;           // right contribution = sum_{k in R} (k - i)
r1 = d1 + d2
if (k1[i] > 0) p1--;                // remove current from remaining count for next i


Important: at time of computing d1 and d2, c1 includes current, and p1 still includes current. That’s what causes confusion — but the math below shows this is harmless.

Full step-by-step table (values at each i)

Columns: i | k1[i] | before c1 | after c1 | p1 (before) | sum_k1[i] | sumr_k1[i] | d1 | d2 | r1 | p1(after)

i=1:
 k1[1]=1
 before c1 = 0
 after c1  = 1            // we did c1++
 p1 (before) = 4
 sum_k1[1] = 1
 sumr_k1[1] = 12
 d1 = 1*1 - 1 = 0        // left distances: (1-1)=0
 d2 = 12 - 1*4 = 8       // right distances: (1-1)+(2-1)+(4-1)+(5-1)=0+1+3+4=8
 r1 = 0 + 8 = 8
 p1(after) = 3           // p1-- after iteration

i=2:
 k1[2]=2
 before c1 = 1
 after c1  = 2
 p1 (before) = 3
 sum_k1[2] = 3
 sumr_k1[2] = 11
 d1 = 2*2 - 3 = 1        // left distances: (2-1)+(2-2)=1+0=1
 d2 = 11 - 2*3 = 5       // right distances: (2-2)+(4-2)+(5-2)=0+2+3=5
 r1 = 1 + 5 = 6
 p1(after) = 2

i=3:
 k1[3]=0
 before c1 = 2
 after c1  = 2           // unchanged
 p1 (before) = 2
 sum_k1[3] = 3
 sumr_k1[3] = 9
 d1 = 3*2 - 3 = 3        // left distances (to i=3): (3-1)+(3-2)=2+1=3
 d2 = 9 - 3*2 = 3        // right distances (4,5 to 3): (4-3)+(5-3)=1+2=3
 r1 = 3 + 3 = 6
 p1(after) = 2           // unchanged (k1[3]==0)

i=4:
 k1[4]=4
 before c1 = 2
 after c1  = 3
 p1 (before) = 2
 sum_k1[4] = 7
 sumr_k1[4] = 9
 d1 = 4*3 - 7 = 5        // left distances to 4: (4-1)+(4-2)+(4-4)=3+2+0=5
 d2 = 9 - 4*2 = 1        // right distances: (4-4)+(5-4)=0+1=1
 r1 = 5 + 1 = 6
 p1(after) = 1

i=5:
 k1[5]=5
 before c1 = 3
 after c1  = 4
 p1 (before) = 1
 sum_k1[5] = 12
 sumr_k1[5] = 5
 d1 = 5*4 -12 = 8        // left distances to 5: (5-1)+(5-2)+(5-4)+(5-5)=4+3+1+0=8
 d2 = 5 - 5*1 = 0        // right distances: none -> 0
 r1 = 8 + 0 = 8
 p1(after) = 0

Why this does not double-count the current element

Both sum_k1[i] (prefix) and sumr_k1[i] (suffix) include the current index i when k1[i] > 0.

Both d1 and d2 therefore include a term for the current element — but the term is zero in both:

In d1 the current contributes (i - i) = 0.

In d2 the current contributes (i - i) = 0 (since sumr contributes +i and i*p1 includes one i for the current).

So the current index shows up in both sums, but its contribution is zero — no double counting of distance happens.

Algebraically:

Let L = {k in k1 | k ≤ i}, R = {k in k1 | k ≥ i} (note both sets include i if i is in k1).

d1 = ∑_{k∈L} (i - k) and d2 = ∑_{k∈R} (k - i).

d1 + d2 = ∑_{k∈L} (i - k) + ∑_{k∈R} (k - i)
The only overlap is k = i, for which both (i - i) and (i - i) are 0. All other indices are counted exactly once (left or right side) in their correct sign. So the total is sum of absolute distances of every k1-position to i — correct and not double-counted.

One-line intuitive summary

The code includes the current index in both prefix and suffix arrays for convenience, but because the distance from the current index to itself is zero, it contributes nothing to either side — hence no double counting. After computing, the code decrements p1 so that for the next iteration p1 truly represents the remaining elements to the right.