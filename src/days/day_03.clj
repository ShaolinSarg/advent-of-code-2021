(ns days.day-03
  (:require [clojure.string :as str]
            [utils.core :refer [read-input]]))


(def instructions (read-input "resources/day-03-input"))


(defn count-bits [instructions]
  (let [number-of-bits (count (first instructions))
        bit-counts (vec (take number-of-bits (iterate conj [0 0])))
        counts (atom bit-counts)]

        (doseq [i instructions
                posn (range number-of-bits)
                :let [bit-value (Integer/parseInt (Character/toString (get i posn)))]]

          (swap! counts update-in [posn bit-value] inc))

        @counts))



(defn gamma-bit [tup]
  (if (> (first tup) (second tup)) 0 1))

(defn epsilon-bit [tup]
  (if (< (first tup) (second tup)) 0 1))


(defn gamma-value [counts]
  (->> counts
       (map gamma-bit)
       (apply str)))

(defn epsilon-value [counts]
  (->> counts
       (map epsilon-bit)
       (apply str)))


(defn binary-to-long [binary]
  (Long/parseLong binary 2))


(def bit-counts (count-bits instructions))


(defn day-3-part-1-answer []
  (apply * (map (partial binary-to-integer)
                ((juxt gamma-value epsilon-value) bit-counts))))


(defn oxygen-bit [[zero-count one-count]]
  (if (>= one-count zero-count) \1 \0))

(defn co2-bit [[zero-count one-count]]
  (if (<= zero-count one-count) \0 \1))


(defn oxygen-value [instructions]
  (loop [n instructions
         i 0]
    (if (= 1 (count n))
      (first n)
      (recur (let [counts (count-bits n)]
               (filter #(= (oxygen-bit (nth counts i)) (nth % i)) n))
             (inc i)))))

(defn co2-value [instructions]
  (loop [n instructions
         i 0]
    (if (= 1 (count n))
      (first n)
      (recur (let [counts (count-bits n)]
               (filter #(= (co2-bit (nth counts i)) (nth % i)) n))
             (inc i)))))


(defn day-3-part-2-answer []
  (apply * (map (partial binary-to-integer)
                ((juxt oxygen-value co2-value) instructions))))
