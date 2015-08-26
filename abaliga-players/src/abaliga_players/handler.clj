(ns abaliga-players.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [abaliga-players.controller.maincontroller :as maincontroller]))

(defn init []
  (println "Abaleague players app will be started soon"))

(defn destroy []
  (println "Abaleague players app is shutting down"))

(defroutes app-routes
  (GET "/" [] (maincontroller/index))
  (GET "/search" [] (maincontroller/search))
  (GET "/insert" [] (maincontroller/insert))
  (GET "/update" [] (maincontroller/update))
  (GET "/delete" [] (maincontroller/delete))
  (GET "/searchPlayer" [name] (maincontroller/searchPlayer name))
  (POST "/insertPlayer" [name club height position nationality dateofbirth] 
       (maincontroller/insertPlayer name height dateofbirth position club nationality))
  (POST "/updatePlayer" [id name height dateofbirth position club nationality] 
       (maincontroller/updatePlayer id name height dateofbirth position club nationality))
  (POST "/deletePlayer" [id] (maincontroller/deletePlayer id))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
