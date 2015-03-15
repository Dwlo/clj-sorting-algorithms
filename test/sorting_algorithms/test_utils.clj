(ns sorting-algorithms.test-utils
  (:require [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]))

(defn ascending?
  [coll]
  (every? (fn [[a b]] (<= a b))
          (partition 2 1 coll)))

(defn property
  [fun-sort]
  (prop/for-all [random-vals (gen/vector gen/int)]
    (let [sorted-vals (fun-sort random-vals)]
      (and (= (count random-vals) (count sorted-vals))
           (ascending? sorted-vals)))))
