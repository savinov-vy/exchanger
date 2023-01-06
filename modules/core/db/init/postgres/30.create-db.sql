-- fill roles
insert into sec_role (ID, CREATE_TS, CREATED_BY, VERSION, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, SYS_TENANT_ID,
                      NAME, LOC_NAME, DESCRIPTION, IS_DEFAULT_ROLE, ROLE_TYPE, SECURITY_SCOPE)
values ('2220b80b-4e83-ec6c-9662-6d02548165af', '2022-09-15 08:47:08', 'admin', 1, '2022-09-15 08:47:08', 'admin', null,
        null, null, 'ManagerRole', 'Менеджер', 'Роль менеджера обменника', null, null, 'GENERIC_UI'),

       ('ab5da3b3-7445-9cd7-fcf2-23b02a3c32ab', '2022-09-15 08:47:08', 'admin', 1, '2022-09-15 08:47:08', 'admin', null,
        null, null, 'CustomerRole', 'Клиент', 'Роль клиента обменника', null, null, 'GENERIC_UI'),

       ('bd29f9da-e811-2f8e-1356-b6bfe2d3371f', '2022-09-15 08:47:08', 'admin', 1, '2022-09-15 08:47:08', 'admin', null,
        null, null, 'AnonymousRole', 'Аноним', 'Роль не залогиненного пользователя', null, null, 'GENERIC_UI'),

       ('eec4311d-15ef-0706-5e00-a1601c7babae', '2022-09-15 08:47:08', 'admin', 1, '2022-09-15 08:47:08', 'admin', null,
        null, null, 'system-minimal', 'Минимальный доступ', 'Роль с минимальными системными возможностями', null, null,
        'GENERIC_UI'),

       ('f4efc0f7-dad8-53d4-0594-ff5d82bf6c9c', '2022-09-15 08:47:08', 'admin', 1, '2022-09-15 08:47:08', 'admin', null,
        null, null, 'system-full-access', 'Роль администратора', 'Роль с полными системными возможностями ', null, null,
        'GENERIC_UI');

-- fill users
insert into SEC_USER
(DTYPE, ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, LOGIN, LOGIN_LC, PASSWORD,
 PASSWORD_ENCRYPTION, NAME, FIRST_NAME, LAST_NAME, MIDDLE_NAME, POSITION_, EMAIL, LANGUAGE_, TIME_ZONE, TIME_ZONE_AUTO,
 ACTIVE, CHANGE_PASSWORD_AT_LOGON, GROUP_ID, GROUP_NAMES, IP_MASK, SYS_TENANT_ID)
values ('exchange_AppUser', '48557c0c-b65e-1ad1-2225-bf8f74d0b9c5', 1, '2022-09-15 08:47:08', 'admin',
        '2022-09-15 08:47:08', null, null, null, 'manager@mail.ru', 'manager@mail.ru',
        '$2a$10$Ar7oYWrypt5o9oVyqSWQ9en4EEqyXQX3BwyqK.7W9oWV6JSmNJq4O', 'bcrypt', 'Николай Гоголь', 'Николай', 'Гоголь',
        'Васильевич', null, null, 'ru', null, null, true, false, '0fa2b1a5-1d68-4d69-9fbd-dff348347f93', 'ManagerGroup',
        null, null);

insert into SEC_USER
(DTYPE, ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, LOGIN, LOGIN_LC, PASSWORD,
 PASSWORD_ENCRYPTION, NAME, FIRST_NAME, LAST_NAME, MIDDLE_NAME, POSITION_, EMAIL, LANGUAGE_, TIME_ZONE, TIME_ZONE_AUTO,
 ACTIVE, CHANGE_PASSWORD_AT_LOGON, GROUP_ID, GROUP_NAMES, IP_MASK, SYS_TENANT_ID)
values ('exchange_AppUser', '1d0b8579-054f-c301-f652-c70fa11d9614', 1, '2022-09-21 08:48:05', 'anonymous',
        '2022-09-21 08:48:05', null, null, null, 'user@mail.ru', 'user@mail.ru',
        '$2a$10$ooGW0lCIeECsv085DKCYMOyyo2FtsduLH6cxC88fIdvnTbK00K0Ym', 'bcrypt', 'Александр Пушкин', 'Александр',
        'Пушкин', 'Сергеевич', null, null, null, null, null, true, false, null, 'CustomerGroup', null, null);

insert into SEC_USER
(DTYPE, ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, LOGIN, LOGIN_LC, PASSWORD,
 PASSWORD_ENCRYPTION, NAME, FIRST_NAME, LAST_NAME, MIDDLE_NAME, POSITION_, EMAIL, LANGUAGE_, TIME_ZONE, TIME_ZONE_AUTO,
 ACTIVE, CHANGE_PASSWORD_AT_LOGON, GROUP_ID, GROUP_NAMES, IP_MASK, SYS_TENANT_ID)
values ('exchange_AppUser', '6c68191f-5fc0-abbb-055d-3bfe140524ff', 1, '2022-09-21 08:48:25', 'anonymous',
        '2022-09-21 08:48:25', null, null, null, 'user2@mail.ru', 'user2@mail.ru',
        '$2a$10$p79Shj2iv0xcnkZM9ADoiezxxbHQSdHMyYn0GcZFCq8IzwuebK2Uy', 'bcrypt', 'Лев Толстой', 'Лев', 'Толстой',
        'Николаевич', null, null, null, null, null, true, false, null, 'CustomerGroup', null, null);

insert into SEC_USER
(DTYPE, ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, LOGIN, LOGIN_LC, PASSWORD,
 PASSWORD_ENCRYPTION, NAME, FIRST_NAME, LAST_NAME, MIDDLE_NAME, POSITION_, EMAIL, LANGUAGE_, TIME_ZONE, TIME_ZONE_AUTO,
 ACTIVE, CHANGE_PASSWORD_AT_LOGON, GROUP_ID, GROUP_NAMES, IP_MASK, SYS_TENANT_ID)
values ('exchange_AppUser', '6d4b036f-7528-7f8e-d67c-c25f6ec30b33', 1, '2022-09-21 08:48:48', 'anonymous',
        '2022-09-21 08:48:48', null, null, null, 'user3@mail.ru', 'user3@mail.ru',
        '$2a$10$752H79iUK7fvOGw/SftMOuqgvwZpEMC11Y4hhiFv9qSh9IVdxXxV.', 'bcrypt', 'Михайл Лермонтов', 'Михаил',
        'Лермонтов', 'Юрьевич', null, null, null, null, null, true, false, null, 'CustomerGroup', null, null);

insert into SEC_USER_ROLE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, USER_ID, ROLE_ID, ROLE_NAME)
values ('e256f471-24f2-933e-5827-683e29dbc452', 1, '2022-09-15 08:47:08', 'admin', '2022-09-15 08:47:08', null, null,
        null, '48557c0c-b65e-1ad1-2225-bf8f74d0b9c5', 'eec4311d-15ef-0706-5e00-a1601c7babae', 'system-minimal'),
       ('fbe44c8b-9ea1-cd16-3bd6-3f8df7a41827', 1, '2022-09-15 10:19:07', 'admin', '2022-09-15 10:19:07', null, null,
        null, 'a405db59-e674-4f63-8afe-269dda788fe8', 'bd29f9da-e811-2f8e-1356-b6bfe2d3371f', 'AnonymousRole'),
       ('918f3d83-055f-779b-82ca-1ab2d993fc5b', 1, '2022-09-15 08:47:08', 'admin', '2022-09-15 08:47:08', null, null,
        null, '48557c0c-b65e-1ad1-2225-bf8f74d0b9c5', '2220b80b-4e83-ec6c-9662-6d02548165af', 'ManagerRole'),

       ('1d0b8579-054f-c301-f652-c70fa11d9614', 1, '2022-09-21 08:48:05', 'anonymous', '2022-09-21 08:48:05', null,
        null,
        null, '1d0b8579-054f-c301-f652-c70fa11d9614', 'ab5da3b3-7445-9cd7-fcf2-23b02a3c32ab', 'CustomerRole'),
       ('96ddc6a2-e074-e007-46d5-8f812b9654dd', 1, '2022-09-21 08:48:05', 'anonymous', '2022-09-21 08:48:05', null,
        null,
        null, '1d0b8579-054f-c301-f652-c70fa11d9614', 'eec4311d-15ef-0706-5e00-a1601c7babae', 'system-minimal'),

       ('0a999ec9-36ff-bd00-de9d-84b94a0ea38a', 1, '2022-09-21 08:48:05', 'anonymous', '2022-09-21 08:48:05', null,
        null,
        null, '6c68191f-5fc0-abbb-055d-3bfe140524ff', 'ab5da3b3-7445-9cd7-fcf2-23b02a3c32ab', 'CustomerRole'),
       ('86fa6087-7a3c-aac3-f590-41c900737c60', 1, '2022-09-21 08:48:05', 'anonymous', '2022-09-21 08:48:05', null,
        null,
        null, '6c68191f-5fc0-abbb-055d-3bfe140524ff', 'eec4311d-15ef-0706-5e00-a1601c7babae', 'system-minimal'),

       ('d7ac34eb-2f09-665b-2b72-6635b8ce185b', 1, '2022-09-21 08:48:05', 'anonymous', '2022-09-21 08:48:05', null,
        null,
        null, '6d4b036f-7528-7f8e-d67c-c25f6ec30b33', 'ab5da3b3-7445-9cd7-fcf2-23b02a3c32ab', 'CustomerRole'),
       ('8b2abcc7-6b4e-d462-5746-00d6d1627077', 1, '2022-09-21 08:48:05', 'anonymous', '2022-09-21 08:48:05', null,
        null,
        null, '6d4b036f-7528-7f8e-d67c-c25f6ec30b33', 'eec4311d-15ef-0706-5e00-a1601c7babae', 'system-minimal');

-- fill Genres
insert into EXCHANGE_GENRE
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME)
values ('1a3ed5bb-8c7e-0737-7e06-65ad3226b439', 1, '2022-09-13 10:01:50', 'admin', '2022-09-13 10:01:50',
        null, null, null, 'Боевик'),
       ('61dcae23-a111-d7f6-edb1-927570ad5f90', 1, '2022-09-14 12:00:02', 'admin', '2022-09-14 12:00:02',
        null, null, null, 'Детский'),
       ('09a5b172-738c-f98b-e92e-160223ac2c9b', 1, '2022-09-14 12:00:08', 'admin', '2022-09-14 12:00:08',
        null, null, null, 'Исторический'),
       ('88eab711-dbcb-7e27-fefb-43a4db0db86d', 1, '2022-09-13 10:01:56', 'admin', '2022-09-13 10:01:56',
        null, null, null, 'Комедия'),
       ('fead24f7-c6df-3ccd-1976-1dc6ce09bb4c', 1, '2022-09-14 11:59:49', 'admin', '2022-09-14 11:59:49',
        null, null, null, 'Научный'),
       ('29d8ec88-dc49-46d6-d6f4-3dcd0bc70feb', 1, '2022-09-13 10:02:01', 'admin', '2022-09-13 10:02:01',
        null, null, null, 'Трагедия'),
       ('d5967584-744d-370c-a9d0-a0ffcfc98539', 1, '2022-09-13 10:02:26', 'admin', '2022-09-13 10:02:26',
        null, null, null, 'Триллер'),
       ('4f7b7037-e5ba-780a-88e4-174f090ce4e4', 1, '2022-09-13 10:02:32', 'admin', '2022-09-13 10:02:32',
        null, null, null, 'Фантастика');


-- fill movies
insert into EXCHANGE_DISK
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, NAME, DESCRIPTION)
values ('6322de32-1d32-4c02-906f-275cfc38b7f5', 1, '2022-09-14 12:01:37', 'admin', '2022-09-14 12:11:54', null, null,
        null, 'История науки', 'Эволюция становления науки до того вида, который нам известен.'),

       ('df9299eb-5c44-45e5-81d1-c9dcb8662e6d', 1, '2022-09-14 12:10:35', 'admin', '2022-09-14 12:10:35', null, null,
        null, 'Каникулы строгого режима', 'О приключениях в детском лагере сбежавших из мест заключения вожатых.'),

       ('d987529a-43f0-b1ef-2337-8413051b145d', 1, '2022-09-14 11:57:28', 'admin', '2022-09-14 12:04:28', null, null,
        null, 'Колобок', 'Русская народная сказка. Прародитель смешариков.'),

       ('ac0c653a-9a23-e152-861a-f5c6ec166377', 1, '2022-09-14 11:55:42', 'admin', '2022-09-14 11:55:42', null, null,
        null, 'Терминатор',
        'Война людей и машин. Авторская экранизация одной из основных проблем современного человечества.'),

       ('a1f45f9f-fe7c-cfbe-f57b-95a4703e031e', 1, '2022-09-14 12:03:48', 'admin', '2022-09-14 12:03:48', null, null,
        null, 'Эквилибриум', 'Остатки человечества пережившие атомную войну решили, что причина всех ' ||
                             'бед - человеческие эмоции. Они начинают строить новый мир - без эмоций');

-- fill table genre - movie link
insert into EXCHANGE_DISK2GENRE
    (GENRE_ID, DISK_ID)
VALUES ('09a5b172-738c-f98b-e92e-160223ac2c9b', '6322de32-1d32-4c02-906f-275cfc38b7f5'),
       ('88eab711-dbcb-7e27-fefb-43a4db0db86d', 'df9299eb-5c44-45e5-81d1-c9dcb8662e6d'),
       ('61dcae23-a111-d7f6-edb1-927570ad5f90', 'df9299eb-5c44-45e5-81d1-c9dcb8662e6d'),
       ('61dcae23-a111-d7f6-edb1-927570ad5f90', 'd987529a-43f0-b1ef-2337-8413051b145d'),
       ('4f7b7037-e5ba-780a-88e4-174f090ce4e4', 'ac0c653a-9a23-e152-861a-f5c6ec166377'),
       ('1a3ed5bb-8c7e-0737-7e06-65ad3226b439', 'ac0c653a-9a23-e152-861a-f5c6ec166377'),
       ('29d8ec88-dc49-46d6-d6f4-3dcd0bc70feb', 'ac0c653a-9a23-e152-861a-f5c6ec166377'),
       ('d5967584-744d-370c-a9d0-a0ffcfc98539', 'ac0c653a-9a23-e152-861a-f5c6ec166377'),
       ('29d8ec88-dc49-46d6-d6f4-3dcd0bc70feb', 'a1f45f9f-fe7c-cfbe-f57b-95a4703e031e'),
       ('4f7b7037-e5ba-780a-88e4-174f090ce4e4', 'a1f45f9f-fe7c-cfbe-f57b-95a4703e031e'),
       ('1a3ed5bb-8c7e-0737-7e06-65ad3226b439', 'a1f45f9f-fe7c-cfbe-f57b-95a4703e031e');

-- fill taken item table
insert into EXCHANGE_TAKEN_ITEM
(ID, VERSION, CREATE_TS, CREATED_BY, UPDATE_TS, UPDATED_BY, DELETE_TS, DELETED_BY, USER_ID, DISK_ID)
values ('42067cc1-b47f-04ed-e756-fb42e1771b6b', 1, '2022-09-14 11:55:42', 'admin', '2022-09-14 11:55:42', null, null,
        null, '48557c0c-b65e-1ad1-2225-bf8f74d0b9c5', 'ac0c653a-9a23-e152-861a-f5c6ec166377'),

       ('3f617213-319a-e3ba-49ee-79fe188f5502', 1, '2022-09-14 11:57:28', 'admin', '2022-09-14 11:57:28', null, null,
        null, '48557c0c-b65e-1ad1-2225-bf8f74d0b9c5', 'd987529a-43f0-b1ef-2337-8413051b145d'),

       ('bde9ce58-b343-4faf-69ee-4133bd87d3b5', 1, '2022-09-14 12:01:37', 'admin', '2022-09-14 12:01:37', null, null,
        null, '48557c0c-b65e-1ad1-2225-bf8f74d0b9c5', '6322de32-1d32-4c02-906f-275cfc38b7f5'),

       ('f9ae1352-77aa-d8d8-ddd8-12d86a6bcf18', 1, '2022-09-14 12:03:48', 'admin', '2022-09-14 12:03:48', null, null,
        null, '48557c0c-b65e-1ad1-2225-bf8f74d0b9c5', 'a1f45f9f-fe7c-cfbe-f57b-95a4703e031e'),

       ('7dc62c4f-160c-d918-b353-862ac781e45f', 1, '2022-09-14 12:10:35', 'admin', '2022-09-14 12:10:35', null, null,
        null, '48557c0c-b65e-1ad1-2225-bf8f74d0b9c5', 'df9299eb-5c44-45e5-81d1-c9dcb8662e6d');
