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

CREATE TABLE categoria (
    id  SERIAL PRIMARY KEY,
            descripcion varchar(255),
            titulo varchar(255)
);

CREATE TABLE examen (
    id  SERIAL PRIMARY KEY,
            categoriaId int8,
            titulo varchar(255),
            descripcion varchar(255),
            puntos_maximos varchar(255),
            numero_de_preguntas varchar(255),
            activo boolean not null


          );

CREATE TABLE pregunta (
    id  SERIAL PRIMARY KEY,
    contenido varchar(5000),
    imagen varchar(255),
    opcion1 varchar(255),
    opcion2 varchar(255),
    opcion3 varchar(255),
    opcion4 varchar(255),
    respuesta varchar(255),
    examenId int8
);

alter table examen
       add constraint FK9e3vkr595xf5ntcw0ih72lifw
       foreign key (categoriaId)
       references categoria;

alter table pregunta
       add constraint FK9g0sx7pv0vsvc4uksis4egp4j
       foreign key (examenId)
       references examen;