/* Populate tables */
INSERT INTO ventas (id, nombre, detalle, create_at) VALUES(1, 'Primera Venta', 'Detalle 1', '2017-08-28');
INSERT INTO ventas (id, nombre, detalle, create_at) VALUES(2, 'Segunda Venta', 'Detalle 2', '2017-08-28');

INSERT INTO users (id, username, password, enabled) VALUES (1,'maliaga','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',true);

INSERT INTO authorities (id, user_id, authority) VALUES (1, 1,'ROLE_USER');
INSERT INTO authorities (id, user_id, authority) VALUES (2, 1,'ROLE_ADMIN');
