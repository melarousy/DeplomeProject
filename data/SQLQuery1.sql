
CREATE TABLE [dbo].[CLINIC](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[CLINIC_NAME] [nvarchar](50) NOT NULL,
	[I] [bit] NULL,
 CONSTRAINT [PK_CLINIC] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[EMPLOYEES]    Script Date: 05/10/2022 1:48:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[EMPLOYEES](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[EMP_NAME] [nvarchar](50) NOT NULL,
	[NATIONAL_ID] [nvarchar](50) NULL,
	[DOF_BIRTH] [date] NULL,
	[WORK_DATE] [date] NULL,
	[EMP_JOPID] [int] NULL,
	[SPECIALIST_ID] [int] NULL,
	[NATIONALITY_ID] [int] NULL,
	[GENDER] [int] NULL,
	[MARTIAL_STATUS] [int] NULL,
	[MOBILE] [nvarchar](50) NULL,
	[BLOD_KIND] [nvarchar](50) NULL,
	[adress] [nvarchar](max) NULL,
	[i] [bit] NULL,
 CONSTRAINT [PK_EMPLOYEES] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[gender]    Script Date: 05/10/2022 1:48:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[gender](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[type_name] [nvarchar](50) NULL,
	[i] [bit] NULL,
 CONSTRAINT [PK_gender] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[JOPS]    Script Date: 05/10/2022 1:48:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[JOBS](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[JOB_NAME] [nvarchar](50) NULL,
	[I] [bit] NULL,
 CONSTRAINT [PK_JOBS] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LOGIN]    Script Date: 05/10/2022 1:48:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOGIN](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[USER_NAME] [nvarchar](50) NULL,
	[USER_PASS] [nvarchar](50) NULL,
	[is_admin] [bit] NULL,
	[I] [bit] NULL,
 CONSTRAINT [PK_LOGIN] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[marital_stats]    Script Date: 05/10/2022 1:48:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[marital_stats](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[marital_name] [nvarchar](50) NULL,
	[i] [bit] NULL,
 CONSTRAINT [PK_marital_stats] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NATIONALITY]    Script Date: 05/10/2022 1:48:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NATIONALITY](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[NATIONALITY_NAME] [nvarchar](50) NULL,
	[I] [bit] NULL,
 CONSTRAINT [PK_NATIONALITY] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PATIENTS]    Script Date: 05/10/2022 1:48:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PATIENTS](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Patient_NAME] [nvarchar](50) NULL,
	[Patient_ID] [nvarchar](50) NULL,
	[Patient_BIRTH] [date] NULL,
	[DATE_OPEN] [date] NULL,
	[Patient_JOP] [nvarchar](50) NULL,
	[Patient_NATIO] [int] NULL,
	[Patient_TYPE] [int] NULL,
	[Patient_MRITAL] [int] NULL,
	[Patient_MOBI] [nvarchar](50) NULL,
	[Patient_ADDRSS] [nvarchar](max) NULL,
	[I] [bit] NULL,
 CONSTRAINT [PK_PATIENTS] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Specialties]    Script Date: 05/10/2022 1:48:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Specialties](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[iob_id] [int] NULL,
	[Special_name] [nvarchar](50) NULL,
	[i] [bit] NULL,
 CONSTRAINT [PK_Specialties] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TICKETS]    Script Date: 05/10/2022 1:48:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Appointments](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[pati_id] [int] NOT NULL,
	[clinc_id] [int] NOT NULL,
	doctor_id [int] NOT NULL,
	[ap_date] [date] NOT NULL,
	[ap_time] [date] NOT NULL,
	[i] [bit] NULL,
 CONSTRAINT [PK_Appointments] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[VENDORS]    Script Date: 05/10/2022 1:48:56 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[VENDORS](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[ven_NAME] [nvarchar](50) NULL,
	[ven_ADDRESS] [nvarchar](50) NULL,
	[ven_MOBILE] [nvarchar](50) NULL,
	[ven_MAIL] [nvarchar](50) NULL,
	[i] [bit] NULL,
 CONSTRAINT [PK_vendors] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO


