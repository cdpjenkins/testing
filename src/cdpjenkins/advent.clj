(ns cdpjenkins.advent
  (:require [clojure.java.io :as io]))

(defn- fuel-for-module [mass]
  (- (int (/ mass 3)) 2))

(defn fuel-for-module-and-fuel [mass]
  (->> mass
       (iterate fuel-for-module)
       (take 10)
       (drop 1)
       (take-while #(> % 0))
       (reduce +)))

(defn total-fuel [masses]
  (->> masses
       (map fuel-for-module)
       (reduce +)))

(defn total-fuel-using-rocket-equation [masses]
  (->> masses
       (map fuel-for-module-and-fuel)
       (reduce +)))

(defn total-fuel-for-file-using-rocket-equation []
  (let [input-file (io/file "resources/advent-1.txt")]
    (with-open [reader (io/reader input-file)]
      (let [s (line-seq reader)]
        (total-fuel-using-rocket-equation
         (map #(Integer/parseInt %) s))))))

(defn total-fuel-for-file []
  (let [input-file (io/file "resources/advent-1.txt")]
    (with-open [reader (io/reader input-file)]
      (let [s (line-seq reader)]
        (total-fuel (map #(Integer/parseInt %) s))))))

(comment
  (def input-file (io/file "resources/advent-1.txt"))
  (.getAbsolutePath input-file)
  (with-open [reader (io/reader input-file)]
    (let [s (line-seq reader)]
      (total-fuel (map #(Integer/parseInt %) s))))
d
  (println (total-fuel-for-file))

  (take 10 (cycle [1 2]))

  (fuel-for-module 100756)
  (fuel-for-module-and-fuel 100756)

  (->> 100756
       (iterate fuel-for-module)
       (take 10)
       (drop 1)
       (take-while #(> % 0))
       (reduce +))

  ()

  (total-fuel [12 14 1969 100756])

  (total-fuel-for-file-using-rocket-equation)

  )


