create table reservation (
    id bigserial not null,
    number_seats integer not null,
    user_id bigint not null references "user",
    projection_id bigint not null references projection,
    canceled boolean,
    primary key (id)
);