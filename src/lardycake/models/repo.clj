(ns lardycake.models.repo
  (:import java.io.File))

;; the repository
(defstruct repo :path :scm)

;; CRUD on the repo itself
(defmulti create-repo :scm)
(defmulti delete-repo :scm)
(defmulti update-repo :scm)
(defmulti get-repo :scm)

;; forward declarations
(declare recursive-delete)

;; default implementations
(defmethod create-repo :default [repo]
  {:error "not implemented"})

(defmethod update-repo :default [repo]
  {:error "not implemented"})

(defmethod get-repo :default [repo]
  {:error "not implemented"})

(defmethod delete-repo :default [repo]
  (recursive-delete (:path repo)))

;; utility
(defn recursive-delete [path]
  (letfn [(recursive-delete-one [file]
            (if (.isDirectory file)
              (recursive-delete-many (.listFiles file)))
            (.delete file))
          (recursive-delete-many [files]
            (if (seq files)
              (do
                (recursive-delete-one (first files))
                (recur (rest files)))))]
    (let [file (File. path)]
      (if (.exists file)
        (recursive-delete-one (File. path))
        false))))


