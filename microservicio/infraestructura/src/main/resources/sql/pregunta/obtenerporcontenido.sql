select preguntaId, contenido, imagen, opcion1, opcion2, opcion3, opcion4, respuestaDada, respuesta
from pregunta
where contenido = :contenido