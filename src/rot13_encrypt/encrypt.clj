(ns rot13-encrypt.encrypt)

(defn rot13 [word]
  (->> (for [i (map int word)
             :let [thirteen (- i 13)]]
         (cond
           (= i 32) 32
           (and (< i 91) (> i 64)) (if (< thirteen 65)
                                     (- 91 (- 65 thirteen))
                                     thirteen)
           (and (< i 123) (> i 96)) (if (< thirteen 97) 
                                      (- 123 (- 97 thirteen))
                                      thirteen)))
       (map char)
       (apply str)))
