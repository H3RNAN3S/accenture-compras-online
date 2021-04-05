insert into clientes(id, nombre, apellido, cedula, direccion, creado_en) values (2, 'Hernan', 'Machuca', '12345', '11# 14-08', now());
insert into clientes(id, nombre, apellido, cedula, direccion, creado_en) values (1, 'Alvaro', 'Santacruz', '3456678', 'Obere Str. 57', now());
insert into clientes(id, nombre, apellido, cedula, direccion, creado_en) values (3, 'Jesus', 'Perea', '797382792', 'Avda. de la Constitución 2222', now());
insert into clientes(id, nombre, apellido, cedula, direccion, creado_en) values (4, 'Orlando', 'Montes', '78278974', 'Mataderos 2312', now());
insert into clientes(id, nombre, apellido, cedula, direccion, creado_en) values (5, 'Brulindo', 'Dias', '7982787', '120 Hanover Sq.', now());
insert into clientes(id, nombre, apellido, cedula, direccion, creado_en) values (6, 'Casimiro', 'Rodrigues', '34325428908', 'Berguvsvägen 8', now());


insert into pedidos(costo_pedido, fecha_pedido, servicio_domicilio, cliente_id) values (120000, '2021-04-04 18:12:38.000000', 25000, 2);
insert into pedidos(costo_pedido, fecha_pedido, servicio_domicilio, cliente_id) values (120000, '2021-04-04 06:12:38.000000', 25000, 1);


insert into productos(id, porcenta_iva, nombre_producto, precio) values (1, 8.0, 'Keyboard', 23000.0);
insert into productos(id, porcenta_iva, nombre_producto, precio) values (2, 10.0, 'Mouse', 23000.0);
insert into productos(id, porcenta_iva, nombre_producto, precio) values (3, 11.0, 'Screen', 600000.0);
insert into productos(id, porcenta_iva, nombre_producto, precio) values (4, 15.0, 'laptop', 2523000.0);
insert into productos(id, porcenta_iva, nombre_producto, precio) values (5, 7.0, 'charger', 15000.0);
insert into productos(id, porcenta_iva, nombre_producto, precio) values (6, 4.0, 'notebook', 6000.0);
insert into productos(id, porcenta_iva, nombre_producto, precio) values (7, 13.0, 'Keyboard Azus', 38000.0);


insert into facturas(id, cantidad, producto_id, pedido_id) values (1, 1, 2, 1);
insert into facturas(id, cantidad, producto_id, pedido_id) values (2, 2, 1, 1);
insert into facturas(id, cantidad, producto_id, pedido_id) values (3, 3, 6, 1);
insert into facturas(id, cantidad, producto_id, pedido_id) values (4, 1, 5, 1);

insert into facturas(id, cantidad, producto_id, pedido_id) values (5, 2, 6, 2);
insert into facturas(id, cantidad, producto_id, pedido_id) values (6, 1, 5, 2);



