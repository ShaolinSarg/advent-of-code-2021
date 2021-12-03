(ns days.day-02
  (:require [clojure.string :as str]
            [utils.core :refer [read-input]]))


(defn parse-command [input]
  (let [[direction magnitude] (str/split input #"\s")]
    [(keyword direction) (Integer/parseInt magnitude)]))

(def instructions (map parse-command
                 (read-input "resources/day-02-input")))


(defn surface [[depth horizontal-position] magnitude]
  [(- depth magnitude) horizontal-position])

(defn dive [[depth horizontal-position] magnitude]
  [(+ depth magnitude) horizontal-position])

(defn forward [[depth horizontal-position] magnitude]
  [depth (+ horizontal-position magnitude)])

(def moves {:up surface
            :down dive
            :forward forward})


(defn command-move [position [direction magnitude]]
  ((direction moves) position magnitude))

(defn day-2-part-1-answer []
  (apply * (reduce command-move
                   [0 0]
                   instructions)))

;-------------------------Part 2----------------------------

(defn init-sub
  ([] (init-sub 0 0 0))

  ([aim depth horizontal-position]
   {:aim aim
    :depth depth
    :horizontal-position horizontal-position
    :up (fn [magnitude] (init-sub (- aim magnitude) depth horizontal-position))
    :down (fn [magnitude] (init-sub (+ aim magnitude) depth horizontal-position))
    :forward (fn [magnitude] (init-sub aim
                                       (+ depth (* aim magnitude))
                                       (+ horizontal-position magnitude)))}))


(defn sub-move [sub [direction magnitude]]
  ((direction sub) magnitude))

(defn day-2-part-2-answer []
  (apply *
         ((juxt :depth :horizontal-position) (reduce sub-move
                                                     (init-sub)
                                                     instructions))))
