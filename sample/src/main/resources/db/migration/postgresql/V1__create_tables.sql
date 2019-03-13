create sequence user_id_seq start with 10 increment by 50;

create table users (
    id bigint DEFAULT nextval('user_id_seq') not null,
    email varchar(255) not null CONSTRAINT user_email_unique UNIQUE,
    name varchar(255) not null,
    created_at timestamp,
    updated_at timestamp,
    primary key (id)
);
