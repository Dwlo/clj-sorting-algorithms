(ns sorting-algorithms.selection-sort
  "Sorting using the selection sort algorithm."
  (:require [sorting-algorithms.utils :refer [remove-val]]))

(defn process
  [sorted-vals vals]
  (if (empty? vals)
    sorted-vals
    (let [min-val (apply min vals)]
      (process (conj sorted-vals min-val) (remove-val min-val vals)))))

(defn sort
  "Sorts values using the selection sort algorithm.
  Steps:
  |---------------+-----------------|
  | sorted vals   | unsorted vals   |
  |---------------+-----------------|
  | [ ]           | [4  2  1  3 ]   |
  | [1 ]          | [4  2  3 ]      |
  | [1  2 ]       | [4  3 ]         |
  | [1  2  3 ]    | [4 ]            |
  | [1  2  3  4 ] | [ ]             |
  |---------------+-----------------|"
  [vals]
  (process [] vals))
