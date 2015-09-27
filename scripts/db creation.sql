USE [AD_TPO]
GO
/****** Object:  Table [dbo].[Bulto]    Script Date: 14/09/2015 10:13:13 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Bulto](
	[codigo] [varchar](50) NOT NULL,
	[idOVenta] [int] NULL,
	[codigoSKF] [varchar](50) NULL,
 CONSTRAINT [PK_Bulto] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CasaCentral]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CasaCentral](
	[id] [int] NOT NULL,
 CONSTRAINT [PK_CasaCentral] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cliente](
	[codigo] [int] NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[direccion] [varchar](50) NOT NULL,
	[idOVenta] [int] NOT NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ComparativaPrecios]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ComparativaPrecios](
	[idComparativa] [int] NOT NULL,
	[estado] [varchar](50) NOT NULL,
 CONSTRAINT [PK_ComparativaPrecios] PRIMARY KEY CLUSTERED 
(
	[idComparativa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CondCompra]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CondCompra](
	[id] [int] NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
	[porcentaje] [float] NOT NULL,
 CONSTRAINT [PK_CondCompra] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Cotizacion]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cotizacion](
	[id] [int] NOT NULL,
	[estado] [varchar](50) NOT NULL,
	[fecha] [datetime] NOT NULL,
 CONSTRAINT [PK_Cotizacion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Envio]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Envio](
	[codigoCliente] [int] NOT NULL,
	[id] [int] NOT NULL,
	[fecha] [datetime] NOT NULL,
	[idOVenta] [int] NOT NULL,
 CONSTRAINT [PK_Envio] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Factura]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Factura](
	[id] [int] NOT NULL,
	[codigoCliente] [int] NOT NULL,
	[idPedidoVenta] [int] NOT NULL,
 CONSTRAINT [PK_Factura] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FormaPago]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FormaPago](
	[idOVenta] [int] NOT NULL,
	[id] [nchar](10) NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
	[porcentaje] [float] NOT NULL,
	[cuotas] [int] NOT NULL,
	[dias] [int] NOT NULL,
	[activa] [bit] NOT NULL,
 CONSTRAINT [PK_FormaPago] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ItemCotizacion]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ItemCotizacion](
	[id] [int] NOT NULL,
	[idCotizacion] [int] NOT NULL,
	[cantidad] [int] NOT NULL,
	[codigoSKF] [varchar](50) NOT NULL,
 CONSTRAINT [PK_ItemCotizacion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ItemEnvio]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ItemEnvio](
	[id] [int] NOT NULL,
	[idEnvio] [int] NOT NULL,
	[codigoSKF] [varchar](50) NOT NULL,
	[cantidad] [int] NOT NULL,
 CONSTRAINT [PK_ItemEnvio] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ItemOCProveedor]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ItemOCProveedor](
	[id] [int] NOT NULL,
	[idOCProveedor] [int] NOT NULL,
	[codigoSKF] [varchar](50) NOT NULL,
	[cantidad] [int] NOT NULL,
 CONSTRAINT [PK_ItemOCProveedor] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ItemPedVenta]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ItemPedVenta](
	[id] [int] NOT NULL,
	[idPedidoVenta] [int] NOT NULL,
 CONSTRAINT [PK_ItemPedVenta] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ItemPrecios]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ItemPrecios](
	[idComparativa] [int] NOT NULL,
	[codigoSKF] [varchar](50) NOT NULL,
	[codRodProv] [varchar](50) NOT NULL,
	[precio] [float] NOT NULL,
	[id] [int] NOT NULL,
 CONSTRAINT [PK_ItemPrecios] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ItemProveedor]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ItemProveedor](
	[codigo] [varchar](50) NOT NULL,
	[precio] [float] NOT NULL,
	[condiciones] [varchar](50) NOT NULL,
	[disponible] [bit] NOT NULL,
	[codigoProveedor] [int] NOT NULL,
	[codigoSKF] [varchar](50) NOT NULL,
 CONSTRAINT [PK_ItemProveedor] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ItemRemito]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ItemRemito](
	[codigoSKF] [varchar](50) NOT NULL,
	[cantidad] [int] NOT NULL,
	[idIRemito] [int] NOT NULL,
 CONSTRAINT [PK_ItemRemito] PRIMARY KEY CLUSTERED 
(
	[codigoSKF] ASC,
	[idIRemito] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCProveedor]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OCProveedor](
	[id] [int] NOT NULL,
	[codigoProveedor] [int] NOT NULL,
	[idCondCompra] [int] NOT NULL,
 CONSTRAINT [PK_OCProveedor] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OVenta]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OVenta](
	[id] [int] NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[direccion] [varchar](50) NOT NULL,
 CONSTRAINT [PK_OVenta] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[PedidoVenta]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PedidoVenta](
	[id] [int] NOT NULL,
	[idCotizacion] [int] NOT NULL,
 CONSTRAINT [PK_PedidoVenta] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Proveedor]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Proveedor](
	[codigoProveedor] [int] NOT NULL,
	[direccion] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Proveedor] PRIMARY KEY CLUSTERED 
(
	[codigoProveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Remito]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Remito](
	[fecha] [datetime] NOT NULL,
	[id] [int] NOT NULL,
	[idOVenta] [int] NOT NULL,
 CONSTRAINT [PK_Remito] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Rodamiento]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Rodamiento](
	[codigoSKF] [varchar](50) NOT NULL,
	[tipo] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Rodamiento] PRIMARY KEY CLUSTERED 
(
	[codigoSKF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Stock]    Script Date: 14/09/2015 10:13:15 p.m. ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Stock](
	[codigoSKF] [varchar](50) NOT NULL,
	[cantidad] [int] NOT NULL,
	[precio] [float] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Bulto]  WITH CHECK ADD  CONSTRAINT [FK_Bulto_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
ALTER TABLE [dbo].[Bulto] CHECK CONSTRAINT [FK_Bulto_OVenta]
GO
ALTER TABLE [dbo].[Bulto]  WITH CHECK ADD  CONSTRAINT [FK_Bulto_Rodamiento] FOREIGN KEY([codigoSKF])
REFERENCES [dbo].[Rodamiento] ([codigoSKF])
GO
ALTER TABLE [dbo].[Bulto] CHECK CONSTRAINT [FK_Bulto_Rodamiento]
GO
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_Cliente_OVenta]
GO
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD  CONSTRAINT [FK_Envio_Cliente] FOREIGN KEY([codigoCliente])
REFERENCES [dbo].[Cliente] ([codigo])
GO
ALTER TABLE [dbo].[Envio] CHECK CONSTRAINT [FK_Envio_Cliente]
GO
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD  CONSTRAINT [FK_Envio_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
ALTER TABLE [dbo].[Envio] CHECK CONSTRAINT [FK_Envio_OVenta]
GO
ALTER TABLE [dbo].[Factura]  WITH CHECK ADD  CONSTRAINT [FK_Factura_Cliente] FOREIGN KEY([codigoCliente])
REFERENCES [dbo].[Cliente] ([codigo])
GO
ALTER TABLE [dbo].[Factura] CHECK CONSTRAINT [FK_Factura_Cliente]
GO
ALTER TABLE [dbo].[Factura]  WITH CHECK ADD  CONSTRAINT [FK_Factura_PedidoVenta] FOREIGN KEY([idPedidoVenta])
REFERENCES [dbo].[PedidoVenta] ([id])
GO
ALTER TABLE [dbo].[Factura] CHECK CONSTRAINT [FK_Factura_PedidoVenta]
GO
ALTER TABLE [dbo].[FormaPago]  WITH CHECK ADD  CONSTRAINT [FK_FormaPago_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
ALTER TABLE [dbo].[FormaPago] CHECK CONSTRAINT [FK_FormaPago_OVenta]
GO
ALTER TABLE [dbo].[ItemCotizacion]  WITH CHECK ADD  CONSTRAINT [FK_ItemCotizacion_Cotizacion] FOREIGN KEY([idCotizacion])
REFERENCES [dbo].[Cotizacion] ([id])
GO
ALTER TABLE [dbo].[ItemCotizacion] CHECK CONSTRAINT [FK_ItemCotizacion_Cotizacion]
GO
ALTER TABLE [dbo].[ItemCotizacion]  WITH CHECK ADD  CONSTRAINT [FK_ItemCotizacion_Rodamiento] FOREIGN KEY([codigoSKF])
REFERENCES [dbo].[Rodamiento] ([codigoSKF])
GO
ALTER TABLE [dbo].[ItemCotizacion] CHECK CONSTRAINT [FK_ItemCotizacion_Rodamiento]
GO
ALTER TABLE [dbo].[ItemEnvio]  WITH CHECK ADD  CONSTRAINT [FK_ItemEnvio_Envio] FOREIGN KEY([idEnvio])
REFERENCES [dbo].[Envio] ([id])
GO
ALTER TABLE [dbo].[ItemEnvio] CHECK CONSTRAINT [FK_ItemEnvio_Envio]
GO
ALTER TABLE [dbo].[ItemEnvio]  WITH CHECK ADD  CONSTRAINT [FK_ItemEnvio_Rodamiento] FOREIGN KEY([codigoSKF])
REFERENCES [dbo].[Rodamiento] ([codigoSKF])
GO
ALTER TABLE [dbo].[ItemEnvio] CHECK CONSTRAINT [FK_ItemEnvio_Rodamiento]
GO
ALTER TABLE [dbo].[ItemOCProveedor]  WITH CHECK ADD  CONSTRAINT [FK_ItemOCProveedor_OCProveedor] FOREIGN KEY([idOCProveedor])
REFERENCES [dbo].[OCProveedor] ([id])
GO
ALTER TABLE [dbo].[ItemOCProveedor] CHECK CONSTRAINT [FK_ItemOCProveedor_OCProveedor]
GO
ALTER TABLE [dbo].[ItemOCProveedor]  WITH CHECK ADD  CONSTRAINT [FK_ItemOCProveedor_Rodamiento] FOREIGN KEY([codigoSKF])
REFERENCES [dbo].[Rodamiento] ([codigoSKF])
GO
ALTER TABLE [dbo].[ItemOCProveedor] CHECK CONSTRAINT [FK_ItemOCProveedor_Rodamiento]
GO
ALTER TABLE [dbo].[ItemPedVenta]  WITH CHECK ADD  CONSTRAINT [FK_ItemPedVenta_PedidoVenta] FOREIGN KEY([idPedidoVenta])
REFERENCES [dbo].[PedidoVenta] ([id])
GO
ALTER TABLE [dbo].[ItemPedVenta] CHECK CONSTRAINT [FK_ItemPedVenta_PedidoVenta]
GO
ALTER TABLE [dbo].[ItemPrecios]  WITH CHECK ADD  CONSTRAINT [FK_ItemPrecios_ComparativaPrecios] FOREIGN KEY([idComparativa])
REFERENCES [dbo].[ComparativaPrecios] ([idComparativa])
GO
ALTER TABLE [dbo].[ItemPrecios] CHECK CONSTRAINT [FK_ItemPrecios_ComparativaPrecios]
GO
ALTER TABLE [dbo].[ItemPrecios]  WITH CHECK ADD  CONSTRAINT [FK_ItemPrecios_ItemProveedor] FOREIGN KEY([codRodProv])
REFERENCES [dbo].[ItemProveedor] ([codigo])
GO
ALTER TABLE [dbo].[ItemPrecios] CHECK CONSTRAINT [FK_ItemPrecios_ItemProveedor]
GO
ALTER TABLE [dbo].[ItemPrecios]  WITH CHECK ADD  CONSTRAINT [FK_ItemPrecios_Rodamiento] FOREIGN KEY([codigoSKF])
REFERENCES [dbo].[Rodamiento] ([codigoSKF])
GO
ALTER TABLE [dbo].[ItemPrecios] CHECK CONSTRAINT [FK_ItemPrecios_Rodamiento]
GO
ALTER TABLE [dbo].[ItemProveedor]  WITH CHECK ADD  CONSTRAINT [FK_ItemProveedor_Proveedor] FOREIGN KEY([codigoProveedor])
REFERENCES [dbo].[Proveedor] ([codigoProveedor])
GO
ALTER TABLE [dbo].[ItemProveedor] CHECK CONSTRAINT [FK_ItemProveedor_Proveedor]
GO
ALTER TABLE [dbo].[ItemProveedor]  WITH CHECK ADD  CONSTRAINT [FK_ItemProveedor_Rodamiento] FOREIGN KEY([codigoSKF])
REFERENCES [dbo].[Rodamiento] ([codigoSKF])
GO
ALTER TABLE [dbo].[ItemProveedor] CHECK CONSTRAINT [FK_ItemProveedor_Rodamiento]
GO
ALTER TABLE [dbo].[ItemRemito]  WITH CHECK ADD  CONSTRAINT [FK_ItemRemito_Remito] FOREIGN KEY([idIRemito])
REFERENCES [dbo].[Remito] ([id])
GO
ALTER TABLE [dbo].[ItemRemito] CHECK CONSTRAINT [FK_ItemRemito_Remito]
GO
ALTER TABLE [dbo].[ItemRemito]  WITH CHECK ADD  CONSTRAINT [FK_ItemRemito_Rodamiento] FOREIGN KEY([codigoSKF])
REFERENCES [dbo].[Rodamiento] ([codigoSKF])
GO
ALTER TABLE [dbo].[ItemRemito] CHECK CONSTRAINT [FK_ItemRemito_Rodamiento]
GO
ALTER TABLE [dbo].[OCProveedor]  WITH CHECK ADD  CONSTRAINT [FK_OCProveedor_CondCompra] FOREIGN KEY([idCondCompra])
REFERENCES [dbo].[CondCompra] ([id])
GO
ALTER TABLE [dbo].[OCProveedor] CHECK CONSTRAINT [FK_OCProveedor_CondCompra]
GO
ALTER TABLE [dbo].[OCProveedor]  WITH CHECK ADD  CONSTRAINT [FK_OCProveedor_Proveedor] FOREIGN KEY([codigoProveedor])
REFERENCES [dbo].[Proveedor] ([codigoProveedor])
GO
ALTER TABLE [dbo].[OCProveedor] CHECK CONSTRAINT [FK_OCProveedor_Proveedor]
GO
ALTER TABLE [dbo].[PedidoVenta]  WITH CHECK ADD  CONSTRAINT [FK_PedidoVenta_Cotizacion] FOREIGN KEY([idCotizacion])
REFERENCES [dbo].[Cotizacion] ([id])
GO
ALTER TABLE [dbo].[PedidoVenta] CHECK CONSTRAINT [FK_PedidoVenta_Cotizacion]
GO
ALTER TABLE [dbo].[Remito]  WITH CHECK ADD  CONSTRAINT [FK_Remito_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
ALTER TABLE [dbo].[Remito] CHECK CONSTRAINT [FK_Remito_OVenta]
GO
ALTER TABLE [dbo].[Stock]  WITH CHECK ADD  CONSTRAINT [FK_Stock_Rodamiento] FOREIGN KEY([codigoSKF])
REFERENCES [dbo].[Rodamiento] ([codigoSKF])
GO
ALTER TABLE [dbo].[Stock] CHECK CONSTRAINT [FK_Stock_Rodamiento]
GO
