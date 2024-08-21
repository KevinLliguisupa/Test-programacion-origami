
CREATE SEQUENCE public.producto_pro_id_seq;

CREATE TABLE public.producto (
                pro_id BIGINT NOT NULL DEFAULT nextval('public.producto_pro_id_seq'),
                nombre VARCHAR NOT NULL,
                descripcion VARCHAR,
                precio NUMERIC(7,2) NOT NULL,
                stock NUMERIC(10,3) NOT NULL,
                estado BOOLEAN NOT NULL,
                CONSTRAINT producto_pk PRIMARY KEY (pro_id)
);


ALTER SEQUENCE public.producto_pro_id_seq OWNED BY public.producto.pro_id;

CREATE SEQUENCE public.cliente_cli_id_seq;

CREATE TABLE public.cliente (
                cli_id BIGINT NOT NULL DEFAULT nextval('public.cliente_cli_id_seq'),
                nombres VARCHAR NOT NULL,
                apellidos VARCHAR NOT NULL,
                cedula VARCHAR(10) NOT NULL,
                direccion VARCHAR,
                telefono VARCHAR,
                email VARCHAR,
                estado BOOLEAN NOT NULL,
                CONSTRAINT cliente_pk PRIMARY KEY (cli_id)
);


ALTER SEQUENCE public.cliente_cli_id_seq OWNED BY public.cliente.cli_id;

CREATE SEQUENCE public.factura_fac_id_seq;

CREATE TABLE public.factura (
                fac_id BIGINT NOT NULL DEFAULT nextval('public.factura_fac_id_seq'),
                cli_id BIGINT NOT NULL,
                numero BIGINT NOT NULL UNIQUE,
                fecha_emision DATE NOT NULL,
                total NUMERIC(7,2) NOT NULL,
                observaciones VARCHAR,
                estado_pago VARCHAR NOT NULL,
                CONSTRAINT factura_pk PRIMARY KEY (fac_id)
);


ALTER SEQUENCE public.factura_fac_id_seq OWNED BY public.factura.fac_id;

CREATE SEQUENCE public.factura_detalle_det_id_seq;

CREATE TABLE public.factura_detalle (
                det_id BIGINT NOT NULL DEFAULT nextval('public.factura_detalle_det_id_seq'),
                fac_id BIGINT NOT NULL,
                pro_id BIGINT NOT NULL,
                cantidad NUMERIC(10,3) NOT NULL,
                precio_unitario NUMERIC(7,2) NOT NULL,
                CONSTRAINT factura_detalle_pk PRIMARY KEY (det_id)
);


ALTER SEQUENCE public.factura_detalle_det_id_seq OWNED BY public.factura_detalle.det_id;

ALTER TABLE public.factura_detalle ADD CONSTRAINT producto_factura_detalle_fk
FOREIGN KEY (pro_id)
REFERENCES public.producto (pro_id)
ON DELETE NO ACTION
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.factura ADD CONSTRAINT cliente_factura_fk
FOREIGN KEY (cli_id)
REFERENCES public.cliente (cli_id)
ON DELETE NO ACTION
ON UPDATE CASCADE
NOT DEFERRABLE;

ALTER TABLE public.factura_detalle ADD CONSTRAINT factura_factura_detalle_fk
FOREIGN KEY (fac_id)
REFERENCES public.factura (fac_id)
ON DELETE NO ACTION
ON UPDATE CASCADE
NOT DEFERRABLE;



------------------- Data --------------------

---------------------------------------------
------------------PRODUCTO-------------------
---------------------------------------------

INSERT INTO producto (nombre, descripcion, precio, stock, estado)
VALUES
('Laptop', 'Laptop Dell Inspiron', 1500.00, 50.000, TRUE),
('Mouse', 'Mouse Inalámbrico Logitech', 25.00, 200.000, TRUE),
('Teclado', 'Teclado Mecánico', 75.00, 150.000, TRUE),
('Monitor', 'Monitor 24 pulgadas Samsung', 300.00, 100.000, TRUE),
('Impresora', 'Impresora Multifuncional HP', 120.00, 80.000, TRUE),
('Cámara', 'Cámara Canon EOS Rebel', 850.00, 40.000, TRUE),
('Auriculares', 'Auriculares Bluetooth Sony', 60.00, 150.000, TRUE),
('Disco Duro', 'Disco Duro Externo 1TB', 90.00, 120.000, TRUE),
('Memoria USB', 'Memoria USB 64GB', 15.00, 300.000, TRUE),
('Tablet', 'Tablet Samsung Galaxy Tab', 350.00, 60.000, TRUE),
('Smartphone', 'Smartphone Xiaomi Mi 10', 700.00, 70.000, TRUE),
('Router', 'Router Wi-Fi TP-Link', 45.00, 90.000, TRUE),
('Silla', 'Silla ergonómica de oficina', 180.00, 30.000, TRUE),
('Escritorio', 'Escritorio para computadora', 250.00, 25.000, TRUE),
('Proyector', 'Proyector Epson', 600.00, 20.000, TRUE);

---------------------------------------------
------------------CLIENTE--------------------
---------------------------------------------

INSERT INTO cliente (nombres, apellidos, cedula, direccion, telefono, email, estado)
VALUES
('Juan', 'Perez', '0145889756', 'Av. Siempre Viva 123', '555-1234', 'juan.perez@example.com', TRUE),
('Maria', 'Gomez', '1758965485', 'Calle Falsa 456', '555-5678', 'maria.gomez@example.com', TRUE),
('Carlos', 'Lopez', '0128965478', 'Boulevard Central 789', '555-9876', 'carlos.lopez@example.com', TRUE),
('Ana', 'Martinez', '1285698430', 'Av. Principal 321', '555-6543', 'ana.martinez@example.com', TRUE),
('Luis', 'Ramirez', '1547896547', 'Calle Secundaria 789', '555-3210', 'luis.ramirez@example.com', TRUE);

---------------------------------------------
------------------FACTURA--------------------
---------------------------------------------

INSERT INTO factura (cli_id, numero, fecha_emision, total, estado_pago)
VALUES
(1, 1001, '2024-08-19', 2500.00, 'Pagado'),
(2, 1002, '2024-08-19', 700.00, 'Pendiente'),
(3, 1003, '2024-08-19', 1450.00, 'Pagado'),
(4, 1004, '2024-08-19', 890.00, 'Pagado'),
(5, 1005, '2024-08-19', 1000.00, 'Pendiente'),
(1, 1006, '2024-08-19', 760.00, 'Pagado'),
(2, 1007, '2024-08-19', 950.00, 'Pendiente'),
(3, 1008, '2024-08-19', 1200.00, 'Pagado'),
(4, 1009, '2024-08-19', 1800.00, 'Pendiente'),
(5, 1010, '2024-08-19', 1100.00, 'Pagado');

---------------------------------------------
--------------FACTURA DETALLE----------------
---------------------------------------------

INSERT INTO factura_detalle (fac_id, pro_id, cantidad, precio_unitario)
VALUES
(1, 1, 1.000, 1500.00),
(1, 2, 2.000, 25.00),
(1, 4, 1.000, 300.00),
(2, 6, 1.000, 850.00),
(2, 8, 2.000, 90.00),
(2, 9, 4.000, 15.00),
(3, 5, 2.000, 120.00),
(3, 7, 3.000, 60.00),
(3, 10, 1.000, 350.00),
(4, 3, 1.000, 75.00),
(4, 11, 1.000, 700.00),
(4, 12, 2.000, 45.00),
(5, 13, 1.000, 180.00),
(5, 14, 1.000, 250.00),
(5, 15, 1.000, 600.00),
(6, 4, 2.000, 300.00),
(6, 6, 1.000, 850.00),
(6, 1, 1.000, 1500.00),
(7, 7, 3.000, 60.00),
(7, 9, 5.000, 15.00),
(7, 14, 2.000, 250.00),
(8, 10, 1.000, 350.00),
(8, 12, 2.000, 45.00),
(8, 15, 1.000, 600.00),
(9, 1, 1.000, 1500.00),
(9, 5, 3.000, 120.00),
(9, 8, 4.000, 90.00),
(10, 2, 2.000, 25.00),
(10, 3, 1.000, 75.00),
(10, 13, 2.000, 180.00),
(10, 15, 1.000, 600.00);