CREATE TABLE USERINFO(
 U_ID VARCHAR(50) PRIMARY KEY
  , U_PASSWORD VARCHAR(200) NOT NULL
  , U_AUTH CHAR(1) NOT NULL
);

CREATE TABLE BOARDINFO(
 B_NO INT PRIMARY KEY AUTO_INCREMENT
 , B_TITLE VARCHAR(100) NOT NULL
 , B_CONTENT TEXT NOT NULL
 , B_CNT INT DEFAULT 0
 , WRITER_ID VARCHAR(50) NOT NULL REFERENCES USERINFO(U_ID)
 , UPDATE_DATE DATETIME
 , CREATE_DATE DATETIME
);

CREATE TABLE BOARDLIKE(
 B_NO INT REFERENCES BOARDINFO(B_NO)
 , U_ID VARCHAR(50) REFERENCES USERINFO(U_ID)
 , B_LIKE CHAR(1) NOT NULL
 , CONSTRAINT BOARDLIKE_UK UNIQUE (B_NO, U_ID)
);