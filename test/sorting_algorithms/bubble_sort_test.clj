(ns sorting-algorithms.bubble-sort-test
  (:require [sorting-algorithms.bubble-sort  :refer [sort] ]
            [sorting-algorithms.test-utils   :as    tu      ]
            [clojure.test.check.clojure-test :as    chk     ]))

(chk/defspec testing-bubble-sort
  1000
  (tu/property sort))
