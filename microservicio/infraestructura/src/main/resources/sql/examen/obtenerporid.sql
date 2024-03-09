select examenId, preguntaId, titulo, descripcion, puntosMaximos, numeroDePreguntas, activo
from examen
where examenId = :examenId