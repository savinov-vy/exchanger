-- Fill Genres
insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('4f7b7037-e5ba-780a-88e4-174f090ce4e4', 1, '2022-09-13 10:02:32', 'admin', '2022-09-13 10:02:32', null, null,
        null, 'Фантастика');

insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('d5967584-744d-370c-a9d0-a0ffcfc98539', 1, '2022-09-13 10:02:26', 'admin', '2022-09-13 10:02:26', null, null,
        null, 'Триллер');

insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('0bcc5cde-2168-0c20-b912-8125f2290732', 1, '2022-09-13 10:02:12', 'admin', '2022-09-13 10:02:12', null, null,
        null, 'Мелодрама');

insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('29d8ec88-dc49-46d6-d6f4-3dcd0bc70feb', 1, '2022-09-13 10:02:01', 'admin', '2022-09-13 10:02:01', null, null,
        null, 'Трагедия');

insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('88eab711-dbcb-7e27-fefb-43a4db0db86d', 1, '2022-09-13 10:01:56', 'admin', '2022-09-13 10:01:56', null, null,
        null, 'Комедия');

insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('1a3ed5bb-8c7e-0737-7e06-65ad3226b439', 1, '2022-09-13 10:01:50', 'admin', '2022-09-13 10:01:50', null, null,
        null, 'Боевик');


-- create one manager
insert into SEC_USER
(DTYPE, ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, LOGIN, LOGIN_LC, PASSWORD,
 PASSWORD_ENCRYPTION, NAME, FIRST_NAME, LAST_NAME, MIDDLE_NAME, POSITION_, EMAIL, LANGUAGE_, TIME_ZONE, TIME_ZONE_AUTO,
 ACTIVE, CHANGE_PASSWORD_AT_LOGON, GROUP_ID, GROUP_NAMES, IP_MASK, SYS_TENANT_ID)
values ('exchange_AppUser', '1ade11f7-6942-78d3-35d5-65490821e348', 1, '2022-09-13 17:09:25', 'admin',
        '2022-09-13 17:09:25', null, null, null, 'manager@mail.ru', 'manager@mail.ru',
        '$2a$10$QNzYJJVKQ27gwApGx85o9.ln4RQL9GjKRv1qjn4QvHCoHzyYf41dq', 'bcrypt', 'Александр Пушкин',
        'Александр', 'Пушкин', 'Сергеевич', null, null, 'ru', null, null, true, false,
        '0fa2b1a5-1d68-4d69-9fbd-dff348347f93', null, null, null);


