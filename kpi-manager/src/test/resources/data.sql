-------------------------------------------------------------------------------------
------------------------------------- TEST DATA -------------------------------------
-------------------------------------------------------------------------------------

--INSERT INTO jpa_sequences
--(seq_key, seq_value)
--VALUES
--('UM_UserId', 10),
--('UM_RoleId', 10),
--('UM_FilterId', 10),
--('UM_FilterItemId', 10);


-- UM_Role
INSERT INTO UM_Role
(UM_RoleId, UM_RoleCreationDate, UM_RoleModificationDate, UM_RoleName, UM_RoleRealm)
VALUES
(1, '2021-05-17T10:47:29.200Z', null, 'ADMIN', 'f40gdaAdmin'),
(2, '2021-05-17T10:55:15.200Z', null, 'PASSENGER', 'f40gdaPassenger'),
(3, '2021-05-17T10:55:15.200Z', null, 'SAV', 'f40gdaAdmin'),
(4, '2021-05-17T10:55:15.200Z', null, 'MANAGE_USER', 'f40gdaAdmin');

-- UM_User
INSERT INTO UM_User
(UM_UserId, UM_UserCreationDate, UM_UserModificationDate, UM_RoleId)
VALUES
(1, '2018-10-26T10:47:29.200Z', null, 1),
(2, '2018-10-26T10:55:15.200Z', null, 2),
(3, '2018-10-29T10:55:15.200Z', null, 3),
(4, '2018-10-29T10:55:15.200Z', null, 1);

-- UM_UserDetails
INSERT INTO UM_UserDetails
(UM_UserId, UM_UserLastName, UM_UserFirstName, UM_UserEmailAddress, UM_UserLocale, UM_CompanyReference)
VALUES
(1, 'lastName', 'firstName', 'existing-email@test.com', 'fr', null),
(2, 'lastName', 'firstName', 'test1@test.com', 'en', 'sytral');

-- UM_UserCredentials
INSERT INTO UM_UserCredentials
(UM_UserId, UM_UserRealm, UM_UserKeycloakId, UM_Username, UM_IdentificationNumber)
VALUES
(1, 'realm', 'daf38b3f-d14c-477c-b2cf-5dc37031642e', 'existingUsername1', null),
(2, 'realm', 'dpm38b3f-d08c-477c-b2gf-7dc37031642e', 'existingUsername2', null),
(3, 'realm', 'dpm38b3f-d08c-477c-b2gf-7dc37031642e', 'existingUsername3', null),
(4, 'realm', 'dpm38b3f-d08c-477c-b2gf-7dc37031642f', 'existingUsername4', '123456789');

-- UM_RolePermission
INSERT INTO UM_RolePermission
(UM_RoleId, UM_Permission)
VALUES
(1, 'ACCESS_ALL_ACCESS_MEDIA'),
(1, 'ACCESS_ALL_ACCOUNTS'),
(1, 'ACCESS_ALL_ACTIVITIES');

-- UPDATE jpa_sequences SET seq_value=4 WHERE seq_key='UM_RoleId';
