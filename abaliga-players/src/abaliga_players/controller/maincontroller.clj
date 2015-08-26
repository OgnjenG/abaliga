(ns abaliga-players.controller.maincontroller
(use ring.util.anti-forgery)
(:require [compojure.core :refer :all]
          [abaliga-players.controller.util :as util]
          [abaliga-players.database.dbconnection :as db]
          [clj-time.core :as t]
          [clj-time.coerce :as c]
            ))

(defn index []
  (util/render-page "homepage" {} [:header :footer]))

(defn search []
  (util/render-page "searchpage" {:showtable false :message false} [:header :footer]))

(defn returnPlayers [name] 
  (if (= name "")
       (db/return-all-players)
       (db/return-players-with-name name)))

(defn searchPlayer [name]
  (let [players (returnPlayers name)]
  (util/render-page "searchpage" {:players players
                                  :showtable (if (empty? players)
                                             false
                                             true)
                                  :message true} [:header :footer])))

(defn insert []
  (util/render-page "insertpage" {:clubs (db/return-all-clubs) :token (anti-forgery-field) :message false} [:header :footer]))

(defn insertPlayer [name height dateofbirth position club nationality]
  (do(let [club (Integer/parseInt club)
           height (Integer/parseInt height)
           dateofbirth (c/to-sql-date dateofbirth)]
  (db/insert-player name height dateofbirth position club nationality)
  (util/render-page "insertpage" {:clubs (db/return-all-clubs) :token (anti-forgery-field) :message true} [:header :footer]))))

(defn update []
  (util/render-page "updatepage" {:clubs (db/return-all-clubs) :token (anti-forgery-field) :message false} [:header :footer]))

(defn updatePlayer [id name height dateofbirth position club nationality]
  (do(let [id (Integer/parseInt id)
           club (Integer/parseInt club)
           height (Integer/parseInt height)
           dateofbirth (c/to-sql-date dateofbirth)]
  (db/update-player id name height dateofbirth position club nationality) 
  (util/render-page "updatepage" {:clubs (db/return-all-clubs) :token (anti-forgery-field) :message true} [:header :footer]))))

(defn delete []
  (util/render-page "deletepage" {:token (anti-forgery-field) :message false} [:header :footer]))

(defn deletePlayer [id]
  (do (let [id (Integer/parseInt id)]
  (db/delete-player id)
  (util/render-page "deletepage" {:token (anti-forgery-field) :message true} [:header :footer]))))
