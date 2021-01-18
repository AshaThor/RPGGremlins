CREATE TABLE
	character
	(
		id INTEGER NOT NULL,
		name varchar NOT NULL,
		char_class varchar NOT NULL,
		race varchar NOT NULL,
		level INTEGER,
		player varchar NOT NULL
	);
CREATE TABLE
	hibernate_sequence
	(
		next_val INTEGER
	);
CREATE TABLE Ref_Ability
(
    id uuid DEFAULT uuid_generate_v4(),
    index character varying NOT NULL,
    name character varying NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE Ref_Ability
    OWNER to postgres;
COMMENT ON TABLE Ref_Ability
    IS 'A table to hold reference data for the skills in the RPG game';