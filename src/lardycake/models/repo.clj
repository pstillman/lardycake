(ns lardycake.models.repo)

;; the repository
(defstruct repo :path :scm)

;; CRUD on the repo itself
(defmulti create-repo :scm)
(defmulti delete-repo :scm)
(defmulti update-repo :scm)
(defmulti get-repo :scm)
