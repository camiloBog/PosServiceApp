select * from usuario;

select * from USUARIO U where U.usuario = 'cb' and U.contrasena = '123';

SELECT * FROM TENANT;
insert into tenant values(2,1,112233, 'Segundo Tenant', 'Alguna direccion', 'algun telefono', '2DOTENANT');


--DELETE FROM usuario ;
insert into usuario values (1, 'camilo', '123', 'Camilo', 'Bustamante', 1, 1);
insert into usuario values (2, 'pp', 'ytt', 'Pedro', 'Picapiedra', 1, 1);
insert into usuario values (3, 'cb', '123', 'Camilo', 'Bustamante', 1, 1);
insert into usuario values (4, 'as', 'asww', 'Andres', 'Sanchez', 1, 1);
insert into usuario values (5, 'jm', 'tyty', 'Juan', 'Mendoza', 1, 1);
insert into usuario values (6, 'dt', '5f', 'Donalt', 'Thrump', 1, 1);
insert into usuario values (7, 'hc', '77', 'Hilary', 'Clinton', 1, 1);
select * from usuario;


CREATE SEQUENCE tenant_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 999999999
  START 2
  CACHE 1
  CYCLE;
ALTER TABLE tenant_seq
  OWNER TO postgres;