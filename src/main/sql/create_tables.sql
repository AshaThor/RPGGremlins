CREATE TABLE ability
(
    id    serial,
    index varchar,
    name  varchar,
    PRIMARY KEY (id)
);

CREATE TABLE skill
(
    id         serial,
    ability_id serial,
    name       varchar,
    PRIMARY KEY (id)
);

CREATE TABLE character_skills
(
    character_id uuid,
    skill_id     serial,
    modifier     int,
    PRIMARY KEY (character_id, skill_id)
);

CREATE TABLE saving_throw
(
    character_id uuid,
    ability_id   serial,
    modifier     int,
    PRIMARY KEY (character_id, ability_id)
);

CREATE TABLE character_abilities
(
    character_id uuid,
    ability_id   serial,
    value        int,
    modifier     int,
    PRIMARY KEY (character_id, ability_id)
);

CREATE TABLE character
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

CREATE TABLE alignment
(
    id         serial,
    alignment varchar,
    PRIMARY KEY (id)
);

CREATE TABLE class
(
    id                     serial,
    name                   varchar,
    hit_dice               int,
    character_skills_limit int,
    lore                   text,
    PRIMARY KEY (id)
);

CREATE TABLE users
(
    username  varchar,
    pass_hash varchar,
    email     text,
    PRIMARY KEY (username)
);

CREATE TABLE character_campaigns
(
    character_id  uuid,
    campaign_name varchar,
    PRIMARY KEY (character_id, campaign_name)
);

CREATE TABLE campaign
(
    name varchar,
    PRIMARY KEY (name)
);

CREATE TABLE race
(
    id             serial,
    name           varchar,
    lore           text,
    parent_race_id serial,
    speed          int,
    PRIMARY KEY (id)
);

CREATE TABLE race_abilities
(
    race_id    serial,
    ability_id serial,
    modifier   int,
    PRIMARY KEY (race_id, ability_id)
);

CREATE TABLE class_skills
(
    skill_id serial,
    class_id serial,
    PRIMARY KEY (skill_id, class_id)
);


ALTER TABLE saving_throw
    ADD FOREIGN KEY (character_id) REFERENCES character (id);

ALTER TABLE character_abilities
    ADD FOREIGN KEY (character_id) REFERENCES character (id);

ALTER TABLE character_skills
    ADD FOREIGN KEY (character_id) REFERENCES character (id);

ALTER TABLE character_campaigns
    ADD FOREIGN KEY (character_id) REFERENCES character (id);

ALTER TABLE character
    ADD FOREIGN KEY (username) REFERENCES users (username);

ALTER TABLE character_campaigns
    ADD FOREIGN KEY (campaign_name) REFERENCES campaign (name);

ALTER TABLE saving_throw
    ADD FOREIGN KEY (ability_id) REFERENCES ability (id);

ALTER TABLE character_abilities
    ADD FOREIGN KEY (ability_id) REFERENCES ability (id);

ALTER TABLE skill
    ADD FOREIGN KEY (ability_id) REFERENCES ability (id);

ALTER TABLE character_skills
    ADD FOREIGN KEY (skill_id) REFERENCES skill (id);

ALTER TABLE character
    ADD FOREIGN KEY (class_id) REFERENCES class (id);

ALTER TABLE class_skills
    ADD FOREIGN KEY (class_id) REFERENCES class (id);

ALTER TABLE class_skills
    ADD FOREIGN KEY (skill_id) REFERENCES skill (id);

ALTER TABLE character
    ADD FOREIGN KEY (race_id) REFERENCES race (id);

ALTER TABLE race_abilities
    ADD FOREIGN KEY (ability_id) REFERENCES ability (id);

ALTER TABLE race_abilities
    ADD FOREIGN KEY (race_id) REFERENCES race (id);

ALTER TABLE character
    ADD FOREIGN KEY (alignment_id) REFERENCES alignment (id);

