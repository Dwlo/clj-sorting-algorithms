(ns sorting-algorithms.selection-sort-test
  (:require [sorting-algorithms.selection-sort :refer [rsort] ]
            [sorting-algorithms.test-utils     :as    tu      ]
            [clojure.test.check.clojure-test   :as    chk     ]))

(chk/defspec testing-selection-sort
  1000
  (tu/property rsort))
