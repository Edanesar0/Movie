CREATE DATABASE "SmartTickets"
WITH
OWNER = postgres
ENCODING = 'UTF8'
CONNECTION LIMIT = -1;

CREATE TABLE tblestado
(
  idestado    SERIAL NOT NULL
    CONSTRAINT "tblEstado_pkey"
    PRIMARY KEY,
  descripcion TEXT
);

COMMENT ON TABLE tblestado IS 'Estado en que se encuentran los tickets';

CREATE TABLE tblcargo
(
  idcargo     SERIAL NOT NULL
    CONSTRAINT "tblCargo_pkey"
    PRIMARY KEY,
  descripcion TEXT
);

COMMENT ON TABLE tblcargo IS 'Tabla en la que se encuentran los cargos de la compañia';

CREATE TABLE tbltipoticket
(
  idtipoticket SERIAL NOT NULL
    CONSTRAINT "tblTipoTicket_pkey"
    PRIMARY KEY,
  descripcion  TEXT
);

COMMENT ON TABLE tbltipoticket IS 'Tipos de tickets';

CREATE TABLE tblprioridad
(
  idprioridad SERIAL NOT NULL
    CONSTRAINT "tblPrioridad_pkey"
    PRIMARY KEY,
  decripcion  TEXT
);

COMMENT ON TABLE tblprioridad IS 'Prioridad de los tickets';

CREATE TABLE tblproyecto
(
  idproyecto SERIAL NOT NULL
    CONSTRAINT pk_proyecto
    PRIMARY KEY,
  nombre     TEXT   NOT NULL,
  logo       TEXT,
  color      TEXT,
  idestado   INTEGER
    CONSTRAINT frk_pro_est
    REFERENCES tblestado
);

COMMENT ON TABLE tblproyecto IS 'Proyectos que se realizan o que esrtan en mantenimiento';

CREATE TABLE tblusuario
(
  idusuario SERIAL  NOT NULL
    CONSTRAINT "tblUsuario_pkey"
    PRIMARY KEY,
  nombre    TEXT    NOT NULL,
  apellido  TEXT    NOT NULL,
  cargo     INTEGER NOT NULL
    CONSTRAINT tblusuario_cargo_fkey
    REFERENCES tblcargo,
  password  TEXT,
  email     TEXT    NOT NULL,
  telefono  TEXT,
  activo    BOOLEAN NOT NULL,
  idlider   INTEGER
    CONSTRAINT tblusuario_idlider_fkey
    REFERENCES tblusuario
);

COMMENT ON TABLE tblusuario IS 'Tabla de usuarios que se encuentran en el sistema';

CREATE TABLE tblticket
(
  idtickets     SERIAL  NOT NULL
    CONSTRAINT "tblTicket_pkey"
    PRIMARY KEY,
  idresponsable INTEGER
    CONSTRAINT "tblTicket_idResponsable_fkey"
    REFERENCES tblusuario,
  idquienpide   INTEGER NOT NULL
    CONSTRAINT "tblTicket_idQuienPide_fkey"
    REFERENCES tblusuario,
  fechainicio   DATE    NOT NULL,
  fechaentrega  DATE,
  horas         INTEGER,
  porcentaje    INTEGER DEFAULT 0,
  idestado      INTEGER
    CONSTRAINT "tblTicket_IdEstado_fkey"
    REFERENCES tblestado,
  descripcion   TEXT,
  idtipo        INTEGER
    CONSTRAINT "tblTicket_IdTipo_fkey"
    REFERENCES tbltipoticket,
  idprioridad   INTEGER
    CONSTRAINT "tblTicket_idPrioridad_fkey"
    REFERENCES tblprioridad,
  archivo       TEXT,
  idproyecto    INTEGER
    CONSTRAINT "tblTicket_idProyecto_fkey"
    REFERENCES tblproyecto,
  comentariodes TEXT
);

COMMENT ON TABLE tblticket IS 'Tickets';

CREATE TABLE tbl_usr_pro
(
  idusuario  INTEGER NOT NULL,
  idproyecto INTEGER NOT NULL,
  fecha      DATE,
  idestado   INTEGER
    CONSTRAINT tbl_usr_pro_idestado_fkey
    REFERENCES tblestado,
  CONSTRAINT tbl_usr_pro_pkey
  PRIMARY KEY (idproyecto, idusuario)
);

