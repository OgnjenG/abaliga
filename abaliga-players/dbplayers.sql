--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clubs; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE clubs (
    id integer NOT NULL,
    name character(30)
);


ALTER TABLE public.clubs OWNER TO postgres;

--
-- Name: clubs_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE clubs_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clubs_id_seq OWNER TO postgres;

--
-- Name: clubs_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE clubs_id_seq OWNED BY clubs.id;


--
-- Name: players; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE players (
    id integer NOT NULL,
    name character(50),
    date_of_birth date,
    "position" character(3),
    height integer,
    nationality character(30),
    club integer
);


ALTER TABLE public.players OWNER TO postgres;

--
-- Name: players_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE players_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.players_id_seq OWNER TO postgres;

--
-- Name: players_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE players_id_seq OWNED BY players.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY clubs ALTER COLUMN id SET DEFAULT nextval('clubs_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY players ALTER COLUMN id SET DEFAULT nextval('players_id_seq'::regclass);


--
-- Data for Name: clubs; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY clubs (id, name) FROM stdin;
1	KK Crvena Zvezda              
2	KK Partizan                   
3	KK Buducnost Voli             
4	KK Cedevita                   
5	KK Cibona                     
6	Mega Leks                     
7	KK Metalac Farmakom Valjevo   
8	KK Krka                       
9	KK Zadar                      
10	KK Union Olimpija             
11	KK MZT Skoplje Aerodrom       
12	KK Tajfun                     
13	KK Igokea                     
\.


--
-- Name: clubs_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('clubs_id_seq', 1, false);


--
-- Data for Name: players; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY players (id, name, date_of_birth, "position", height, nationality, club) FROM stdin;
2	Stefan Jovic                                      	1990-07-28	PG 	193	Serbian                       	1
3	Milenko Tepic                                     	1987-07-28	SG 	198	Serbian                       	2
4	Big Sofo                                          	1994-07-28	PF 	211	Serbian                       	1
5	JR Reynolds                                       	2015-08-11	PG 	189	USA                           	1
7	Marko Marinovic                                   	2015-08-12	PG 	190	Serbian                       	10
8	Nikola Jokic                                      	1991-08-04	PF 	202	Serbian                       	6
1	Luka Mitrovic                                     	1994-07-26	PF 	204	Serbian                       	1
\.


--
-- Name: players_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('players_id_seq', 8, true);


--
-- Name: pk_clubid; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY clubs
    ADD CONSTRAINT pk_clubid PRIMARY KEY (id);


--
-- Name: pk_id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY players
    ADD CONSTRAINT pk_id PRIMARY KEY (id);


--
-- Name: fk_clubid; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY players
    ADD CONSTRAINT fk_clubid FOREIGN KEY (club) REFERENCES clubs(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--

