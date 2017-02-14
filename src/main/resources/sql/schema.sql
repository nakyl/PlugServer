CREATE TABLE user (
  username VARCHAR2(50) NOT NULL PRIMARY KEY,
  email VARCHAR2(50),
  password VARCHAR2(500),
  activated BOOLEAN DEFAULT FALSE,
  activationkey VARCHAR2(50) DEFAULT NULL,
  resetpasswordkey VARCHAR2(50) DEFAULT NULL
);

CREATE TABLE authority (
  name VARCHAR2(50) NOT NULL PRIMARY KEY
);

CREATE TABLE user_authority (
    username VARCHAR2(50) NOT NULL,
    authority VARCHAR2(50) NOT NULL,
    FOREIGN KEY (username) REFERENCES user (username),
    FOREIGN KEY (authority) REFERENCES authority (name),
    UNIQUE INDEX user_authority_idx_1 (username, authority)
);

CREATE TABLE oauth_access_token (
  token_id VARCHAR2(256) DEFAULT NULL,
  token BLOB,
  authentication_id VARCHAR2(256) DEFAULT NULL,
  user_name VARCHAR2(256) DEFAULT NULL,
  client_id VARCHAR2(256) DEFAULT NULL,
  authentication BLOB,
  refresh_token VARCHAR2(256) DEFAULT NULL
);

CREATE TABLE oauth_refresh_token (
  token_id VARCHAR2(256) DEFAULT NULL,
  token BLOB,
  authentication BLOB
);