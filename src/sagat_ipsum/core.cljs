(ns sagat-ipsum.core
    (:require ))

(enable-console-print!)

(def sagat-words ["TIGER" "UPPERCUT" "KNEE" "DESTRUCTION" "KNEE" "GENOCIDE"])

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

(loop [x 99]
  (when (> x 1)
    (println 
      (nth latin-words
                  (int (rand 79))))
    (recur (- x 2))))

(println (count sagat-words))

(defonce app-state (atom {:text "Hello world!"}))


(defn on-js-reload []
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)
