USE [UpdateServer]
GO
/****** Object:  Table [dbo].[strategy]    Script Date: 07/21/2017 18:05:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[strategy](
	[strategy_id] [bigint] IDENTITY(1,1) NOT NULL,
	[appid] [nvarchar](50) NOT NULL,
	[name] [nvarchar](50) NULL,
	[versionCode] [int] NULL,
	[versionName] [nvarchar](50) NULL,
	[time] [datetime] NULL,
	[force] [bit] NULL,
	[changelog] [nvarchar](500) NULL,
	[url] [nvarchar](50) NULL,
	[states] [nchar](10) NULL,
	[downloads] [int] NULL,
 CONSTRAINT [PK_strategy] PRIMARY KEY CLUSTERED 
(
	[strategy_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[projects]    Script Date: 07/21/2017 18:05:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[projects](
	[appid] [nvarchar](50) NOT NULL,
	[name] [nvarchar](50) NOT NULL,
	[icon] [nvarchar](50) NULL,
	[platform] [nvarchar](50) NULL,
	[type] [nvarchar](50) NULL,
	[info] [nvarchar](500) NULL,
	[time] [datetime] NULL,
	[creator] [nvarchar](50) NULL,
 CONSTRAINT [PK_projects] PRIMARY KEY CLUSTERED 
(
	[appid] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[download]    Script Date: 07/21/2017 18:05:41 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[download](
	[download_id] [bigint] IDENTITY(1,1) NOT NULL,
	[strategy_id] [bigint] NOT NULL,
	[time] [datetime] NULL,
 CONSTRAINT [PK_download] PRIMARY KEY CLUSTERED 
(
	[download_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
