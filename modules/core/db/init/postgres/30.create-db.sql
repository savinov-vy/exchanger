-- fill users
insert into SEC_USER
(DTYPE, ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, LOGIN, LOGIN_LC, PASSWORD,
 PASSWORD_ENCRYPTION, NAME, FIRST_NAME, LAST_NAME, MIDDLE_NAME, POSITION_, EMAIL, LANGUAGE_, TIME_ZONE, TIME_ZONE_AUTO,
 ACTIVE, CHANGE_PASSWORD_AT_LOGON, GROUP_ID, GROUP_NAMES, IP_MASK, SYS_TENANT_ID)
values ('exchange_AppUser', '2ccbe7f1-3c01-e0e4-cd23-18a4c5396193', 1, '2022-09-13 18:45:27', 'admin',
        '2022-09-13 18:45:27', null, null, null, 'manager@mail.ru', 'manager@mail.ru',
        '$2a$10$xJZOiGVn5TUZfI/rBjS9QeYoj49pwp5VYnXVPWSInLHaJWn2VwTKq', 'bcrypt', 'Александр Пушкин',
        'Александр', 'Пушкин', 'Сергеевич', null, null, 'ru', null, null, true, false,
        '0fa2b1a5-1d68-4d69-9fbd-dff348347f93', null, null, null);

insert into SEC_USER_ROLE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, USER_ID, ROLE_ID, ROLE_NAME)
values ('8a0c31e4-1292-0e96-0c68-9d9ac90b83cf', 1, '2022-09-13 18:45:27', 'admin', '2022-09-13 18:45:27', null, null,
        null, '2ccbe7f1-3c01-e0e4-cd23-18a4c5396193', null, 'ManagerRole');


-- fill Genres
insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('1a3ed5bb-8c7e-0737-7e06-65ad3226b439', 1, '2022-09-13 10:01:50', 'admin', '2022-09-13 10:01:50', null, null,
        null, 'Боевик');

insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('61dcae23-a111-d7f6-edb1-927570ad5f90', 1, '2022-09-14 12:00:02', 'admin', '2022-09-14 12:00:02', null, null,
        null, 'Детский');

insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('09a5b172-738c-f98b-e92e-160223ac2c9b', 1, '2022-09-14 12:00:08', 'admin', '2022-09-14 12:00:08', null, null,
        null, 'Исторический');

insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('88eab711-dbcb-7e27-fefb-43a4db0db86d', 1, '2022-09-13 10:01:56', 'admin', '2022-09-13 10:01:56', null, null,
        null, 'Комедия');

insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('fead24f7-c6df-3ccd-1976-1dc6ce09bb4c', 1, '2022-09-14 11:59:49', 'admin', '2022-09-14 11:59:49', null, null,
        null, 'Научный');

insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('29d8ec88-dc49-46d6-d6f4-3dcd0bc70feb', 1, '2022-09-13 10:02:01', 'admin', '2022-09-13 10:02:01', null, null,
        null, 'Трагедия');

insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('d5967584-744d-370c-a9d0-a0ffcfc98539', 1, '2022-09-13 10:02:26', 'admin', '2022-09-13 10:02:26', null, null,
        null, 'Триллер');


insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('4f7b7037-e5ba-780a-88e4-174f090ce4e4', 1, '2022-09-13 10:02:32', 'admin', '2022-09-13 10:02:32', null, null,
        null, 'Фантастика');


-- fill movies
insert into EXCHANGE_DISK
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, DESCRIPTION)
values ('6322de32-1d32-4c02-906f-275cfc38b7f5', 2, '2022-09-14 12:01:37', 'admin', '2022-09-14 12:11:54', 'admin',
        null, null, 'История науки', 'Эволюция становления науки до того вида, который нам известен.');

insert into EXCHANGE_DISK
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, DESCRIPTION)
values ('df9299eb-5c44-45e5-81d1-c9dcb8662e6d', 1, '2022-09-14 12:10:35', 'admin', '2022-09-14 12:10:35', null,
        null, null, 'Каникулы строгого режима', 'О приключениях в детском лагере сбежавших из мест заключения вожатых.');

insert into EXCHANGE_DISK
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, DESCRIPTION)
values ('d987529a-43f0-b1ef-2337-8413051b145d', 3, '2022-09-14 11:57:28', 'admin', '2022-09-14 12:04:28', 'admin', null,
        null, 'Колобок', 'Русская народная сказка. Прародитель смешариков.');

insert into EXCHANGE_DISK
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, DESCRIPTION)
values ('ac0c653a-9a23-e152-861a-f5c6ec166377', 1, '2022-09-14 11:55:42', 'admin', '2022-09-14 11:55:42', null, null, null,
        'Терминатор', 'Война людей и машин. Авторская экранизация одной из основных проблем современного человечества.');

insert into EXCHANGE_DISK
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, DESCRIPTION)
values ('a1f45f9f-fe7c-cfbe-f57b-95a4703e031e', 1, '2022-09-14 12:03:48', 'admin', '2022-09-14 12:03:48', null, null,
        null, 'Эквилибриум', 'Остатки человечества пережившие атомную войну решили, что причина всех ' ||
                             'бед - человеческие эмоции. Они начинают строить новый мир - без эмоций');

-- fill taken item table
insert into EXCHANGE_TAKEN_ITEM
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, USER_ID, DISK_ID)
values ('42067cc1-b47f-04ed-e756-fb42e1771b6b', 1, '2022-09-14 11:55:42', 'admin', '2022-09-14 11:55:42', null, null,
        null, '2ccbe7f1-3c01-e0e4-cd23-18a4c5396193', 'ac0c653a-9a23-e152-861a-f5c6ec166377');

insert into EXCHANGE_TAKEN_ITEM
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, USER_ID, DISK_ID)
values ('3f617213-319a-e3ba-49ee-79fe188f5502', 1, '2022-09-14 11:57:28', 'admin', '2022-09-14 11:57:28', null, null,
        null, '2ccbe7f1-3c01-e0e4-cd23-18a4c5396193', 'd987529a-43f0-b1ef-2337-8413051b145d');

insert into EXCHANGE_TAKEN_ITEM
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, USER_ID, DISK_ID)
values ('bde9ce58-b343-4faf-69ee-4133bd87d3b5', 1, '2022-09-14 12:01:37', 'admin', '2022-09-14 12:01:37', null, null,
        null, '2ccbe7f1-3c01-e0e4-cd23-18a4c5396193', '6322de32-1d32-4c02-906f-275cfc38b7f5');

insert into EXCHANGE_TAKEN_ITEM
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, USER_ID, DISK_ID)
values ('f9ae1352-77aa-d8d8-ddd8-12d86a6bcf18', 1, '2022-09-14 12:03:48', 'admin', '2022-09-14 12:03:48', null,
        null, null, '2ccbe7f1-3c01-e0e4-cd23-18a4c5396193', 'a1f45f9f-fe7c-cfbe-f57b-95a4703e031e');

insert into EXCHANGE_TAKEN_ITEM
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, USER_ID, DISK_ID)
values ('7dc62c4f-160c-d918-b353-862ac781e45f', 1, '2022-09-14 12:10:35', 'admin', '2022-09-14 12:10:35', null,
        null, null, '2ccbe7f1-3c01-e0e4-cd23-18a4c5396193', 'df9299eb-5c44-45e5-81d1-c9dcb8662e6d');

