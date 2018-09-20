(ns leiningen.adl
  (:require [adl.main :refer [process]]
            [adl-support.core :refer [*warn*]]
            [leiningen.core.main :refer [debug info warn]]))

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;;;;
;;;; leiningen.adl: integrate Application Description Language processing with
;;;; leiningen.
;;;;
;;;; This program is distributed under the ECLIPSE PUBLIC LICENSE, for
;;;; compatibility with leiningen.
;;;;
;;;; Copyright (C) 2018 Simon Brooke
;;;;
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn adl
  "Process an Application Description Language file using
  configuration taken from the `project.clj`.

  A key `:adl` may be supplied, whose value should be a map with
  some or all of the following keys:

  * `:adl-file` the filename of the ADL file to generate from
    (defaults to `[project-name].adl.xml`);
  * `:locale` the locale to generate files for (defaults to your
    default locale);
  * `:path` the path under which to generate files (defaults to
    the current directory);
  * `:verbosity` if set to an integer greater than zero, will
    print additional information about what ADL is doing.

  Additionally, the name of an ADL file may be supplied as an
  argument, in which case that file will be used in preference
  to any specified in the `project.clj`."
  [project & args]
  (let [c (merge
           ;; defaults
           {:abstract-key-name-convention "id"
            :help false
            :locale (or (java.util.Locale/getDefault) "en_GB.UTF-8")
            :path "."
            :verbosity 0}
           (:adl project))
        config {:options c
                :arguments (cond
                            (not (empty? args)) args
                            (not (nil? (:adl-file c))) (:adl-file c)
                            true
                            [(str (:name project) ".adl.xml")])}]
    (binding [*warn* info]
      (try
        (process config)
        (catch Exception any
          (warn
           (str
            (.getName (.getClass any))
            ": "
            (.getMessage any)))
          nil)))))



