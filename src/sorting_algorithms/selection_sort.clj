(ns sorting-algorithms.selection-sort
  "Sorting using the selection sort algorithm."
  (:require [sorting-algorithms.utils :as  ut]))

(defn process
  [ordered-ns ns]
  (if (empty? ns)
    ordered-ns
    (let [min-val (apply min ns)]
      (process (cons min-val ordered-ns) (ut/remove-item min-val ns)))))

(defn rsort
  "Sorts in reverse order using the selection sort algorithm.
  Example:
  [1  4  2  3 ]
  [4* 1  2  3 ]
  [4* 3* 1  2 ]
  [4* 3* 2* 1 ]
  [4* 3* 2* 1*]"
  [numbers]
  (process [] numbers))
