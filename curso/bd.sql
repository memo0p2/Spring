create database cursojava;
use cursojava;
-- drop table usuarios;
create table usuarios(
id bigint not null auto_increment,
nombre varchar(50) not null,
apellido varchar(50) not null,
telefono varchar(50) ,
email varchar(50) not null,
password varchar(250) not null,
primary key(id)
);

insert into usuarios(nombre, apellido, telefono, email, password) values ("Guillermo","Ramirez","memo0p2@hotmail.com","5512345678","1234");
insert into usuarios(nombre, apellido, telefono, email, password) values ("Guillermo1","Ramirez1","memo0p3@hotmail.com","5512345678","me456mo");
insert into usuarios(nombre, apellido, telefono, email, password) values ("Guillermo2","Ramirez2","memo0p4@hotmail.com","5512345678","643");
insert into usuarios(nombre, apellido, telefono, email, password) values ("Guillermo3","Ramirez3","memo0p5@hotmail.com","5512345678","meqwedqwmo");
insert into usuarios(nombre, apellido, telefono, email, password) values ("Nuevo","pepe","sdfsdf@hotmail.com","551233345678","dsddd");

select * from usuarios;
