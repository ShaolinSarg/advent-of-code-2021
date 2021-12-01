(ns days.day-01
  (:require [utils.core :refer [read-input]]))


(def depths (map #(Integer/parseInt %)
                 (read-input "resources/day-01-input")))


(defn count-increase [[previous-depth increase-count] next-depth]
  (if (> next-depth previous-depth)
    [next-depth (inc increase-count)]
    [next-depth increase-count]))

(defn count-increases [depths]
  (second
   (reduce count-increase
           [(first depths) 0]
           depths)))


(defn group-totals [depths]
  (map (partial apply +)
       (partition 3 1 depths)))


(defn day-1-part-1-answer []
  (count-increases depths))

(defn day-1-part-2-answer []
  (count-increases (group-totals depths)))
