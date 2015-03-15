(ns sorting-algorithms.utils
  "Utilities functions used by the sort algorithms and not directly related to the sort algorithm.")


(defn remove-val
  "Removes the first given item from the vector."
  [n ns]
  (->> (take-while #(not= % n ) ns)
       (merge (rest (drop-while #(not= % n) ns)))
       (flatten)))
