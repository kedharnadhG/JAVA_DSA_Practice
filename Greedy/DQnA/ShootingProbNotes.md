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
# See this 

------------------------------------------------------------

***

# The Sum of Distances: Core Logic and Walkthrough

## The Core Formulas

For each index `i`, we calculate the total sum of distances `r1` from `i` to all non-zero elements in the array. This is done by summing two contributions: one from the left (`d1`) and one from the right (`d2`).

Let's define the key variables:
* **`c1`**: Count of non-zero elements to the left of and including the current index `i`.
* **`p1`**: Count of non-zero elements to the right of and including the current index `i`.
* **`sum_k1[i]`**: The prefix sum of indices of non-zero elements up to and including `i`.
* **`sumr_k1[i]`**: The suffix sum of indices of non-zero elements from `i` to the end.

The formulas for the contributions are as follows:

- **Left Contribution ($d1$)**: `d1 = i * c1 - sum_k1[i]`
- **Right Contribution ($d2$)**: `d2 = sumr_k1[i] - i * p1`
- **Total Distance ($r1$)**: `r1 = d1 + d2`

**Important**: At the moment of computation, both `c1` and `p1` still include the current index `i` if `k1[i] > 0`. This might seem confusing, but it's essential for the math to work, as explained in the section below. After the calculation for a given `i`, if `k1[i] > 0`, we decrement `p1` to prepare for the next iteration.

---

## Step-by-Step Walkthrough Table

Here is a full breakdown of the values at each index `i`.

| **i** | **k1[i]** | **before c1** | **after c1** | **p1 (before)** | **sum_k1[i]** | **sumr_k1[i]** | **d1** | **d2** | **r1** | **p1(after)** |
| :--- | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
| **1** | 1 | 0 | 1 | 4 | 1 | 12 | $1 \cdot 1 - 1 = 0$ | $12 - 1 \cdot 4 = 8$ | 8 | 3 |
| **2** | 2 | 1 | 2 | 3 | 3 | 11 | $2 \cdot 2 - 3 = 1$ | $11 - 2 \cdot 3 = 5$ | 6 | 2 |
| **3** | 0 | 2 | 2 | 2 | 3 | 9 | $3 \cdot 2 - 3 = 3$ | $9 - 3 \cdot 2 = 3$ | 6 | 2 |
| **4** | 4 | 2 | 3 | 2 | 7 | 9 | $4 \cdot 3 - 7 = 5$ | $9 - 4 \cdot 2 = 1$ | 6 | 1 |
| **5** | 5 | 3 | 4 | 1 | 12 | 5 | $5 \cdot 4 - 12 = 8$ | $5 - 5 \cdot 1 = 0$ | 8 | 0 |

---

## The Non-Double-Counting Principle

A key insight into this algorithm is understanding why including the current element `i` in both the prefix (`sum_k1`) and suffix (`sumr_k1`) sums doesn't lead to a double-count of distance.

The distance from the current element to itself is **always zero**.
* For `d1`, the term for the current element `i` is $(i - i) = 0$.
* For `d2`, the term for the current element `i` is also effectively $(i - i) = 0$.

Because the contribution of the current element to both the left and right distance sums is zero, its inclusion is mathematically harmless. It simplifies the implementation without affecting the final result. The total distance is correctly calculated as the sum of the absolute distances to all other non-zero elements.

**Algebraically**:
Let $L$ be the set of indices of non-zero elements to the left of or at $i$, and $R$ be the set of indices of non-zero elements to the right of or at $i$.
$d1 = \sum_{k \in L} (i - k)$
$d2 = \sum_{k \in R} (k - i)$

The total distance is $d1 + d2$. The only index where the sets $L$ and $R$ overlap is `i` itself. For this single shared index, the contributions are $(i - i) + (i - i) = 0$, so there's no double-counting. Each other index is counted exactly once, either in the left sum or the right sum.

---

## One-Line Intuitive Summary

This code elegantly includes the current index in both left and right distance calculations, and because the distance from an index to itself is zero, it contributes nothing to either sum, resulting in an accurate total distance without any double-counting.