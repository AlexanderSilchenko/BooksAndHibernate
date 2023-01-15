create table book
(
    id          serial
        primary key
        unique,
    title       varchar not null,
    autor_id    integer not null
        constraint book_autor_id_fk
            references autor,
    year        integer not null,
    genre       varchar not null,
    pages       integer not null,
    description varchar not null
);

alter table book
    owner to postgres;

