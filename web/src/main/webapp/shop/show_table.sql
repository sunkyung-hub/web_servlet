create table shop_member(
sidx int not null auto_increment,
spart enum('P', 'C') not null,
sid char(50) not null,
spw varchar(10) not null,
snm char(40),
stel char(11) not null,
semail varchar(50) not null,
sno char(13) null,
sdate timestamp not null default current_timestamp,
primary key(sidx),
unique(sid),
unique(stel),
unique(semail)
);