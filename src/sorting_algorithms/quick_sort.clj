(ns sorting-algorithms.quick-sort
  "Sorting using the quick sort algorithm."
  (:require [sorting-algorithms.utils :refer [remove-val]]))


(defn sort
  "Sorts values using the quick sort algorithm.
  Steps:
  [3  4  2  1  5]
  [2 1] 3 [4  5]
  [1] 2 3  4 [5]
   1  2  3  4  5"
  [values]
  (if (empty? values)
    []
    (let [head           (first values)
          remaining-vals (remove-val head values)
          greaters       (filter #(>  % head) remaining-vals)
          smallers       (filter #(<= % head) remaining-vals)]
      (concat (sort smallers) [head] (sort greaters)))))
