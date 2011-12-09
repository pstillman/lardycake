(ns lardycake.models.git-repo
  (:use lardycake.models.repo)
  (:require [clj-jgit.porcelain :as jgit]))

(alias 'repo 'lardycake.models.repo)

(defmethod create-repo ::repo/Git [repo]
  (let [full-path (concat *scm-base* "/git/" (:path repo))]
    (conj repo {:_repo (jgit/git-init full-path)})))

;; delete is implemented the same everywhere

(defmethod update-repo ::repo/Git [repo]
  {:message (format "updating path: %s, type: %s" (:path repo) (:scm repo))})

(defmethod get-repo ::repo/Git [repo]
  {:message (format "getting path: %s, type: %s" (:path repo) (:scm repo))})