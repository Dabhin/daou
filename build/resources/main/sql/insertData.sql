
INSERT INTO test.USERINFO(U_ID, U_PASSWORD,U_AUTH)
VALUES('admin' ,'1234','0'),
      ('user' ,'1234','1');

INSERT INTO test.boardinfo(B_TITLE, B_CONTENT, B_CNT, WRITER_ID, UPDATE_DATE, CREATE_DATE)
VALUES ('tetile_1', 'content_1', 0, 'user', now(), now()),
       ('tetile_2', 'content_2', 0, 'user', now(), now()),
       ('tetile_3', 'content_3', 0, 'user', now(), now()),
       ('test_1', 'content_1', 0, 'user1', now(), now()),
       ('test_2', 'content_2', 0, 'user1', now(), now()),
       ('test_3', 'content_3', 0, 'user1', now(), now());