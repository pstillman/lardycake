(defproject lardycake "0.1.0-SNAPSHOT"
            :description "A noir app for fiddling with SCMs"
            :dependencies [[org.clojure/clojure "1.3.0"]
                           [noir "1.2.1"]
                           [clj-jgit "0.0.2"]]
            :dev-dependencies [[lein-ring "0.4.6"]
                               [org.clojure/clojure-contrib "1.2.0"]]
            :main lardycake.server)

