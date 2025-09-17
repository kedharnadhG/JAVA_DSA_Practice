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

---

````markdown
# Aarsi & Krypto Shooting Problem – Detailed Notes

## Problem Context
We are asked to compute distances between a chosen shooting index `i` and all positions where enemies (`k1`) are present. The challenge is to avoid **double-counting** the current index when it appears in both left and right contributions.

---

## Core Idea
For each position `i`, we compute:

- **Left Contribution (d1)**  
  ```java
  d1 = i * c1 - sum_k1[i];
````

where

* `c1` = count of enemies seen so far (including current if any).
* `sum_k1[i]` = prefix sum of positions up to `i`.

This expands to:

$$
d1 = \sum_{k \in L} (i - k)
$$

where `L = {k | k ≤ i}`.

* **Right Contribution (d2)**

  ```java
  d2 = sumr_k1[i] - i * p1;
  ```

  where

  * `p1` = remaining count of enemies (including current if any).
  * `sumr_k1[i]` = suffix sum of positions from `i` to end.

  This expands to:

  $$
  d2 = \sum_{k \in R} (k - i)
  $$

  where `R = {k | k ≥ i}`.

* **Total Result**

  ```java
  r1 = d1 + d2;
  ```

---

## Why Current Index is Zero Contribution

* In `d1`, the current element contributes `(i - i) = 0`.
* In `d2`, the current element contributes `(i - i) = 0`.

Thus, although `i` appears in both `L` and `R`, its contribution is **zero** in both places, avoiding double-counting.

---

## Dry Run Example

Let’s take enemy positions:

```
k1 = [1, 2, 2, 4, 5]
```

We maintain:

* `c1` → prefix count.
* `p1` → suffix count.
* `sum_k1[i]` → prefix sums.
* `sumr_k1[i]` → suffix sums.

### Step-by-Step Table

| i | k1\[i] | c1 (before) | c1 (after) | p1 (before) | sum\_k1\[i] | sumr\_k1\[i] | d1 (left) | d2 (right) | r1 = d1+d2 | p1 (after) |
| - | ------ | ----------- | ---------- | ----------- | ----------- | ------------ | --------- | ---------- | ---------- | ---------- |
| 1 | 1      | 0           | 1          | 4           | 1           | 12           | 0         | 8          | 8          | 3          |
| 2 | 2      | 1           | 2          | 3           | 3           | 11           | 1         | 5          | 6          | 2          |
| 3 | 0      | 2           | 2          | 2           | 3           | 9            | 3         | 3          | 6          | 2          |
| 4 | 4      | 2           | 3          | 2           | 7           | 9            | 5         | 1          | 6          | 1          |
| 5 | 5      | 3           | 4          | 1           | 12          | 5            | 8         | 0          | 8          | 0          |

---

### Verification of Each Step

* **i=1**

  * Left distances: (1-1)=0
  * Right distances: (2-1)+(2-1)+(4-1)+(5-1)=1+1+3+4=8
  * Total = 0+8=8

* **i=2**

  * Left distances: (2-1)+(2-2)=1+0=1
  * Right distances: (2-2)+(4-2)+(5-2)=0+2+3=5
  * Total = 6

* **i=3**

  * Left distances: (3-1)+(3-2)=2+1=3
  * Right distances: (4-3)+(5-3)=1+2=3
  * Total = 6

* **i=4**

  * Left distances: (4-1)+(4-2)+(4-4)=3+2+0=5
  * Right distances: (4-4)+(5-4)=0+1=1
  * Total = 6

* **i=5**

  * Left distances: (5-1)+(5-2)+(5-4)+(5-5)=4+3+1+0=8
  * Right distances: none = 0
  * Total = 8

---

## Why No Double Counting

Both prefix (`sum_k1[i]`) and suffix (`sumr_k1[i]`) include the current index.

* In left contribution: `(i - i) = 0`
* In right contribution: `(i - i) = 0`

So including the current in both is **harmless**.

Formally:

$$
d1 + d2 = \sum_{k∈L} (i - k) + \sum_{k∈R} (k - i)
$$

The overlap happens only when `k=i`, but that adds **0+0**.
All other terms are counted exactly once, giving the correct sum of absolute distances.

---

## One-Line Summary

The code safely includes the current index in both prefix and suffix because its self-distance is zero. Hence, no double counting occurs, and the result correctly represents the total distance to all enemy positions.

```

---

This is now a **single structured Markdown file** with:  
✅ Headings  
✅ Code/formulas  
✅ Dry-run table  
✅ Step-by-step explanations  
✅ Final intuition  

Do you want me to also include a **Java code block** at the end of the `.md` (so you can run & test alongside notes), or keep this purely as explanatory notes?
```
.