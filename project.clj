(defproject petmimado "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [stasis "2.2.0" :exclusions [org.clojure/clojure]]
                 [hiccup "1.0.5"]
                 [optimus "0.15.0"]]
  :plugins [[lein-ring "0.8.10"]]
  :aliases {"build-site" ["run" "-m" "petmimado.core/export"]}
  :ring {:handler petmimado.core/app})
