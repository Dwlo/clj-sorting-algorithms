(ns sorting-algorithms.quick-sort
  "Sorting using the quick sort algorithm.")


(defn sort
  "Sorts values using the quick sort algorithm.
  Steps:
  [3  4  2  1  5]
  [2 1] 3 [4  5]
  [1] 2 3  4 [5]
   1  2  3  4  5"
  [[head & tail :as values]]
  (if (empty? values)
    []
    (let [greaters (filter #(>  % head) tail)
          smallers (filter #(<= % head) tail)]
      (concat (sort smallers) [head] (sort greaters)))))
