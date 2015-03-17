(ns sorting-algorithms.insertion-sort
  "Sorting using the insertion sort algorithm.")


(defn insert-at-right-place
  "Inserts a value at the right place in the sorted vector."
  [sorted-values value]
  (if (empty? sorted-values)
    [value]
    (let [last-val (peek sorted-values)]
      (if (>= value last-val)
        (conj sorted-values value)
        (let [not-last-sorted-vals (pop sorted-values)]
          (conj (insert-at-right-place not-last-sorted-vals value) last-val))))))

(defn sort
  "Sorts using the insertion sort algorithm.
  Steps:
  |----------------+------------------|
  | sorted vals    | not sorted vals  |
  |----------------+------------------|
  |                |                  |
  | [ ]            | [ 1  4  2  3 ]   |
  | [ 1 ]          | [ 4  2  3 ]      |
  | [ 1  4 ]       | [ 2  3 ]         |
  | [ 1  2  4 ]    | [ 3 ]            |
  | [ 1  2  3  4 ] | [ ]              |
  |----------------+------------------|"
  [vals]
  (reduce insert-at-right-place [] vals))
