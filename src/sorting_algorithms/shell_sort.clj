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
  (map ins-srt/sort sliced-items))

(defn process
  [gap items]
  (remove nil?
          (->> items
               (slice-items gap)
               sort-slices
               fill-with-nils
               (apply interleave))))

(defn sort
  "Sorts using the shell sort algorithm.
  Example:
  [5 1 6 7 2 4 3 8 9 ] k = 4

  [5  2  9]   ---|
  [1  4]      ---|
  [6  3]      ---|--- slices
  [7  8]      ---|

  [2  5  9]   ---|
  [1  4]      ---|
  [3  6]      ---|--- sorted slices
  [7  8]      ---|

  [2  1  3  7  5  4  6  8  9] k = 2

  [2  3  5  6  9]  ---|
  [1  7  4  8]     ---|-- slices

  [2  3  5  6  9]  ---|
  [1  4  7  8]     ---|-- sorted slices

  [2  1  3  4  5  7  6  8  9] k = 1

  [2  1  3  4  5  7  6  8  9] |-- slice

  [1  2  3  4  5  6  7  8  9] |-- sorted slice"

  [items]
  (let [starting-gap  (quot (count items) 2)
        gaps (take-while #(not (zero? %))
                         (iterate #(quot % 2) starting-gap))]
    (reduce #(process %2 %1) items gaps)))

(defn rsort
  [vals]
  (reverse (sort vals)))
