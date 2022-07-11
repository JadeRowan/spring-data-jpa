create table categories (
    id bigint not null auto_increment,
    name varchar(255),
    primary key (id)
) engine=InnoDB;

create table products (
    id bigint not null auto_increment,
    price decimal(19,2),
    title varchar(255),
    category_id bigint,
    primary key (id)
) engine=InnoDB;

alter table products
    add constraint FKog2rp4qthbtt2lfyhfo32lsw9
    foreign key (category_id) references categories (id);