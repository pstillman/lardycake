(ns lardycake.util.fs
  (:import java.io.File))

;; utility
(defn recursive-delete [path]
  (letfn [(delete-one [file]
            (when (.isDirectory file)
              (delete-many (.listFiles file)))
            (.delete file))
          (delete-many [files]
            (when (seq files)
              (delete-one (first files))
              (recur (rest files))))]
    (let [file (File. path)]
      (if (.exists file)
        (delete-one (File. path))
        false))))
