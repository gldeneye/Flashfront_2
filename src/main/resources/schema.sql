CREATE TABLE COMMENTS(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    THREADID BIGINT not null,
    FORUMUSERID BIGINT not null,
    COMMENT VARCHAR(500)
);

CREATE TABLE THREAD(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(50)
);


CREATE TABLE FORUMUSER(
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    USERNAME VARCHAR(25),
    PASSWORD VARCHAR(50)
);

ALTER table COMMENTS add foreign key (THREADID) references THREAD(ID);
ALTER table COMMENTS add foreign key (FORUMUSERID) references FORUMUSER(ID);


