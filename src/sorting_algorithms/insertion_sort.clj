(ns sorting-algorithms.insertion-sort
  "Sorting using the insertion sort algorithm.")


(defn insert
  "Inserts an item into a ordered vector."
  [ordered-items item]
  (if (empty? ordered-items)
    [item]
    (if (> item (first ordered-items))
      (cons item ordered-items)
      (cons (first ordered-items) (insert (rest ordered-items) item)))))

(defn rsort
  "Sorts in reverse order using the insertion sort algorithm.
  Steps:
  |---------------+-----------------|
  | ordered items | unordered items |
  |---------------+-----------------|
  |               |                 |
  | [ ]           | [1  4  2  3 ]   |
  | [1 ]          | [4  2  3 ]      |
  | [4  1 ]       | [2  3 ]         |
  | [4  2  1 ]    | [3 ]            |
  | [4  3  2  1 ] | [ ]             |
  |---------------+-----------------|"
  [items]
  (reduce (fn [ns n] (insert ns n)) [] items))
