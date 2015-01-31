(ns sorting-algorithms.quick-sort
  "Sorting using the quick sort algorithm."
  (:require [sorting-algorithms.utils :refer [remove-item]]))


(defn rsort
  "Sorts in reverse order using the quick sort algorithm.
  Steps:
  [3  4  2  1  5 ]
  [4  5  3* 2  1 ]
  [5  4* 3* 2* 1 ]
  [5* 4* 3* 2* 1*]"

  [items]
  (if (empty? items)
    []
    (let [head            (first items)
          remaining-items (remove-item head items)
          greaters        (filter #(>  % head) remaining-items)
          smallers        (filter #(<= % head) remaining-items)]
      (concat (rsort greaters) [head] (rsort smallers)))))
