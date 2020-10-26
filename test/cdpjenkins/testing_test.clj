(ns cdpjenkins.testing-test
  (:require [clojure.test :refer :all]
            [cdpjenkins.testing :refer :all]))

(deftest test-play
  (testing "Moves and shizzle"
    (are [player1 player2] (= 0 (play player1 player2))
      :rock :scissors
      :scissors :paper
      :paper :rock)
    (are [player1 player2] (= 1 (play player1 player2) )
      :scissors :rock
      :paper :scissors
      :rock :paper)))


(deftest test-dna-to-rnag
  (testing "DNA to RNA mappings"
    (are [dna expected-rna] (= expected-rna (dna-to-rna dna))
      "GCTA" "CGAU")))

(deftest throws-exception-for-invalid-nucleotides
  (is (thrown? AssertionError (dna-to-rna "CONTAINS INVALID CHARS"))))

