(ns sorting-algorithms.bubble-sort
  "Sorting using the bubble sort algorithm.")


(defn binary-sort-step
  [traversed-items next-item-to-travese]
  (if (empty? traversed-items)
    [next-item-to-travese]
    (if (> next-item-to-travese (first traversed-items))
      (cons next-item-to-travese traversed-items)
      (cons (first traversed-items) (cons next-item-to-travese (rest traversed-items))))))

(defn traverse
  [items]
  (if (empty? items)
    []
    (reduce binary-sort-step [] items)))


(defn rsort
  "Sorts in reverse order using the bubble sort algorithm.
  Example:
  [1  4  2  3 ]
  [1  4  3  2 ]
  [1  4  3  2 ]
  [4* 1  3  2 ]
  [4* 1  3  2 ]
  [4* 3* 1  2 ]
  [4* 3* 2* 1 ]
  [4* 3* 2* 1*]"
  [items]
  (if (empty? items)
    []
    (let [result (traverse items)]
      (cons (first result) (rsort (rest result))))))
