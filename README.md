# abaliga-players

This is clojure web aplication made for manipulating with abaleague players' data. Application provides some basic functionalities like searching for player, inserting player, updating player or deleting player. Nowadays, there is a big emphases on security of web applications, so this application is protected against CSRF attacks.
In this application, all the data is persisted in PostgreSQL database and frontend is done with help of Clostache web templating system. Please find enclosed dbplayers.sql file with sql commands for generating the database in project root.

## Prerequisites

You will need [Leiningen][] 2.0.0 or above installed.

[leiningen]: https://github.com/technomancy/leiningen

## Running

To start a web server for the application, run:

    lein ring server
	
## Some of libraries used

### compojure 1.3.1
A concise routing library for Ring - https://github.com/weavejester/compojure

	[compojure "1.3.1"]
	
### clostache 1.4.0

Library for templating HTML files in Clojure - https://github.com/fhd/clostache

	[de.ubercode.clostache/clostache "1.4.0"]
	
### java.jdbc 0.4.1

A low-level Clojure wrapper for JDBC-based access to databases -https://github.com/clojure/java.jdbc

	[org.clojure/java.jdbc "0.4.1"]

### postgresql 9.3-1102.jdbc41

A library for accessing and creating PostgreSQL database files - https://clojars.org/postgresql

	[postgresql "9.3-1102.jdbc41"]
	
### ring-anti-forgery 1.0.0

Ring middleware that prevents CSRF attacks by via a randomly-generated anti-forgery token - https://github.com/ring-clojure/ring-anti-forgery

	[ring/ring-anti-forgery "1.0.0"]

### clj-time 0.11.0

A date and time library for Clojure - https://github.com/clj-time/clj-time

	[clj-time "0.11.0"]

## License

Copyright Â© 2015 Ognjen Grubac
