# apk scheme

# --- !Ups

CREATE TABLE apk (
    id SERIAL primary key,
    app_name varchar(255) NOT NULL,
    apk_name varchar(255) NOT NULL,
    icon_name varchar(255) NOT NULL,
    package_name varchar(255) NOT NULL,
    version_code integer NOT NULL,
    version_name varchar(255) NOT NULL
);

# --- !Downs

DROP TABLE apk;