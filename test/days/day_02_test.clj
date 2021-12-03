(ns days.day-02-test
  (:require [clojure.test :refer [is deftest testing]]
            [days.day-02 :as sut]
            [clojure.string :as str]))

(def depths ["forward 5"
             "down 5"
             "forward 8"
             "up 3"
             "down 8"
             "forward 2"])


(def sub (sut/init-sub))



(deftest day-02-tests
  (testing "parse-command"
    (testing "should return the command and the number value"
      (is (= [:forward 5] (sut/parse-command "forward 5")))
      (is (= [:down 5] (sut/parse-command "down 5")))
      (is (= [:up 3] (sut/parse-command "up 3")))))


  (testing "command-move"
    (testing "should return the new position"
      (is (= [0 1] (sut/command-move [1 1] [:up 1])))
      (is (= [2 1] (sut/command-move [1 1] [:down 1])))
      (is (= [2 3] (sut/command-move [2 1] [:forward 2])))))

  (testing "init-sub"
    (testing "should initialise the state of a sub"
      (is (= 0 (:aim (sut/init-sub))))
      (is (= 0 (:depth (sut/init-sub))))
      (is (= 0 (:horizontal-position (sut/init-sub))))))


  (testing "up"
    (testing "should change the aim value negatively"
      (is (= -3 (:aim ((:up sub) 3))))))

  (testing "down"
    (testing "should change the aim value positively"
      (is (= 2 (:aim ((:down sub) 2))))))

  (testing "forward"
    (testing "should change the horizontal and depth value"
      (is (= 0 (:depth ((:forward sub) 2))))
      (is (= 9 (:depth ((:forward ((:down sub) 3)) 3))))
      (is (= 3 (:horizontal-position ((:forward sub) 3)))))))



