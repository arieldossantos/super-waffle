(ns super-waffle.core
  (:use clojure.pprint)
  (:require [clojure.data.json :as json]
            [io.pedestal.http :as http]
            [io.pedestal.http.route :as route]
            [super-waffle.adapter.player :as player])
  (:gen-class))

;server def
(defonce server (atom nil))


(defn ok [body]
  {:status  200
   :body    body
   :headers {"Content-Type" "text/html"}})

(defn ok-json [body]
  {:status  200
   :body    (json/write-str body)
   :headers {"Content-Type" "application/json"}})

;echo interceptor
(def echo
  {:name  ::echo
   :enter (fn [context]
            (let [request (:request context)
                  response (ok request)]
              (assoc context :response response)))})

(defn get-example [request]
  (ok-json {:message "hello, worssl!"}))

(def routes
  (route/expand-routes
    #{["/" :get get-example :route-name :get-hello-world]
      ["/player" :get (comp ok-json player/list-all) :route-name :get-list-of-players]
      ["/echo" :any echo]}))

(def server-options {::http/routes routes
                     ::http/type   :jetty
                     ::http/port   3000})

(defn start-dev []
  (reset! server
          (http/start (http/create-server
                        (assoc server-options ::http/join? false)))))

(defn restart []
  (http/stop @server)
  (start-dev))
