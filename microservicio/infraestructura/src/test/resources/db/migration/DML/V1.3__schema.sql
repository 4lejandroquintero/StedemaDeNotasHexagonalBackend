insert into cliente(id, nombre_cliente, email_cliente,contrasena_cliente, documento_identidad_cliente, membresia_cliente)
values(2, 'Sara', 'sara@mail.com', 'admin','12345', 'RUBY');

insert into pelicula(id, nombre_pelicula, sinopsis_pelicula, imagen_pelicula, categoria_edad_pelicula)
values (1, 'Avengers: Infinity war', 'Pelicula de superheroes','urlImagen','+13');

insert into funcion(id, id_pelicula, nombre_teatro_funcion, sala_funcion, dia_funcion, hora_funcion, valor_funcion, categoria_audio_funcion, categoria_subtitulos_funcion, categoria_dimension_visual_funcion)
values (2, 1, 'Cinemark', 'Sala #2', '2023-06-15', '08:30:00',15000,'Doblaje Latino', 'Sin Subtitulos', '2D');

insert into boleto(id, cantidad_asientos, numero_asientos_boleto, id_funcion)
values (2, 3, 'A1,A2,A3', 2);

insert into factura(id ,id_boleto, id_cliente, fecha_factura, estado_factura, valor_boletos_factura,valor_descuento_factura, valor_total)
values(2, 2, 2, '2023-07-16','PENDIENTE', 45000, 15750, 29250);

insert into pago(id_factura, valor_a_pagar, devuelta) values (2, 30000, 750);