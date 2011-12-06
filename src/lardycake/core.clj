(ns lardycake.core
  (:use compojure.core)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [lardycake.models.repo :as repo]
            [lardycake.models.git-repo]
            [clj-json.core :as json]))

(defn json-response [data & [status]]
  {:status (or status 200)
   :headers {"Content-Type" "application/json"}
   :body (json/generate-string data)})

(defroutes main-routes
  (GET "/" [] "<h1>Shweeet!</h1>")
  (GET "/repo" []
       (json-response
        (repo/get-repo {:scm ::repo/Git :path "/somewhere/over/the/rainbow"})))
  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (handler/site main-routes))

