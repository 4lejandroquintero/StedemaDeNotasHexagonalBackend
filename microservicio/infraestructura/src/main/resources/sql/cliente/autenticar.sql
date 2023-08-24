select id, nombre_cliente, email_cliente, contrasena_cliente, documento_identidad_cliente, membresia_cliente from cliente
where email_cliente = :email_cliente