(ns sagat-ipsum.core
    (:require ))

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

(def sentence-len-vector [3 4 5])

;; (defn which-word-append [calcd-num]
;;   (let [rand-num (rand)])
;;   (if (> rand-num tiger-perc)
;;   "TIGER!")
;;   (get sagat-words
;;        (int (rand 
;;          (count sagat-words)))))

(defn print-sentence [word-count]
    (loop [x word-count
           build-str ""]
      (if (> x 0)
        (do
          (recur (- x 1) (str build-str (str (get sagat-words 
                                              (int (rand 
                                                     (count sagat-words)))) " "))))
        build-str)))

(defn print-paragraph [param-num]
    (loop [x param-num 
           build-str ""]
      (if (> x 0)
        (do 
          (recur (- x 1) (str build-str (print-sentence (get sentence-len-vector
                                                             (int (rand
                                                                    (count sentence-len-vector))))))))
        build-str)))

(println (print-paragraph 1))
(println (print-paragraph 1))
(println (print-paragraph 1))
(println (print-paragraph 1))
(println (print-paragraph 1))
(println (print-paragraph 1))
(println (print-paragraph 1))


(defonce app-state (atom {:text "Hello world!"}))


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
