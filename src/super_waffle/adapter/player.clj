(ns super-waffle.adapter.player
  (:require [schema.core :as s]
            [schema-generators.generators :as g]))


(def PlayerResponse
  "A player response type"
  {:name s/Str
   :shirt-number s/Int
   :date-of-birth s/Str
   :height s/Num})

(defn list-all [_]
  (g/sample 20 PlayerResponse))