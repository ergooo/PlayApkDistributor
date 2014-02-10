# apk scheme

# --- !Ups

CREATE TABLE apk (
    id SERIAL primary key,
    name varchar(255) NOT NULL,
    apk_url varchar(255) NOT NULL,
    icon_url varchar(255) NOT NULL,
    package_name varchar(255) NOT NULL
);

# --- !Downs

DROP TABLE apk;