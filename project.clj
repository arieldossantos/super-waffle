(defproject super-waffle "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[javax.servlet/servlet-api "2.5"]
                 [ring "1.9.5"]
                 [metosin/reitit "0.5.17"]
                 [metosin/muuntaja "0.6.8"]
                 [org.clojure/clojure "1.10.3"]]
  :main ^:skip-aot super-waffle.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}})
