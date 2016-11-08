--
-- PostgreSQL database dump
--

-- Dumped from database version 9.3.15
-- Dumped by pg_dump version 9.3.15
-- Started on 2016-11-07 21:43:22

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11750)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2119 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- TOC entry 202 (class 1255 OID 16636)
-- Name: crearschema(character varying); Type: FUNCTION; Schema: public; Owner: postgres
--

CREATE FUNCTION crearschema(nombreschema character varying) RETURNS SETOF record
    LANGUAGE plpgsql
    AS $$
  DECLARE
     BEGIN
     SELECT DISTINCT SCHEMANAME FROM PG_TABLES;
     
     IF nombreSchema <> '' THEN
        EXECUTE 'CREATE SCHEMA ' || nombreSchema;        
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.ALMACEN AS SELECT * FROM PUBLIC.ALMACEN LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.ALMACENPRODUCTO AS SELECT * FROM PUBLIC.ALMACENPRODUCTO LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.AREA AS SELECT * FROM PUBLIC.AREA LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.CIUDAD AS SELECT * FROM PUBLIC.CIUDAD LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.DETALLEMOVIMIENTO AS SELECT * FROM PUBLIC.DETALLEMOVIMIENTO LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.FUNCIONALIDAD AS SELECT * FROM PUBLIC.FUNCIONALIDAD LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.MODULO AS SELECT * FROM PUBLIC.MODULO LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.MOVIMIENTO AS SELECT * FROM PUBLIC.MOVIMIENTO LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.PERFILES AS SELECT * FROM PUBLIC.PERFILES LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.PERFILFUNCIONALIDAD AS SELECT * FROM PUBLIC.PERFILFUNCIONALIDAD LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.PERSONA AS SELECT * FROM PUBLIC.PERSONA LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.PRODUCTO AS SELECT * FROM PUBLIC.PRODUCTO LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.TENANT AS SELECT * FROM PUBLIC.TENANT LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.TIPOIDENTIFICACION AS SELECT * FROM PUBLIC.TIPOIDENTIFICACION LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.TIPOMEDIDA AS SELECT * FROM PUBLIC.TIPOMEDIDA LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.TIPOMOVIMIENTO AS SELECT * FROM PUBLIC.TIPOMOVIMIENTO LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.TIPOPERSONAS AS SELECT * FROM PUBLIC.TIPOPERSONAS LIMIT 0';
	EXECUTE 'CREATE TABLE ' || nombreSchema || '.USUARIO AS SELECT * FROM PUBLIC.USUARIO LIMIT 0';
     END IF;
     RETURN;
  END;
$$;


ALTER FUNCTION public.crearschema(nombreschema character varying) OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 171 (class 1259 OID 16637)
-- Name: almacen; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE almacen (
    idalmacen integer NOT NULL,
    descripcion bigint,
    idciudad integer NOT NULL,
    direccion bigint NOT NULL,
    telefono character varying(20),
    mail character varying(30),
    contacto integer NOT NULL
);


ALTER TABLE public.almacen OWNER TO postgres;

--
-- TOC entry 172 (class 1259 OID 16640)
-- Name: almacenproducto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE almacenproducto (
    idalmacen integer NOT NULL,
    idproducto integer NOT NULL,
    cantidad numeric(10,2) NOT NULL,
    stockminimo numeric(10,2) NOT NULL,
    stockmaximo numeric(10,2) NOT NULL,
    valorcompra numeric(18,2) NOT NULL
);


ALTER TABLE public.almacenproducto OWNER TO postgres;

--
-- TOC entry 173 (class 1259 OID 16643)
-- Name: area; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE area (
    idarea integer NOT NULL,
    descripcion character varying(20)
);


ALTER TABLE public.area OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16646)
-- Name: ciudad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE ciudad (
    idciudad integer NOT NULL,
    descripcion character varying(50)
);


ALTER TABLE public.ciudad OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16649)
-- Name: detallemovimiento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE detallemovimiento (
    idmovimiento integer NOT NULL,
    iddetalle integer NOT NULL,
    idalmacen integer NOT NULL,
    idproducto integer NOT NULL,
    cantidad integer NOT NULL,
    valorcompra numeric(18,2) NOT NULL,
    valorventa numeric(18,2)
);


ALTER TABLE public.detallemovimiento OWNER TO postgres;

--
-- TOC entry 176 (class 1259 OID 16652)
-- Name: dummy; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE dummy (
    columna character varying(10)
);


ALTER TABLE public.dummy OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 16655)
-- Name: funcionalidad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE funcionalidad (
    idfuncionalidad integer NOT NULL,
    descripcion character varying(50) NOT NULL,
    idmodulo integer NOT NULL
);


ALTER TABLE public.funcionalidad OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 16658)
-- Name: modulo; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE modulo (
    idmodulo integer NOT NULL,
    descripcion character varying(50) NOT NULL
);


ALTER TABLE public.modulo OWNER TO postgres;

--
-- TOC entry 179 (class 1259 OID 16661)
-- Name: movimiento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE movimiento (
    idmovimiento integer NOT NULL,
    idtipomovimiento integer NOT NULL,
    idcliente integer,
    idproveedor integer,
    fecha timestamp without time zone,
    idusuario integer NOT NULL
);


ALTER TABLE public.movimiento OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 16664)
-- Name: perfiles; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE perfiles (
    idperfil integer NOT NULL,
    descripcion character varying(20)
);


ALTER TABLE public.perfiles OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 16667)
-- Name: perfilfuncionalidad; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE perfilfuncionalidad (
    idperfil integer NOT NULL,
    idfuncionalidad integer NOT NULL,
    inserta boolean NOT NULL,
    borra boolean,
    modificia boolean
);


ALTER TABLE public.perfilfuncionalidad OWNER TO postgres;

--
-- TOC entry 182 (class 1259 OID 16670)
-- Name: persona; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE persona (
    idpersona integer NOT NULL,
    idtipopersona integer NOT NULL,
    idtipoidentificacion bigint NOT NULL,
    identificacion bigint NOT NULL,
    nombre bigint NOT NULL,
    direccion bigint,
    telefono bigint,
    correocontacto bigint NOT NULL,
    contacto bigint NOT NULL
);


ALTER TABLE public.persona OWNER TO postgres;

--
-- TOC entry 183 (class 1259 OID 16673)
-- Name: producto; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE producto (
    idproducto integer NOT NULL,
    descripcion character varying(50) NOT NULL,
    idfabricante integer,
    idtipomedida integer,
    medida numeric(10,2)
);


ALTER TABLE public.producto OWNER TO postgres;

--
-- TOC entry 184 (class 1259 OID 16676)
-- Name: tenant; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tenant (
    idtenant integer NOT NULL,
    tipoidentificacion integer NOT NULL,
    identificacion character varying(20) NOT NULL,
    nombre character varying(50) NOT NULL,
    direccion character varying(50),
    telefono character varying(20),
    esquema character varying(50) NOT NULL
);


ALTER TABLE public.tenant OWNER TO postgres;

--
-- TOC entry 185 (class 1259 OID 16679)
-- Name: tipoidentificacion; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipoidentificacion (
    ididentificacion integer NOT NULL,
    descripcion character varying(50)
);


ALTER TABLE public.tipoidentificacion OWNER TO postgres;

--
-- TOC entry 186 (class 1259 OID 16682)
-- Name: tipomedida; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipomedida (
    idtipomedida integer NOT NULL,
    descripcion character varying(50)
);


ALTER TABLE public.tipomedida OWNER TO postgres;

--
-- TOC entry 187 (class 1259 OID 16685)
-- Name: tipomovimiento; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipomovimiento (
    idmovimiento integer NOT NULL,
    descripcion character varying(10)
);


ALTER TABLE public.tipomovimiento OWNER TO postgres;

--
-- TOC entry 188 (class 1259 OID 16688)
-- Name: tipopersonas; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE tipopersonas (
    idtipopersona integer NOT NULL,
    descripcion character varying(50) NOT NULL
);


ALTER TABLE public.tipopersonas OWNER TO postgres;

--
-- TOC entry 189 (class 1259 OID 16691)
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE usuario (
    idusuario integer NOT NULL,
    usuario character(10) NOT NULL,
    contrasena character varying(10) NOT NULL,
    nombre character varying(50),
    apellidos character varying(30),
    idarea integer NOT NULL,
    idtenant integer NOT NULL
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- TOC entry 2093 (class 0 OID 16637)
-- Dependencies: 171
-- Data for Name: almacen; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY almacen (idalmacen, descripcion, idciudad, direccion, telefono, mail, contacto) FROM stdin;
\.


--
-- TOC entry 2094 (class 0 OID 16640)
-- Dependencies: 172
-- Data for Name: almacenproducto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY almacenproducto (idalmacen, idproducto, cantidad, stockminimo, stockmaximo, valorcompra) FROM stdin;
\.


--
-- TOC entry 2095 (class 0 OID 16643)
-- Dependencies: 173
-- Data for Name: area; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY area (idarea, descripcion) FROM stdin;
1	Administrador
2	Contabilidad
3	Inventarios
4	Facturacion
\.


--
-- TOC entry 2096 (class 0 OID 16646)
-- Dependencies: 174
-- Data for Name: ciudad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY ciudad (idciudad, descripcion) FROM stdin;
\.


--
-- TOC entry 2097 (class 0 OID 16649)
-- Dependencies: 175
-- Data for Name: detallemovimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY detallemovimiento (idmovimiento, iddetalle, idalmacen, idproducto, cantidad, valorcompra, valorventa) FROM stdin;
\.


--
-- TOC entry 2098 (class 0 OID 16652)
-- Dependencies: 176
-- Data for Name: dummy; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY dummy (columna) FROM stdin;
1
2
3
4
5
6
7
1
2
3
4
5
6
7
1
2
3
4
5
6
7
1
2
3
4
5
6
7
\.


--
-- TOC entry 2099 (class 0 OID 16655)
-- Dependencies: 177
-- Data for Name: funcionalidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY funcionalidad (idfuncionalidad, descripcion, idmodulo) FROM stdin;
\.


--
-- TOC entry 2100 (class 0 OID 16658)
-- Dependencies: 178
-- Data for Name: modulo; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY modulo (idmodulo, descripcion) FROM stdin;
\.


--
-- TOC entry 2101 (class 0 OID 16661)
-- Dependencies: 179
-- Data for Name: movimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY movimiento (idmovimiento, idtipomovimiento, idcliente, idproveedor, fecha, idusuario) FROM stdin;
\.


--
-- TOC entry 2102 (class 0 OID 16664)
-- Dependencies: 180
-- Data for Name: perfiles; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY perfiles (idperfil, descripcion) FROM stdin;
\.


--
-- TOC entry 2103 (class 0 OID 16667)
-- Dependencies: 181
-- Data for Name: perfilfuncionalidad; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY perfilfuncionalidad (idperfil, idfuncionalidad, inserta, borra, modificia) FROM stdin;
\.


--
-- TOC entry 2104 (class 0 OID 16670)
-- Dependencies: 182
-- Data for Name: persona; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY persona (idpersona, idtipopersona, idtipoidentificacion, identificacion, nombre, direccion, telefono, correocontacto, contacto) FROM stdin;
\.


--
-- TOC entry 2105 (class 0 OID 16673)
-- Dependencies: 183
-- Data for Name: producto; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY producto (idproducto, descripcion, idfabricante, idtipomedida, medida) FROM stdin;
\.


--
-- TOC entry 2106 (class 0 OID 16676)
-- Dependencies: 184
-- Data for Name: tenant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tenant (idtenant, tipoidentificacion, identificacion, nombre, direccion, telefono, esquema) FROM stdin;
1	1	1234567890	Software POS	Calle False # 123	1234567	SOFTPOS
\.


--
-- TOC entry 2107 (class 0 OID 16679)
-- Dependencies: 185
-- Data for Name: tipoidentificacion; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipoidentificacion (ididentificacion, descripcion) FROM stdin;
1	Tarjeta de Identidad
2	Cedula de Ciudadania
3	Tarjeta de Extranjeria
\.


--
-- TOC entry 2108 (class 0 OID 16682)
-- Dependencies: 186
-- Data for Name: tipomedida; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipomedida (idtipomedida, descripcion) FROM stdin;
\.


--
-- TOC entry 2109 (class 0 OID 16685)
-- Dependencies: 187
-- Data for Name: tipomovimiento; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipomovimiento (idmovimiento, descripcion) FROM stdin;
\.


--
-- TOC entry 2110 (class 0 OID 16688)
-- Dependencies: 188
-- Data for Name: tipopersonas; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY tipopersonas (idtipopersona, descripcion) FROM stdin;
\.


--
-- TOC entry 2111 (class 0 OID 16691)
-- Dependencies: 189
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY usuario (idusuario, usuario, contrasena, nombre, apellidos, idarea, idtenant) FROM stdin;
1	Pancracio 	12345	Pedro	PicaPiedra	1	1
\.


--
-- TOC entry 1895 (class 2606 OID 16695)
-- Name: pk_almacen; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY almacen
    ADD CONSTRAINT pk_almacen PRIMARY KEY (idalmacen);


--
-- TOC entry 1899 (class 2606 OID 16697)
-- Name: pk_almacenproducto; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY almacenproducto
    ADD CONSTRAINT pk_almacenproducto PRIMARY KEY (idalmacen, idproducto);


--
-- TOC entry 1901 (class 2606 OID 16699)
-- Name: pk_area; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY area
    ADD CONSTRAINT pk_area PRIMARY KEY (idarea);


--
-- TOC entry 1905 (class 2606 OID 16701)
-- Name: pk_ciudad; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ciudad
    ADD CONSTRAINT pk_ciudad PRIMARY KEY (idciudad);


--
-- TOC entry 1909 (class 2606 OID 16703)
-- Name: pk_detallemovimiento; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detallemovimiento
    ADD CONSTRAINT pk_detallemovimiento PRIMARY KEY (idmovimiento, iddetalle);


--
-- TOC entry 1915 (class 2606 OID 16705)
-- Name: pk_funcionalidad; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY funcionalidad
    ADD CONSTRAINT pk_funcionalidad PRIMARY KEY (idfuncionalidad);


--
-- TOC entry 1919 (class 2606 OID 16707)
-- Name: pk_modulo; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY modulo
    ADD CONSTRAINT pk_modulo PRIMARY KEY (idmodulo);


--
-- TOC entry 1923 (class 2606 OID 16709)
-- Name: pk_movimiento; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT pk_movimiento PRIMARY KEY (idmovimiento);


--
-- TOC entry 1927 (class 2606 OID 16711)
-- Name: pk_perfiles; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY perfiles
    ADD CONSTRAINT pk_perfiles PRIMARY KEY (idperfil);


--
-- TOC entry 1931 (class 2606 OID 16713)
-- Name: pk_perfilfuncionalidad; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY perfilfuncionalidad
    ADD CONSTRAINT pk_perfilfuncionalidad PRIMARY KEY (idperfil, idfuncionalidad);


--
-- TOC entry 1937 (class 2606 OID 16715)
-- Name: pk_persona; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT pk_persona PRIMARY KEY (idpersona);


--
-- TOC entry 1941 (class 2606 OID 16717)
-- Name: pk_producto; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT pk_producto PRIMARY KEY (idproducto);


--
-- TOC entry 1943 (class 2606 OID 16719)
-- Name: pk_tenant; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tenant
    ADD CONSTRAINT pk_tenant PRIMARY KEY (idtenant);


--
-- TOC entry 1947 (class 2606 OID 16721)
-- Name: pk_tipoidentificacion; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipoidentificacion
    ADD CONSTRAINT pk_tipoidentificacion PRIMARY KEY (ididentificacion);


--
-- TOC entry 1951 (class 2606 OID 16723)
-- Name: pk_tipomedida; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipomedida
    ADD CONSTRAINT pk_tipomedida PRIMARY KEY (idtipomedida);


--
-- TOC entry 1955 (class 2606 OID 16725)
-- Name: pk_tipomovimiento; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipomovimiento
    ADD CONSTRAINT pk_tipomovimiento PRIMARY KEY (idmovimiento);


--
-- TOC entry 1959 (class 2606 OID 16727)
-- Name: pk_tipopersonas; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipopersonas
    ADD CONSTRAINT pk_tipopersonas PRIMARY KEY (idtipopersona);


--
-- TOC entry 1963 (class 2606 OID 16729)
-- Name: pk_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT pk_usuario PRIMARY KEY (idusuario);


--
-- TOC entry 1897 (class 2606 OID 16731)
-- Name: uq_almacen_idalmacen; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY almacen
    ADD CONSTRAINT uq_almacen_idalmacen UNIQUE (idalmacen);


--
-- TOC entry 1903 (class 2606 OID 16733)
-- Name: uq_area_idarea; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY area
    ADD CONSTRAINT uq_area_idarea UNIQUE (idarea);


--
-- TOC entry 1907 (class 2606 OID 16735)
-- Name: uq_ciudad_idciudad; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY ciudad
    ADD CONSTRAINT uq_ciudad_idciudad UNIQUE (idciudad);


--
-- TOC entry 1911 (class 2606 OID 16737)
-- Name: uq_detallemovimiento_iddetalle; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detallemovimiento
    ADD CONSTRAINT uq_detallemovimiento_iddetalle UNIQUE (iddetalle);


--
-- TOC entry 1913 (class 2606 OID 16739)
-- Name: uq_detallemovimiento_idmovimiento; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY detallemovimiento
    ADD CONSTRAINT uq_detallemovimiento_idmovimiento UNIQUE (idmovimiento);


--
-- TOC entry 1917 (class 2606 OID 16741)
-- Name: uq_funcionalidad_idfuncionalidad; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY funcionalidad
    ADD CONSTRAINT uq_funcionalidad_idfuncionalidad UNIQUE (idfuncionalidad);


--
-- TOC entry 1921 (class 2606 OID 16743)
-- Name: uq_modulo_idmodulo; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY modulo
    ADD CONSTRAINT uq_modulo_idmodulo UNIQUE (idmodulo);


--
-- TOC entry 1925 (class 2606 OID 16745)
-- Name: uq_movimiento_idmovimiento; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT uq_movimiento_idmovimiento UNIQUE (idmovimiento);


--
-- TOC entry 1929 (class 2606 OID 16747)
-- Name: uq_perfiles_idperfil; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY perfiles
    ADD CONSTRAINT uq_perfiles_idperfil UNIQUE (idperfil);


--
-- TOC entry 1933 (class 2606 OID 16749)
-- Name: uq_perfilfuncionalidad_idfuncionalidad; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY perfilfuncionalidad
    ADD CONSTRAINT uq_perfilfuncionalidad_idfuncionalidad UNIQUE (idfuncionalidad);


--
-- TOC entry 1935 (class 2606 OID 16751)
-- Name: uq_perfilfuncionalidad_idperfil; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY perfilfuncionalidad
    ADD CONSTRAINT uq_perfilfuncionalidad_idperfil UNIQUE (idperfil);


--
-- TOC entry 1939 (class 2606 OID 16753)
-- Name: uq_persona_idpersona; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT uq_persona_idpersona UNIQUE (idpersona);


--
-- TOC entry 1945 (class 2606 OID 16755)
-- Name: uq_tenant_idtenant; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tenant
    ADD CONSTRAINT uq_tenant_idtenant UNIQUE (idtenant);


--
-- TOC entry 1949 (class 2606 OID 16757)
-- Name: uq_tipoidentificacion_ididentificacion; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipoidentificacion
    ADD CONSTRAINT uq_tipoidentificacion_ididentificacion UNIQUE (ididentificacion);


--
-- TOC entry 1953 (class 2606 OID 16759)
-- Name: uq_tipomedida_idtipomedida; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipomedida
    ADD CONSTRAINT uq_tipomedida_idtipomedida UNIQUE (idtipomedida);


--
-- TOC entry 1957 (class 2606 OID 16761)
-- Name: uq_tipomovimiento_idmovimiento; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipomovimiento
    ADD CONSTRAINT uq_tipomovimiento_idmovimiento UNIQUE (idmovimiento);


--
-- TOC entry 1961 (class 2606 OID 16763)
-- Name: uq_tipopersonas_idtipopersona; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY tipopersonas
    ADD CONSTRAINT uq_tipopersonas_idtipopersona UNIQUE (idtipopersona);


--
-- TOC entry 1965 (class 2606 OID 16765)
-- Name: uq_usuario_idusuario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT uq_usuario_idusuario UNIQUE (idusuario);


--
-- TOC entry 1967 (class 2606 OID 16767)
-- Name: uq_usuario_usuario; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT uq_usuario_usuario UNIQUE (usuario);


--
-- TOC entry 1968 (class 2606 OID 16768)
-- Name: fk_almacen_ciudad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY almacen
    ADD CONSTRAINT fk_almacen_ciudad FOREIGN KEY (idciudad) REFERENCES ciudad(idciudad);


--
-- TOC entry 1969 (class 2606 OID 16773)
-- Name: fk_almacenproducto_almacen; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY almacenproducto
    ADD CONSTRAINT fk_almacenproducto_almacen FOREIGN KEY (idalmacen) REFERENCES almacen(idalmacen);


--
-- TOC entry 1970 (class 2606 OID 16778)
-- Name: fk_almacenproducto_producto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY almacenproducto
    ADD CONSTRAINT fk_almacenproducto_producto FOREIGN KEY (idproducto) REFERENCES producto(idproducto);


--
-- TOC entry 1971 (class 2606 OID 16783)
-- Name: fk_detallemovimiento_almacen; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detallemovimiento
    ADD CONSTRAINT fk_detallemovimiento_almacen FOREIGN KEY (idalmacen) REFERENCES almacen(idalmacen);


--
-- TOC entry 1972 (class 2606 OID 16788)
-- Name: fk_detallemovimiento_movimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detallemovimiento
    ADD CONSTRAINT fk_detallemovimiento_movimiento FOREIGN KEY (idmovimiento) REFERENCES movimiento(idmovimiento);


--
-- TOC entry 1973 (class 2606 OID 16793)
-- Name: fk_detallemovimiento_producto; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY detallemovimiento
    ADD CONSTRAINT fk_detallemovimiento_producto FOREIGN KEY (idproducto) REFERENCES producto(idproducto);


--
-- TOC entry 1974 (class 2606 OID 16798)
-- Name: fk_funcionalidad_modulo; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY funcionalidad
    ADD CONSTRAINT fk_funcionalidad_modulo FOREIGN KEY (idmodulo) REFERENCES modulo(idmodulo);


--
-- TOC entry 1975 (class 2606 OID 16803)
-- Name: fk_movimiento_cliente; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT fk_movimiento_cliente FOREIGN KEY (idcliente) REFERENCES persona(idpersona);


--
-- TOC entry 1976 (class 2606 OID 16808)
-- Name: fk_movimiento_proveedor; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT fk_movimiento_proveedor FOREIGN KEY (idproveedor) REFERENCES persona(idpersona);


--
-- TOC entry 1977 (class 2606 OID 16813)
-- Name: fk_movimiento_tipomovimiento; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT fk_movimiento_tipomovimiento FOREIGN KEY (idtipomovimiento) REFERENCES tipomovimiento(idmovimiento);


--
-- TOC entry 1978 (class 2606 OID 16818)
-- Name: fk_movimiento_usuario; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY movimiento
    ADD CONSTRAINT fk_movimiento_usuario FOREIGN KEY (idusuario) REFERENCES usuario(idusuario);


--
-- TOC entry 1979 (class 2606 OID 16823)
-- Name: fk_perffunc_funcionalidad; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY perfilfuncionalidad
    ADD CONSTRAINT fk_perffunc_funcionalidad FOREIGN KEY (idfuncionalidad) REFERENCES funcionalidad(idfuncionalidad);


--
-- TOC entry 1980 (class 2606 OID 16828)
-- Name: fk_perffunc_perfil; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY perfilfuncionalidad
    ADD CONSTRAINT fk_perffunc_perfil FOREIGN KEY (idperfil) REFERENCES perfiles(idperfil);


--
-- TOC entry 1981 (class 2606 OID 16833)
-- Name: fk_persona_tipoidentificacion; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT fk_persona_tipoidentificacion FOREIGN KEY (idtipoidentificacion) REFERENCES tipoidentificacion(ididentificacion);


--
-- TOC entry 1982 (class 2606 OID 16838)
-- Name: fk_persona_tipopersona; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY persona
    ADD CONSTRAINT fk_persona_tipopersona FOREIGN KEY (idtipopersona) REFERENCES tipopersonas(idtipopersona);


--
-- TOC entry 1983 (class 2606 OID 16843)
-- Name: fk_producto_tipomedida; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY producto
    ADD CONSTRAINT fk_producto_tipomedida FOREIGN KEY (idtipomedida) REFERENCES tipomedida(idtipomedida);


--
-- TOC entry 1984 (class 2606 OID 16848)
-- Name: fk_usuario_area; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT fk_usuario_area FOREIGN KEY (idarea) REFERENCES area(idarea);


--
-- TOC entry 1985 (class 2606 OID 16853)
-- Name: fk_usuario_tenant; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT fk_usuario_tenant FOREIGN KEY (idtenant) REFERENCES tenant(idtenant);


--
-- TOC entry 2118 (class 0 OID 0)
-- Dependencies: 7
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2016-11-07 21:43:22

--
-- PostgreSQL database dump complete
--

