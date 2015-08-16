(defproject abaliga-players "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.3.1"]
                 [ring/ring-defaults "0.1.2"]
                 [de.ubercode.clostache/clostache "1.4.0"]
                 [org.clojure/java.jdbc "0.4.1"]
                 [postgresql "9.3-1102.jdbc41"]]
  :plugins [[lein-ring "0.8.13"]
            [lein2-eclipse "2.0.0"]]
  :ring {:handler abaliga-players.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}}
  :main abaliga-players.repl)
