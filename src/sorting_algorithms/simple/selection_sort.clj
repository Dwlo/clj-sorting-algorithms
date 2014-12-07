(ns sorting-algorithms.simple.selection-sort
  "Sorting using the selection sort algorithm.")

(defn remove-item
  "Removes the first given item from the vector."
  [n ns]
  (->> (take-while #(not= % n ) ns)
       (merge (rest (drop-while #(not= % n) ns)))
       (flatten)))

(defn process
  [ordered-ns ns]
  (if (empty? ns)
    ordered-ns
    (let [min-val (apply min ns)]
      (process (cons min-val ordered-ns) (remove-item min-val ns)))))

(defn rsort
  "Sorts in reverse order the given numbers"
  [numbers]
  (process [] numbers))
