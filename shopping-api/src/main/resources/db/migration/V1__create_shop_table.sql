create schema if not exists shopping;

create table shopping.shop (
    id bigserial primary key,
    user_identifier varchar(100) not null,
    date timestamp not null default current_timestamp,
    total float not null
);

create table shopping.item(
    shop_id bigint references shopping.shop(id),
    product_identifier varchar(100) not null,
    price float not null
);