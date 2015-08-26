(ns abaliga-players.database.dbconnection
  (:require [clojure.java.jdbc :as sql])
  (:import java.sql.DriverManager))

(def db
    {:classname "org.postgresql.Driver"
     :subprotocol "postgresql"
     :subname "//localhost:5432/dbplayers"
     :username "postgres"
     :password "ognjen"})

(defn return-all-clubs []
 (sql/query db
 ["select * from clubs"]))

(defn return-all-players []
 (sql/query db
 ["select players.id, players.name, players.height, players.date_of_birth, players.position, clubs.name as clubsname, players.nationality from players join clubs on players.club = clubs.id order by players.id"]))

(defn return-players-with-name [name]
 (sql/query db
 ["select players.id, players.name, players.height, players.date_of_birth, players.position, clubs.name as clubsname, players.nationality from players join clubs on players.club = clubs.id where players.name= ? order by players.id" name]))

(defn insert-player [name height dateofbirth position club nationality]
  (sql/insert! db :players
                {:name name
                 :height height
                 :date_of_birth dateofbirth
                 :position position
                 :club club
                 :nationality nationality}))

(defn update-player [id name height dateofbirth position club nationality]
  (sql/update! db :players
                {:name name
                 :height height
                 :date_of_birth dateofbirth
                 :position position
                 :club club
                 :nationality nationality}
                ["id = ?" id]))

(defn delete-player [id]
 (sql/delete! db :players ["id = ?" id]))

