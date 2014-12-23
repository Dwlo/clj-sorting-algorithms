(ns sorting-algorithms.quick-sort
  (:require [sorting-algorithms.utils :as  ut]))


(defn rsort
  "Sorts in reverse order using the quick sort algorithm.
  Example:
  [3  4  2  1  5 ]
  [4  5  3* 2  1 ]
  [5  4* 3* 2* 1 ]
  [5* 4* 3* 2* 1*]"
  [items]
  (if (empty? items)
    []
    (let [head            (first items)
          remaining-items (ut/remove-item head items)
          greaters        (filter #(>  % head) remaining-items)
          smallers        (filter #(<= % head) remaining-items)]
      (concat (rsort greaters) [head] (rsort smallers)))))
