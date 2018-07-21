(defproject lein-adl "0.1.2"
  :description "Integrate Application Description Language into lein workflow"
  :url "https://github.com/simon-brooke/lein-adl"
  :license {:name "Eclipse Public License" ;; for compatibility with leiningen
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[adl-support "0.1.3"]
                 [adl "1.4.3"]]
                   
  :plugins [[lein-codox "0.10.3"]
            [lein-release "1.0.5"]]

  ;; `lein release` doesn't work with `git flow release`. To use
  ;; `lein release`, first merge `develop` into `master`, and then, in branch
  ;; `master`, run `lein release`

  ;; in fact, `lein release` is pretty comprehensively broken, which is a
  ;; shame because it's a good idea.

  ;; :release-tasks [["vcs" "assert-committed"]
  ;;                 ["clean"]
  ;;                 ["test"]
  ;;                 ["codox"]
  ;;                 ["change" "version" "leiningen.release/bump-version" "release"]
  ;;                 ["vcs" "commit"]
  ;;                 ;; ["vcs" "tag"] -- not working, problems with secret key
  ;;                 ["uberjar"]
  ;;                 ["install"]
  ;;                 ["deploy" "clojars"]
  ;;                 ["change" "version" "leiningen.release/bump-version"]
  ;;                 ["vcs" "commit"]]

  :eval-in-leiningen true)
