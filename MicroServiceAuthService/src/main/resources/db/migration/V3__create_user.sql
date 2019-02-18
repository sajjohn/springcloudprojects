create table user(
user_id BIGINT IDENTITY,
user_name VARCHAR(255),
password VARCHAR(255),
account_expired BOOLEAN,
account_locked BOOLEAN,
CREDENTIALS_EXPIRED BOOLEAN,
ENABLED BOOLEAN,
PRIMARY KEY(user_id)
);


create table authority(
authority_id BIGINT IDENTITY,
authority_name VARCHAR(255),
PRIMARY KEY(authority_id));


CREATE TABLE user_authority (
   user_id BIGINT NOT NULL,
   authority_id BIGINT NOT NULL,
   PRIMARY KEY (USER_ID, AUTHORITY_ID)
);

ALTER TABLE user_authority ADD CONSTRAINT USERS_AUTHORITIES_USER
   FOREIGN KEY (USER_ID) REFERENCES USER;

ALTER TABLE user_authority ADD CONSTRAINT USERS_AUTHORITIES_AUTHORITY
   FOREIGN KEY (authority_id) REFERENCES authority;