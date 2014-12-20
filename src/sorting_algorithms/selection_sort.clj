(ns sorting-algorithms.selection-sort
  "Sorting using the selection sort algorithm."
  (:require [sorting-algorithms.utils :as  ut]))

(defn process
  [ordered-items messy-items]
  (if (empty? messy-items)
    ordered-items
    (let [min-val (apply min messy-items)]
      (process (cons min-val ordered-items) (ut/remove-item min-val messy-items)))))

(defn rsort
  "Sorts in reverse order using the selection sort algorithm.
  Example:
  [1  4  2  3 ]
  [4* 1  2  3 ]
  [4* 3* 1  2 ]
  [4* 3* 2* 1 ]
  [4* 3* 2* 1*]"
  [items]
  (process [] items))
