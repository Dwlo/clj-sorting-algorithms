(ns sorting-algorithms.selection-sort-test
  (:require [sorting-algorithms.selection-sort :refer [sort] ]
            [sorting-algorithms.test-utils     :as    tu      ]
            [clojure.test.check.clojure-test   :as    chk     ]))

(chk/defspec testing-selection-sort
  1000
  (tu/property sort))
