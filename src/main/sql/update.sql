CREATE TABLE rpggremlins.blog
(
    id         serial,
    title varchar,
    img_link       varchar,
    hook varchar(140),
    body text,
    author varchar,
    date  varchar,
    likes integer,
    PRIMARY KEY (id)
);