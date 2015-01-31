(ns sorting-algorithms.quick-sort-test
  (:require [sorting-algorithms.quick-sort   :refer [rsort] ]
            [sorting-algorithms.test-utils   :as    tu      ]
            [clojure.test.check.clojure-test :as    chk     ]))

(chk/defspec testing-quick-sort
  1000
  (tu/property rsort))
