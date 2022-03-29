(defproject super-waffle "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[io.pedestal/pedestal.service "0.5.10"]
                 [io.pedestal/pedestal.jetty "0.5.10"]
                 [io.pedestal/pedestal.route "0.5.10"]
                 [org.clojure/data.json "2.4.0"]
                 [prismatic/schema "1.2.0"]
                 [prismatic/schema-generators "0.1.4"]
                 [org.clojure/clojure "1.10.3"]]
  :main ^:skip-aot super-waffle.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot      :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
