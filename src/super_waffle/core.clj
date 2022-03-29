(ns super-waffle.core
  (:require [io.pedestal.http :as http]
            [io.pedestal.http.route :as route])
  (:gen-class))


(defn get-example [request]
  {:status 200 :body "hello, world!"})

(def routes
  (route/expand-routes
    #{["/" :get get-example :route-name :get-hello-world]}))

(def server-options {::http/routes routes
                     ::http/type   :jetty
                     ::http/port   3000})

(defn create-server []
  (http/create-server server-options))


(defn start []
  (http/start (create-server)))

(defn restart []
  (http/stop server-options)
  (http/start (create-server)))