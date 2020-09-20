(ns bottles.core
  (:require [clojure.string :as s]))

(defn bottle-text
  [number]
  (condp = number
    1 "1 bottle"
    0 "no more bottles"
    (str number " bottles")))

(defn action-text
  [number]
  (condp = number
    1 "Take it down and pass it around"
    0 "Go to the store and buy some more"
    "Take one down and pass it around"))

(defn verse
  [number]
  (let [bottles (bottle-text number)
        action (action-text number)
        remaining (bottle-text (if (> number 0) (dec number) 99))]
    (format "%s of beer on the wall, %s of beer.\n%s, %s of beer on the wall.\n"
            (s/capitalize bottles) bottles action remaining)))

(defn verses
  [high low]
  (let [coll (reverse (range low (inc high)))]
    (s/join "\n" (map #(verse %) coll))))

(defn song
  []
  (verses 99 0))
