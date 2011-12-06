(ns lardycake.models.git-repo
  (:use lardycake.models.repo))

(alias 'repo 'lardycake.models.repo)

(defmethod create-repo ::repo/Git [repo]
  {:message (format "creating path: %s, type: %s" (:path repo) (:scm repo))})

(defmethod delete-repo ::repo/Git [repo]
  {:message (format "deleting path: %s, type: %s" (:path repo) (:scm repo))})

(defmethod update-repo ::repo/Git [repo]
  {:message (format "updating path: %s, type: %s" (:path repo) (:scm repo))})

(defmethod get-repo ::repo/Git [repo]
  {:message (format "getting path: %s, type: %s" (:path repo) (:scm repo))})