alter table "user" drop column user_role;

create table role (
    id bigserial,
    name varchar(255) not null,
    primary key(id)
);

alter table "user" add role_id bigint;
alter table "user" add constraint fk_role_id foreign key (role_id) references role (id);

insert into role(name) values('ROLE_ADMIN');
insert into role(name) values('ROLE_REGISTERED');

update "user" set role_id = 1 where id = 1;
update "user" set role_id = 2 where id = 2;