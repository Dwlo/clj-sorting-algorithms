(ns sorting-algorithms.insertion-sort-test
  (:require [sorting-algorithms.insertion-sort :refer [sort] ]
            [sorting-algorithms.test-utils     :as    tu      ]
            [clojure.test.check.clojure-test   :as    chk     ]))

(chk/defspec testing-insertion-sort
  1000
  (tu/property sort))
