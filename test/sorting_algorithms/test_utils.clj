(ns sorting-algorithms.test-utils
  (:require [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]))

(defn descending?
  [coll]
  (every? (fn [[a b]] (>= a b))
          (partition 2 1 coll)))

(defn property
  [rsort]
  (prop/for-all [v (gen/vector gen/int)]
    (let [s (rsort v)]
      (and (= (count v) (count s))
           (descending? s)))))
