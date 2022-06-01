-- Creating database data

-- JPA sequences table
CREATE TABLE JPA_SEQUENCES (
	SEQ_KEY VARCHAR(255) NOT NULL PRIMARY KEY,
	SEQ_VALUE NUMERIC(20) NULL DEFAULT NULL
);

-- Users table
CREATE TABLE UM_User
(
  UM_UserId NUMERIC(20) NOT NULL PRIMARY KEY,
  UM_UserCreationDate TIMESTAMP NOT NULL,
  UM_UserModificationDate TIMESTAMP
);

-- User details table
CREATE TABLE UM_UserDetails
(
  UM_UserId NUMERIC(20) NOT NULL PRIMARY KEY REFERENCES UM_User (UM_UserId),
  UM_UserLastName VARCHAR(255),
  UM_UserFirstName VARCHAR(255),
  UM_UserEmailAddress VARCHAR(255),
  UM_UserLocale VARCHAR(255),
  UNIQUE(UM_UserEmailAddress)
);

-- User credentials table
CREATE TABLE UM_UserCredentials
(
  UM_UserId NUMERIC(20) NOT NULL PRIMARY KEY REFERENCES UM_User (UM_UserId),
  UM_UserRealm VARCHAR(255) NOT NULL,
  UM_UserKeycloakId VARCHAR(255) NOT NULL,
  UM_Username VARCHAR(255) NOT NULL,
  UNIQUE(UM_UserRealm, UM_Username)
);
