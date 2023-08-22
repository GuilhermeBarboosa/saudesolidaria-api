--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2023-08-22 10:38:41

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 215 (class 1259 OID 26642)
-- Name: roles; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.roles (
                              id integer NOT NULL,
                              role character varying(30) NOT NULL
);


ALTER TABLE public.roles OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 26672)
-- Name: sequence_id_role; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sequence_id_role
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_id_role OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 26671)
-- Name: sequence_id_user; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sequence_id_user
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_id_user OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 26635)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.users (
                              id bigint NOT NULL,
                              email character varying(255) NOT NULL,
                              senha character varying(255) NOT NULL,
                              nome character varying(255) NOT NULL,
                              role bigint NOT NULL,
                              cpf character varying(255) NOT NULL,
                              actived boolean NOT NULL,
                              created date NOT NULL,
                              updated date
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 3326 (class 0 OID 26642)
-- Dependencies: 215
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, role) FROM stdin;
1	admin
\.


--
-- TOC entry 3325 (class 0 OID 26635)
-- Dependencies: 214
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, email, senha, nome, role, cpf, actived, created, updated) FROM stdin;
1	root@email.com	1	root	1	019.733.945-96	t	2023-05-05	2023-05-05
\.


--
-- TOC entry 3334 (class 0 OID 0)
-- Dependencies: 217
-- Name: sequence_id_role; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sequence_id_role', 1, false);


--
-- TOC entry 3335 (class 0 OID 0)
-- Dependencies: 216
-- Name: sequence_id_user; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sequence_id_user', 1, false);


--
-- TOC entry 3179 (class 2606 OID 26674)
-- Name: users id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 3181 (class 2606 OID 26661)
-- Name: roles id_role; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT id_role PRIMARY KEY (id);


--
-- TOC entry 3182 (class 2606 OID 26662)
-- Name: users fk_role; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk_role FOREIGN KEY (role) REFERENCES public.roles(id) NOT VALID;


-- Completed on 2023-08-22 10:38:41

--
-- PostgreSQL database dump complete
--

