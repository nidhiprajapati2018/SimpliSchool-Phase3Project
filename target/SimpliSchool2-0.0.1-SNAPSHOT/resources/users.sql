create database simpli_school;
use simpli_school;
create table users (userid int primary key auto_increment, username varchar(10), password varchar(10), role varchar(10));
insert into users (username, password, role) values ('simpli', '12345', 'guest');
insert into users (username, password, role) values ('admin', 'admin', 'admin');