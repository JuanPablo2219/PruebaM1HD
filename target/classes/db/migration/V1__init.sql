CREATE TABLE IF NOT EXISTS conference(
id SERIAL,
title VARCHAR(30),
description VARCHAR(30),
city  VARCHAR(30),
total_assistants int,
PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS assistant(
id SERIAL,
full_name VARCHAR(30),
role VARCHAR(30),
age int,
conference_id SERIAL,
PRIMARY KEY (id),
FOREIGN KEY (conference_id) REFERENCES conference(id)
);