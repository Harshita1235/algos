Algorithms Assignment
1. Architecture Notes
MergeSort

Uses divide and conquer (split in half).

Reuses one buffer array → less memory use.

Switches to insertion sort for small arrays (faster in practice).

QuickSort

Picks a random pivot to avoid bad cases.

Recurses only on the smaller side, handles the bigger side with a loop → avoids deep recursion.

Deterministic Select

Groups numbers into chunks of 5 → finds median of medians as pivot.

Only needs to recurse into one side (the side with the k-th element).

Closest Pair

Sort points by x once.

Divide points into left/right halves and check the “strip” near the middle.

Each point only checks a few (≤ 7) neighbors.

2. Recurrence Analysis

MergeSort:
T(n) = 2T(n/2) + Θ(n) → Θ(n log n)

QuickSort:
T(n) = T(smaller) + T(larger) + Θ(n) → Expected Θ(n log n)

Deterministic Select:
T(n) = T(n/5) + T(7n/10) + Θ(n) → Θ(n)

Closest Pair:
T(n) = 2T(n/2) + Θ(n) → Θ(n log n)

3. Plots (to be added)
Runtime vs Input Size (n)

MergeSort & Closest Pair → grow like n log n.

QuickSort → usually n log n, but with variability (random pivots).

Deterministic Select → roughly linear, but larger constant factors.

 (Insert plot here: x-axis = n, y-axis = runtime in ms)

Recursion Depth vs Input Size (n)

MergeSort depth = log₂(n).

QuickSort depth = ~log n on average, can degrade on bad pivots.

Deterministic Select depth = O(log n).

Closest Pair depth = log₂(n).

📊 (Insert plot here: x-axis = n, y-axis = max recursion depth)

4. Notes about Constants

For small n, insertion sort is faster (cache-friendly).

QuickSort may slow down due to unlucky pivots.

Closest Pair has extra overhead from sorting strips.

5. Summary

MergeSort and Closest Pair behaved like Θ(n log n).

QuickSort usually Θ(n log n), but sometimes slower with bad pivots.

Deterministic Select is linear, but slower constants than QuickSort.

Overall: theory matches practice, but constants (cache, GC) affect results.

6. Testing Notes

MergeSort & QuickSort: verified correctness on random + adversarial arrays, recursion depth bounded by O(log n).

Deterministic Select: cross-checked with Arrays.sort(a)[k].

Closest Pair: validated against brute-force O(n²) for small n (≤ 2000).
