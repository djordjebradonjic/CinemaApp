
create table movie (
    id bigserial not null,
    name varchar(255) not null,
    director varchar(255) not null,
    duration integer not null,
    description varchar(255) not null,
    deleted boolean,
    primary key (id)
);
create table movie_genres (
    movie_id bigint not null references movie,
    genres varchar(255) not null
);
create table theater (
    id bigserial not null,
    name varchar(255) not null,
    capacity integer not null,
    primary key (id)
);

create table projection (
    id bigserial not null,
    start_time timestamp(6),
    ticket_price integer,
    end_time timestamp(6),
    movie_id bigint not null references movie,
    theater_id bigint not null references theater,
    available_seats bigint not null,
    deleted boolean,
    primary key (id)
);

create table "user" (
    id bigserial not null,
    username varchar(255) not null unique,
    password varchar(255) not null,
    name varchar(255),
    surname varchar(255),
    email varchar(255) not null unique,
    user_role varchar(255) not null,
    primary key (id)
);


