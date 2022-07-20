create schema if not exists users;

create table users.user (
    id bigserial primary key,
    name varchar(100) not null,
    document varchar(11) not null unique,
    address varchar(100) not null,
    email varchar(100) not null,
    phone varchar(100) not null,
    register_date timestamp default CURRENT_TIMESTAMP
)