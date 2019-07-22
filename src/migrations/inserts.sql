USE RioCuartoViaja;

insert into empleados (dni,nombre,apellido,loc_origen,telefono,pass) values	(40297574, "Juan", "Lopez", "Sampacho","35815402665",1234);
insert into empleados (dni,nombre,apellido,loc_origen,telefono,pass) values	(39888000, "Pedro", "Gomez", "Bulnes","358215436220",1111);
insert into empleados (dni,nombre,apellido,loc_origen,telefono,pass) values	(35603438, "Laura", "Fernandez", "Rio Cuarto","35815440555",1234);
insert into empleados (dni,nombre,apellido,loc_origen,telefono,pass) values	(30697345, "Sofia", "Martinez", "San Basilio","35815505223",1234);
insert into empleados (dni,nombre,apellido,loc_origen,telefono,pass) values	(37875800, "Esteban", "Cuesta", "Rio Cuarto","3582436225",1234);
insert into empleados (dni,nombre,apellido,loc_origen,telefono,pass) values	(37875801, "Matias", "Formento", "Mackenna","3584659987",1111);
insert into empleados (dni,nombre,apellido,loc_origen,telefono,pass) values	(31562856, "Lucia", "Moreno", "Coronel Moldes","3581569635",1111);
insert into empleados (dni,nombre,apellido,loc_origen,telefono,pass) values	(29987432, "Camila", "Sosa", "Rio Cuarto","3582465998",1234);
insert into empleados (dni,nombre,apellido,loc_origen,telefono,pass) values	(33498123, "Mariana", "Aguilar", "Rio Cuarto","358556914",1234);	

insert into gerentes (dni,gastos_repres) values (37875801, 3562.60);

insert into administrativos (dni,turno) values (40297574, "mañana");
insert into administrativos (dni,turno) values	(39888000, "tarde");
insert into administrativos (dni,turno) values	(35603438, "mañana");
insert into administrativos (dni,turno) values	(30697345, "tarde");
insert into administrativos (dni,turno) values	(37875800, "tarde");
insert into administrativos (dni,turno) values	(31562856, "mañana");
insert into administrativos (dni,turno) values	(29987432, "mañana");
insert into administrativos (dni,turno) values	(33498123, "tarde");

insert into agrupacion_jubilados(nombre,direccion,telefono) values("NO TIENE","","");
insert into agrupacion_jubilados(nombre,direccion,telefono) values("OTROS","","");
insert into agrupacion_jubilados(nombre,direccion,telefono) values("Abuelos Unidos","Av. Italia 1351","358469665");
insert into agrupacion_jubilados(nombre,direccion,telefono) values("Vivir","Irigoyen 865","358466542");
insert into agrupacion_jubilados(nombre,direccion,telefono) values("Jubilados Felices","San Martin 145","358498969");
insert into agrupacion_jubilados(nombre,direccion,telefono) values("Centro de Jubilados","Buenos Aires 665","358404999");
insert into agrupacion_jubilados(nombre,direccion,telefono) values("Los nonos","Belgrano 345","358405113");

insert into clientes (dni,nombre,apellido,direccion,telefono,nombre_agrupacion) values (21345987, "Kevin", "Salazar", "Constitucion 556","3582404556","Abuelos Unidos");
insert into clientes (dni,nombre,apellido,direccion,telefono,nombre_agrupacion) values (25476234, "Susana", "Messi", "Rivadavia 3669","3582466242","Los nonos");
insert into clientes (dni,nombre,apellido,direccion,telefono,nombre_agrupacion) values (22752405, "Alvaro", "Vidal", "Av. Italia 226","3582403665","Jubilados Felices");
insert into clientes (dni,nombre,apellido,direccion,telefono,nombre_agrupacion) values (15256352, "Hector", "Rodriguez", "Av. Ranqueles 886","3582404556","Los nonos");
insert into clientes (dni,nombre,apellido,direccion,telefono,nombre_agrupacion) values (10225665, "Roberto", "Berardo", "General Paz 2115","358465668","Vivir");
insert into clientes (dni,nombre,apellido,direccion,telefono,nombre_agrupacion) values (52256654, "Fatima", "Flores", "Madrid 255","3584789554","Abuelos Unidos");
insert into clientes (dni,nombre,apellido,direccion,telefono,nombre_agrupacion) values (10226554, "Iris", "Ravetta", "Bolivar 155","3584556332","Centro de Jubilados");
insert into clientes (dni,nombre,apellido,direccion,telefono,nombre_agrupacion) values (16223665, "Carlos", "Perez", "Caseros 641","358404665","Los nonos");
insert into clientes (dni,nombre,apellido,direccion,telefono,nombre_agrupacion) values (18885644, "Alcira", "Ferro", "Alvear 887","3584455856","Centro de Jubilados");
insert into clientes (dni,nombre,apellido,direccion,telefono,nombre_agrupacion) values (14556987, "Felipe", "Garcia", "Cabrera 1698","35844632366","Centro de Jubilados");

insert into ficha_medicas (dni,nombre_enfermedad,es_cronica,nombre_medicamento,frecuencia,medicamento_alergico) values (21345987, "Diabetes", "si","med1","diaria","medAl1");
insert into ficha_medicas (dni,nombre_enfermedad,es_cronica,nombre_medicamento,frecuencia,medicamento_alergico) values (25476234, "Diabetes", "si","med2","semanal","medAl2");
insert into ficha_medicas (dni,nombre_enfermedad,es_cronica,nombre_medicamento,frecuencia,medicamento_alergico) values (22752405, "Diabetes", "si","med3","diaria","medAl3");
insert into ficha_medicas (dni,nombre_enfermedad,es_cronica,nombre_medicamento,frecuencia,medicamento_alergico) values (15256352, "Diabetes", "si","med4","semanal","medAl4");
insert into ficha_medicas (dni,nombre_enfermedad,es_cronica,nombre_medicamento,frecuencia,medicamento_alergico) values (10225665, "Diabetes", "si","med5","diaria","medAl5");
insert into ficha_medicas (dni,nombre_enfermedad,es_cronica,nombre_medicamento,frecuencia,medicamento_alergico) values (52256654, "Diabetes", "si","med6","diaria","medAl6");
insert into ficha_medicas (dni,nombre_enfermedad,es_cronica,nombre_medicamento,frecuencia,medicamento_alergico) values (10226554, "Diabetes", "si","med7","diaria","medAl7");
insert into ficha_medicas (dni,nombre_enfermedad,es_cronica,nombre_medicamento,frecuencia,medicamento_alergico) values (16223665, "Diabetes", "si","med8","diaria","medAl8");
insert into ficha_medicas (dni,nombre_enfermedad,es_cronica,nombre_medicamento,frecuencia,medicamento_alergico) values (18885644, "Diabetes", "si","med9","diaria","medAl9");
insert into ficha_medicas (dni,nombre_enfermedad,es_cronica,nombre_medicamento,frecuencia,medicamento_alergico) values (14556987, "Diabetes", "si","med10","diaria","medAl10");

insert into traslados (id,costo,duracion,distancia) values (NULL,2569.40,16,1300);
insert into traslados (id,costo,duracion,distancia) values (NULL,1799.99,9,723.4);
insert into traslados (id,costo,duracion,distancia) values (NULL,1499.99,8,600);
insert into traslados (id,costo,duracion,distancia) values (NULL,689.65,3,231);
insert into traslados (id,costo,duracion,distancia) values (NULL,2250.80,13,1095);

insert into paquete_turisticos (id,ciudad_destino,id_traslado) values (NULL,"Cataratas del Iguazú",1);
insert into paquete_turisticos (id,ciudad_destino,id_traslado) values (NULL,"Termas de Río Hondo",2);
insert into paquete_turisticos (id,ciudad_destino,id_traslado) values (NULL,"Buenos Aires",3);
insert into paquete_turisticos (id,ciudad_destino,id_traslado) values (NULL,"Villa Carlos Paz",4);
insert into paquete_turisticos (id,ciudad_destino,id_traslado) values (NULL,"Salta",5);

insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,1,"Luna llena","paseo de noche por las cataratas",1300);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,1,"Balsas","paseo el balsas por el rio Iguazu",800);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,1,"Parque Nacional","Visita al Parque Nacional Iguazu",400);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,1,"","",0);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,2,"La Banda","visita a La Banda por puente carretero,museo bicentenario,catedral,mirador las torres",760);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,2,"Isla Del Sol","Visita a la Isla del Sol",300);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,2,"City Tour","paseo guiado por las Termas de Rio Hondo",1300);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,2,"","",0);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,3,"SanIsidro+Tigre+Delta"," Paseo en lancha",0);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,3,"Parque de la costa","Visita la parque de la costa",700);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,3,"Tango","cena y show de tango",1100);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,3,"","",0);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,4,"Teatro","Incluye una noche de teatro",650);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,4,"Catamaran","Paseo por el lago San Roque",800);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,4,"Aerosilla","Subida la cerro en aerosiilla",500);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,4,"","",0);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,5,"Virgen","visita a la virgen del cerro ",600);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,5,"Tren de las Nubes","recorrido en tren con vista a hermosos paisajes",1200);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,5,"Garganta del Diablo","visita a la garganta del diablo cayafate",900);
insert into atraccion_turisticas (id,id_paquete,nombre,descripcion,costo) values (NULL,5,"","",0);

insert into cliente_paquetes (id,dni,id_paquete) values (NULL,21345987, 1);
insert into cliente_paquetes (id,dni,id_paquete) values (NULL,25476234, 1);
insert into cliente_paquetes (id,dni,id_paquete) values (NULL,22752405, 2);
insert into cliente_paquetes (id,dni,id_paquete) values (NULL,15256352, 3);
insert into cliente_paquetes (id,dni,id_paquete) values (NULL,10225665, 4);
insert into cliente_paquetes (id,dni,id_paquete) values (NULL,52256654, 4);
insert into cliente_paquetes (id,dni,id_paquete) values (NULL,10226554, 2);
insert into cliente_paquetes (id,dni,id_paquete) values (NULL,16223665, 5);
insert into cliente_paquetes (id,dni,id_paquete) values (NULL,18885644, 4);
insert into cliente_paquetes (id,dni,id_paquete) values (NULL,14556987, 3);

insert into atraccion_clientes (id,id_cliente_paquete,id_atraccion) values (NULL,1, 1);
insert into atraccion_clientes (id,id_cliente_paquete,id_atraccion) values (NULL,7, 6);
insert into atraccion_clientes (id,id_cliente_paquete,id_atraccion) values (NULL,7, 7);
insert into atraccion_clientes (id,id_cliente_paquete,id_atraccion) values (NULL,7, 8);
insert into atraccion_clientes (id,id_cliente_paquete,id_atraccion) values (NULL,1, 2);
insert into atraccion_clientes (id,id_cliente_paquete,id_atraccion) values (NULL,1, 3);
insert into atraccion_clientes (id,id_cliente_paquete,id_atraccion) values (NULL,3, 5);
insert into atraccion_clientes (id,id_cliente_paquete,id_atraccion) values (NULL,3, 4);
insert into atraccion_clientes (id,id_cliente_paquete,id_atraccion) values (NULL,5, 10);
insert into atraccion_clientes (id,id_cliente_paquete,id_atraccion) values (NULL,5, 11);


insert into efectivos (id_paquete,monto_total_descuento,fecha) values (1,4685.99,"2019-07-26");
insert into efectivos (id_paquete,monto_total_descuento,fecha) values (2,5862.55,"2019-06-25");

insert into plan_cuotas (id_paquete,nro_plan,cant_cuotas,fecha_inc,fecha_fin) values (3,NULL,12,"2019-07-02","2020-07-02");
insert into plan_cuotas (id_paquete,nro_plan,cant_cuotas,fecha_inc,fecha_fin) values (4,NULL,18,"2019-07-06","2021-1-06");
insert into plan_cuotas (id_paquete,nro_plan,cant_cuotas,fecha_inc,fecha_fin) values (5,NULL,6,"2019-06-29","2019-12-29");
insert into plan_cuotas (id_paquete,nro_plan,cant_cuotas,fecha_inc,fecha_fin) values (6,NULL,12,"2019-08-15","2020-08-15");
insert into plan_cuotas (id_paquete,nro_plan,cant_cuotas,fecha_inc,fecha_fin) values (7,NULL,12,"2019-08-11","2020-08-11");

insert into cuotas (nro_plan,monto,fecha,estado) values (1,466.98,"2019-07-11","paga");
insert into cuotas (nro_plan,monto,fecha,estado) values (2,320.50,"2019-08-15","por vencer");
insert into cuotas (nro_plan,monto,fecha,estado) values (3,998.10,"2019-07-06","paga");
insert into cuotas (nro_plan,monto,fecha,estado) values (4,466.98,"2019-05-28","vencida");
insert into cuotas (nro_plan,monto,fecha,estado) values (5,466.98,"2019-06-09","paga");

