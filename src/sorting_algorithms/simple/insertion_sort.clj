(ns sorting-algorithms.simple.insertion-sort
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
  "Sorts in reverse order the given numbers"
  [numbers]
  (reduce (fn [ns n] (insert ns n)) [] numbers))
