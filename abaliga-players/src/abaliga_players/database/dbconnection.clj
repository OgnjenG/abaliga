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