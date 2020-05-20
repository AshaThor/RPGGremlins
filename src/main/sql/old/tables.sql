CREATE TABLE "ref_abilitys" (
                                "id" uuid,
                                "index" varchar,
                                "name" varchar
);

CREATE TABLE "ref_skills" (
                              "id" uuid,
                              "ref_ability_id_fkey" uuid,
                              "index" varchar,
                              "name" varchar
);

CREATE TABLE "skill" (
                         "charcter_id_fkey" uuid,
                         "ref_skills_id_fkey" uuid,
                         "modifier" int
);

CREATE TABLE "saving_throw" (
                                "charcter_id_fkey" uuid,
                                "ref_ability_id" uuid,
                                "modifier" int
);

CREATE TABLE "ability" (
                           "charcter_id_fkey" uuid,
                           "ref_ability_id_fkey" uuid,
                           "value" int,
                           "modifier" int
);

CREATE TABLE "character" (
                             "id" uuid,
                             "user_id_fkey" uuid,
                             "class_id_fkey" uuid,
                             "ref_race_if_fkey" uuid,
                             "name" varchar,
                             "background" varchar,
                             "ref_alignment_id_fkey" uuid,
                             "exp" int
);

CREATE TABLE "ref_alignment" (
                                 "id" uuid,
                                 "aliginment" varchar
);

CREATE TABLE "ref_class" (
                             "id" uuid,
                             "name" varchar,
                             "hit_dice" int,
                             "skill_limit" int,
                             "lore" text,
                             "speed" int
);

CREATE TABLE "user" (
                        "id" uuid,
                        "username" varchar,
                        "pass_hash" varchar,
                        "email" text
);

CREATE TABLE "character_campaign" (
                                      "id" uuid,
                                      "charcter_id_fkey" uuid,
                                      "campaign_id_fkey" uuid
);

CREATE TABLE "campaign" (
                            "id" uuid,
                            "name" varchar
);

CREATE TABLE "ref_race" (
                            "id" uuid,
                            "name" varchar,
                            "lore" text
);

CREATE TABLE "ref_sub_race" (
                                "id" uuid,
                                "ref_race_id_fkey" uuid,
                                "name" varchar
);

CREATE TABLE "sub_race_abilities" (
                                      "ref_sub_race_id" uuid,
                                      "ref_abilitys_id_fkey" uuid,
                                      "modifier" int
);

CREATE TABLE "class_skills" (
                                "ref_skills_id_fkey" uuid,
                                "ref_class_id_fkey" uuid
);

CREATE TABLE "race_abilitys" (
                                 "ref_race_id_fkey" uuid,
                                 "ref_abilitys_id_fkey" uuid,
                                 "modifier" int
);

ALTER TABLE "saving_throw" ADD FOREIGN KEY ("charcter_id_fkey") REFERENCES "character" ("id");

ALTER TABLE "ability" ADD FOREIGN KEY ("charcter_id_fkey") REFERENCES "character" ("id");

ALTER TABLE "skill" ADD FOREIGN KEY ("charcter_id_fkey") REFERENCES "character" ("id");

ALTER TABLE "character_campaign" ADD FOREIGN KEY ("charcter_id_fkey") REFERENCES "character" ("id");

ALTER TABLE "character" ADD FOREIGN KEY ("user_id_fkey") REFERENCES "user" ("id");

ALTER TABLE "character_campaign" ADD FOREIGN KEY ("campaign_id_fkey") REFERENCES "campaign" ("id");

ALTER TABLE "saving_throw" ADD FOREIGN KEY ("ref_ability_id") REFERENCES "ref_abilitys" ("id");

ALTER TABLE "ability" ADD FOREIGN KEY ("ref_ability_id_fkey") REFERENCES "ref_abilitys" ("id");

ALTER TABLE "ref_skills" ADD FOREIGN KEY ("ref_ability_id_fkey") REFERENCES "ref_abilitys" ("id");

ALTER TABLE "skill" ADD FOREIGN KEY ("ref_skills_id_fkey") REFERENCES "ref_skills" ("id");

ALTER TABLE "character" ADD FOREIGN KEY ("class_id_fkey") REFERENCES "ref_class" ("id");

ALTER TABLE "class_skills" ADD FOREIGN KEY ("ref_class_id_fkey") REFERENCES "ref_class" ("id");

ALTER TABLE "class_skills" ADD FOREIGN KEY ("ref_skills_id_fkey") REFERENCES "ref_skills" ("id");

ALTER TABLE "character" ADD FOREIGN KEY ("ref_race_if_fkey") REFERENCES "ref_race" ("id");

ALTER TABLE "race_abilitys" ADD FOREIGN KEY ("ref_abilitys_id_fkey") REFERENCES "ref_abilitys" ("id");

ALTER TABLE "race_abilitys" ADD FOREIGN KEY ("ref_race_id_fkey") REFERENCES "ref_race" ("id");

ALTER TABLE "ref_sub_race" ADD FOREIGN KEY ("ref_race_id_fkey") REFERENCES "ref_race" ("id");

ALTER TABLE "sub_race_abilities" ADD FOREIGN KEY ("ref_sub_race_id") REFERENCES "ref_sub_race" ("id");

ALTER TABLE "sub_race_abilities" ADD FOREIGN KEY ("ref_abilitys_id_fkey") REFERENCES "ref_abilitys" ("id");

ALTER TABLE "character" ADD FOREIGN KEY ("ref_alignment_id_fkey") REFERENCES "ref_alignment" ("id");
