use laptrinhjavaweb;
create table role(
	id bigint not null primary key auto_increment,
    name varchar(255) not null, 
    code varchar(255) not null,
    createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);
create table user(
	id bigint not null primary key auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    fullname varchar(255) null,
    status int not null,
    roleid bigint not null,
	createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);
Alter table user ADD CONSTRAINT fk_user_role foreign key(roleid) references role(id);

create table news(
	id bigint not null primary key auto_increment,
    title varchar(255) null,
    thumnail varchar(255) null,
    shortdescription text not null,
    content text null,
    categoryid bigint not null,
	createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);
create table category(
	id bigint not null primary key auto_increment,
	name varchar(255) not null, 
    code varchar(255) not null,
	createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);

Alter table news ADD CONSTRAINT fk_news_category foreign key(categoryid) references category(id);

create table comment(
	id bigint not null primary key auto_increment,
	content text not null, 
    user_id bigint not null,
    new_id bigint not null,
	createddate timestamp null,
    modifieddate timestamp null,
    createdby varchar(255) null,
    modifiedby varchar(255) null
);
Alter table comment ADD CONSTRAINT fk_comment_user foreign key(user_id) references user(id);
Alter table comment ADD CONSTRAINT fk_comment_news foreign key(new_id) references news(id);