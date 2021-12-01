(ns days.day-01-test
  (:require [clojure.test :refer [is deftest testing]]
            [days.day-01 :as sut]))

(def depths [199 200 208 210 200 207 240 269 260 263])

(deftest day-01-tests
  (testing "count-increase"
    (testing "should return the right increases"
      (is (= [100 0] (sut/count-increase [200 0] 100)))
      (is (= [300 1] (sut/count-increase [200 0] 300)))
      (is (= [400 5] (sut/count-increase [200 4] 400)))))


  (testing "count-increases"
    (testing "should return the right counts"
      (is (= 7 (sut/count-increases depths)))
      (is (= 5 (sut/count-increases (sut/group-totals depths))))))


  (testing "group-totals"
    (testing "should return the right group counts"
      (is (= 607 (first (sut/group-totals depths))))
      (is (= 618 (second (sut/group-totals depths)))))))

