create schema if not exists db_example;

create table clients
(
    id         bigint auto_increment primary key,
    first_name varchar(32) not null,
    last_name  varchar(32) not null
);

create table items
(
    id             bigint auto_increment primary key,
    name           varchar(32)   not null,
    price_amount   decimal(7, 2) not null,
    price_currency varchar(3)    not null
);

create table orders
(
    id               bigint auto_increment primary key,
    client_id        bigint      not null,
    status           varchar(1)  not null,
    express          bit         not null,
    created          datetime(6) not null,

    address_city     varchar(32) not null,
    address_street   varchar(32) not null,
    address_building varchar(32) not null,

    constraint client_fk
        foreign key (client_id) references clients (id)
);

create table order_items
(
    order_id bigint not null,
    item_id  bigint not null,
    quantity int    not null,

    primary key (order_id, item_id),
    constraint item_fk
        foreign key (item_id) references items (id),
    constraint order_fk
        foreign key (order_id) references orders (id)
);

insert into items
values (1, 'Jamon', 10.50, 'EUR'),
       (2, 'Coca-Cola', 1.37, 'USD');

