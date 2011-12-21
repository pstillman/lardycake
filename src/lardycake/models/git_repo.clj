(ns lardycake.models.git-repo
  (:use lardycake.models.repo)
  (:require [clj-jgit.porcelain :as jgit]))

(alias 'repo 'lardycake.models.repo)

(defmethod create-repo ::repo/Git [repo]
  (let [full-path (:path repo)]
    (jgit/git-init full-path true)
    repo))

;; delete is implemented the same everywhere

;; shall we keep metadata too?
(defmethod update-repo ::repo/Git [repo]
  {:message (format "updating path: %s, type: %s" (:path repo) (:scm repo))})

(defmethod get-repo ::repo/Git [repo]
  {:message (format "getting path: %s, type: %s" (:path repo) (:scm repo))})