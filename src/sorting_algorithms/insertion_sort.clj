(ns sorting-algorithms.insertion-sort
  "Sorting using the insertion sort algorithm.")


(defn insert
  "Inserts a number into a ordered vector."
  [ordered-ns n]
  (if (empty? ordered-ns)
    [n]
    (if (> n (first ordered-ns))
      (cons n ordered-ns)
      (cons (first ordered-ns) (insert (rest ordered-ns) n)))))

(defn rsort
  "Sorts in reverse order using the insertion sort algorithm.
  Example:
  [1  4  2  3 ]
  [4  1  2  3 ]
  [4  2  1  3 ]
  [4  2  3  1 ]
  [4* 3* 2* 1*]"
  [numbers]
  (reduce (fn [ns n] (insert ns n)) [] numbers))
