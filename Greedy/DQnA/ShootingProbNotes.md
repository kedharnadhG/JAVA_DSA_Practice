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
