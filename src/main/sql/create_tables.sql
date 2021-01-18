CREATE SCHEMA rpggremlins

CREATE TABLE rpggremlins.ability
(
    id    serial,
    index varchar,
    name  varchar,
    PRIMARY KEY (id)
);

CREATE TABLE rpggremlins.skill
(
    id         serial,
    ability_id serial,
    name       varchar,
    PRIMARY KEY (id)
);

CREATE TABLE rpggremlins.character_skills
(
    character_id uuid,
    skill_id     serial,
    modifier     int,
    PRIMARY KEY (character_id, skill_id)
);

CREATE TABLE rpggremlins.saving_throw
(
    character_id uuid,
    ability_id   serial,
    modifier     int,
    PRIMARY KEY (character_id, ability_id)
);

CREATE TABLE rpggremlins.character_abilities
(
    character_id uuid,
    ability_id   serial,
    value        int,
    modifier     int,
    PRIMARY KEY (character_id, ability_id)
);

CREATE TABLE rpggremlins.character
(
    id           uuid,
    username     varchar,
    class_id     serial,
    race_id      serial,
    name         varchar,
    background   varchar,
    alignment_id serial,
    exp          int,
    PRIMARY KEY (id)
);

CREATE TABLE rpggremlins.alignment
(
    id         serial,
    alignment varchar,
    PRIMARY KEY (id)
);

CREATE TABLE rpggremlins.class
(
    id                     serial,
    name                   varchar,
    hit_dice               int,
    character_skills_limit int,
    lore                   text,
    PRIMARY KEY (id)
);

CREATE TABLE rpggremlins.users
(
    username  varchar,
    pass_hash varchar,
    email     text,
    PRIMARY KEY (username)
);

CREATE TABLE rpggremlins.character_campaigns
(
    character_id  uuid,
    campaign_name varchar,
    PRIMARY KEY (character_id, campaign_name)
);

CREATE TABLE rpggremlins.campaign
(
    name varchar,
    PRIMARY KEY (name)
);

CREATE TABLE rpggremlins.race
(
    id             serial,
    name           varchar,
    lore           text,
    parent_race_id serial,
    speed          int,
    PRIMARY KEY (id)
);

CREATE TABLE rpggremlins.race_abilities
(
    race_id    serial,
    ability_id serial,
    modifier   int,
    PRIMARY KEY (race_id, ability_id)
);

CREATE TABLE rpggremlins.class_skills
(
    skill_id serial,
    class_id serial,
    PRIMARY KEY (skill_id, class_id)
);


ALTER TABLE rpggremlins.saving_throw
    ADD FOREIGN KEY (character_id) REFERENCES character (id);

ALTER TABLE rpggremlins.character_abilities
    ADD FOREIGN KEY (character_id) REFERENCES character (id);

ALTER TABLE rpggremlins.character_skills
    ADD FOREIGN KEY (character_id) REFERENCES character (id);

ALTER TABLE rpggremlins.character_campaigns
    ADD FOREIGN KEY (character_id) REFERENCES character (id);

ALTER TABLE rpggremlins.character
    ADD FOREIGN KEY (username) REFERENCES users (username);

ALTER TABLE rpggremlins.character_campaigns
    ADD FOREIGN KEY (campaign_name) REFERENCES campaign (name);

ALTER TABLE rpggremlins.saving_throw
    ADD FOREIGN KEY (ability_id) REFERENCES ability (id);

ALTER TABLE rpggremlins.character_abilities
    ADD FOREIGN KEY (ability_id) REFERENCES ability (id);

ALTER TABLE rpggremlins.skill
    ADD FOREIGN KEY (ability_id) REFERENCES ability (id);

ALTER TABLE rpggremlins.character_skills
    ADD FOREIGN KEY (skill_id) REFERENCES skill (id);

ALTER TABLE rpggremlins.character
    ADD FOREIGN KEY (class_id) REFERENCES class (id);

ALTER TABLE rpggremlins.class_skills
    ADD FOREIGN KEY (class_id) REFERENCES class (id);

ALTER TABLE rpggremlins.class_skills
    ADD FOREIGN KEY (skill_id) REFERENCES skill (id);

ALTER TABLE rpggremlins.character
    ADD FOREIGN KEY (race_id) REFERENCES race (id);

ALTER TABLE rpggremlins.race_abilities
    ADD FOREIGN KEY (ability_id) REFERENCES ability (id);

ALTER TABLE rpggremlins.race_abilities
    ADD FOREIGN KEY (race_id) REFERENCES race (id);

ALTER TABLE rpggremlins.character
    ADD FOREIGN KEY (alignment_id) REFERENCES alignment (id);

