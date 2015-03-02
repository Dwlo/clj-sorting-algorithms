(ns sorting-algorithms.insertion-sort
  "Sorting using the insertion sort algorithm.")


(defn insert-in-right-place
  "Inserts a value at the right place in the sorted vector."
  [sorted-values value]
  (if (empty? sorted-values)
    [value]
    (let [not-last-sorted-vals (pop sorted-values)
          last-val (peek sorted-values)]
        (if (>= value last-val)
        (conj sorted-values value)
        (conj (insert-in-right-place not-last-sorted-vals value) last-val)))))

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
  [items]
  (reduce insert-in-right-place [] items))

(defn rsort
  [vals]
  (reverse (sort vals)))
