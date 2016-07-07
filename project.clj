(defproject listora/ring-congestion "0.1.3-SNAPSHOT"
  :description "Rate limiting ring middleware"
  :url "https://github.com/listora/ring-congestion"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :scm {:name "git"
        :url "https://github.com/listora/again"}
  :deploy-repositories [["releases" :clojars]]

  :dependencies [[clj-time "0.12.0" :exclusions [org.clojure/clojure]]
                 [com.taoensso/carmine "2.13.1" :exclusions [org.clojure/clojure]]
                 [org.clojure/clojure "1.8.0"]]

  :profiles {:dev {:dependencies [[compojure "1.5.1"]
                                  [ring-mock "0.1.5"]]

                   :plugins [[jonase/eastwood "0.1.5"]
                             [listora/whitespace-linter "0.1.0"]]

                   :eastwood {:exclude-linters [:deprecations :unused-ret-vals]}

                   :aliases {"ci" ["do" ["test"] ["lint"]]
                             "lint" ["do" ["whitespace-linter"] ["eastwood"]]}}}

  :test-selectors {:default (complement :redis)
                   :redis :redis
                   :unit :unit
                   :all (fn [_] true)})
