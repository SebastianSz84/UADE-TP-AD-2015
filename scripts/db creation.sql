USE [master]
GO
/****** Object:  Database [UADE-TP-AD-2015]    Script Date: 09/27/2015 17:29:22 ******/
CREATE DATABASE [UADE-TP-AD-2015] 
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [UADE-TP-AD-2015].[dbo].[sp_fulltext_database] @action = 'disable'
end
GO
ALTER DATABASE [UADE-TP-AD-2015] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET ARITHABORT OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET  ENABLE_BROKER 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET  READ_WRITE 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET RECOVERY FULL 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET  MULTI_USER 
GO
ALTER DATABASE [UADE-TP-AD-2015] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [UADE-TP-AD-2015] SET DB_CHAINING OFF 
GO
USE [UADE-TP-AD-2015]
GO
/****** Object:  Table [dbo].[Bultos]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bultos](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idOVenta] [int] NULL,
 CONSTRAINT [PK_Bultos] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CasaCentral]    Script Date: 11/21/2015 5:28:04 PM ******/
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
/****** Object:  Table [dbo].[Cliente]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cliente](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[direccion] [varchar](50) NOT NULL,
	[idOVenta] [int] NOT NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Clientes_Formas]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Clientes_Formas](
	[idCliente] [int] NOT NULL,
	[idForma] [int] NOT NULL
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ComparativaPrecios]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[ComparativaPrecios](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [datetime] NOT NULL,
 CONSTRAINT [pk_comparativa] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

CREATE TABLE [dbo].[ItemsComparativa](
	[id] [int] NOT NULL,
	[codigoItemProveedor] [varchar](50) NOT NULL,
 CONSTRAINT [pk_itemcomparativa] PRIMARY KEY CLUSTERED 
(
	[id] ASC,
	[codigoItemProveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[CondCompra]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[CondCompra](
	[id] [int] IDENTITY(1,1) NOT NULL,
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
/****** Object:  Table [dbo].[Cotizacion]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Cotizacion](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[estado] [varchar](50) NOT NULL,
	[fecha] [datetime] NOT NULL,
	[idCliente] [int] NOT NULL,
 CONSTRAINT [PK_Cotizacion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Envio]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Envio](
	[idCliente] [int] NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [datetime] NOT NULL,
	[idOVenta] [int] NOT NULL,
 CONSTRAINT [PK_Envio] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Factura]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Factura](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idCliente] [int] NOT NULL,
	[idPedidoVenta] [int] NOT NULL,
 CONSTRAINT [PK_Factura] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FormaPago]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[FormaPago](
	[idOVenta] [int] NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
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
/****** Object:  Table [dbo].[ItemBultos]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING OFF
GO
CREATE TABLE [dbo].[ItemBultos](
	[idBulto] [int] NOT NULL,
	[codigoSKF] [varchar](50) NOT NULL,
	[cantidad] [int] NULL,
 CONSTRAINT [PK_ItemBultos] PRIMARY KEY CLUSTERED 
(
	[idBulto] ASC,
	[codigoSKF] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[ItemCotizacion]    Script Date: 11/21/2015 5:28:04 PM ******/
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
/****** Object:  Table [dbo].[ItemEnvio]    Script Date: 11/21/2015 5:28:04 PM ******/
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
/****** Object:  Table [dbo].[ItemOCProveedor]    Script Date: 11/21/2015 5:28:04 PM ******/
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
/****** Object:  Table [dbo].[ItemPedVenta]    Script Date: 11/21/2015 5:28:04 PM ******/
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
/****** Object:  Table [dbo].[ItemProveedor]    Script Date: 11/21/2015 5:28:04 PM ******/
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
/****** Object:  Table [dbo].[ItemRemito]    Script Date: 11/21/2015 5:28:04 PM ******/
CREATE TABLE [dbo].[ItemRemito](
	[codigoSKF] [varchar](50) NOT NULL,
	[cantidad] [int] NOT NULL,
	[idIRemito] [int] NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_ItemRemito_id] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OCProveedor]    Script Date: 11/21/2015 5:28:04 PM ******/
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
/****** Object:  Table [dbo].[OVenta]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[OVenta](
	[id] [int] IDENTITY (1,1) NOT NULL,
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
/****** Object:  Table [dbo].[PedidoVenta]    Script Date: 11/21/2015 5:28:04 PM ******/
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
/****** Object:  Table [dbo].[Proveedor]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Proveedor](
	[codigoProveedor] [int] IDENTITY(1,1) NOT NULL,
	[direccion] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Proveedor] PRIMARY KEY CLUSTERED 
(
	[codigoProveedor] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Remito]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Remito](
	[fecha] [datetime] NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
	[idOVenta] [int] NOT NULL,
 CONSTRAINT [PK_Remito] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Rodamiento]    Script Date: 11/21/2015 5:28:04 PM ******/
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
/****** Object:  Table [dbo].[Stock]    Script Date: 11/21/2015 5:28:04 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Stock](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[codigoSKF] [varchar](50) NOT NULL,
	[cantidad] [int] NOT NULL,
	[precio] [float] NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Bultos]  WITH CHECK ADD  CONSTRAINT [FK_Bulto_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
ALTER TABLE [dbo].[Bultos] CHECK CONSTRAINT [FK_Bulto_OVenta]
GO
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_Cliente_OVenta]
GO
ALTER TABLE [dbo].[Clientes_Formas]  WITH CHECK ADD  CONSTRAINT [FK_Clientes_Formas_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([id])
GO
ALTER TABLE [dbo].[Clientes_Formas] CHECK CONSTRAINT [FK_Clientes_Formas_Cliente]
GO
ALTER TABLE [dbo].[Clientes_Formas]  WITH CHECK ADD  CONSTRAINT [FK_Clientes_Formas_FormaPago] FOREIGN KEY([idForma])
REFERENCES [dbo].[FormaPago] ([id])
GO
ALTER TABLE [dbo].[Clientes_Formas] CHECK CONSTRAINT [FK_Clientes_Formas_FormaPago]
GO
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD  CONSTRAINT [FK_Envio_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([id])
GO
ALTER TABLE [dbo].[Envio] CHECK CONSTRAINT [FK_Envio_Cliente]
GO
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD  CONSTRAINT [FK_Envio_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
ALTER TABLE [dbo].[Envio] CHECK CONSTRAINT [FK_Envio_OVenta]
GO
ALTER TABLE [dbo].[Factura]  WITH CHECK ADD  CONSTRAINT [FK_Factura_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([id])
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
ALTER TABLE [dbo].[ItemBultos]  WITH CHECK ADD  CONSTRAINT [FK_ItemBultos_Bulto] FOREIGN KEY([idBulto])
REFERENCES [dbo].[Bultos] ([id])
GO
ALTER TABLE [dbo].[ItemBultos] CHECK CONSTRAINT [FK_ItemBultos_Bulto]
GO
ALTER TABLE [dbo].[ItemBultos]  WITH CHECK ADD  CONSTRAINT [FK_ItemBultos_Rodamiento] FOREIGN KEY([codigoSKF])
REFERENCES [dbo].[Rodamiento] ([codigoSKF])
GO
ALTER TABLE [dbo].[ItemBultos] CHECK CONSTRAINT [FK_ItemBultos_Rodamiento]
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
ALTER TABLE [dbo].[Cotizacion]  WITH CHECK ADD  CONSTRAINT [FK_Cotizacion_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([id])
GO
ALTER TABLE [dbo].[ItemsComparativa]  WITH CHECK ADD  CONSTRAINT [fk_comparativa_itemcomparativa] FOREIGN KEY([id])
REFERENCES [dbo].[ComparativaPrecios] ([id])
GO
ALTER TABLE [dbo].[ItemsComparativa] CHECK CONSTRAINT [fk_comparativa_itemcomparativa]
GO
ALTER TABLE [dbo].[ItemsComparativa]  WITH CHECK ADD  CONSTRAINT [fk_itemproveedor_itemcomparativa] FOREIGN KEY([codigoItemProveedor])
REFERENCES [dbo].[ItemProveedor] ([codigo])
GO
ALTER TABLE [dbo].[ItemsComparativa] CHECK CONSTRAINT [fk_itemproveedor_itemcomparativa]
GO
