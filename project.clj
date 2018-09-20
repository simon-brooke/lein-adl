(defproject lein-adl "0.1.4-SNAPSHOT"
  :description "Integrate Application Description Language into lein workflow"
  :url "https://github.com/simon-brooke/lein-adl"
  :license {:name "Eclipse Public License" ;; for compatibility with leiningen
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[adl-support "0.1.4"]
                 [adl "1.4.5"]]

  :plugins [[lein-codox "0.10.3"]
            [lein-release "1.0.5"]]

  :deploy-repositories [["releases" :clojars]
                        ["snapshots" :clojars]]

  ;; `lein release` doesn't play nice with `git flow release`. Run `lein release` in the
  ;; `develop` branch, then merge the release tag into the `master` branch.

  :release-tasks [["vcs" "assert-committed"]
                  ["clean"]
                  ["test"]
                  ["codox"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ;; ["vcs" "tag"] -- not working, problems with secret key
                  ["uberjar"]
                  ["install"]
                  ["deploy" "clojars"]
                  ["change" "version" "leiningen.release/bump-version"]
                  ["vcs" "commit"]]

  :eval-in-leiningen true)
