(ns cdpjenkins.testing
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))


(defn play [player1 player2]
  (condp = player1
        :rock (condp = player2
                :scissors 0
                :paper 1
                ;;:rock -1
                )
        :paper (condp = player2
                 :rock 0
                 :scissors 1
                 ;; paper -1
                 )
        :scissors (condp = player2
                    :paper 0
                    :rock 1
                    ;; scissors -1
                    )
        )
  )


(comment
  (play :rock :paper)
  (play :paper :rock)
  )
