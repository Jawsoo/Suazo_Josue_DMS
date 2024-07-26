PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE anime (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT NOT NULL UNIQUE,
    genre TEXT NOT NULL,
    episodes INTEGER NOT NULL,
    rating REAL NOT NULL,
    studio TEXT NOT NULL,
    start_year INTEGER NOT NULL,
    end_year INTEGER,
    type TEXT NOT NULL
);

INSERT INTO anime VALUES(1,'Naruto','Action',220,8.3,'Studio Pierrot',2002,2007,'TV');
INSERT INTO anime VALUES(2,'One Piece','Adventure',1000,9.0,'Toei Animation',1999,'current','TV');
INSERT INTO anime VALUES(3,'Attack on Titan','Action',75,9.1,'Wit Studio',2013,2021,'TV');
INSERT INTO anime VALUES(4,'Spirited Away','Fantasy',1,8.6,'Studio Ghibli',2001,2001,'Movie');
INSERT INTO anime VALUES(5,'My Hero Academia','Action',113,8.5,'Bones',2016,'current','TV');
INSERT INTO anime VALUES(6,'Demon Slayer','Action',26,8.8,'ufotable',2019,2019,'TV');
INSERT INTO anime VALUES(7,'Death Note','Thriller',37,9.0,'Madhouse',2006,2007,'TV');
INSERT INTO anime VALUES(8,'Fullmetal Alchemist: Brotherhood','Adventure',64,9.2,'Bones',2009,2010,'TV');
INSERT INTO anime VALUES(9,'Sword Art Online','Fantasy',25,7.6,'A-1 Pictures',2012,2012,'TV');
INSERT INTO anime VALUES(10,'Your Name','Romance',1,8.4,'CoMix Wave Films',2016,2016,'Movie');
INSERT INTO anime VALUES(11,'Dragon Ball Z','Action',291,8.7,'Toei Animation',1989,1996,'TV');
INSERT INTO anime VALUES(12,'Cowboy Bebop','Sci-Fi',26,8.9,'Sunrise',1998,1999,'TV');
INSERT INTO anime VALUES(13,'Neon Genesis Evangelion','Mecha',26,8.5,'Gainax',1995,1996,'TV');
INSERT INTO anime VALUES(14,'Bleach','Action',366,7.9,'Studio Pierrot',2004,2012,'TV');
INSERT INTO anime VALUES(15,'Tokyo Ghoul','Horror',24,7.8,'Studio Pierrot',2014,2014,'TV');
INSERT INTO anime VALUES(16,'Fate/stay night: Unlimited Blade Works','Fantasy',26,8.1,'ufotable',2014,2015,'TV');
INSERT INTO anime VALUES(17,'Code Geass','Mecha',50,8.7,'Sunrise',2006,2008,'TV');
INSERT INTO anime VALUES(18,'JoJo''s Bizarre Adventure','Adventure',152,8.5,'David Production',2012,'current','TV');
INSERT INTO anime VALUES(19,'Black Clover','Fantasy',170,7.9,'Studio Pierrot',2017,2021,'TV');
INSERT INTO anime VALUES(20,'Fairy Tail','Fantasy',328,7.7,'A-1 Pictures',2009,2019,'TV');
INSERT INTO anime VALUES(21,'My Neighbor Totoro','Fantasy',1,8.2,'Studio Ghibli',1988,1988,'Movie');
INSERT INTO anime VALUES(22,'Fate/Zero','Action',25,8.3,'Ufotable',2011,2012,'TV');
INSERT INTO anime VALUES(23,'One Punch Man','Action',12,8.8,'Madhouse',2015,2015,'TV');
INSERT INTO anime VALUES(24,'Gintama','Comedy',367,8.9,'Sunrise',2006,2018,'TV');
INSERT INTO anime VALUES(25,'Re:Zero','Fantasy',25,8.3,'White Fox',2016,2016,'TV');
INSERT INTO anime VALUES(26,'Steins;Gate','Sci-Fi',24,9.1,'White Fox',2011,2011,'TV');
INSERT INTO anime VALUES(27,'Hunter x Hunter','Adventure',148,9.0,'Madhouse',2011,2014,'TV');
INSERT INTO anime VALUES(28,'Mob Psycho 100','Action',25,8.6,'Bones',2016,2019,'TV');
DELETE FROM sqlite_sequence;
INSERT INTO sqlite_sequence VALUES('anime',28);
COMMIT;