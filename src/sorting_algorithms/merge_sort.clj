(ns sorting-algorithms.merge-sort
  "Sorting using merge sort algorithm.")

(defn explode
  "Explodes an vecotr with one or many items into multiples single item vectors."
  [items]
  (for [i items] [i]))

(defn merge-sort
  "Merges and sorts two arrays already sorted in reverse order."
  [items1 items2]
  (let [head1 (first items1)
        head2 (first items2)]
    (cond
     (empty? items1) items2
     (empty? items2) items1
     (< head1 head2) (cons head2 (merge-sort items1 (drop 1 items2)))
     :else (cons head1 (merge-sort (drop 1 items1) items2)))))

(defn rsort
  "Sorts in reverse using the merge sort algorithm.
  Example:
  [1  4  2  3 ]
  [1] [4] [2] [3]
  [1 4]   [2 3]
  [1* _  _  _ ]
  [1* 2* _  _ ]
  [1* 2* 3* _ ]
  [1* 2* 3* 4*]"
  [items]
  (reduce merge-sort [] (explode items)))