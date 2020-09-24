insert into user (id, username, password) values (1, 'Tankica','1234');
insert into user (id, username, password) values (2, 'John','1111');

insert into tag (id, name, user_id) values (1,'Tag1',1);
insert into tag (id, name, user_id) values (2,'Tag2',1);
insert into tag (id, name, user_id) values (3,'Tag3',2);
insert into tag (id, name, user_id) values (4,'Tag4',2);
insert into tag (id, name, user_id) values (5,'Tag5',2);

insert into note (id, title, content, user_id) values (1,'title1','content1',1);
insert into note (id, title, content, user_id) values (2,'title2','content2',2);
insert into note (id, title, content, user_id) values (3,'title3','content3',1);
insert into note (id, title, content, user_id) values (4,'title4','content4',2);
insert into note (id, title, content, user_id) values (5,'title5','content5',1);

insert into note_tags (note_id,tags_id) values (1,1);
insert into note_tags (note_id,tags_id) values (2,1);
insert into note_tags (note_id,tags_id) values (3,3);
insert into note_tags (note_id,tags_id) values (3,5);
insert into note_tags (note_id,tags_id) values (4,5);
insert into note_tags (note_id,tags_id) values (5,5);