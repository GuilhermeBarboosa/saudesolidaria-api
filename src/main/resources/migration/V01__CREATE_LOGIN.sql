--
-- PostgreSQL database dump
--

-- Dumped from database version 15.1
-- Dumped by pg_dump version 15.1

-- Started on 2023-08-25 11:10:26

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
-- TOC entry 225 (class 1259 OID 26712)
-- Name: consultas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.consultas (
                                  id bigint NOT NULL,
                                  data date NOT NULL,
                                  medico bigint NOT NULL,
                                  local bigint NOT NULL,
                                  actived boolean NOT NULL,
                                  created date NOT NULL,
                                  updated date
);


ALTER TABLE public.consultas OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 26695)
-- Name: especialidades; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.especialidades (
                                       id bigint NOT NULL,
                                       especialidade character varying(255) NOT NULL,
                                       actived boolean NOT NULL,
                                       created date NOT NULL,
                                       updated date NOT NULL
);


ALTER TABLE public.especialidades OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 26705)
-- Name: local; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.local (
                              id bigint NOT NULL,
                              rua character varying(255) NOT NULL,
                              bairro character varying(255) NOT NULL,
                              numero character varying(25) NOT NULL,
                              nome_local character varying(255),
                              actived boolean NOT NULL,
                              created date NOT NULL,
                              updated date
);


ALTER TABLE public.local OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 26685)
-- Name: medicos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.medicos (
                                id bigint NOT NULL,
                                crm bigint NOT NULL,
                                "user" bigint NOT NULL,
                                created date NOT NULL,
                                updated date,
                                especialidade bigint NOT NULL,
                                actived boolean NOT NULL
);


ALTER TABLE public.medicos OWNER TO postgres;

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
-- TOC entry 220 (class 1259 OID 26683)
-- Name: sequence_id_consulta; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sequence_id_consulta
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_id_consulta OWNER TO postgres;

--
-- TOC entry 3374 (class 0 OID 0)
-- Dependencies: 220
-- Name: sequence_id_consulta; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sequence_id_consulta OWNED BY public.consultas.id;


--
-- TOC entry 219 (class 1259 OID 26682)
-- Name: sequence_id_espec; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sequence_id_espec
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_id_espec OWNER TO postgres;

--
-- TOC entry 3375 (class 0 OID 0)
-- Dependencies: 219
-- Name: sequence_id_espec; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sequence_id_espec OWNED BY public.especialidades.id;


--
-- TOC entry 221 (class 1259 OID 26684)
-- Name: sequence_id_local; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sequence_id_local
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_id_local OWNER TO postgres;

--
-- TOC entry 3376 (class 0 OID 0)
-- Dependencies: 221
-- Name: sequence_id_local; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sequence_id_local OWNED BY public.local.id;


--
-- TOC entry 218 (class 1259 OID 26681)
-- Name: sequence_id_medico; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.sequence_id_medico
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.sequence_id_medico OWNER TO postgres;

--
-- TOC entry 3377 (class 0 OID 0)
-- Dependencies: 218
-- Name: sequence_id_medico; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.sequence_id_medico OWNED BY public.medicos.id;


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
-- TOC entry 3368 (class 0 OID 26712)
-- Dependencies: 225
-- Data for Name: consultas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.consultas (id, data, medico, local, actived, created, updated) FROM stdin;
\.


--
-- TOC entry 3366 (class 0 OID 26695)
-- Dependencies: 223
-- Data for Name: especialidades; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.especialidades (id, especialidade, actived, created, updated) FROM stdin;
\.


--
-- TOC entry 3367 (class 0 OID 26705)
-- Dependencies: 224
-- Data for Name: local; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.local (id, rua, bairro, numero, nome_local, actived, created, updated) FROM stdin;
\.


--
-- TOC entry 3365 (class 0 OID 26685)
-- Dependencies: 222
-- Data for Name: medicos; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.medicos (id, crm, "user", created, updated, especialidade, actived) FROM stdin;
\.


--
-- TOC entry 3358 (class 0 OID 26642)
-- Dependencies: 215
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.roles (id, role) FROM stdin;
1	admin
\.


--
-- TOC entry 3357 (class 0 OID 26635)
-- Dependencies: 214
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.users (id, email, senha, nome, role, cpf, actived, created, updated) FROM stdin;
2	gui@gmail.com	$2a$10$nFym4ZQawff9yNfJ4Jni/u7kLjfQRDp9fKMfP2idukB8VXmM0qzdq	gui	1	019.567.234-54	t	2023-08-22	2023-08-22
1	root@email.com	$2a$10$nFym4ZQawff9yNfJ4Jni/u7kLjfQRDp9fKMfP2idukB8VXmM0qzdq	root	1	019.733.945-96	t	2023-05-05	2023-05-05
\.


--
-- TOC entry 3378 (class 0 OID 0)
-- Dependencies: 220
-- Name: sequence_id_consulta; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sequence_id_consulta', 1, false);


--
-- TOC entry 3379 (class 0 OID 0)
-- Dependencies: 219
-- Name: sequence_id_espec; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sequence_id_espec', 1, false);


--
-- TOC entry 3380 (class 0 OID 0)
-- Dependencies: 221
-- Name: sequence_id_local; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sequence_id_local', 1, false);


--
-- TOC entry 3381 (class 0 OID 0)
-- Dependencies: 218
-- Name: sequence_id_medico; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sequence_id_medico', 1, false);


--
-- TOC entry 3382 (class 0 OID 0)
-- Dependencies: 217
-- Name: sequence_id_role; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sequence_id_role', 1, false);


--
-- TOC entry 3383 (class 0 OID 0)
-- Dependencies: 216
-- Name: sequence_id_user; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.sequence_id_user', 2, true);


--
-- TOC entry 3199 (class 2606 OID 26674)
-- Name: users id; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 3209 (class 2606 OID 26716)
-- Name: consultas id_consultas; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultas
    ADD CONSTRAINT id_consultas PRIMARY KEY (id);


--
-- TOC entry 3205 (class 2606 OID 26699)
-- Name: especialidades id_especialidade; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.especialidades
    ADD CONSTRAINT id_especialidade PRIMARY KEY (id);


--
-- TOC entry 3207 (class 2606 OID 26711)
-- Name: local id_local; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.local
    ADD CONSTRAINT id_local PRIMARY KEY (id);


--
-- TOC entry 3203 (class 2606 OID 26689)
-- Name: medicos id_medico; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicos
    ADD CONSTRAINT id_medico PRIMARY KEY (id);


--
-- TOC entry 3201 (class 2606 OID 26661)
-- Name: roles id_role; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.roles
    ADD CONSTRAINT id_role PRIMARY KEY (id);


--
-- TOC entry 3213 (class 2606 OID 26722)
-- Name: consultas fk_consulta_local; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultas
    ADD CONSTRAINT fk_consulta_local FOREIGN KEY (local) REFERENCES public.local(id);


--
-- TOC entry 3214 (class 2606 OID 26717)
-- Name: consultas fk_consulta_medico; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.consultas
    ADD CONSTRAINT fk_consulta_medico FOREIGN KEY (medico) REFERENCES public.medicos(id);


--
-- TOC entry 3211 (class 2606 OID 26700)
-- Name: medicos fk_medico_espec; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicos
    ADD CONSTRAINT fk_medico_espec FOREIGN KEY (especialidade) REFERENCES public.especialidades(id) NOT VALID;


--
-- TOC entry 3212 (class 2606 OID 26690)
-- Name: medicos fk_medico_user; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.medicos
    ADD CONSTRAINT fk_medico_user FOREIGN KEY ("user") REFERENCES public.users(id);


--
-- TOC entry 3210 (class 2606 OID 26662)
-- Name: users fk_role; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.users
    ADD CONSTRAINT fk_role FOREIGN KEY (role) REFERENCES public.roles(id) NOT VALID;


-- Completed on 2023-08-25 11:10:26

--
-- PostgreSQL database dump complete
--

