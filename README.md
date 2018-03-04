# MemberSystem一、	
关系模式
我们所设计的系统是会员管理系统，因此必须得实现对会员信息的录入，数据库管理，查询，修改，增添以及对会员充值情况的修改及查询等，因此我们将所有的数据分为两大块，分别是卡信息和消费明细，两块分别在数据库中建表。
关系模式如下：
CARD（CARDNUMBER,PASSWORD,NAME,USERNAME,ID,TEL,BALANCE,STATE,ACTIVATEDATE,VALIDITY）
COST(CARDNUMBER,CONSUMPTIONDATE,COST) 
卡信息（卡号，密码，姓名，用户名，身份证号，余额，卡状态，激活日期，有效期）
消费（流水号 卡号，消费日期，消费金额）
Ps：下划线代表主键
二、	功能介绍
1.	我们的系统分为三大部分：数据库，界面和从外部读卡；
1.1	数据库
我们直接用sql语言建表，用java实现对数据库的链接，关闭链接，发卡，状态控制，密码重置，消费，身份验证，查询余额的功能。
1.2	利用windows builder做出会员系统管理界面：
