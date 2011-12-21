(ns lardycake.models.repo
  (:require [lardycake.util.fs :as fs])
  (:import java.io.File))

;; the repository
(defstruct repo :path :scm)

;; CRUD on the repo itself
(defmulti create-repo :scm)
(defmulti delete-repo :scm)
(defmulti update-repo :scm)
(defmulti get-repo :scm)

;; forward declarations
;; (declare recursive-delete)

;; default implementations
(defmethod create-repo :default [repo]
  {:error "not implemented"})

(defmethod update-repo :default [repo]
  {:error "not implemented"})

(defmethod get-repo :default [repo]
  {:error "not implemented"})

(defmethod delete-repo :default [repo]
  (fs/recursive-delete (:path repo)))



