(ns sorting-algorithms.bubble-sort
  "Sorting using the bubble sort algorithm.")


(defn bubblify
  "Bubbles the given values."
  [vals]
  (-> (fn [sorted-vals next-val]
        (cond
         (empty? sorted-vals) [next-val]
         (> next-val (peek sorted-vals)) (conj sorted-vals next-val)
         :else (conj (pop sorted-vals) next-val (peek sorted-vals))))
      (reduce [] vals)))

(defn rearrange
  "Rearranges the given values using the bubble sort method."
  [sorted-vals vals]
  (if (empty? vals)
    sorted-vals
    (let [bubbled-vals (bubblify vals)
          last-val (peek bubbled-vals)
          not-last-vals (pop bubbled-vals)]
      (rearrange (cons last-val sorted-vals) not-last-vals))))

(defn sort
  "Sorts the given values using the bubble sort algorithm.
  Example:
  |----------------+----------------|
  | sorted         | unsorted       |
  |----------------+----------------|
  | [ ]            | [ 2- 4- 1  3 ] |
  | [ ]            | [ 2  4- 1- 3 ] |
  | [ ]            | [ 2  1  4- 3-] |
  | [ ]            | [ 2  1  3  4*] |
  |----------------+----------------|
  | [ 4 ]          | [ 2- 1- 3 ]    |
  | [ 4 ]          | [ 1  2- 3-]    |
  | [ 4 ]          | [ 1  2  3*]    |
  |----------------+----------------|
  | [ 3  4 ]       | [ 1- 2-]       |
  | [ 3  4 ]       | [ 1  2*]       |
  |----------------+----------------|
  | [2  3  4 ]     | [ 1*]          |
  |----------------+----------------|
  | [ 1  2  3  4 ] | [ ]            |
  |----------------+----------------|"
  [vals]
  (rearrange [] vals))

(defn rsort [vals]
  (reverse (sort vals)))
