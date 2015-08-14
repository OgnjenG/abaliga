(ns abaliga-players.controller.util
  (:require
    [clostache.parser :as clostache]
    [clojure.java.io :as io]))

(defn read-template [template-name]
  (slurp (io/resource
    (str "public/views/" template-name ".mustache"))))

(defn render-template [template-file params]
  (clostache/render (read-template template-file) params))

(defn render-page [template data partials]
  (clostache/render-resource
    (str "public/views/" template ".mustache")
    data
    (reduce (fn [accum pt]
              (assoc accum pt (slurp (io/resource (str "public/views/"
                                                       (name pt)
                                                       ".mustache")))))
            {}
            partials)))
