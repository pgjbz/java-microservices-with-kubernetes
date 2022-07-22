create table products.product (
    id bigserial primary key,
    product_identifier varchar not null unique,
    name varchar(100) not null,
    description varchar not null,
    price float not null,
    category_id bigint references products.category(id)
);