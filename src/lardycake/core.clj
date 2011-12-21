(ns lardycake.core
  (:use compojure.core)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [lardycake.models.repo :as repo]
            [lardycake.models.git-repo]
            [clj-json.core :as json]))

(def scm-base "/Users/joni/Scratch/clojure/scm-base")

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defn repo-type [t]
  (case t
    ;; only git for now
    ::repo/Git))

(defn make-path [scm name]
  (format "%s/%s/%s" scm-base scm name))

(defroutes main-routes
  ;; say hello gracie
  (GET "/" [] "<h1>Shweeet!</h1>")
  ;; pull a repo's metadata
  (GET "/repo/:scm/:name" [scm name]
       (json-response
        (repo/get-repo {:scm (repo-type scm) :path (make-path scm name)})))
  ;; create a new repo
  (POST "/repo/:scm/:name" [scm name]
        (json-response
         (repo/create-repo {:scm (repo-type scm) :path (make-path scm name)})))
  ;; remove the repo
  (DELETE "/repo/:scm/:name" [scm name]
          (json-response
           (repo/delete-repo {:scm (repo-type scm) :path (make-path scm name)})))
  (route/resources "/")
  (route/not-found "Page not found"))

(def app (handler/site main-routes))

