(ns sorting-algorithms.shell-sort
  "Sort using the shell sort algorithm."
  (:require [sorting-algorithms.insertion-sort :as ins-srt]))

(defn fill-with-nils
  "Fills the vectors with nil values to have same length"
  [vectors]
  (let [max-count (apply max (map #(count %) vectors))]
    (map #(concat % (repeat (- max-count (count %)) nil)) vectors)))

(defn slice-items
  "Divides into slices the given items based on the gap."
  [gap items]
  (for [i (range 0 gap)] (take-nth gap (drop i items))))

(defn sort-slices
  "Sorts the given slices using the insertion sort."
  [sliced-items]
  (map ins-srt/rsort sliced-items))

(defn process
  [gap items]
  (remove nil?
          (->> items
               (slice-items gap)
               sort-slices
               fill-with-nils
               (apply interleave))))

(defn rsort
  "Sorts in reverse order using the shell sort algorithm.
  Example:
  [5 1 6 7 2 4 3 8 9 ] k = 4

  [5 2 9]     ---|
  [1 4]       ---|
  [6 3]       ---|--- slices
  [7 8]       ---|

  [9 5 2]     ---|
  [4 1]       ---|
  [6 3]       ---|--- sorted slices
  [8 7]       ---|


  [9 4 6 8 5 1 3 7 2] k = 2

  [9 6 5 3 2] ---|
  [4 8 1 7]   ---|-- slices

  [9 6 5 3 2] ---|
  [8 7 4 1]   ---|-- sorted slices

  [9 8 6 7 5 4 3 1 2] k = 1

  [9 8 6 7 5 4 3 1 2] |-- slice

  [9 8 7 6 5 4 3 2 1] |-- sorted slice

  [9 8 7 6 5 4 3 2 1] * sorted vector"

  [items]
  (let [starting-gap  (quot (count items) 2)
        gaps (take-while #(not (zero? %))
                         (iterate #(quot % 2) starting-gap))]
    (reduce #(process %2 %1) items gaps)))
