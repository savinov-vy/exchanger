-- begin EXCHANGE_TAKEN_ITEM
create table EXCHANGE_TAKEN_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID uuid not null,
    DISK_ID uuid not null,
    --
    primary key (ID)
)^
-- end EXCHANGE_TAKEN_ITEM
-- begin EXCHANGE_DISK
create table EXCHANGE_DISK (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    DESCRIPTION varchar(255) not null,
    --
    primary key (ID)
)^
-- end EXCHANGE_DISK
-- begin EXCHANGE_GENRE
create table EXCHANGE_GENRE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    --
    primary key (ID)
)^
-- end EXCHANGE_GENRE
-- begin EXCHANGE_DISK2GENRE
create table EXCHANGE_DISK2GENRE (
    GENRE_ID uuid,
    DISK_ID uuid,
    primary key (GENRE_ID, DISK_ID)
)^
-- end EXCHANGE_DISK2GENRE
-- begin SEC_USER
alter table SEC_USER add column DTYPE varchar(31) ^
update SEC_USER set DTYPE = 'exchange_AppUser' where DTYPE is null ^
-- end SEC_USER
