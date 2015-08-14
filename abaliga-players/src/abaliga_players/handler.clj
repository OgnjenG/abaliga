(ns abaliga-players.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [abaliga-players.controller.maincontroller :as maincontroller]))

(defroutes app-routes
  (GET "/" [] (maincontroller/index))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
