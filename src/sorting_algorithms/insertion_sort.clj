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
        (-> sorted-values
            pop                           ;; compute rest of unsorted values
            (insert-at-right-place value)
            (conj last-val))))))

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
