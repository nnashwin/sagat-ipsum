(ns sagat-ipsum.core
    (:require [clojure.string :as str]))

(enable-console-print!)

(def sagat-words ["TIGER UPPERCUT!" "TIGER KNEE!" "TIGER DESTRUCTION!" "TIGER GENOCIDE!"])

(def latin-words ["arcu" "nibh" "quam" "quis" "pulvinar" "tincidunt" "Quis" "amet,"
  "enim"
  "Hac"
  "pulvinar"
  "tellus"
  "consectetur"
  "netus"
  "fames"
  "tempor"
  "lacinia"
  "faucibus"
  "euismod"
  "tristique"
  "platea"
  "viverra"
  "id"
  "volutpat"
  "ac" "senectus"
  "odio"
  "nunc"
  "sem"
  "tincidunt"
  "aliqua"
  "ut"
  "gravida"
  "Aliquet"
  "eu"
  "Arcu"
  "adipiscing"
  "incididunt"
  "praesent"
  "Tristique"
  "sit"
  "elementum"
  "habitasse"
  "Lorem"
  "Dui"
  "massa"
  "labore"
  "eiusmod"
  "Elementum"
  "non"
  "do"
  "integer"
  "sed"
  "elit,"
  "etiam"
  "neque"
  "purus"
  "et"
  "Auctor"
  "ornare"
  "magna"
  "sagittis"
  "malesuada"
  "mauris"
  "dolore"
  "amet"
  "ipsum"
  "Risus"
  "dictumst"
  "Rutrum"
  "quisque"
  "augue"
  "dolor"
  "at" 
  "Id"
  "pellentesque"
  "in" 
  "imperdiet" 
  "nulla" 
  "pharetra"])

(def para-num 4)

(def sentence-len-vector [5 6 7])

(def tiger-perc 0.8)

(defn which-word-append [rand-num]
  (if (> tiger-perc rand-num)
    "TIGER!" (get sagat-words
      (int (rand 
        (count sagat-words))))))



(defn print-sentence [word-count]
    (loop [x word-count
           build-str ""]
      (if (> x 0)
        (do
          (recur (- x 1) (str build-str (str (which-word-append (rand)) " "))))
        build-str)))

(defn print-paragraph [param-num]
    (loop [x param-num 
           str-vec []]
      (if (> x 0)
        (do 
          (println str-vec)
          (recur (- x 1) (conj str-vec (print-sentence (get sentence-len-vector
                                                             (int (rand
                                                                    (count sentence-len-vector))))))))
        str-vec)))

(println (count (str/split (print-paragraph 3) #" ")))


(defonce app-state (atom {:text "Hello world!"}))


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
