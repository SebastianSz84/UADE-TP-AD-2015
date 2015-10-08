USE [master]
GO
/****** Object:  Database [UADE-TP-AD-2015]    Script Date: 09/27/2015 17:29:22 ******/
CREATE DATABASE [UADE-TP-AD-2015] ON  PRIMARY 
( NAME = N'[UADE-TP-AD-2015]', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL.1\MSSQL\DATA\[UADE-TP-AD-2015].mdf' , SIZE = 2048KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'[UADE-TP-AD-2015]_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL.1\MSSQL\DATA\[UADE-TP-AD-2015]_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
 COLLATE SQL_Latin1_General_CP1_CI_AS
GO
EXEC dbo.sp_dbcmptlevel @dbname=N'UADE-TP-AD-2015', @new_cmptlevel=90
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
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[OVenta]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[OVenta](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[direccion] [varchar](50) NOT NULL,
 CONSTRAINT [PK_OVenta] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Proveedor]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Proveedor](
	[codigoProveedor] [int] NOT NULL,
	[direccion] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Proveedor] PRIMARY KEY CLUSTERED 
(
	[codigoProveedor] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CasaCentral]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[CasaCentral](
	[id] [int] NOT NULL,
 CONSTRAINT [PK_CasaCentral] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Rodamiento]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Rodamiento](
	[codigoSKF] [varchar](50) NOT NULL,
	[tipo] [varchar](50) NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_Rodamiento] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ComparativaPrecios]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ComparativaPrecios](
	[idComparativa] [int] NOT NULL,
	[estado] [varchar](50) NOT NULL,
 CONSTRAINT [PK_ComparativaPrecios] PRIMARY KEY CLUSTERED 
(
	[idComparativa] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[CondCompra]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[CondCompra](
	[id] [int] NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
	[porcentaje] [float] NOT NULL,
 CONSTRAINT [PK_CondCompra] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Cotizacion]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Cotizacion](
	[id] [int] NOT NULL,
	[estado] [varchar](50) NOT NULL,
	[fecha] [datetime] NOT NULL,
 CONSTRAINT [PK_Cotizacion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[PedidoVenta]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[PedidoVenta](
	[id] [int] NOT NULL,
	[idCotizacion] [int] NOT NULL,
	[idOVenta] [int] NULL,
 CONSTRAINT [PK_PedidoVenta] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Envio]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Envio](
	[idCliente] [int] NOT NULL,
	[id] [int] NOT NULL,
	[fecha] [datetime] NOT NULL,
	[idOVenta] [int] NOT NULL,
 CONSTRAINT [PK_Envio] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[FormaPago]') AND type in (N'U'))
BEGIN
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
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Cliente]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Cliente](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[direccion] [varchar](50) NOT NULL,
	[idOVenta] [int] NULL,
 CONSTRAINT [PK_Cliente] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Bulto]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Bulto](
	[id] [int] NOT NULL,
	[idOVenta] [int] NULL,
 CONSTRAINT [PK_Bulto] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Remito]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Remito](
	[fecha] [datetime] NOT NULL,
	[id] [int] NOT NULL,
	[idOVenta] [int] NOT NULL,
 CONSTRAINT [PK_Remito] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ItemProveedor]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ItemProveedor](
	[codigo] [varchar](50) NOT NULL,
	[precio] [float] NOT NULL,
	[condiciones] [varchar](50) NOT NULL,
	[disponible] [bit] NOT NULL,
	[codigoProveedor] [int] NULL,
	[codigoSKF] [varchar](50) NOT NULL,
 CONSTRAINT [PK_ItemProveedor] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[OCProveedor]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[OCProveedor](
	[id] [int] NOT NULL,
	[codigoProveedor] [int] NOT NULL,
	[idCondCompra] [int] NOT NULL,
 CONSTRAINT [PK_OCProveedor] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ItemOCProveedor]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ItemOCProveedor](
	[id] [int] NOT NULL,
	[idOCProveedor] [int] NOT NULL,
	[codigoSKF] [varchar](50) NOT NULL,
	[cantidad] [int] NOT NULL,
 CONSTRAINT [PK_ItemOCProveedor] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ItemPedVenta]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ItemPedVenta](
	[id] [int] NOT NULL,
	[idPedidoVenta] [int] NULL,
	[cantidad] [int] NOT NULL,
	[precio] [numeric](10, 2) NOT NULL,
 CONSTRAINT [PK_ItemPedVenta] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Factura]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Factura](
	[id] [int] NOT NULL,
	[idCliente] [int] NOT NULL,
	[idPedidoVenta] [int] NOT NULL,
 CONSTRAINT [PK_Factura] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ItemEnvio]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ItemEnvio](
	[id] [int] NOT NULL,
	[idEnvio] [int] NOT NULL,
	[codigoSKF] [varchar](50) NOT NULL,
	[cantidad] [int] NOT NULL,
 CONSTRAINT [PK_ItemEnvio] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ItemBulto]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ItemBulto](
	[id] [int] NOT NULL,
	[idBulto] [int] NOT NULL,
	[codigoSKF] [varchar](50) NOT NULL,
 CONSTRAINT [PK_ItemBulto] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ItemRemito]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ItemRemito](
	[codigoSKF] [varchar](50) NOT NULL,
	[cantidad] [int] NOT NULL,
	[idIRemito] [int] NOT NULL,
 CONSTRAINT [PK_ItemRemito] PRIMARY KEY CLUSTERED 
(
	[codigoSKF] ASC,
	[idIRemito] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ItemPrecios]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ItemPrecios](
	[idComparativa] [int] NOT NULL,
	[codigoSKF] [varchar](50) NOT NULL,
	[codRodProv] [varchar](50) NOT NULL,
	[precio] [float] NOT NULL,
	[id] [int] NOT NULL,
 CONSTRAINT [PK_ItemPrecios] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[Stock]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[Stock](
	[idRodamiento] [int] NULL,
	[cantidad] [int] NOT NULL,
	[precio] [float] NOT NULL,
	[id] [int] IDENTITY(1,1) NOT NULL,
 CONSTRAINT [PK_Stock] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[ItemCotizacion]') AND type in (N'U'))
BEGIN
CREATE TABLE [dbo].[ItemCotizacion](
	[id] [int] NOT NULL,
	[idCotizacion] [int] NULL,
	[cantidad] [int] NOT NULL,
	[codigoSKF] [varchar](50) NOT NULL,
	[precio] [numeric](10, 2) NOT NULL,
 CONSTRAINT [PK_ItemCotizacion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
END
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_PedidoVenta_Cotizacion]') AND parent_object_id = OBJECT_ID(N'[dbo].[PedidoVenta]'))
ALTER TABLE [dbo].[PedidoVenta]  WITH CHECK ADD  CONSTRAINT [FK_PedidoVenta_Cotizacion] FOREIGN KEY([idCotizacion])
REFERENCES [dbo].[Cotizacion] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_PedidoVenta_OVenta]') AND parent_object_id = OBJECT_ID(N'[dbo].[PedidoVenta]'))
ALTER TABLE [dbo].[PedidoVenta]  WITH CHECK ADD  CONSTRAINT [FK_PedidoVenta_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Envio_Cliente]') AND parent_object_id = OBJECT_ID(N'[dbo].[Envio]'))
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD  CONSTRAINT [FK_Envio_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Envio_OVenta]') AND parent_object_id = OBJECT_ID(N'[dbo].[Envio]'))
ALTER TABLE [dbo].[Envio]  WITH CHECK ADD  CONSTRAINT [FK_Envio_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_FormaPago_OVenta]') AND parent_object_id = OBJECT_ID(N'[dbo].[FormaPago]'))
ALTER TABLE [dbo].[FormaPago]  WITH CHECK ADD  CONSTRAINT [FK_FormaPago_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Cliente_OVenta]') AND parent_object_id = OBJECT_ID(N'[dbo].[Cliente]'))
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Bulto_OVenta]') AND parent_object_id = OBJECT_ID(N'[dbo].[Bulto]'))
ALTER TABLE [dbo].[Bulto]  WITH CHECK ADD  CONSTRAINT [FK_Bulto_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Remito_OVenta]') AND parent_object_id = OBJECT_ID(N'[dbo].[Remito]'))
ALTER TABLE [dbo].[Remito]  WITH CHECK ADD  CONSTRAINT [FK_Remito_OVenta] FOREIGN KEY([idOVenta])
REFERENCES [dbo].[OVenta] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemProveedor_Proveedor]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemProveedor]'))
ALTER TABLE [dbo].[ItemProveedor]  WITH CHECK ADD  CONSTRAINT [FK_ItemProveedor_Proveedor] FOREIGN KEY([codigoProveedor])
REFERENCES [dbo].[Proveedor] ([codigoProveedor])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_OCProveedor_CondCompra]') AND parent_object_id = OBJECT_ID(N'[dbo].[OCProveedor]'))
ALTER TABLE [dbo].[OCProveedor]  WITH CHECK ADD  CONSTRAINT [FK_OCProveedor_CondCompra] FOREIGN KEY([idCondCompra])
REFERENCES [dbo].[CondCompra] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_OCProveedor_Proveedor]') AND parent_object_id = OBJECT_ID(N'[dbo].[OCProveedor]'))
ALTER TABLE [dbo].[OCProveedor]  WITH CHECK ADD  CONSTRAINT [FK_OCProveedor_Proveedor] FOREIGN KEY([codigoProveedor])
REFERENCES [dbo].[Proveedor] ([codigoProveedor])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemOCProveedor_OCProveedor]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemOCProveedor]'))
ALTER TABLE [dbo].[ItemOCProveedor]  WITH CHECK ADD  CONSTRAINT [FK_ItemOCProveedor_OCProveedor] FOREIGN KEY([idOCProveedor])
REFERENCES [dbo].[OCProveedor] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemPedVenta_PedidoVenta]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemPedVenta]'))
ALTER TABLE [dbo].[ItemPedVenta]  WITH CHECK ADD  CONSTRAINT [FK_ItemPedVenta_PedidoVenta] FOREIGN KEY([idPedidoVenta])
REFERENCES [dbo].[PedidoVenta] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Factura_Cliente]') AND parent_object_id = OBJECT_ID(N'[dbo].[Factura]'))
ALTER TABLE [dbo].[Factura]  WITH CHECK ADD  CONSTRAINT [FK_Factura_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Factura_PedidoVenta]') AND parent_object_id = OBJECT_ID(N'[dbo].[Factura]'))
ALTER TABLE [dbo].[Factura]  WITH CHECK ADD  CONSTRAINT [FK_Factura_PedidoVenta] FOREIGN KEY([idPedidoVenta])
REFERENCES [dbo].[PedidoVenta] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemEnvio_Envio]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemEnvio]'))
ALTER TABLE [dbo].[ItemEnvio]  WITH CHECK ADD  CONSTRAINT [FK_ItemEnvio_Envio] FOREIGN KEY([idEnvio])
REFERENCES [dbo].[Envio] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemBulto_Bulto]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemBulto]'))
ALTER TABLE [dbo].[ItemBulto]  WITH CHECK ADD  CONSTRAINT [FK_ItemBulto_Bulto] FOREIGN KEY([idBulto])
REFERENCES [dbo].[Bulto] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemRemito_Remito]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemRemito]'))
ALTER TABLE [dbo].[ItemRemito]  WITH CHECK ADD  CONSTRAINT [FK_ItemRemito_Remito] FOREIGN KEY([idIRemito])
REFERENCES [dbo].[Remito] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemPrecios_ComparativaPrecios]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemPrecios]'))
ALTER TABLE [dbo].[ItemPrecios]  WITH CHECK ADD  CONSTRAINT [FK_ItemPrecios_ComparativaPrecios] FOREIGN KEY([idComparativa])
REFERENCES [dbo].[ComparativaPrecios] ([idComparativa])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemPrecios_ItemProveedor]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemPrecios]'))
ALTER TABLE [dbo].[ItemPrecios]  WITH CHECK ADD  CONSTRAINT [FK_ItemPrecios_ItemProveedor] FOREIGN KEY([codRodProv])
REFERENCES [dbo].[ItemProveedor] ([codigo])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_Stock_Rodamiento]') AND parent_object_id = OBJECT_ID(N'[dbo].[Stock]'))
ALTER TABLE [dbo].[Stock]  WITH CHECK ADD  CONSTRAINT [FK_Stock_Rodamiento] FOREIGN KEY([idRodamiento])
REFERENCES [dbo].[Rodamiento] ([id])
GO
IF NOT EXISTS (SELECT * FROM sys.foreign_keys WHERE object_id = OBJECT_ID(N'[dbo].[FK_ItemCotizacion_Cotizacion]') AND parent_object_id = OBJECT_ID(N'[dbo].[ItemCotizacion]'))
ALTER TABLE [dbo].[ItemCotizacion]  WITH CHECK ADD  CONSTRAINT [FK_ItemCotizacion_Cotizacion] FOREIGN KEY([idCotizacion])
REFERENCES [dbo].[Cotizacion] ([id])

