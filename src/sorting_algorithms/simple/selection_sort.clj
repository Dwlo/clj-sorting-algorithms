(ns sorting-algorithms.simple.selection-sort
  "Sorting using the selection sort algorithm."
  (:require [sorting-algorithms.utils :as  ut]))

(defn process
  [ordered-ns ns]
  (if (empty? ns)
    ordered-ns
    (let [min-val (apply min ns)]
      (process (cons min-val ordered-ns) (ut/remove-item min-val ns)))))

(defn rsort
  "Sorts in reverse order the given numbers"
  [numbers]
  (process [] numbers))
