(ns super-waffle.core
  (:require [ring.adapter.jetty :as ring-jetty]
            [muuntaja.core :as m]
            [reitit.ring :as ring])
  (:gen-class))

(def app
  (ring/ring-handler
    (ring/router
      [["/"
        {:get {:handler (fn [request]
                          {:status 200
                           :body   "teste"})}}]])))

(def ring-options {:port  8090
                   :join? false})

(defonce server (atom (ring-jetty/run-jetty app ring-options)))

(defn start-server []
  (.stop @server)
  (reset! server (ring-jetty/run-jetty app ring-options)))
