CREATE TABLE TB_USER
(
 ID VARCHAR2(20) PRIMARY KEY,
 PWD VARCHAR2(20),
 NAME VARCHAR2(20)
);

CREATE TABLE TB_ITEM
(
 ID VARCHAR2(20),
 NAME VARCHAR2(20),
 PRICE NUMBER
);

ALTER TABLE TB_ITEM 
ADD FOREIGN KEY(ID) REFERENCES TB_USER(ID);

ALTER TABLE TB_ITEM
ADD CONSTRAINT TB_USER_ID_NAME_PK PRIMARY KEY(ID, NAME);

