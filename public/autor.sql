create table autor
(
    id   serial
        primary key
        unique,
    name varchar not null
);

alter table autor
    owner to postgres;

