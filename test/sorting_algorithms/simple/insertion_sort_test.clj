(ns sorting-algorithms.simple.insertion-sort-test
  (:require [sorting-algorithms.simple.insertion-sort :refer :all]
            [clojure.test :refer :all]
            [clojure.test.check :as tc]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :as chk]))

(defn descending?
  [coll]
  (every? (fn [[a b]] (>= a b))
          (partition 2 1 coll)))

(def property
  (prop/for-all [v (gen/vector gen/int)]
    (let [s (rsort v)]
      (and (= (count v) (count s))
           (descending? s)))))

(chk/defspec testing-reverse-sort
  1000
  property)
