alter table EXCHANGE_DISK add column DESCRIPTION varchar(255) ^
update EXCHANGE_DISK set DESCRIPTION = '' where DESCRIPTION is null ;
alter table EXCHANGE_DISK alter column DESCRIPTION set not null ;
