CREATE TABLE cliente (
	id_cliente INT(11) NOT NULL AUTO_INCREMENT,
	nombre_cliente VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	apellido_cliente VARCHAR(50) COLLATE 'utf8mb4_general_ci',
	email_cliente VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
	contrasena_cliente VARCHAR(255) NOT NULL COLLATE 'utf8mb4_general_ci',
	documento_identidad_cliente CHAR(15) COLLATE 'utf8mb4_general_ci',
	numero_telefonico_cliente VARCHAR(255)  COLLATE 'utf8mb4_general_ci',
	fecha_nacimiento_cliente DATE,
	membresia_cliente VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	esta_activo_cliente TINYINT(1) DEFAULT '0',
	PRIMARY KEY (id_cliente) USING BTREE,
	UNIQUE INDEX documento_identidad (documento_identidad_cliente) USING BTREE,
	UNIQUE INDEX email (email_cliente) USING BTREE
);
CREATE TABLE pelicula (
	id INT(11) NOT NULL AUTO_INCREMENT,
	nombre_pelicula VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
	sinopsis_pelicula VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	imagen_pelicula VARCHAR(255) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	categoria_edad_pelicula VARCHAR(100) NULL DEFAULT NULL,
	PRIMARY KEY (id) USING BTREE,
	UNIQUE INDEX nombre_pelicula (nombre_pelicula) USING BTREE
);
CREATE TABLE funcion (
	id_funcion INT(11) NOT NULL AUTO_INCREMENT,
	id_pelicula INT(11) NOT NULL,
	nombre_teatro_funcion VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb4_general_ci',
	sala_funcion VARCHAR(100) NOT NULL COLLATE 'utf8mb4_general_ci',
	hora_funcion TIME NOT NULL,
	dia_funcion DATE NOT NULL,
	categoria_audio_funcion VARCHAR(100) NULL DEFAULT 'Doblaje Latino' COLLATE 'utf8mb4_general_ci',
	categoria_subtitulos_funcion VARCHAR(100) NULL DEFAULT 'Sin Subtitulos' COLLATE 'utf8mb4_general_ci',
	categoria_dimension_visual_funcion VARCHAR(100) NULL DEFAULT '2D' COLLATE 'utf8mb4_general_ci',
	valor_funcion DECIMAL(20,3) NOT NULL,
	PRIMARY KEY (id_funcion) USING BTREE,
	INDEX id_pelicula (id_pelicula) USING BTREE,
	CONSTRAINT id_pelicula FOREIGN KEY (id_pelicula) REFERENCES pelicula (id) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE boleto (
	id_boleto INT(11) NOT NULL AUTO_INCREMENT,
	cantidad_asientos INT(11) NOT NULL ,
	numero_asientos_boleto VARCHAR(50) NOT NULL,
	id_funcion INT(11) NOT NULL,
	PRIMARY KEY (id_boleto) USING BTREE,
	INDEX id_funcion (id_funcion) USING BTREE,
	CONSTRAINT id_funcion FOREIGN KEY (id_funcion) REFERENCES funcion (id_funcion) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE factura (
	id_factura INT(11) NOT NULL AUTO_INCREMENT,
	id_boleto INT(11) NOT NULL,
	id_cliente INT(11) NOT NULL,
	fecha_factura TIMESTAMP NOT NULL,
	estado_factura VARCHAR(50) NOT NULL COLLATE 'utf8mb4_general_ci',
	valor_boletos_factura DECIMAL(20,3) NOT NULL,
	valor_descuento_factura DECIMAL(15,3) NOT NULL,
	valor_total DECIMAL(20,3) NOT NULL,
	PRIMARY KEY (id_factura) USING BTREE,
	INDEX id_boleto (id_boleto) USING BTREE,
	INDEX id_cliente (id_cliente) USING BTREE,
	CONSTRAINT id_boleto FOREIGN KEY (id_boleto) REFERENCES boleto (id_boleto) ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT id_cliente FOREIGN KEY (id_cliente) REFERENCES cliente (id_cliente) ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE pago (
    id_pago INT(11) NOT NULL AUTO_INCREMENT,
	id_factura INT(11) NOT NULL,
	valor_a_pagar INT(11) NOT NULL,
	devuelta INT(11) NOT NULL,
	PRIMARY KEY (id_pago) USING BTREE,
	INDEX id_factura (id_factura) USING BTREE,
	CONSTRAINT id_factura FOREIGN KEY (id_factura) REFERENCES factura (id_factura) ON UPDATE NO ACTION ON DELETE NO ACTION
);
