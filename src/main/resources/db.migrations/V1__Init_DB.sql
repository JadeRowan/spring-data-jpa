CREATE SCHEMA IF NOT EXISTS test;
create table test.categories (

    id bigint not null auto_increment,
    name varchar(255),
    primary key (id)
 );

create table test.products (
    id bigint not null auto_increment,
    price decimal(19,2),
    title varchar(255),
    category_id bigint,
    primary key (id)
);

alter table test.products
    add constraint FKog2rp4qthbtt2lfyhfo32lsw9
    foreign key (category_id) references test.categories (id);

