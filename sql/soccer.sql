
-- Soccer JPA 버전

select * from Stadium;
select * from Team;
select * from Schedule;
select * from Player;

show tables;

DROP TABLE IF EXISTS Stadium, Team, Schedule, Player;

CREATE TABLE Stadium(
	id INT AUTO_INCREMENT,
	stadium_name VARCHAR(40),
	hometeam_id VARCHAR(10),
	seat_count INT,
	address VARCHAR(60),
	ddd VARCHAR(10),
	tel VARCHAR(10),
	PRIMARY KEY(id)
);

CREATE TABLE Team(
	id INT AUTO_INCREMENT,
	region_name VARCHAR(10),
	team_name VARCHAR(40),
	e_team_name VARCHAR(50),
	orig_yyyy VARCHAR(10),
	zip_code1 VARCHAR(10),
	zip_code2 VARCHAR(10),
	address VARCHAR(80),
	ddd VARCHAR(10),
	tel VARCHAR(10),
	fax VARCHAR(10),
	homepage VARCHAR(50),
	owner VARCHAR(10),
	stadium_id INT,
	PRIMARY KEY(id),
	FOREIGN KEY (stadium_id) REFERENCES Stadium(id)
);

CREATE TABLE Schedule(
	id INT AUTO_INCREMENT,
	stadium_id INT,
	gubun VARCHAR(10),
	hometeam_id VARCHAR(10),
	awayteam_id VARCHAR(10),
	home_score INT,
	away_score INT,
	PRIMARY KEY(id),
	FOREIGN KEY (stadium_id) REFERENCES Stadium(id)
);

CREATE TABLE Player(
	id INT AUTO_INCREMENT,
	player_name VARCHAR(20),
	e_player_name VARCHAR(20),
	nickname VARCHAR(30),
	join_yyyy VARCHAR(10),
	position VARCHAR(10),
	back_no INT,
	nation VARCHAR(20),
	birth_date DATE,
	solar VARCHAR(10),
	height INT,
	weight INT,
	team_id INT,
	PRIMARY KEY(id),
	FOREIGN KEY (team_id) REFERENCES Team(id)
);