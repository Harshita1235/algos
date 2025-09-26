# Algorithms Assignment

## Architecture Notes
- **MergeSort**
  - Uses divide and conquer (split in half).
  - Reuses one buffer array → less memory use.
  - Switches to insertion sort for small arrays (faster in practice).
- **QuickSort**
  - Picks a random pivot to avoid bad cases.
  - Recurses only on the smaller side, handles the bigger side with a loop → avoids deep recursion.
- **Deterministic Select**
  - Groups numbers into chunks of 5 → finds median of medians as pivot.
  - Only needs to recurse into one side (the side with the `k`th element).
- **Closest Pair**
  - Sort points by x once.
  - Divide points into left/right halves and check “strip” near the middle.
  - Each point only checks a few (≤7) neighbors.

---

## Recurrence Analysis
- **MergeSort**: `T(n) = 2T(n/2) + Θ(n)` → **Θ(n log n)**  
- **QuickSort**: `T(n) = T(smaller) + T(larger)` → **Expected Θ(n log n)**  
- **Deterministic Select**: `T(n) = T(n/5) + T(7n/10) + Θ(n)` → **Θ(n)**  
- **Closest Pair**: `T(n) = 2T(n/2) + Θ(n)` → **Θ(n log n)**  

---

## Plots (to be added)
- Time vs n (runtime in ms).
- Depth vs n (recursion depth).
- Notes about constants:
  - Small n → insertion sort is faster (cache-friendly).
  - QuickSort can vary because of random pivots.
  - Closest Pair has some hidden overhead from sorting strips.

---

## Summary
- MergeSort and Closest Pair behaved like `n log n`.
- QuickSort usually `n log n`, sometimes slower (bad pivots).
- Deterministic Select is linear, but slower constants than QuickSort.
- Overall: theory matches practice, but constants (cache, GC) affect results.
