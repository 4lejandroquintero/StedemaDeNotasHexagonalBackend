CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    username VARCHAR(50) UNIQUE,
    password VARCHAR(50),
    nombre VARCHAR(100) ,
    apellido VARCHAR(255) ,
    email VARCHAR(255) UNIQUE,
    telefono VARCHAR(255),
    enabled BOOLEAN,
    rol VARCHAR(50)
);

CREATE TABLE pregunta (
    preguntaId SERIAL PRIMARY KEY,
    contenido VARCHAR(5000) NOT NULL,
    imagen VARCHAR(255),
    opcion1 VARCHAR(255),
    opcion2 VARCHAR(100),
    opcion3 VARCHAR(100),
    opcion4 VARCHAR(100),
    respuestaDada VARCHAR(100),
    respuesta VARCHAR(100)
);

CREATE TABLE examen (
    examenId SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    puntosMaximo VARCHAR(100) NOT NULL,
    numeroDePreguntas VARCHAR(100) NOT NULL
);

CREATE TABLE categoria (
    categoriaId SERIAL PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    examenId INT NOT NULL,
    FOREIGN KEY (examenId) REFERENCES examen(examenId) ON UPDATE NO ACTION ON DELETE NO ACTION
);

