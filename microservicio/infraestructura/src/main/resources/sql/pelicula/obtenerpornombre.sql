select id, nombre_pelicula, sinopsis_pelicula, imagen_pelicula, categoria_edad_pelicula
from pelicula
where nombre_pelicula = :nombre_pelicula