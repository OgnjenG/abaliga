(ns abaliga-players.controller.maincontroller
(:require [compojure.core :refer :all]
          [abaliga-players.controller.util :as util]
            ))

(defn index []
  (util/render-page "homepage" {} [:header :footer]))