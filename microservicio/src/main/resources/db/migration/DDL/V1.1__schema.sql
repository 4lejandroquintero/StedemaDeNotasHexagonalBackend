CREATE TABLE cliente (
	id INT(11) NOT NULL AUTO_INCREMENT,
	nombre_cliente VARCHAR(50) NOT NULL ,
	apellido_cliente VARCHAR(50) ,
	email_cliente VARCHAR(100) NOT NULL ,
	contrasena_cliente VARCHAR(255) NOT NULL ,
	documento_identidad_cliente CHAR(15) ,
	numero_telefonico_cliente VARCHAR(255)  ,
	fecha_nacimiento_cliente DATE,
	membresia_cliente VARCHAR(50) NOT NULL ,
	esta_activo_cliente TINYINT(1),
	PRIMARY KEY (id),
	UNIQUE INDEX documento_identidad (documento_identidad_cliente),
	UNIQUE INDEX email (email_cliente)
);
CREATE TABLE pelicula (
	id INT(11) NOT NULL AUTO_INCREMENT,
	nombre_pelicula VARCHAR(100) NOT NULL ,
	sinopsis_pelicula VARCHAR(255) NULL   ,
	imagen_pelicula VARCHAR(255) NULL   ,
	categoria_edad_pelicula VARCHAR(100) NULL  ,
	PRIMARY KEY (id),
	UNIQUE INDEX nombre_pelicula (nombre_pelicula)
);
CREATE TABLE funcion (
	id INT(11) NOT NULL AUTO_INCREMENT,
	id_pelicula INT(11) NOT NULL,
	nombre_teatro_funcion VARCHAR(100) NULL ,
	sala_funcion VARCHAR(100) NOT NULL ,
	hora_funcion TIME NOT NULL,
	dia_funcion DATE NOT NULL,
	categoria_audio_funcion VARCHAR(100) NULL ,
	categoria_subtitulos_funcion VARCHAR(100) NULL,
	categoria_dimension_visual_funcion VARCHAR(100) NULL,
	valor_funcion DECIMAL(20,3) NOT NULL,
	PRIMARY KEY (id)
);
	ALTER TABLE funcion ADD CONSTRAINT id_pelicula FOREIGN KEY (id_pelicula) REFERENCES pelicula (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE TABLE boleto (
	id INT(11) NOT NULL AUTO_INCREMENT,
	cantidad_asientos INT(11) NOT NULL ,
	numero_asientos_boleto VARCHAR(50) NOT NULL,
	id_funcion INT(11) NOT NULL,
	PRIMARY KEY (id)
);
	ALTER TABLE boleto ADD CONSTRAINT id_funcion FOREIGN KEY (id_funcion) REFERENCES funcion (id) ON UPDATE NO ACTION ON DELETE NO ACTION;

CREATE TABLE factura (
	id INT(11) NOT NULL AUTO_INCREMENT,
	id_boleto INT(11) NOT NULL,
	id_cliente INT(11) NOT NULL,
	fecha_factura TIMESTAMP NOT NULL,
	estado_factura VARCHAR(50) NOT NULL ,
	valor_boletos_factura DECIMAL(20,3) NOT NULL,
	valor_descuento_factura DECIMAL(15,3) NOT NULL,
	valor_total DECIMAL(20,3) NOT NULL,
	PRIMARY KEY (id)
);
	ALTER TABLE factura ADD CONSTRAINT id_boleto FOREIGN KEY (id_boleto) REFERENCES boleto (id) ON UPDATE NO ACTION ON DELETE NO ACTION;
    ALTER TABLE factura ADD CONSTRAINT id_cliente FOREIGN KEY (id_cliente) REFERENCES cliente (id) ON UPDATE NO ACTION ON DELETE NO ACTION;


CREATE TABLE pago (
    id INT(11) NOT NULL AUTO_INCREMENT,
	id_factura INT(11) NOT NULL,
	valor_a_pagar INT(11) NOT NULL,
	devuelta INT(11) NOT NULL,
	PRIMARY KEY (id)
);
	ALTER TABLE pago ADD CONSTRAINT id_factura FOREIGN KEY (id_factura) REFERENCES factura (id) ON UPDATE NO ACTION ON DELETE NO ACTION;


