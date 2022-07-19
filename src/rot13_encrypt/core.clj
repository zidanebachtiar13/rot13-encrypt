(ns rot13-encrypt.core
  (:require [rot13-encrypt.encrypt :refer [rot13]]
            [rot13-encrypt.clipboard :refer [copy]]
            [clojure.tools.cli :refer [parse-opts]])
  (:gen-class))

(defn validate [word]
  (loop [words (map int word)]
    (if (empty? words)
      true
      (if (or (< 64 (first words) 91) (< 96 (first words) 123) (= (first words) 32))
        (recur (rest words))
        false))))

(def cli-options
  [["-e" "--encrypt ENCRYPT" "Word to encrypt"
    :parse-fn #(str %)
    :validate [#(validate %) "Argument must be alphabet"]]
   ["-h" "--help"]]) 

(defn -main [& args]
  (let [arguments (parse-opts args cli-options)
        options (:options arguments)
        summary (:summary arguments)]
    (cond 
      (:errors arguments) (println (get (:errors arguments) 0))
      (or (empty? options) (:help options)) (println summary)
      :else (let [encryption (rot13 (:encrypt options))]
              (copy encryption)
              (println (str "Result: " encryption))))))
