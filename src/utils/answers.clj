(ns utils.answers
  (:require [days.day-01 :refer [day-1-part-1-answer
                                 day-1-part-2-answer]]
            [days.day-02 :refer [day-2-part-1-answer
                                 day-2-part-2-answer]]
            [days.day-03 :refer [day-3-part-1-answer
                                 day-3-part-2-answer]]))


(defn -main [& args]
  (println)
  (println "# Sarg's answers to the advent of code 2021")
  (println)
  (println (str "Day 1 part 1 [" (day-1-part-1-answer) "]"))
  (println (str "Day 1 part 2 [" (day-1-part-2-answer) "]"))
  (println)
  (println (str "Day 2 part 1 [" (day-2-part-1-answer) "]"))
  (println (str "Day 2 part 2 [" (day-2-part-2-answer) "]"))
  (println)
  (println (str "Day 3 part 1 [" (day-3-part-1-answer) "]"))
  (println (str "Day 3 part 2 [" (day-3-part-2-answer) "]"))
  (println))
