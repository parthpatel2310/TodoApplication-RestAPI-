insert into usertype values(1,'admin');
insert into usertype values(2,'user');
insert into user values(1,'admin','$2a$10$myDn8xygsGHUR4f/tP8NLeXKVJOFpaq11eXek0Xedw0cF6BgtJrX2','admin@gmail.com',1);
insert into user values(2,'parth','$2a$10$myDn8xygsGHUR4f/tP8NLeXKVJOFpaq11eXek0Xedw0cF6BgtJrX2','parth@gmail.com',2);
insert into todo(id,userid,description,target_date,status) values(1,1,'learning spring','2019-11-23',FALSE);
insert into todo(id,userid,description,target_date,status) values(2,1,'learning aws','2019-11-27',FALSE);
insert into todo(id,userid,description,target_date,status) values(3,1,'learning angular','2019-12-12',FALSE);
insert into todo(id,userid,description,target_date,status) values(4,2,'learning guitar','2019-12-12',FALSE);
