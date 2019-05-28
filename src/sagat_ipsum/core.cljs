(ns sagat-ipsum.core
    (:require [clojure.string :as str]
              [reagent.core :as r]
              [sagat_ipsum.dict :as d]))

(enable-console-print!)

;; convert js obj to clj vector and ensure it has keys
(def dict (js->clj sagat_ipsum/dict :keywordize-keys true))

(def para-num (r/atom 0))

(def generated-text (r/atom ""))

(def sentence-len-vector [8 9 10])

(def tiger-perc 0.8)

(def colors {:trunks "#7C35FA"
             :sagat-red "#F70713"
             :sand "#FCC86F"
             :scar "#B27B1B"})

(def standard-styles {:text-padding "1rem"
                      :container-width "900px"})

(defn which-word-append [rand-num]
  (if (> tiger-perc rand-num)
    "TIGER!" (get (:sagat_words dict)
      (int (rand 
        (count (:sagat_words dict)))))))

(defn print-sentence [word-count]
    (loop [x word-count
           str-vec []]
      (if (> x 0)
        (do
          (recur (- x 1) (conj str-vec (str (which-word-append (rand)) " "))))
        str-vec)))

(defn print-paragraph [param-num]
    (loop [x param-num 
           str-vec []]
      (if (> x 0)
        (do 
          (recur (- x 1) (conj str-vec (print-sentence (get sentence-len-vector
                                                             (int (rand
                                                                    (count sentence-len-vector))))))))
        str-vec)))

(defn sagat-overlay[]
  [:section#sagat-overlay {:style 
         {:background-color (:trunks colors) :height "147px" :width "100vw" :font-size "2rem" :padding-top "1.5rem" :padding-left "1rem"}} 
        [:h1 {:style {:margin "-18px auto 0" :width "900px"}} "SAGAT IPSUM"]
        [:h4 {:style {:margin "-18px auto 0" :width "900px"}} "In Shadaloo, I am the Ipsum."]])

(defn handle-generate-click [e]
  (.preventDefault e)
  (let [generated-text-str (atom "")]
    (doseq [v (print-paragraph @para-num)]
  ;; convert the vectors into an spaced, appended string
          (reset! generated-text-str (str @generated-text-str (clojure.string/join v) "\n\n")))
    (reset! generated-text (add-start-end-text @generated-text-str))))

(defn handle-clear-text-click [e]
  (.preventDefault e)
  (reset! para-num 0)
  (reset! generated-text ""))

(defn add-start-end-text [input-str]
  (str "<--start sagat-ipsum code-->\n\n" input-str "<--end sagat-ipsum code-->"))

(defn how-many-paragraphs-form []
  [:form {:style {:padding-left (:text-padding standard-styles)}}
   [:div
    [:label
     "How many paragraphs?"
     [:input {:type "text"
              :style { :width "1.5rem" :margin-left "9.35rem" :text-align "center" }
              :value @para-num
              :on-change #(reset! para-num (-> % .-target .-value))}]
     ]
    ]
   [:div {:style {:margin-top "1rem"}}
     [:button {:on-click (fn [e] (handle-generate-click e))} "Generate it."]
     [:button {:on-click (fn [e] (handle-clear-text-click e)) :style {:margin-left "1rem"}} "Clear text."]
   ]])

(defn sagat-ipsum-app []
  [:div {:style {:height "100%" :background-color (:sagat-red colors)}}
    [:div#top {:style {:background-color (:sagat-red colors) :height "30px" :width "100vw"}}]
    [sagat-overlay]
    [:div#bottom {:style {:background-color (:sagat-red colors) :height "75vh" :width "100vw"}}
      [:div {:style {:width "913px" :margin "0 auto"}}
        [:div#form-right {:style {:float "right"}}
          [:img { :src "http://lorempixel.com/400/200"}]]
       [:h3 {:style {:padding-left (:text-padding standard-styles)}} "No, motherfucker"]
       [how-many-paragraphs-form]
       [:textarea#generated-text {:style { :min-width "23rem" :min-height "8rem" :margin "2rem 0 0 1rem" }
                                  :value @generated-text
                                  :on-change #(reset! generated-text (-> % .-target .-value))}]]]])

(defonce app-state (atom {:text "Hello world!"}))

(defn ^:export run []
  (r/render [sagat-ipsum-app]
            (js/document.getElementById "app")))
