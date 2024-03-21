select id, categoriaId, titulo, descripcion, puntos_maximos, numero_de_preguntas, activo
from examen
where id = :id