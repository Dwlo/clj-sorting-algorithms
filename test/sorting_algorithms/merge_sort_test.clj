(ns sorting-algorithms.merge-sort-test
  (:require [sorting-algorithms.merge-sort   :refer [sort] ]
            [sorting-algorithms.test-utils   :as    tu      ]
            [clojure.test.check.clojure-test :as    chk     ]))


(chk/defspec testing-merge-sort
  1000
  (tu/property sort))
