(defproject rot13-encrypt "0.1.0-SNAPSHOT"
  :description "A Command line Application (CLI) to encrypt word with ROT-13 decoder."
  :url "https://github.com/zidanebachtiar13/rot13-encrypt"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [org.clojure/tools.cli "1.0.206"]]
  :main ^:skip-aot rot13-encrypt.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
