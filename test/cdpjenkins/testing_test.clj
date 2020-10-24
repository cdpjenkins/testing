(ns cdpjenkins.testing-test
  (:require [clojure.test :refer :all]
            [cdpjenkins.testing :refer :all]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))

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
