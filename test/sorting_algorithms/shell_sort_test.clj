(ns sorting-algorithms.shell-sort-test
  (:require [sorting-algorithms.shell-sort   :refer  [sort]]
            [sorting-algorithms.test-utils   :as     tu     ]
            [clojure.test.check.clojure-test :as     chk    ]))


(chk/defspec testing-shell-sort
  1000
  (tu/property sort))
