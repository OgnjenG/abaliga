(ns abaliga-players.controller.maincontroller
(:require [compojure.core :refer :all]
          [abaliga-players.controller.util :as util]
          [abaliga-players.database.dbconnection :as db]
            ))

(defn index []
  (util/render-page "homepage" {} [:header :footer]))

(defn search []
  (util/render-page "searchpage" {} [:header :footer]))

(defn insert []
  (util/render-page "insertpage" {:clubs (db/return-all-clubs)} [:header :footer]))

(defn update []
  (util/render-page "updatepage" {:clubs (db/return-all-clubs)} [:header :footer]))

(defn delete []
  (util/render-page "deletepage" {} [:header :footer]))