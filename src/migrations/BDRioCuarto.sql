DROP DATABASE IF EXISTS RioCuartoViaja;
CREATE DATABASE IF NOT EXISTS RioCuartoViaja;
USE RioCuartoViaja;

DROP TABLE IF EXISTS empleados;
CREATE TABLE IF NOT EXISTS empleados (
	dni int(8) NOT NULL,
	nombre varchar(32),
	apellido varchar(32),
	loc_origen varchar(45),
	telefono varchar(45),
	pass varchar(45),
	PRIMARY KEY (dni)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS gerentes;
CREATE TABLE IF NOT EXISTS gerentes (
	dni int(8) NOT NULL,
	gastos_repres float(10),
	PRIMARY KEY (dni),
	CONSTRAINT fk_dni_gerentes FOREIGN KEY (dni) REFERENCES empleados (dni)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS administrativos;
CREATE TABLE IF NOT EXISTS administrativos (
	dni int(8) NOT NULL,
	turno enum ('mañana','tarde'), 
	PRIMARY KEY (dni),
	CONSTRAINT fk_dni_administrativos FOREIGN KEY (dni) REFERENCES empleados (dni)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS agrupacion_jubilados;
CREATE TABLE IF NOT EXISTS agrupacion_jubilados (
	nombre varchar(45) NOT NULL,
	direccion varchar(45),
	telefono varchar (45),
	PRIMARY KEY (nombre)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS clientes;
CREATE TABLE IF NOT EXISTS clientes (
	dni int(8) NOT NULL,
	nombre varchar(32),
	apellido varchar(32),
	direccion varchar(45),
	telefono varchar(45),
	nombre_agrupacion varchar (45),
	PRIMARY KEY (dni),
	CONSTRAINT fk_nombre_agrupacion FOREIGN KEY (nombre_agrupacion) REFERENCES agrupacion_jubilados (nombre)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;


DROP TABLE IF EXISTS ficha_medicas;
CREATE TABLE IF NOT EXISTS ficha_medicas (
	dni int(8) NOT NULL,
	nombre_enfermedad varchar(45),
	es_cronica enum ('si','no'),
	nombre_medicamento varchar(45),
	frecuencia varchar (45),
	medicamento_alergico varchar (45),
	CONSTRAINT unique_ficha UNIQUE (dni),
	CONSTRAINT fk_dni_ficha FOREIGN KEY (dni) REFERENCES clientes (dni)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS traslados;
CREATE TABLE IF NOT EXISTS traslados(
	id int(10) NOT NULL AUTO_INCREMENT,
	costo float(10),
	duracion float(10),
	distancia float(10),
	PRIMARY KEY (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS paquete_turisticos;
CREATE TABLE IF NOT EXISTS paquete_turisticos (
	id int(10) NOT NULL AUTO_INCREMENT,
	ciudad_destino varchar(45) NOT NULL,
	id_traslado int(10) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_id_traslado FOREIGN KEY (id_traslado) REFERENCES traslados (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS atraccion_turisticas;
CREATE TABLE IF NOT EXISTS atraccion_turisticas (
	id int(10) NOT NULL AUTO_INCREMENT,
	id_paquete int(10) NOT NULL,
	nombre varchar(45),
	descripcion varchar (80),
	costo float(10),
	PRIMARY KEY (id),
	CONSTRAINT fk_id_paquete_at_tur FOREIGN KEY (id_paquete) REFERENCES paquete_turisticos (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS atraccion_clientes;
CREATE TABLE IF NOT EXISTS atraccion_clientes (
	dni int(8) NOT NULL,
	id_paquete int(10) NOT NULL,
	id_atraccion int(8) NOT NULL,
	PRIMARY KEY (dni,id_paquete,id_atraccion),
	CONSTRAINT fk_dni_cliente_atracc FOREIGN KEY (dni) REFERENCES clientes (dni) ON DELETE CASCADE,
	CONSTRAINT fk_id_paquete_atracc FOREIGN KEY (id_paquete) REFERENCES paquete_turisticos (id),
	CONSTRAINT fk_id_atraccion_atracc FOREIGN KEY (id_atraccion) REFERENCES atraccion_turisticas (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS cliente_paquetes;
CREATE TABLE IF NOT EXISTS cliente_paquetes (
	id int(10) NOT NULL AUTO_INCREMENT,
	dni int(8) NOT NULL,
	id_paquete int(10) NOT NULL,
	PRIMARY KEY (id),
	CONSTRAINT fk_dni_cliente_ap FOREIGN KEY (dni) REFERENCES clientes (dni) ON DELETE CASCADE,
	CONSTRAINT fk_id_paquete_ap FOREIGN KEY (id_paquete) REFERENCES paquete_turisticos (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS efectivos;
CREATE TABLE IF NOT EXISTS efectivos(
	id_paquete int(10) NOT NULL,
	monto_total_descuento float(10),
	fecha date,
	CONSTRAINT fk_id_paquete_ef FOREIGN KEY (id_paquete) REFERENCES cliente_paquetes (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS plan_cuotas;
CREATE TABLE IF NOT EXISTS plan_cuotas (
	id_paquete int(10) NOT NULL,
	nro_plan int(10) NOT NULL,
	cant_cuotas int(2) CHECK (cant_cuotas>=2 and cant_cuotas<=20),
	fecha_inc date,
	fecha_fin date,
	PRIMARY KEY (nro_plan),
	CONSTRAINT fk_id_paquete_cuota FOREIGN KEY (id_paquete) REFERENCES cliente_paquetes (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS cuotas;
CREATE TABLE IF NOT EXISTS cuotas (
	nro_plan int(10) NOT NULL,
	monto float(10),
	fecha date,
	estado enum ('paga','vencida','por vencer'),
	CONSTRAINT fk_nro_plan FOREIGN KEY (nro_plan) REFERENCES plan_cuotas (nro_plan)
) ENGINE = InnoDB DEFAULT CHARSET = utf8;