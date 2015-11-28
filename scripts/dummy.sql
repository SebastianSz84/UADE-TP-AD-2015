USE [UADE-TP-AD-2015]
GO

INSERT INTO OVenta VALUES ('Oficina de Venta 1', 'Direccion Oficina de Venta 1')
INSERT INTO OVenta VALUES ('Oficina de Venta 2', 'Direccion Oficina de Venta 2')
INSERT INTO [ComparativaPrecios] VALUES (getdate())
INSERT INTO [dbo].[CondCompra] VALUES ('Condicion1', 15)
INSERT INTO [dbo].[CondCompra] VALUES ('Condicion2', 5)
INSERT INTO [dbo].[CondCompra] VALUES ('Condicion3', 25)
INSERT INTO [dbo].[CondCompra] VALUES ('Condicion4', 10)
INSERT INTO [dbo].[Rodamiento] VALUES ('SKF001', 'TipoRodamiento1', 10, 100)
INSERT INTO [dbo].[Rodamiento] VALUES ('SKF002', 'TipoRodamiento2', 3, 50)
INSERT INTO [dbo].[Rodamiento] VALUES ('SKF003', 'TipoRodamiento3', 8, 80)
INSERT INTO [dbo].[Rodamiento] VALUES ('SKF004', 'TipoRodamiento4', 3, 120)
INSERT INTO [dbo].[Rodamiento] VALUES ('SKF005', 'TipoRodamiento5', 5, 200)
INSERT INTO [dbo].[Rodamiento] VALUES ('SKF006', 'TipoRodamiento6', 0, 0)
INSERT INTO [dbo].[Rodamiento] VALUES ('SKF007', 'TipoRodamiento7', 0, 0)
INSERT INTO [dbo].[Rodamiento] VALUES ('SKF008', 'TipoRodamiento8', 0, 0)
INSERT INTO [dbo].[Rodamiento] VALUES ('SKF009', 'TipoRodamiento9', 0, 0)
INSERT INTO [dbo].[Rodamiento] VALUES ('SKF010', 'TipoRodamiento10', 0, 0)

INSERT INTO [dbo].[Proveedor] VALUES ('Proveedor A', 'Direccion Proveedor 1')
INSERT INTO [dbo].[Proveedor] VALUES ('Proveedor B', 'Direccion Proveedor 2')
INSERT INTO [dbo].[Proveedor] VALUES ('Proveedor C', 'Direccion Proveedor 3')
INSERT INTO [dbo].[Proveedor] VALUES ('Proveedor D', 'Direccion Proveedor 4')
INSERT INTO [dbo].[ItemProveedor] VALUES ('1','ABCD1','100.00','Descuento 10% comprando más de 100 unidades','1','SKF001')
INSERT INTO [dbo].[ItemProveedor] VALUES ('1','ABCD2','160.00','N/A','1','SKF002')
INSERT INTO [dbo].[ItemProveedor] VALUES ('2','EFGH1','110.00','Descuento 15% comprando más de 50 unidades','1','SKF001')
INSERT INTO [dbo].[ItemProveedor] VALUES ('2','EFGH2','150.00','N/A','1','SKF002')
INSERT INTO [dbo].[ItemsComparativa] VALUES (1, 'SKF001',1)
INSERT INTO [dbo].[ItemsComparativa] VALUES (1, 'SKF002',4)

GO

INSERT INTO CLIENTE VALUES('Veronica Fernandez', 'Diagonal Norte 777', 1)
INSERT INTO CLIENTE VALUES('Gabriel Cava', 'Gurruchaga 410', 1)
INSERT INTO CLIENTE VALUES('Gustavo Yauny', 'Uruguay 1834', 2)
INSERT INTO CLIENTE VALUES('Sebastian Szarfsztejn', 'Cordoba 400', 2)
INSERT INTO CLIENTE VALUES('Leonardo Esmoris', 'Lima 713', 1)
insert into [dbo].[Cotizacion] VALUES ('Pendiente', getdate(), 1)
insert into [dbo].[Cotizacion] VALUES ('Armada', getdate(), 2)
insert into [dbo].[Cotizacion] VALUES ('Aceptada', getdate(), 3)
insert into [dbo].[Cotizacion] VALUES ('Rechazada', getdate(), 4)
INSERT INTO Bultos VALUES(1)
INSERT INTO Bultos VALUES(1)
INSERT INTO Bultos VALUES(1)
INSERT INTO Bultos VALUES(1)
INSERT INTO Bultos VALUES(2)
INSERT INTO Bultos VALUES(2)
INSERT INTO Bultos VALUES(2)
INSERT INTO Bultos VALUES(2)
insert into [dbo].[Envio] VALUES (1, getdate(), 1) 
insert into [dbo].[Envio] VALUES (2, getdate(), 1) 
insert into [dbo].[Envio] VALUES (4, getdate(), 2) 
INSERT INTO [dbo].[FormaPago] VALUES (1, 'Credito', 5, 12, 25, 1)
INSERT INTO [dbo].[FormaPago] VALUES (2, 'Credito', 7, 12, 31, 1)
INSERT INTO [dbo].[FormaPago] VALUES (1, 'Efectivo', 25, 0, 25, 1)
INSERT INTO [dbo].[FormaPago] VALUES (1, 'Efectivo', 35, 0, 12, 0)
INSERT INTO [dbo].[FormaPago] VALUES (2, 'Debito', 10, 0, 31, 1)
insert into dbo.Remito VALUES (getdate(), 1)
insert into dbo.Remito VALUES (getdate(), 1)
insert into dbo.Remito VALUES (getdate(), 1)
insert into dbo.Remito VALUES (getdate(), 1)
insert into dbo.Remito VALUES (getdate(), 2)
insert into dbo.Remito VALUES (getdate(), 2)
insert into dbo.Remito VALUES (getdate(), 2)
insert into dbo.Remito VALUES (getdate(), 2)

GO

INSERT INTO [dbo].[ItemBultos] values (1, 'SKF001', 10)
INSERT INTO [dbo].[ItemBultos] values (1, 'SKF002', 5)
INSERT INTO [dbo].[ItemBultos] values (1, 'SKF003', 2)
INSERT INTO [dbo].[ItemBultos] values (2, 'SKF004', 10)
INSERT INTO [dbo].[ItemBultos] values (2, 'SKF005', 10)
INSERT INTO [dbo].[ItemBultos] values (2, 'SKF006', 10)
INSERT INTO [dbo].[ItemBultos] values (3, 'SKF001', 10)
INSERT INTO [dbo].[ItemBultos] values (3, 'SKF002', 5)
INSERT INTO [dbo].[ItemBultos] values (3, 'SKF003', 2)
INSERT INTO [dbo].[ItemBultos] values (3, 'SKF004', 10)
INSERT INTO [dbo].[ItemBultos] values (3, 'SKF005', 10)
INSERT INTO [dbo].[ItemBultos] values (3, 'SKF006', 10)
INSERT INTO [dbo].[ItemCotizacion] VALUES (1, 'SKF001', 10, null, 0)
INSERT INTO [dbo].[ItemCotizacion] VALUES (1, 'SKF002', 4, null, 0)
INSERT INTO [dbo].[ItemCotizacion] VALUES (2, 'SKF001', 12, 1, 1)
INSERT INTO [dbo].[ItemCotizacion] VALUES (2, 'SKF002', 18, 4, 1)
INSERT INTO [dbo].[ItemCotizacion] VALUES (3, 'SKF001', 20, 1, 1)
INSERT INTO [dbo].[ItemCotizacion] VALUES (3, 'SKF002', 100, 4, 1)
INSERT INTO [dbo].[ItemCotizacion] VALUES (4, 'SKF001', 5, 1, 1)
INSERT INTO [dbo].[ItemCotizacion] VALUES (4, 'SKF002', 7, 4, 1)
INSERT INTO [dbo].[ItemEnvio] VALUES (1, 1, 'SKF001', 10)
INSERT INTO [dbo].[ItemEnvio] VALUES (2, 1, 'SKF002', 5)
INSERT INTO [dbo].[ItemEnvio] VALUES (3, 1, 'SKF003', 10)
INSERT INTO [dbo].[ItemEnvio] VALUES (4, 1, 'SKF001', 10)
INSERT INTO [dbo].[ItemEnvio] VALUES (5, 2, 'SKF002', 5)
INSERT INTO [dbo].[ItemEnvio] VALUES (6, 2, 'SKF003', 10)
INSERT INTO [dbo].[ItemEnvio] VALUES (7, 3, 'SKF001', 10)
INSERT INTO [dbo].[ItemEnvio] VALUES (8, 3, 'SKF002', 5)
INSERT INTO [dbo].[ItemEnvio] VALUES (9, 3, 'SKF003', 10)
INSERT INTO [dbo].[OCProveedor] VALUES (1, 1, 1)
INSERT INTO [dbo].[OCProveedor] VALUES (2, 1, 2)
INSERT INTO [dbo].[OCProveedor] VALUES (3, 2, 1)
INSERT INTO [dbo].[OCProveedor] VALUES (4, 2, 3)
INSERT INTO [dbo].[OCProveedor] VALUES (5, 2, 4)
INSERT INTO Clientes_Formas VALUES (1,1)
INSERT INTO Clientes_Formas VALUES (1,2)
INSERT INTO Clientes_Formas VALUES (2,1)
INSERT INTO Clientes_Formas VALUES (2,4)
INSERT INTO Clientes_Formas VALUES (3,5)
INSERT INTO Clientes_Formas VALUES (1,4)

GO

INSERT INTO dbo.PedidoVenta VALUES (6,3)
INSERT INTO dbo.PedidoVenta VALUES (1,1)
INSERT INTO dbo.PedidoVenta VALUES (2,1)
INSERT INTO dbo.PedidoVenta VALUES (3,2)
INSERT INTO dbo.PedidoVenta VALUES (4,2)
INSERT INTO dbo.PedidoVenta VALUES (5,2)
insert into  [dbo].[ItemOCProveedor] values (1,1,'SKF001',10)
insert into  [dbo].[ItemOCProveedor] values (2,2,'SKF002',10)
insert into  [dbo].[ItemOCProveedor] values (3,2,'SKF003',10)
insert into  [dbo].[ItemOCProveedor] values (4,2,'SKF004',10)
insert into  [dbo].[ItemOCProveedor] values (5,3,'SKF005',10)
insert into  [dbo].[ItemOCProveedor] values (6,3,'SKF001',10)
insert into  [dbo].[ItemOCProveedor] values (7,3,'SKF002',10)
insert into  [dbo].[ItemOCProveedor] values (8,1,'SKF003',10)
INSERT INTO ItemRemito VALUES ('SKF001', 10, 1)
INSERT INTO ItemRemito VALUES ('SKF002', 2, 2)
INSERT INTO ItemRemito VALUES ('SKF003', 4, 1)
INSERT INTO ItemRemito VALUES ('SKF004', 6, 2)
INSERT INTO ItemRemito VALUES ('SKF001', 8, 1)
INSERT INTO ItemRemito VALUES ('SKF002', 10, 3)
INSERT INTO ItemRemito VALUES ('SKF003', 12, 3)

GO