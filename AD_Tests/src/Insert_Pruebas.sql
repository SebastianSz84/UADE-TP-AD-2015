INSERT INTO [UADE-TP-AD-2015].[dbo].[Rodamiento] ([codigoSKF],[tipo]) VALUES ('ABC1','Tipo1')
INSERT INTO [UADE-TP-AD-2015].[dbo].[Rodamiento] ([codigoSKF],[tipo]) VALUES ('DEF2','Tipo2')

INSERT INTO [UADE-TP-AD-2015].[dbo].[OVenta] ([nombre],[direccion]) VALUES ('OVenta 1','Calle Falsa 123')
INSERT INTO [UADE-TP-AD-2015].[dbo].[OVenta] ([nombre],[direccion]) VALUES ('OVenta 2','Calle Falsa 456')

INSERT INTO [UADE-TP-AD-2015].[dbo].[Cliente] ([nombre],[direccion],[idOVenta]) VALUES ('Cliente I','Av. Siempre Viva 123','1')
INSERT INTO [UADE-TP-AD-2015].[dbo].[Cliente] ([nombre],[direccion],[idOVenta]) VALUES ('Cliente II','Del Bosque Norte 145','2')

INSERT INTO [UADE-TP-AD-2015].[dbo].[Rodamiento] ([codigoSKF],[tipo]) VALUES ('CodigoSKF1','Rod1')
INSERT INTO [UADE-TP-AD-2015].[dbo].[Rodamiento] ([codigoSKF],[tipo]) VALUES ('CodigoSKF2','Rod2')

INSERT INTO [UADE-TP-AD-2015].[dbo].[Proveedor] ([direccion]) VALUES ('Calle Prov 1')
INSERT INTO [UADE-TP-AD-2015].[dbo].[Proveedor] ([direccion]) VALUES ('Calle Prov 2')

INSERT INTO [UADE-TP-AD-2015].[dbo].[ItemProveedor] ([codigo],[precio],[condiciones],[disponible],[codigoProveedor],[codigoSKF])
     VALUES ('ABCD1','100.00','Descuento 10% comprando más de 100 unidades','1','1','CodigoSKF1')
INSERT INTO [UADE-TP-AD-2015].[dbo].[ItemProveedor] ([codigo],[precio],[condiciones],[disponible],[codigoProveedor],[codigoSKF])
     VALUES ('ABCD2','160.00','N/A','1','1','CodigoSKF2')

INSERT INTO [UADE-TP-AD-2015].[dbo].[ComparativaPrecios] ([fecha]) VALUES ('20151126')

INSERT INTO [UADE-TP-AD-2015].[dbo].[ItemsComparativa] ([id],[codigoItemProveedor]) VALUES ('1','ABCD1')
INSERT INTO [UADE-TP-AD-2015].[dbo].[ItemsComparativa] ([id],[codigoItemProveedor]) VALUES ('1','ABCD2')