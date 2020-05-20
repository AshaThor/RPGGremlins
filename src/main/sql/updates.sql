ALTER TABLE rpggremlins.race
    ADD COLUMN speed integer;

ALTER TABLE rpggremlins.class DROP COLUMN speed;

CREATE SEQUENCE rpggremlins.character_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 2147483647
    CACHE 1;

ALTER SEQUENCE rpggremlins.character_id_seq
    OWNER TO postgres;