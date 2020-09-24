insert into user (id, username, password) values (101, 'Tankica','1234');
insert into user (id, username, password) values (102, 'John','1111');

insert into tag (id, name, user_id) values (1,'Tag1',101);
insert into tag (id, name, user_id) values (2,'Tag2',102);

insert into note (id, title, content, user_id) values (1,'title1','content1',101);
insert into note (id, title, content, user_id) values (2,'title2','content2',102);

insert into note_tags (notes_id,tags_id) values (1,1);
insert into note_tags (notes_id,tags_id) values (2,1);