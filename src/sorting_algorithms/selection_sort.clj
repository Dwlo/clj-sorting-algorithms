(ns sorting-algorithms.selection-sort
  "Sorting using the selection sort algorithm."
  (:require [sorting-algorithms.utils :refer [remove-item]]))

(defn process
  [ordered-items messy-items]
  (if (empty? messy-items)
    ordered-items
    (let [min-val (apply min messy-items)]
      (process (cons min-val ordered-items) (remove-item min-val messy-items)))))

(defn rsort
  "Sorts in reverse order using the selection sort algorithm.
  Steps:
  |---------------+-----------------|
  | ordered items | unordered items |
  |---------------+-----------------|
  | [ ]           | [1  4  2  3 ]   |
  | [1 ]          | [4  2  3 ]      |
  | [2  1 ]       | [4  3 ]         |
  | [3  2  1 ]    | [4 ]            |
  | [4  3  2  1 ] | [ ]             |
  |---------------+-----------------|"
  [items]
  (process [] items))
