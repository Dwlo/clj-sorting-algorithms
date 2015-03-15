(ns sorting-algorithms.test-utils
  (:require [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]))

(defn ascending?
  [coll]
  (every? (fn [[a b]] (<= a b))
          (partition 2 1 coll)))

(defn property
  [fun-sort]
  (prop/for-all [v (gen/vector gen/int)]
    (let [s (fun-sort v)]
      (and (= (count v) (count s))
           (ascending? s)))))
