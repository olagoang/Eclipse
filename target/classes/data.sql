INSERT INTO CATEGORY(id, name) VALUES (1, 'Eurogames');
INSERT INTO CATEGORY(id, name) VALUES (2, 'Ameritrash');
INSERT INTO CATEGORY(id, name) VALUES (3, 'Familiar');

INSERT INTO AUTHOR(id, name, nationality) VALUES (1, 'Alan R. Moon', 'US');
INSERT INTO AUTHOR(id, name, nationality) VALUES (2, 'Vital Lacerda', 'PT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (3, 'Simone Luciani', 'IT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (4, 'Perepau Llistosella', 'ES');
INSERT INTO AUTHOR(id, name, nationality) VALUES (5, 'Michael Kiesling', 'DE');
INSERT INTO AUTHOR(id, name, nationality) VALUES (6, 'Phil Walker-Harding', 'US');

INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (1, 'On Mars', '14', 1, 2);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (2, 'Aventureros al tren', '8', 3, 1);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (3, '1920: Wall Street', '12', 1, 4);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (4, 'Barrage', '14', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (5, 'Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (6, 'Azul', '8', 3, 5);


INSERT INTO CLIENT(id, name) VALUES (1, 'Europa');
INSERT INTO CLIENT(id, name) VALUES (2, 'Paco');
INSERT INTO CLIENT(id, name) VALUES (3, 'Jose');

INSERT INTO PRESTAMO(id,game_id,client_id,fecha_in,fecha_out) VALUES(1,1,2,to_date('6/11/2022','DD/MM/YYYY'),to_date('8/11/2022','DD/MM/YYYY'));
INSERT INTO PRESTAMO(id,game_id,client_id,fecha_in,fecha_out) VALUES(2,2,2,to_date('7/11/2022','DD/MM/YYYY'),to_date('10/11/2022','DD/MM/YYYY'));
INSERT INTO PRESTAMO(id,game_id,client_id,fecha_in,fecha_out) VALUES(3,2,1,to_date('7/11/2022','DD/MM/YYYY'),to_date('11/11/2022','DD/MM/YYYY'));
INSERT INTO PRESTAMO(id,game_id,client_id,fecha_in,fecha_out) VALUES(4,3,2,to_date('20/11/2022','DD/MM/YYYY'),to_date('27/11/2022','DD/MM/YYYY'));
INSERT INTO PRESTAMO(id,game_id,client_id,fecha_in,fecha_out) VALUES(5,3,1,to_date('6/11/2022','DD/MM/YYYY'),to_date('8/11/2022','DD/MM/YYYY'));
