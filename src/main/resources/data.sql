insert into data (id, name, year, author, gender) values (1, 'Ritchie, Waters and Moen', 2003, 'Karim Cullen', 'Fantasia');
insert into data (id, name, year, author, gender) values (2, 'Nader, Abernathy and McClure', 2009, 'Hally Macrow', 'Suspense');
insert into data (id, name, year, author, gender) values (3, 'Terry Group', 2004, 'Bertie Jouanny', 'Terror');
insert into data (id, name, year, author, gender) values (4, 'Harris-Wilkinson', 2008, 'Blaire Hawsby', 'Suspense');



insert into tb_user values (1, '$2a$10$JsVQFks6jYKCUqkj1KVkxOvvfHRwrKLcUwIFpF1Zkr57BEF4BcsrS', 'admin');
insert into tb_user values (2, '$2a$10$JsVQFks6jYKCUqkj1KVkxOvvfHRwrKLcUwIFpF1Zkr57BEF4BcsrS', 'user');
insert into tb_role values (1, 'ROLE_ADMIN');
insert into tb_role values (2, 'ROLE_USER');
insert into tb_users_roles values (1, 1);
insert into tb_users_roles values (2, 2);
insert into tb_book (id, name, year, author, gender) values (1, 'Ritchie, Waters and Moen', 2003, 'Karim Cullen', 'Fantasia');
insert into tb_book (id, name, year, author, gender) values (2, 'Nader, Abernathy and McClure', 2009, 'Hally Macrow', 'Suspense');

select * from tb_book;
select * from tb_users_roles;
select * from tb_user;
select * from tb_role;